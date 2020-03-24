package engineeringtechnology.graphicfield;

import engineeringtechnology.cuttingmodes.data.DataGF;
import engineeringtechnology.graphicfield.tabs.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProcessingCheckBox implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        setCheck(setTab(ProcessingTab.getNumberTab()));
    }

    private TabCutter setTab(int numberTab) {
        TabCutter tab = null;
        for (int i = 0; i < DataGF.LIST_TAB.size(); i++) {
            if (numberTab == i) {
                tab = DataGF.LIST_TAB.get(i);
            }
        }
        return tab;
    }

    private void setCheck(TabCutter tab) {
        if (tab.isCheck()) {
            tab.setCheck(false);
        } else {
            tab.setCheck(true);
        }
    }
}
