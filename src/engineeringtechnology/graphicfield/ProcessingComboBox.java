package engineeringtechnology.graphicfield;

import engineeringtechnology.graphicfield.tabs.TabCutter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProcessingComboBox implements ActionListener {
    private TabCutter tabCutter;

    public ProcessingComboBox(TabCutter tabCutter) {
        this.tabCutter = tabCutter;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox<String> clickedComboBox = (JComboBox<String>)e.getSource();
        if (clickedComboBox == tabCutter.getComboBoxNameCutter() && tabCutter.getComboBoxNameCutter().getSelectedIndex() == 0) {
            ProcessingButton.setNameComboBox("Коническая фреза");
        }
        if (clickedComboBox == tabCutter.getComboBoxNameCutter() && tabCutter.getComboBoxNameCutter().getSelectedIndex() == 1) {
            ProcessingButton.setNameComboBox("Торцевая фреза");
        }
    }
}
