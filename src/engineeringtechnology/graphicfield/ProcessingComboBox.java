package engineeringtechnology.graphicfield;

import engineeringtechnology.cuttingmodes.data.DataGF;
import engineeringtechnology.graphicfield.tabs.TabCutter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Set;

public class ProcessingComboBox implements ActionListener {
    private int numberBox;

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox<String> clickedComboBox = (JComboBox) e.getSource();
        numberBox = clickedComboBox.getSelectedIndex();
        setBox(ProcessingTab.getNumberTab());
    }

    private void setBox(int numberTab) {
        Set<Map.Entry<Integer, TabCutter>> dataTab = DataGF.LIST_TAB.entrySet();
        for (Map.Entry<Integer, TabCutter> value : dataTab) {
            if (numberTab == value.getKey()) {
                value.getValue().setNumberBox(numberBox);
            }
        }
    }
}
