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
            Cutter cutter = new Cutter();
            calculationModesTool(cutter, tabCutter);

        }
        if ("сверло".equals(nameTab)) {
            Drill drill = new Drill();
            calculationModesTool(drill, tabDrill);
            calculationLengthPointDrill(drill, tabDrill);
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
        try {
            if (conditionInputDiameter(tool, tab) && conditionInputDiameterFeed(tool, tab)) {
                tab.getFieldTurns().setText("" + tool.calculateTurns(numberDiameter));
                tab.getFieldMachineFeed().setText("" + tool.calculateFeed(numberFeed, tool.calculateTurns(numberDiameter)));
                tab.getFieldFeed().setText("" + numberFeed);
            }
        } catch (NumberFormatException e) {
            tab.getFieldTurns().setText("" + tool.calculateTurns(numberDiameter));
            tab.getFieldMachineFeed().setText("" + tool.calculateFeed(tool.calculateTurns(numberDiameter)));
            tab.getFieldFeed().setText("" + tool.getFeed());
        }
    }

    private boolean conditionInputDiameter(AbstractTool tool, TabCutter tab) {
        String stringDiameter = tab.getFieldDiameter().getText();
        try {
            if (stringDiameter.equals("")) {
                numberDiameter = Integer.parseInt(stringDiameter);
            }
        } catch (NumberFormatException e) {
            System.out.println("введи диаметр");
            tab.getFieldTurns().setText("0");
            tab.getFieldMachineFeed().setText("0");
            tab.getFieldFeed().setText("");
            numberDiameter = 0;
            return false;
        }
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

    private void calculationLengthPointDrill(Drill drill, TabDrill tab) {
        if (numberDiameter >= drill.getMinDiameter() && numberDiameter <= drill.getMaxDiameter()) {
            tab.getFieldBlade().setText("" + drill.lengthPointDrill(numberDiameter));
        } else {
            tab.getFieldBlade().setText("0");
        }
    }

    private void deleteContentField() {
        tabDrill.getFieldDiameter().setText("");
        tabDrill.getFieldTurns().setText("0");
        tabDrill.getFieldFeed().setText("");
        tabDrill.getFieldMachineFeed().setText("0");
        tabDrill.getFieldBlade().setText("0");
    }

    public static void setNameTab(String nameTab) {
        ProcessingField.nameTab = nameTab;
    }
}
