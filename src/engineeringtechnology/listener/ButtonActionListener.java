package engineeringtechnology.listener;

import engineeringtechnology.cuttingmodes.AbstractTool;
import engineeringtechnology.cuttingmodes.data.Data;
import engineeringtechnology.cuttingmodes.tool.*;
import engineeringtechnology.graphicfield.Field;
import engineeringtechnology.graphicfield.tabs.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Класс слушатель кнопок
 */
public class ButtonActionListener implements ActionListener {
    /**
     * Поле поле
     */
    private Field field;

    /**
     * Поле вкладка зенкер
     */
    private TabCountersink tabCountersink;

    /**
     * Поле вкладка фреза
     */
    private TabCutter tabCutter;

    /**
     * Поле вкладка сверло
     */
    private TabDrill tabDrill;

    /**
     * Поле вкладка развертка
     */
    private TabSweep tabSweep;

    /**
     * Поле вкладка метчик
     */
    private TabTap tabTap;

    /**
     * Конструктор кнопочного слушателя
     * @param field поле
     * @param tabCountersink вкладка зенкер
     * @param tabCutter вкладка фреза
     * @param tabDrill вкладка сверло
     * @param tabSweep вкладка развертка
     * @param tabTap вкладка метчик
     */
    public ButtonActionListener(Field field, TabCountersink tabCountersink, TabCutter tabCutter, TabDrill tabDrill,
                                TabSweep tabSweep, TabTap tabTap) {
        this.field = field;
        this.tabCountersink = tabCountersink;
        this.tabCutter = tabCutter;
        this.tabDrill = tabDrill;
        this.tabSweep = tabSweep;
        this.tabTap = tabTap;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        AbstractTab tab = getTab(TabActionListener.getNumberTab());
        AbstractTool tool = getTool(TabActionListener.getNumberTab(), tab.getNumberComboBox());
        if (clickedButton == field.getButtonStart()) {
            if (tool instanceof Tap && tab instanceof TabTap) {
                calculationModesTap((Tap) tool, (TabTap) tab);
            } else {
                calculationModesTool(tool, tab);
            }
        }
        if (clickedButton == field.getButtonStop()) {
            tab.getMessageError().setText("");
            deleteSelectTab(tool, tab);
        }
    }

    /**
     * Метод определяет активизированную вкладку
     * @param numberTab номер вкладки
     * @return возвращает активизированную вкладку
     */
    private AbstractTab getTab(int numberTab) {
        return Data.LIST_TAB.get(numberTab);
    }

    /**
     * Метод определяет активизированный инструмент
     * @param numberTab номер вкладки
     * @param numberComboBox номер в выподающем списке
     * @return возвращает активизированный инструмент
     */
    private AbstractTool getTool(int numberTab, int numberComboBox) {
        return Data.LIST_TOOL.get(numberTab).get(numberComboBox);
    }

    /**
     * Метод рассчитывает режимы резания инструмента
     * @param tool инструмент
     * @param tab вкладка
     */
    private void calculationModesTool(AbstractTool tool, AbstractTab tab) {
        try {
            if (conditionInputDiameter(tool, tab) && conditionInputDiameterFeed(tool, tab)) {
                setFieldsWithoutFeed(tool, tab);
            }
        } catch (NumberFormatException e) {
            setFieldsWithFeed(tool, tab);
        }
        selectSpecificTab(tool, tab);
    }

    /**
     * Метод рассчитывает режимы резания метчика
     * @param tool инструмент
     * @param tab вкладка
     */
    private void calculationModesTap(Tap tool, TabTap tab) {
        if (conditionInputDiameter(tool, tab) && conditionInputDiameterFeedTap(tool, tab)) {
            setFieldsTabTap(tool, tab);
        }
        selectSpecificTab(tool, tab);
    }

    /**
     * Метод проверяет поле диаметра на наличие диаметра находящегося в определенном диапазоне
     * @param tool инструмент
     * @param tab вкладка
     * @return возвращает false, если в поле число отсутствует или не в том диапазоне
     */
    private boolean conditionInputDiameter(AbstractTool tool, AbstractTab tab) {
        String stringDiameter = tab.getFieldDiameter().getText();
        if ("".equals(stringDiameter)) {
            tool.setNumberDiameter(0);
            massageForDiameter(tool, tab);
            return false;
        }
        tab.getMessageError().setText("");
        tool.setNumberDiameter(Double.parseDouble(stringDiameter));
        if (tool.getNumberDiameter() >= tool.getMinDiameter() && tool.getNumberDiameter() <= tool.getMaxDiameter()) {
            return true;
        } else {
            massageForDiameter(tool, tab);
            return false;
        }
    }

