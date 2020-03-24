package engineeringtechnology.graphicfield;

import engineeringtechnology.cuttingmodes.data.DataGF;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProcessingComboBox implements ActionListener {
    private int numberBox;

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox<String> clickedComboBox = (JComboBox) e.getSource();
        numberBox = clickedComboBox.getSelectedIndex();
        setBox(ProcessingTab.getNumberTab());
    }

    private void setBox(int numberTab) {
        for (int i = 0; i < DataGF.LIST_TAB.size(); i++) {
            if (numberTab == i) {
                DataGF.LIST_TAB.get(i).setNumberBox(numberBox);
            }
        }
    }
}
