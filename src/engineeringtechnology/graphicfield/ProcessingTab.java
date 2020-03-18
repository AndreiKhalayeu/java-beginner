package engineeringtechnology.graphicfield;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ProcessingTab implements ChangeListener {
    private static String nameTab = "фреза";

    @Override
    public void stateChanged(ChangeEvent e) {

        JTabbedPane clickedTabbedPane = (JTabbedPane) e.getSource();

        if (clickedTabbedPane.getSelectedIndex() == 0) {
            nameTab = "фреза";
        }
        if (clickedTabbedPane.getSelectedIndex() == 1) {
            nameTab = "сверло";
        }
        if (clickedTabbedPane.getSelectedIndex() == 2) {
            nameTab = "зенкер";
        }
        if (clickedTabbedPane.getSelectedIndex() == 3) {
            nameTab = "развертка";
        }
        if (clickedTabbedPane.getSelectedIndex() == 4) {
            nameTab = "метчик";
        }
    }

    public static String getNameTab() {
        return nameTab;
    }
}