    /**
     * Метод выводит сообщение о нужном размере диаметра инструмента и обнуляет нужные поля
     * @param tool инструмент
     * @param tab вкладка
     */
    private void massageForDiameter(AbstractTool tool, AbstractTab tab) {
        tab.getMessageError().setForeground(Color.red);
        tab.getMessageError().setText("Введите диаметр инструмента от " + (int) tool.getMinDiameter() +
                " до " + (int) tool.getMaxDiameter() + " мм!");
        deleteSelectTab(tool, tab);
    }

    /**
     * Метод проверяет в нужном ли диапазоне находиться поле подач
     * @param tool инструмент
     * @param tab вкладка
     * @return возвращает true если подача в указанном диапазоне значений, false если
     * не в указанном диапазоне значений
     */
    private boolean conditionInputDiameterFeed(AbstractTool tool, AbstractTab tab) {
        String stringFeed = tab.getFieldFeed().getText();
        tool.setNumberFeed(Double.parseDouble(stringFeed));
        if (tool.getNumberFeed() >= tool.getMinFeed() && tool.getNumberFeed() <= tool.getMaxFeed()) {
            return true;
        } else {
            massageForFeed(tool, tab);
            return false;
        }
    }

    /**
     * Метод проверяет есть ли подача для метчика
     * @param tap инструмент метчик
     * @param tab вкладка метчик
     * @return возвращает true если подача есть, false если
     * подачи нет
     */
    private boolean conditionInputDiameterFeedTap(Tap tap, TabTap tab) {
        String stringFeed = tab.getFieldFeed().getText();
        if ("".equals(stringFeed)) {
            tap.setNumberFeed(0);
            massageForFeedTap(tab);
            return false;
        }
        tap.setNumberFeed(Double.parseDouble(stringFeed));
        if (tap.isFeed(tap.getNumberFeed())) {
            return true;
        } else {
            massageForFeedTap(tab);
            return false;
        }
    }

    /**
     * Метод выводит сообщение о нужном размере подачи инструмента и обнуляет нужные поля
     * @param tool инструмент
     * @param tab вкладка
     */
    private void massageForFeed(AbstractTool tool, AbstractTab tab) {
        tab.getMessageError().setForeground(Color.red);
        tab.getMessageError().setText("Введите подачу инструмента от " + tool.getMinFeed() +
                " до " + tool.getMaxFeed() + " мм/об!");
        tab.getFieldTurns().setText("0");
        tab.getFieldMachineFeed().setText("0");
        tab.getLabelFormulaTurnsFeed().setText("");
    }

    /**
     * Метод выводит сообщение о нужном размере подачи инструмента и обнуляет нужные поля
     * @param tab вкладка метчик
     */
    private void massageForFeedTap(TabTap tab) {
        tab.getMessageError().setForeground(Color.red);
        tab.getMessageError().setText("Введите шаг метрической резьбы от 0.5 до 3.5!");
        tab.getFieldDrill().setText("0");
        tab.getFieldTurns().setText("0");
        tab.getFieldMachineFeed().setText("0");
        tab.getLabelFormulaTurnsFeed().setText("");
    }

    /**
     * Метод выбирает инструмент сверло или метчик
     * и бросает в выбранный метод уже преобразованные типы
     * @param tool инструмент
     * @param tab вкладка
     */
    private void selectSpecificTab(AbstractTool tool, AbstractTab tab) {
        if (tool instanceof Drill && tab instanceof TabDrill) {
            calculationLengthPointDrill((Drill) tool, (TabDrill) tab);
        }
        if (tool instanceof Tap && tab instanceof TabTap) {
            calculationDrill((Tap) tool, (TabTap) tab);
        }
    }

    /**
     * Метод выбирает расчет оборотов в зависимости стоит ли флажек.
     * @param tool инструмент
     * @param tab вкладка
     * @return возвращает обороты для ГФ2171 если true(флажек установлен), возвращает расчетные обороты если false(флажек
     * не установлен)
     */
    private int calculateWithCheckBox(AbstractTool tool, AbstractTab tab) {
        int turns;
        if (tab.isCheckBox()) {
            turns = tool.calculateTurnsGF(tool.calculateTurns(tool.getNumberDiameter()));
        } else {
            turns = tool.calculateTurns(tool.getNumberDiameter());
        }
        return turns;
    }

    /**
     * Метод заполняет расчетные поля при установленной подаче
     * @param tool инструмент
     * @param tab вкладка
     */
    private void setFieldsWithoutFeed(AbstractTool tool, AbstractTab tab) {
        tab.getFieldMachineFeed().setText("" + tool.calculateFeed(tool.getNumberFeed(), calculateWithCheckBox(tool, tab)));
        tab.getFieldFeed().setText("" + tool.getNumberFeed());
        tab.getFieldTurns().setText("" + calculateWithCheckBox(tool, tab));
        tab.getLabelFormulaTurnsFeed().setText("n = 1000 * " + tool.getSpeed() + " / 3.14 * " + tool.getNumberDiameter() +
                ", об/мин  F = " + calculateWithCheckBox(tool, tab) + " * " + tool.getNumberFeed() + ", мм/мин");
    }

