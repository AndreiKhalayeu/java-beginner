package engineeringtechnology.graphicfield;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ProcessingTab implements ChangeListener {

    @Override
    public void stateChanged(ChangeEvent e) {

        JTabbedPane clickedTabbedPane = (JTabbedPane) e.getSource();

        if (clickedTabbedPane.getSelectedIndex() == 0) {
            ProcessingField.setNameTab("фреза");
        }
        if (clickedTabbedPane.getSelectedIndex() == 1) {
            ProcessingField.setNameTab("сверло");
        }
        if (clickedTabbedPane.getSelectedIndex() == 2) {
            ProcessingField.setNameTab("зенкер");
        }
        if (clickedTabbedPane.getSelectedIndex() == 3) {
            ProcessingField.setNameTab("развертка");
        }
        if (clickedTabbedPane.getSelectedIndex() == 4) {
            ProcessingField.setNameTab("метчик");
        }
    }
}
