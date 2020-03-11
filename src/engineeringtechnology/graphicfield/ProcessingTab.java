package engineeringtechnology.graphicfield;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ProcessingTab implements ChangeListener {

    @Override
    public void stateChanged(ChangeEvent e) {

        JTabbedPane clickedTabbedPane = (JTabbedPane) e.getSource();

        if (clickedTabbedPane.getSelectedIndex() == 0) {
            ProcessingButton.setNameTab("фреза");
        }
        if (clickedTabbedPane.getSelectedIndex() == 1) {
            ProcessingButton.setNameTab("сверло");
        }
        if (clickedTabbedPane.getSelectedIndex() == 2) {
            ProcessingButton.setNameTab("зенкер");
        }
        if (clickedTabbedPane.getSelectedIndex() == 3) {
            ProcessingButton.setNameTab("развертка");
        }
        if (clickedTabbedPane.getSelectedIndex() == 4) {
            ProcessingButton.setNameTab("метчик");
        }
    }
}
