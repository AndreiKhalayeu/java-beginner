package engineeringtechnology.graphicfield;

import engineeringtechnology.cuttingmodes.tool.Cutter;
import engineeringtechnology.graphicfield.tabs.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ProcessingTab implements ChangeListener {
    private Field field;
    private TabCountersink tabCountersink;
    private TabCutter tabCutter;
    private TabDrill tabDrill;
    private TabSweep tabSweep;
    private TabTap tabTap;

    ProcessingTab(Field field, TabCountersink tabCountersink, TabCutter tabCutter, TabDrill tabDrill,
                  TabSweep tabSweep, TabTap tabTap) {
        this.field = field;
        this.tabCountersink = tabCountersink;
        this.tabCutter = tabCutter;
        this.tabDrill = tabDrill;
        this.tabSweep = tabSweep;
        this.tabTap = tabTap;
    }
    @Override
    public void stateChanged(ChangeEvent e) {

        JTabbedPane clickedTabbedPane = (JTabbedPane) e.getSource();

        if (clickedTabbedPane.getSelectedIndex() == 0) {
            System.out.println("фреза");
        }
        if (clickedTabbedPane.getSelectedIndex() == 1) {
            System.out.println("сверло");
        }
        if (clickedTabbedPane.getSelectedIndex() == 2) {
            System.out.println("зенкер");
        }
        if (clickedTabbedPane.getSelectedIndex() == 3) {
            System.out.println("развертка");
        }
        if (clickedTabbedPane.getSelectedIndex() == 4) {
            System.out.println("метчик");
        }

    }
}
