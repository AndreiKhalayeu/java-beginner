package engineeringtechnology.graphicfield;

import engineeringtechnology.graphicfield.tabs.TabCutter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProcessingCheckBox implements ActionListener {
    private TabCutter tabCutter;

    public ProcessingCheckBox(TabCutter tabCutter) {
        this.tabCutter = tabCutter;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JCheckBox clickedCheckBox = (JCheckBox) e.getSource();
        if (clickedCheckBox == tabCutter.getCheckBoxCutter()) {
            if (ProcessingButton.getCheck()) {
                ProcessingButton.setCheck(false);
            } else {
                ProcessingButton.setCheck(true);
            }
        }
    }
}
