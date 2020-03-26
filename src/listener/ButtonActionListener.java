package listener;

import engineeringtechnology.cuttingmodes.AbstractTool;
import engineeringtechnology.cuttingmodes.data.DataGF;
import engineeringtechnology.cuttingmodes.tool.*;
import engineeringtechnology.graphicfield.Field;
import engineeringtechnology.graphicfield.tabs.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonActionListener implements ActionListener {
    private Field field;
    private TabCountersink tabCountersink;
    private TabCutter tabCutter;
    private TabDrill tabDrill;
    private TabSweep tabSweep;
    private TabTap tabTap;
    private double numberDiameter;
    private double numberFeed;

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
        JButton clickedButton = (JButton)e.getSource();
        TabCutter tab = getTab(TabActionListener.getNumberTab());
        int numberComboBox = getNumberComboBox(TabActionListener.getNumberTab());
        AbstractTool tool = getTool(TabActionListener.getNumberTab(), numberComboBox);
        if (clickedButton == field.getButtonStart()) {
            calculationModesTool(tool, tab);
        } else if (clickedButton == field.getButtonStop()) {
            deleteSelectTab();
        }
    }

    private AbstractTool getTool(int numberTab, int numberComboBox) {
        for (int i = 0; i < DataGF.LIST_TOOL.size(); i++) {
            if (numberTab == i) {
                for (int j = 0; j < DataGF.LIST_TOOL.get(i).size(); j++) {
                    if (numberComboBox == j) {
                        return DataGF.LIST_TOOL.get(i).get(j);
                    }
                }
            }
        }
        return null;
    }

    private int getNumberComboBox(int numberTab) {
        for (int i = 0; i < DataGF.LIST_TAB.size(); i++) {
            if (numberTab == i) {
                return DataGF.LIST_TAB.get(i).getNumberComboBox();
            }
        }
        return 0;
    }

    private TabCutter getTab(int numberTab) {
        for (int i = 0; i < DataGF.LIST_TAB.size(); i++) {
            if (numberTab == i) {
                return DataGF.LIST_TAB.get(i);
            }
        }
        return null;
    }

