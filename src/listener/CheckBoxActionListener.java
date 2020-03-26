package listener;

import engineeringtechnology.cuttingmodes.data.DataGF;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckBoxActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        verifyCheckBox(TabActionListener.getNumberTab());
    }

    private void verifyCheckBox(int numberTab) {
        for (int i = 0; i < DataGF.LIST_TAB.size(); i++) {
            if (numberTab == i) {
                if (DataGF.LIST_TAB.get(i).isCheckBox()) {
                    DataGF.LIST_TAB.get(i).setCheckBox(false);
                } else {
                    DataGF.LIST_TAB.get(i).setCheckBox(true);
                }
            }
        }
    }
}
