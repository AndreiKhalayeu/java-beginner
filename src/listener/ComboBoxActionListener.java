package listener;

import engineeringtechnology.cuttingmodes.data.DataGF;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboBoxActionListener implements ActionListener {
    private int numberComboBox;

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox<String> clickedComboBox = (JComboBox) e.getSource();
        numberComboBox = clickedComboBox.getSelectedIndex();
        setNumberComboBox(TabActionListener.getNumberTab());
    }

    private void setNumberComboBox(int numberTab) {
        for (int i = 0; i < DataGF.LIST_TAB.size(); i++) {
            if (numberTab == i) {
                DataGF.LIST_TAB.get(i).setNumberComboBox(numberComboBox);
            }
        }
    }
}
