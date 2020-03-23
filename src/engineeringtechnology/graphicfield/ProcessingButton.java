package engineeringtechnology.graphicfield;

import engineeringtechnology.cuttingmodes.AbstractTool;
import engineeringtechnology.cuttingmodes.data.DataGF;
import engineeringtechnology.cuttingmodes.tool.*;
import engineeringtechnology.graphicfield.tabs.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class ProcessingButton implements ActionListener {
    private Field field;
    private TabCountersink tabCountersink;
    private TabCutter tabCutter;
    private TabDrill tabDrill;
    private TabSweep tabSweep;
    private TabTap tabTap;
    private double numberDiameter;
    private double numberFeed;

    ProcessingButton(Field field, TabCountersink tabCountersink, TabCutter tabCutter, TabDrill tabDrill,
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
        TabCutter tab = getTab(ProcessingTab.getNumberTab());
        int numberBox = getBox(ProcessingTab.getNumberTab());
        AbstractTool tool = getTool(ProcessingTab.getNumberTab(), numberBox);
        if (clickedButton == field.getButtonStart()) {
            calculationModesTool(tool, tab);
        } else if (clickedButton == field.getButtonStop()) {
            deleteSelectTab();
        }
    }

    private AbstractTool getTool(int numberTab, int numberBox) {
        ArrayList<AbstractTool> list;
        AbstractTool tool = null;
        Set<Map.Entry<Integer, ArrayList<AbstractTool>>> dataTool = DataGF.LIST_TOOL.entrySet();
        for (Map.Entry<Integer, ArrayList<AbstractTool>> value : dataTool) {
            if (numberTab == value.getKey()) {
                list = value.getValue();
                for (int i = 0; i < list.size(); i++) {
                    if (numberBox == i) {
                        tool = list.get(i);
                    }
                }
            }
        }
        return tool;
    }

    private int getBox(int numberTab) {
        int numberBox = 0;
        Set<Map.Entry<Integer, TabCutter>> dataTool = DataGF.LIST_TAB.entrySet();
        for (Map.Entry<Integer, TabCutter> value : dataTool) {
            if (numberTab == value.getKey()) {
                numberBox = value.getValue().getNumberBox();
            }
        }
        return numberBox;
    }

    private TabCutter getTab(int numberTab) {
        TabCutter tab = null;
        Set<Map.Entry<Integer, TabCutter>> dataTool = DataGF.LIST_TAB.entrySet();
        for (Map.Entry<Integer, TabCutter> value : dataTool) {
            if (numberTab == value.getKey()) {
                tab = value.getValue();
            }
        }
        return tab;
    }

    private void calculationModesTool(AbstractTool tool, TabCutter tab) {
        try {
            if (conditionInputDiameter(tool, tab) && conditionInputDiameterFeed(tool, tab)) {
                check(tool, tab);
                tab.getFieldMachineFeed().setText("" + tool.calculateFeed(numberFeed, tool.calculateTurns(numberDiameter)));
                tab.getFieldFeed().setText("" + numberFeed);
            }
        } catch (NumberFormatException e) {
            field.getMessageError().setForeground(Color.green);
            field.getMessageError().setText("Установлена средняя подача S=" + tool.getFeed() + " мм/об");
            check(tool, tab);
            tab.getFieldMachineFeed().setText("" + tool.calculateFeed(tool.calculateTurns(numberDiameter)));
            tab.getFieldFeed().setText("" + tool.getFeed());
        }
    }

    private void check(AbstractTool tool, TabCutter tab) {
        if (tab.isCheck()) {
            tab.getFieldTurns().setText("" + tool.calculateTurnsGF(tool.calculateTurns(numberDiameter)));
        } else {
            tab.getFieldTurns().setText("" + tool.calculateTurns(numberDiameter));
        }
    }

    private boolean conditionInputDiameter(AbstractTool tool, TabCutter tab) {
        String stringDiameter = tab.getFieldDiameter().getText();
        try {
            if (stringDiameter.equals("")) {
                numberDiameter = Double.parseDouble(stringDiameter);
            }
        } catch (NumberFormatException e) {
            massageForDiameter(tool, tab);
            return false;
        }
        field.getMessageError().setText("");
        numberDiameter = Double.parseDouble(stringDiameter);
        return !stringDiameter.equals("") && allowableDiameter(tool, tab, numberDiameter);
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
        tab.getFieldTurns().setText("0");
        tab.getFieldMachineFeed().setText("0");
        tab.getFieldFeed().setText("");
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
        if (ProcessingTab.getNumberTab() == 0) {
            deleteContentField(tabCutter);
        }
        if (ProcessingTab.getNumberTab() == 1) {
            deleteContentField(tabDrill);
            tabDrill.getFieldBlade().setText("0");
        }
        if (ProcessingTab.getNumberTab() == 2) {
            deleteContentField(tabCountersink);
        }
        if (ProcessingTab.getNumberTab() == 3) {
            deleteContentField(tabSweep);
        }
        if (ProcessingTab.getNumberTab() == 4) {
            field.getMessageError().setText("");
            tabTap.getFieldDiameter().setText("");
            tabTap.getFieldTurns().setText("0");
            tabTap.getFieldMachineFeed().setText("0");
            tabTap.getFieldDrill().setText("0");
        }
    }

    private void deleteContentField(TabCutter tab) {
        field.getMessageError().setText("");
        tab.getFieldDiameter().setText("");
        tab.getFieldTurns().setText("0");
        tab.getFieldFeed().setText("");
        tab.getFieldMachineFeed().setText("0");
    }
}
