package engineeringtechnology.graphicfield;

import engineeringtechnology.cuttingmodes.AbstractTool;
import engineeringtechnology.cuttingmodes.tool.*;
import engineeringtechnology.graphicfield.tabs.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProcessingButton implements ActionListener {
    private Field field;
    private TabCountersink tabCountersink;
    private TabCutter tabCutter;
    private TabDrill tabDrill;
    private TabSweep tabSweep;
    private TabTap tabTap;
    private double numberDiameter;
    private double numberFeed;
    private static String nameTab = "фреза";
    private static String nameComboBox = "Коническая фреза";
    private static boolean check = false;

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
        if (clickedButton == field.getButtonStart()) {
            selectTab();
        } else if (clickedButton == field.getButtonStop()) {
            deleteSelectTab();
        }
    }

    private void selectTab() {
        if ("фреза".equals(nameTab) && "Коническая фреза".equals(nameComboBox)) {
            Cutter cutter = new Cutter();
            calculationModesTool(cutter, tabCutter, check);
        }
        if ("фреза".equals(nameTab) && "Торцевая фреза".equals(nameComboBox)) {
            CutterButt cutterButt = new CutterButt();
            calculationModesTool(cutterButt, tabCutter, check);
        }
        if ("сверло".equals(nameTab)) {
            Drill drill = new Drill();
            calculationModesTool(drill, tabDrill, check);
            calculationLengthPointDrill(drill, tabDrill);
        }
        if ("зенкер".equals(nameTab)) {
            Countersink countersink = new Countersink();
            calculationModesTool(countersink, tabCountersink, check);
        }
        if ("развертка".equals(nameTab)) {
            Sweep sweep = new Sweep();
            calculationModesTool(sweep, tabSweep, check);
        }
        if ("метчик".equals(nameTab)) {
            Tap tap = new Tap();
            calculationModesTool(tap, tabTap, check);
        }
    }

    private void calculationModesTool(AbstractTool tool, TabCutter tab, boolean check) {
        try {
            if (conditionInputDiameter(tool, tab) && conditionInputDiameterFeed(tool, tab)) {
                check(tool, tab, check);
                tab.getFieldMachineFeed().setText("" + tool.calculateFeed(numberFeed, tool.calculateTurns(numberDiameter)));
                tab.getFieldFeed().setText("" + numberFeed);
            }
        } catch (NumberFormatException e) {
            field.getMessageError().setForeground(Color.green);
            field.getMessageError().setText("Установлена средняя подача S=" + tool.getFeed() + " мм/об");
            check(tool, tab, check);
            tab.getFieldMachineFeed().setText("" + tool.calculateFeed(tool.calculateTurns(numberDiameter)));
            tab.getFieldFeed().setText("" + tool.getFeed());
        }
    }

    private void check(AbstractTool tool, TabCutter tab, boolean check) {
        if (check) {
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
            field.getMessageError().setForeground(Color.red);
            field.getMessageError().setText("Введите диаметр инструмента от " + (int)tool.getMinDiameter() + " до " + (int)tool.getMaxDiameter() + " мм!");
            tab.getFieldTurns().setText("0");
            tab.getFieldMachineFeed().setText("0");
            tab.getFieldFeed().setText("");
            numberDiameter = 0;
            return false;
        }
        field.getMessageError().setText("");
        numberDiameter = Double.parseDouble(stringDiameter);
        return !stringDiameter.equals("") && allowableDiameter(tool, numberDiameter);
    }

    private boolean conditionInputDiameterFeed(AbstractTool tool, TabCutter tab) {
        String stringFeed = tab.getFieldFeed().getText();
        numberFeed = Double.parseDouble(stringFeed);
        return !stringFeed.equals("") && allowableFeed(tool, numberFeed);
    }

    private boolean allowableDiameter(AbstractTool tool, double diameter) {
        return diameter >= tool.getMinDiameter() && diameter <= tool.getMaxDiameter();
    }

    private boolean allowableFeed(AbstractTool tool, double feed) {
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
        if ("фреза".equals(nameTab)) {
            deleteContentField(tabCutter);
        }
        if ("сверло".equals(nameTab)) {
            deleteContentField(tabDrill);
            tabDrill.getFieldBlade().setText("0");
        }
        if ("зенкер".equals(nameTab)) {
            deleteContentField(tabCountersink);
        }
        if ("развертка".equals(nameTab)) {
            deleteContentField(tabSweep);
        }
        if ("метчик".equals(nameTab)) {
            tabTap.getFieldDiameter().setText("");
            tabTap.getFieldTurns().setText("0");
            tabTap.getFieldMachineFeed().setText("0");
            tabTap.getFieldDrill().setText("0");
        }
    }

    private void deleteContentField(TabCutter tab) {
        tab.getFieldDiameter().setText("");
        tab.getFieldTurns().setText("0");
        tab.getFieldFeed().setText("");
        tab.getFieldMachineFeed().setText("0");
    }

    public static void setNameTab(String nameTab) {
        ProcessingButton.nameTab = nameTab;
    }

    public static void setNameComboBox(String nameComboBox) {
        ProcessingButton.nameComboBox = nameComboBox;
    }

    public static boolean getCheck() {
        return check;
    }

    public static void setCheck(boolean check) {
        ProcessingButton.check = check;
    }
}
