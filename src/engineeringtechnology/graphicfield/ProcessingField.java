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
            Cutter cutter = new Cutter();
            calculationModesTool(cutter, tabCutter);
        }
        if ("сверло".equals(nameTab)) {
            Drill drill = new Drill();
            calculationModesTool(drill, tabDrill);
        }
        if ("зенкер".equals(nameTab)) {
            Countersink countersink = new Countersink();
            calculationModesTool(countersink, tabCountersink);
        }
        if ("развертка".equals(nameTab)) {
            Sweep sweep = new Sweep();
            calculationModesTool(sweep, tabSweep);
        }
        if ("метчик".equals(nameTab)) {
            Tap tap = new Tap();
            calculationModesTool(tap, tabTap);
        }
    }

    private void calculationModesTool(AbstractTool tool, TabCutter tab) {
        int number = Integer.parseInt(tab.getFieldDiameter().getText());
        String string = tab.getFieldDiameter().getText();
        try {
            if (!string.equals(" ") && number > 9 && number < 51) {
                tab.getFieldTurns().setText("" + tool.calculateTurns(number));
                tab.getFieldMachineFeed().setText("" + tool.calculateFeed(tool.calculateTurns(number)));
                tab.getFieldFeed().setText("" + tool.getFeed());
            }
        } catch (NumberFormatException e) {
            tab.getFieldTurns().setText("");
            tab.getFieldFeed().setText("");
            tab.getFieldMachineFeed().setText("");
        }
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
