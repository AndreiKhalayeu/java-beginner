package engineeringtechnology.graphicfield;

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
            calculationModes();
        } else if (clickedButton == field.getButtonStop()){
            deleteContentField();
        }
    }

    private void calculationModes() {
        if (nameTab.equals("фреза")) {
            Cutter cutter = new Cutter();
            //System.out.println("фреза");
            try {
                if (!tabCutter.getFieldDiameter().getText().equals(" ") && Integer.parseInt(tabCutter.getFieldDiameter().getText()) > 9
                        && Integer.parseInt(tabCutter.getFieldDiameter().getText()) < 51) {
                    tabCutter.getFieldTurns().setText("" + cutter.calculateTurns(Cutter.SPEED, Integer.parseInt(tabCutter.getFieldDiameter().getText())));
                }
            } catch (NumberFormatException e) {
                tabCutter.getFieldTurns().setText("");
            }
        }
        if (nameTab.equals("сверло")) {
            Drill drill = new Drill();
            //System.out.println("сверло");
            try {
                if (!tabDrill.getFieldDiameter().getText().equals(" ") && Integer.parseInt(tabDrill.getFieldDiameter().getText()) > 5
                        && Integer.parseInt(tabDrill.getFieldDiameter().getText()) < 51) {
                    tabDrill.getFieldTurns().setText("" + drill.calculateTurns(Drill.SPEED, Integer.parseInt(tabDrill.getFieldDiameter().getText())));
                }
            } catch (NumberFormatException e) {
                tabDrill.getFieldTurns().setText("");
            }
        }
        if (nameTab.equals("зенкер")) {
            Countersink countersink = new Countersink();
            //System.out.println("зенкер");
            try {
                if (!tabCountersink.getFieldDiameter().getText().equals(" ") && Integer.parseInt(tabCountersink.getFieldDiameter().getText()) > 7
                        && Integer.parseInt(tabCountersink.getFieldDiameter().getText()) < 41) {
                    tabCountersink.getFieldTurns().setText("" + countersink.calculateTurns(Countersink.SPEED, Integer.parseInt(tabCountersink.getFieldDiameter().getText())));
                }
            } catch (NumberFormatException e) {
                tabCountersink.getFieldTurns().setText("");
            }
        }
        if (nameTab.equals("развертка")) {
            Sweep sweep = new Sweep();
            //System.out.println("развертка");
            try {
                if (!tabSweep.getFieldDiameter().getText().equals(" ") && Integer.parseInt(tabSweep.getFieldDiameter().getText()) > 7
                        && Integer.parseInt(tabSweep.getFieldDiameter().getText()) < 41) {
                    tabSweep.getFieldTurns().setText("" + sweep.calculateTurns(Sweep.SPEED, Integer.parseInt(tabSweep.getFieldDiameter().getText())));
                }
            } catch (NumberFormatException e) {
                tabSweep.getFieldTurns().setText("");
            }
        }
        if (nameTab.equals("метчик")) {
            Tap tap = new Tap();
            //System.out.println("метчик");
            try {
                if (!tabTap.getFieldDiameter().getText().equals(" ") && Integer.parseInt(tabTap.getFieldDiameter().getText()) > 5
                        && Integer.parseInt(tabTap.getFieldDiameter().getText()) < 35) {
                    tabTap.getFieldTurns().setText("" + tap.calculateTurns(Tap.SPEED, Integer.parseInt(tabTap.getFieldDiameter().getText())));
                }
            } catch (NumberFormatException e) {
                tabTap.getFieldTurns().setText("");
            }
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
