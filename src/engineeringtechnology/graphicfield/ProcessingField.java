package engineeringtechnology.graphicfield;

import engineeringtechnology.cuttingmodes.AbstractTool;
import engineeringtechnology.cuttingmodes.tool.*;
import engineeringtechnology.graphicfield.tabs.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProcessingField implements ActionListener {
    private Field field;
    private TabCountersink tabCountersink;
    private TabCutter tabCutter;
    private TabDrill tabDrill;
    private TabSweep tabSweep;
    private TabTap tabTap;
    private int numberDiameter;
    private double numberFeed;
    private static String nameTab = "фреза";

    ProcessingField(Field field, TabCountersink tabCountersink, TabCutter tabCutter, TabDrill tabDrill,
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

        if (clickedButton == field.getButtonStart()) {
            selectTab();
        } else if (clickedButton == field.getButtonStop()){
            deleteContentField();
        }
    }

    private void selectTab() {
        if ("фреза".equals(nameTab)) {
            Cutter cutter = new Cutter(25,0.2,5,65,0.1,0.3);
            calculationModesTool(cutter, tabCutter);
        }
        if ("сверло".equals(nameTab)) {
            Drill drill = new Drill(18,0.2, 4, 50, 0.1, 0.3);
            calculationModesTool(drill, tabDrill);
        }
        if ("зенкер".equals(nameTab)) {
            Countersink countersink = new Countersink(12, 0.3, 7, 60, 0.2, 0.4);
            calculationModesTool(countersink, tabCountersink);
        }
        if ("развертка".equals(nameTab)) {
            Sweep sweep = new Sweep(8, 0.5,4,50,0.4,0.6);
            calculationModesTool(sweep, tabSweep);
        }
        if ("метчик".equals(nameTab)) {
            Tap tap = new Tap(6, 1,6,30,0.8,3.5);
            calculationModesTool(tap, tabTap);
        }
    }

    private void calculationModesTool(AbstractTool tool, TabCutter tab) {
        try {
            if (conditionInputDiameter(tool, tab) && conditionInputDiameterFeed(tool, tab)) {
                tab.getFieldTurns().setText("" + tool.calculateTurns(numberDiameter));
                tab.getFieldMachineFeed().setText("" + tool.calculateFeed(numberFeed, tool.calculateTurns(numberDiameter)));
            }
            if (conditionInputDiameter(tool, tab)) {
                tab.getFieldTurns().setText("" + tool.calculateTurns(numberDiameter));
                tab.getFieldMachineFeed().setText("" + tool.calculateFeed(tool.calculateTurns(numberDiameter)));
                tab.getFieldFeed().setText("" + tool.getFeed());
            }
        } catch (NumberFormatException e) {
            System.out.println("76445");
        }
    }

    private boolean conditionInputDiameter(AbstractTool tool, TabCutter tab) {
        String stringDiameter = tab.getFieldDiameter().getText();
        numberDiameter = Integer.parseInt(stringDiameter);
        return !stringDiameter.equals("") && allowableDiameter(tool, numberDiameter);
    }

    private boolean conditionInputDiameterFeed(AbstractTool tool, TabCutter tab) {
        String stringFeed = tab.getFieldFeed().getText();
        numberFeed = Double.parseDouble(stringFeed);
        return !stringFeed.equals("") && allowableFeed(tool, numberFeed);
    }

    private boolean allowableDiameter(AbstractTool tool, int diameter) {
        return diameter >= tool.getMinDiameter() && diameter <= tool.getMaxDiameter();
    }

    private boolean allowableFeed(AbstractTool tool, double feed) {
        return feed >= tool.getMinFeed() && feed <= tool.getMaxFeed();
    }






    private void deleteContentField() {
        tabCutter.getFieldDiameter().setText("");
        tabCutter.getFieldTurns().setText("");
        tabCutter.getFieldMachineFeed().setText("");
    }

    public static void setNameTab(String nameTab) {
        ProcessingField.nameTab = nameTab;
    }
}
