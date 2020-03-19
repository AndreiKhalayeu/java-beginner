package engineeringtechnology.graphicfield;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProcessingCheckBox implements ActionListener {
    private static boolean checkCutter = false;
    private static boolean checkCountersink = false;
    private static boolean checkDrill = false;
    private static boolean checkSweep = false;
    private static boolean checkTap = false;

    @Override
    public void actionPerformed(ActionEvent e) {
//        JCheckBox clickedCheckBox = (JCheckBox) e.getSource();
//        System.out.println(clickedCheckBox.isSelected());
        if (ProcessingTab.getNumberTab() == 0) {
            checkCutter = !checkCutter;
        }
        if (ProcessingTab.getNumberTab() == 1) {
            checkDrill = !checkDrill;
        }
        if (ProcessingTab.getNumberTab() == 2) {
            checkCountersink = !checkCountersink;
        }
        if (ProcessingTab.getNumberTab() == 3) {
            checkSweep = !checkSweep;
        }
        if (ProcessingTab.getNumberTab() == 4) {
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
