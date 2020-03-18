package engineeringtechnology.graphicfield;

import engineeringtechnology.graphicfield.tabs.TabCutter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProcessingCheckBox implements ActionListener {
    private TabCutter tabCutter;
    private static boolean checkCutter = false;
    private static boolean checkDrill = false;
    private static boolean checkCountersink = false;
    private static boolean checkSweep = false;
    private static boolean checkTap = false;

    public ProcessingCheckBox(TabCutter tabCutter) {
        this.tabCutter = tabCutter;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JCheckBox clickedCheckBox = (JCheckBox) e.getSource();
        if (clickedCheckBox == tabCutter.getCheckBox() && "фреза".equals(ProcessingTab.getNameTab())) {
            checkCutter = !checkCutter;
        }
        if (clickedCheckBox == tabCutter.getCheckBox() && "сверло".equals(ProcessingTab.getNameTab())) {
            checkDrill = !checkDrill;
        }
        if (clickedCheckBox == tabCutter.getCheckBox() && "зенкер".equals(ProcessingTab.getNameTab())) {
            checkCountersink = !checkCountersink;
        }
        if (clickedCheckBox == tabCutter.getCheckBox() && "развертка".equals(ProcessingTab.getNameTab())) {
            checkSweep = !checkSweep;
        }
        if (clickedCheckBox == tabCutter.getCheckBox() && "метчик".equals(ProcessingTab.getNameTab())) {
            checkTap = !checkTap;
        }
    }

    public static boolean getCheckCutter() {
        return checkCutter;
    }

    public static boolean getCheckDrill() {
        return checkDrill;
    }

    public static boolean getCheckCountersink() {
        return checkCountersink;
    }

    public static boolean getCheckSweep() {
        return checkSweep;
    }

    public static boolean getCheckTap() {
        return checkTap;
    }
}
