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
     * Поле число диаметра
     */
    private double numberDiameter;

    /**
     * Поле число подачи
     */
    private double numberFeed;

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
            calculationModesTool(tool, tab);
        }
        if (clickedButton == field.getButtonStop()) {
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
                selectSpecificTab(tool, tab);
                tab.getFieldMachineFeed().setText("" + tool.calculateFeed(numberFeed, calculateWithCheckBox(tool, tab)));
                tab.getFieldFeed().setText("" + numberFeed);
                tab.getLabelFormulaTurnsFeed().setText("n = 1000 * " + tool.getSpeed() + " / 3.14 * " + numberDiameter + ", об/мин  F = " + calculateWithCheckBox(tool, tab) + " * " + numberFeed + ", мм/мин");
            }
        } catch (NumberFormatException e) {
            field.getMessageError().setForeground(Color.green);
            field.getMessageError().setText("Установлена средняя подача S=" + tool.getFeed() + " мм/об");
            selectSpecificTab(tool, tab);
            tab.getFieldMachineFeed().setText("" + tool.calculateFeed(calculateWithCheckBox(tool, tab)));
            tab.getFieldFeed().setText("" + tool.getFeed());
            tab.getLabelFormulaTurnsFeed().setText("n = 1000 * " + tool.getSpeed() + " / 3.14 * " + numberDiameter + ", об/мин  F = " + calculateWithCheckBox(tool, tab) + " * " + tool.getFeed() + ", мм/мин");
        }
    }

    /**
     * Метод ищет инструмент сверло и вкладку сверло
     * и бросает в выбранный метод уже преобразованные типы
     * @param tool инструмент
     * @param tab вкладка
     */
    private void selectSpecificTab(AbstractTool tool, AbstractTab tab) {
        if (tool instanceof Drill && tab instanceof TabDrill) {
            calculationLengthPointDrill((Drill) tool, (TabDrill) tab);
        }
        if (tool instanceof Tap && tab instanceof TabTap) {
            calculationModesTap((Tap) tool, (TabTap) tab);
        }
    }

    /**
     * Метод проверяет стоит ли флажек во вкладке. Если стоит расчет подачи ведется для станка ГФ2171, иначе
     * расчет подачи ведется по обычному варианту
     * @param tool инструмент
     * @param tab вкладка
     * @return возвращает подачу для ГФ2171 если true(флажек установлен), возвращает расчетную подачу если false(флажек
     * не установлен)
     */
    private int calculateWithCheckBox(AbstractTool tool, AbstractTab tab) {
        int turns;
        if (tab.isCheckBox()) {
            turns = tool.calculateTurnsGF(tool.calculateTurns(numberDiameter));
        } else {
            turns = tool.calculateTurns(numberDiameter);
        }
        tab.getFieldTurns().setText("" + turns);
        return turns;
    }

    /**
     * Метод проверяет поле диаметра на наличие числа
     * @param tool инструмент
     * @param tab вкладка
     * @return возвращает false, если в поле число отсутствует
     */
    private boolean conditionInputDiameter(AbstractTool tool, AbstractTab tab) {
        String stringDiameter = tab.getFieldDiameter().getText();
        if (stringDiameter.equals("")) {
            massageForDiameter(tool, tab);
            return false;
        }
        field.getMessageError().setText("");
        numberDiameter = Double.parseDouble(stringDiameter);
        return allowableDiameter(tool, tab, numberDiameter);
    }

    /**
     * Метод проверяет попадает ли диаметр инструмента в диапазон
     * @param tool инструмент
     * @param tab вкладка
     * @param diameter диаметр инструмента
     * @return возвращает true если диаметр вошел в диапазон и false если не вошел
     */
    private boolean allowableDiameter(AbstractTool tool, AbstractTab tab, double diameter) {
        if (diameter >= tool.getMinDiameter() && diameter <= tool.getMaxDiameter()) {
            return true;
        } else {
            massageForDiameter(tool, tab);
        }
        return false;
    }

    /**
     * Метод выводит сообщение о нужном размере диаметра инструмента
     * @param tool инструмент
     * @param tab вкладка
     */
    private void massageForDiameter(AbstractTool tool, AbstractTab tab) {
        field.getMessageError().setForeground(Color.red);
        field.getMessageError().setText("Введите диаметр инструмента от " + (int) tool.getMinDiameter() + " до " + (int) tool.getMaxDiameter() + " мм!");
        tab.getFieldFeed().setText("");
        tab.getFieldTurns().setText("0");
        tab.getFieldMachineFeed().setText("0");
        tab.getLabelFormulaTurnsFeed().setText("");
    }

    /**
     * Метод проверяет поле подачи
     * @param tool инструмент
     * @param tab вкладка
     * @return возвращает true если поле не пустое и подача в указанном диапазоне, false если
     * поле пустое или находится не в указанном диапазоне значений
     */
    private boolean conditionInputDiameterFeed(AbstractTool tool, AbstractTab tab) {
        String stringFeed = tab.getFieldFeed().getText();
        numberFeed = Double.parseDouble(stringFeed);
        return !stringFeed.equals("") && allowableFeed(tool, tab, numberFeed);
    }

    /**
     * Метод проверяет поле подачи
     * @param tool инструмент
     * @param tab вкладка
     * @param feed подача
     * @return возвращает true если поле в указанном диапазоне, false если
     * поле не в указанном диапазоне значений
     */
    private boolean allowableFeed(AbstractTool tool, AbstractTab tab, double feed) {
        if (feed >= tool.getMinFeed() && feed <= tool.getMaxFeed()) {
            return true;
        } else {
            field.getMessageError().setForeground(Color.red);
            field.getMessageError().setText("Введите подачу инструмента от " + tool.getMinFeed() + " до " + tool.getMaxFeed() + " мм/об!");
            tab.getFieldTurns().setText("0");
            tab.getFieldMachineFeed().setText("0");
            tab.getLabelFormulaTurnsFeed().setText("");
        }
        return feed >= tool.getMinFeed() && feed <= tool.getMaxFeed();
    }

    /**
     * Метод проверяет входит ли диаметр сверла в диапазон. Если входит , торассчитывается длина острого конца сверла,
     * если не входит в поле остается значение 0
     * @param drill инструмент сверло
     * @param tab вкладка сверло
     */
    private void calculationLengthPointDrill(Drill drill, TabDrill tab) {
        if (numberDiameter >= drill.getMinDiameter() && numberDiameter <= drill.getMaxDiameter()) {
            if (drill.lengthPointDrill(numberDiameter) % 1 == 0) {
                tab.getFieldBlade().setText("" + (int) drill.lengthPointDrill(numberDiameter));
            } else {
                tab.getFieldBlade().setText(String.format("%.2f", drill.lengthPointDrill(numberDiameter)).replaceAll("\\.?0*$", ""));
            }
        } else {
            tab.getFieldBlade().setText("0");
        }
    }

    /**
     * Метод рассчитывает режимы резания метчика
     * @param tool инструмент метчик
     * @param tab вкладка метчик
     */
    private void calculationModesTap(Tap tool, TabTap tab) {
        tab.getFieldDrill().setText(String.format("%.2f", tool.calculateDiameterDrill(numberDiameter, numberFeed)));
    }

    /**
     * Метод выбирает вкладку в которой требуется удались содержимое полей
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
            field.getMessageError().setText("");
            tabTap.getFieldDiameter().setText("");
            tabTap.getFieldTurns().setText("0");
            tabTap.getFieldMachineFeed().setText("0");
            tabTap.getFieldDrill().setText("0");
            tabTap.getLabelFormulaTurnsFeed().setText("");
        }
    }

    /**
     * Метод очищает все поля вкладки
     * @param tab вкладка
     */
    private void deleteContentField(AbstractTab tab) {
        field.getMessageError().setText("");
        tab.getFieldDiameter().setText("");
        tab.getFieldFeed().setText("");
        tab.getFieldTurns().setText("0");
        tab.getFieldMachineFeed().setText("0");
        tab.getLabelFormulaTurnsFeed().setText("");
    }
}