//    private AbstractTool getTool(int numberTab, int numberComboBox) {
//        for (int i = 0; i < DataGF.LIST_TOOL.size(); i++) {
//            if (numberTab == i) {
//                for (int j = 0; j < DataGF.LIST_TOOL.get(i).size(); j++) {
//                    if (numberComboBox == j) {
//                        return DataGF.LIST_TOOL.get(i).get(j);
//                    }
//                }
//            }
//        }
//        return null;
//    }
//
//    private int getNumberComboBox(int numberTab) {
//        for (int i = 0; i < DataGF.LIST_TAB.size(); i++) {
//            if (numberTab == i) {
//                return DataGF.LIST_TAB.get(i).getNumberComboBox();
//            }
//        }
//        return 0;
//    }
//
//    private TabCutter getTab(int numberTab) {
//        for (int i = 0; i < DataGF.LIST_TAB.size(); i++) {
//            if (numberTab == i) {
//                return DataGF.LIST_TAB.get(i);
//            }
//        }
//        return null;
//    }

    private void calculationModesTool(AbstractTool tool, TabCutter tab) {
        try {
            if (conditionInputDiameter(tool, tab) && conditionInputDiameterFeed(tool, tab)) {
                calculateWithCheckBox(tool, tab);
                tab.getFieldMachineFeed().setText("" + tool.calculateFeed(numberFeed, tool.calculateTurns(numberDiameter)));
                tab.getFieldFeed().setText("" + numberFeed);
                tab.getLabelFormulaTurnsFeed().setText("n = 1000 * " + tool.getSpeed() + " / 3.14 * " + numberDiameter + ", об/мин" + "  F = " + tool.calculateTurns(numberDiameter) + " * " + numberFeed + ", мм/мин");
            }
        } catch (NumberFormatException e) {
            field.getMessageError().setForeground(Color.green);
            field.getMessageError().setText("Установлена средняя подача S=" + tool.getFeed() + " мм/об");
            calculateWithCheckBox(tool, tab);
            tab.getFieldMachineFeed().setText("" + tool.calculateFeed(tool.calculateTurns(numberDiameter)));
            tab.getFieldFeed().setText("" + tool.getFeed());
            tab.getLabelFormulaTurnsFeed().setText("n = 1000 * " + tool.getSpeed() + " / 3.14 * " + numberDiameter + ", об/мин" + "  F = " + tool.calculateTurns(numberDiameter) + " * " + tool.getFeed() + ", мм/мин");
        }
    }

    private void calculateWithCheckBox(AbstractTool tool, TabCutter tab) {
        if (tab.isCheckBox()) {
            tab.getFieldTurns().setText("" + tool.calculateTurnsGF(tool.calculateTurns(numberDiameter)));
        } else {
            tab.getFieldTurns().setText("" + tool.calculateTurns(numberDiameter));
        }
    }

    private boolean conditionInputDiameter(AbstractTool tool, TabCutter tab) {
        String stringDiameter = tab.getFieldDiameter().getText();
        if (stringDiameter.equals("")) {
            massageForDiameter(tool, tab);
            return false;
        }
        field.getMessageError().setText("");
        numberDiameter = Double.parseDouble(stringDiameter);
        return allowableDiameter(tool, tab, numberDiameter);
    }

    private boolean allowableDiameter(AbstractTool tool, TabCutter tab, double diameter) {
        if (diameter >= tool.getMinDiameter() && diameter <= tool.getMaxDiameter()) {
            return true;
        } else {
            massageForDiameter(tool, tab);
        }
        return false;
    }

    private void massageForDiameter(AbstractTool tool, TabCutter tab) {
        field.getMessageError().setForeground(Color.red);
        field.getMessageError().setText("Введите диаметр инструмента от " + (int)tool.getMinDiameter() + " до " + (int)tool.getMaxDiameter() + " мм!");
        tab.getFieldFeed().setText("");
        tab.getFieldTurns().setText("0");
        tab.getFieldMachineFeed().setText("0");
        tab.getLabelFormulaTurnsFeed().setText("");
    }

    private boolean conditionInputDiameterFeed(AbstractTool tool, TabCutter tab) {
        String stringFeed = tab.getFieldFeed().getText();
        numberFeed = Double.parseDouble(stringFeed);
        return !stringFeed.equals("") && allowableFeed(tool, tab, numberFeed);
    }

    private boolean allowableFeed(AbstractTool tool, TabCutter tab, double feed) {
        if (feed >= tool.getMinFeed() && feed <= tool.getMaxFeed()) {
            return true;
        } else {
            field.getMessageError().setForeground(Color.red);
            field.getMessageError().setText("Введите подачу инструмента от " + tool.getMinFeed()+ " до " + tool.getMaxFeed() + " мм!");
            tab.getFieldTurns().setText("0");
            tab.getFieldMachineFeed().setText("0");
            tab.getLabelFormulaTurnsFeed().setText("");
        }
        return feed >= tool.getMinFeed() && feed <= tool.getMaxFeed();
    }

    private void calculationLengthPointDrill(Drill drill, TabDrill tab) {
        if (numberDiameter >= drill.getMinDiameter() && numberDiameter <= drill.getMaxDiameter()) {
            if (drill.lengthPointDrill(numberDiameter) % 1 == 0) {
                tab.getFieldBlade().setText("" + (int)drill.lengthPointDrill(numberDiameter));
            } else {
                tab.getFieldBlade().setText(String.format("%.2f", drill.lengthPointDrill(numberDiameter)).replaceAll("\\.?0*$", ""));
            }
        } else {
            tab.getFieldBlade().setText("0");
        }
    }

    private void deleteSelectTab() {
        if (TabActionListener.getNumberTab() == 0) {
            deleteContentField(tabCutter);
        }
        if (TabActionListener.getNumberTab() == 1) {
            deleteContentField(tabDrill);
            tabDrill.getFieldBlade().setText("0");
        }
        if (TabActionListener.getNumberTab() == 2) {
            deleteContentField(tabCountersink);
        }
        if (TabActionListener.getNumberTab() == 3) {
            deleteContentField(tabSweep);
        }
        if (TabActionListener.getNumberTab() == 4) {
            field.getMessageError().setText("");
            tabTap.getFieldDiameter().setText("");
            tabTap.getFieldTurns().setText("0");
            tabTap.getFieldMachineFeed().setText("0");
            tabTap.getFieldDrill().setText("0");
            tabTap.getLabelFormulaTurnsFeed().setText("");
        }
    }

    private void deleteContentField(TabCutter tab) {
        field.getMessageError().setText("");
        tab.getFieldDiameter().setText("");
        tab.getFieldFeed().setText("");
        tab.getFieldTurns().setText("0");
        tab.getFieldMachineFeed().setText("0");
        tab.getLabelFormulaTurnsFeed().setText("");
    }
}
