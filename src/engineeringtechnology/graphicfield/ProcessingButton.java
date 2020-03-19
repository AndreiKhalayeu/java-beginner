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
        if (ProcessingTab.getNumberTab() == 0 && ProcessingComboBox.getNumberBox() == 0) {
            Cutter cutter = new Cutter();
            calculationModesTool(cutter, tabCutter, ProcessingCheckBox.getCheckCutter());
        }
        if (ProcessingTab.getNumberTab() == 0 && ProcessingComboBox.getNumberBox() == 1) {
            CutterButt cutterButt = new CutterButt();
            calculationModesTool(cutterButt, tabCutter, ProcessingCheckBox.getCheckCutter());
        }
        if (ProcessingTab.getNumberTab() == 1 && ProcessingComboBox.getNumberBox() == 0) {
            Drill drill = new Drill();
            calculationModesTool(drill, tabDrill, ProcessingCheckBox.getCheckDrill());
            calculationLengthPointDrill(drill, tabDrill);
        }
        if (ProcessingTab.getNumberTab() == 1 && ProcessingComboBox.getNumberBox() == 1) {
            // создать объект для другого сверла
            Drill drill = new Drill();
            calculationModesTool(drill, tabDrill, ProcessingCheckBox.getCheckDrill());
            calculationLengthPointDrill(drill, tabDrill);
        }
        if (ProcessingTab.getNumberTab() == 2 && ProcessingComboBox.getNumberBox() == 0) {
            Countersink countersink = new Countersink();
            calculationModesTool(countersink, tabCountersink, ProcessingCheckBox.getCheckCountersink());
        }
        if (ProcessingTab.getNumberTab() == 2 && ProcessingComboBox.getNumberBox() == 1) {
            CountersinkButt countersinkButt = new CountersinkButt();
            calculationModesTool(countersinkButt, tabCountersink, ProcessingCheckBox.getCheckCountersink());
        }
        if (ProcessingTab.getNumberTab() == 3 && ProcessingComboBox.getNumberBox() == 0) {
            Sweep sweep = new Sweep();
            calculationModesTool(sweep, tabSweep, ProcessingCheckBox.getCheckSweep());
        }
        if (ProcessingTab.getNumberTab() == 3 && ProcessingComboBox.getNumberBox() == 1) {
            //создать объект для конусной
            Sweep sweep = new Sweep();
            calculationModesTool(sweep, tabSweep, ProcessingCheckBox.getCheckSweep());
        }
        if (ProcessingTab.getNumberTab() == 4 && ProcessingComboBox.getNumberBox() == 0) {
            Tap tap = new Tap();
            calculationModesTool(tap, tabTap, ProcessingCheckBox.getCheckTap());
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
