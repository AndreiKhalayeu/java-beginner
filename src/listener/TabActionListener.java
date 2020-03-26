package listener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TabActionListener implements ChangeListener {
    private static int numberTab;

    @Override
    public void stateChanged(ChangeEvent e) {
        JTabbedPane clickedTabbedPane = (JTabbedPane) e.getSource();
        numberTab = clickedTabbedPane.getSelectedIndex();
    }

    public static int getNumberTab() {
        return numberTab;
    }
}