    /**
     * Метод заполняет расчетные поля при неустановленной подаче, устанавливает среднюю подачу и
     * выводит сообщение об этой установке
     * @param tool инструмент
     * @param tab вкладка
     */
    private void setFieldsWithFeed(AbstractTool tool, AbstractTab tab) {
        tab.getMessageError().setForeground(Color.GRAY);
        tab.getMessageError().setText("Установлена средняя подача S=" + tool.getFeed() + " мм/об");
        tab.getFieldMachineFeed().setText("" + tool.calculateFeed(calculateWithCheckBox(tool, tab)));
        tab.getFieldFeed().setText("" + tool.getFeed());
        tab.getFieldTurns().setText("" + calculateWithCheckBox(tool, tab));
        tab.getLabelFormulaTurnsFeed().setText("n = 1000 * " + tool.getSpeed() + " / 3.14 * " +tool.getNumberDiameter() +
                ", об/мин  F = " + calculateWithCheckBox(tool, tab) + " * " + tool.getFeed() + ", мм/мин");
    }

    /**
     * Метод заполняет расчетные поля вкладки метчик
     * @param tool инструмент метчик
     * @param tab вкладка метчик
     */
    private void setFieldsTabTap(Tap tool, TabTap tab) {
        tab.getFieldMachineFeed().setText("" + tool.calculateFeed(tool.getNumberFeed(), calculateWithCheckBox(tool, tab)));
        tab.getFieldTurns().setText("" + calculateWithCheckBox(tool, tab));
        tab.getLabelFormulaTurnsFeed().setText("n = 1000 * " + tool.getSpeed() + " / 3.14 * " + tool.getNumberDiameter() +
                ", об/мин  F = " + calculateWithCheckBox(tool, tab) + " * " + tool.getNumberFeed() + " * 0.9, мм/мин");
    }

    /**
     * Метод расчитывает длину острого конца сверла, если диаметр сверла не входит в заданные пределы , то обнуляется
     * поле расчета острого конца сверла
     * @param drill инструмент сверло
     * @param tab вкладка сверло
     */
    private void calculationLengthPointDrill(Drill drill, TabDrill tab) {
        if (drill.getNumberDiameter() >= drill.getMinDiameter() && drill.getNumberDiameter() <= drill.getMaxDiameter()) {
            if (drill.lengthPointDrill(drill.getNumberDiameter()) % 1 == 0) {
                tab.getFieldBlade().setText("" + (int) drill.lengthPointDrill(drill.getNumberDiameter()));
            } else {
                tab.getFieldBlade().setText(String.format("%.2f", drill.lengthPointDrill(drill.getNumberDiameter())).replaceAll("\\.?0*$", ""));
            }
        } else {
            tab.getFieldBlade().setText("0");
        }
    }

    /**
     * Метод рассчитывает сверло под метчик, если диаметр метчика не входит в заданные пределы, то обнуляет поле
     * расчета сверла под метчик
     * @param tap инструмент метчик
     * @param tab вкладка метчик
     */
    private void calculationDrill(Tap tap, TabTap tab) {
        if (tap.getNumberDiameter() >= tap.getMinDiameter() && tap.getNumberDiameter() <= tap.getMaxDiameter()) {
            tab.getFieldDrill().setText(String.format("%.2f", tap.calculateDiameterDrill(tap.getNumberDiameter(), tap.getNumberFeed())));
        } else {
            tab.getFieldDrill().setText("0");
        }
    }

    /**
     * Метод определяет вкладку и удаляет содержимое всех полей
     * @param tool инструмент
     * @param tab вкладка
     */
    private void deleteSelectTab(AbstractTool tool, AbstractTab tab) {
        if (tool instanceof Cutter && tab instanceof TabCutter) {
            deleteContentField(tabCutter);
        }
        if (tool instanceof Drill && tab instanceof TabDrill) {
            deleteContentField(tabDrill);
            tabDrill.getFieldBlade().setText("0");
        }
        if (tool instanceof Countersink && tab instanceof TabCountersink) {
            deleteContentField(tabCountersink);
        }
        if (tool instanceof Sweep && tab instanceof TabSweep) {
            deleteContentField(tabSweep);
        }
        if (tool instanceof Tap && tab instanceof TabTap) {
            deleteContentField(tabTap);
            tabTap.getFieldDrill().setText("0");
        }
    }

    /**
     * Метод очищает все поля вкладки
     * @param tab вкладка
     */
    private void deleteContentField(AbstractTab tab) {
        tab.getFieldDiameter().setText("");
        tab.getFieldFeed().setText("");
        tab.getFieldTurns().setText("0");
        tab.getFieldMachineFeed().setText("0");
        tab.getLabelFormulaTurnsFeed().setText("");
    }
}
