package engineeringtechnology.graphicfield;

import engineeringtechnology.cuttingmodes.data.DataGF;
import engineeringtechnology.graphicfield.tabs.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Set;

public class ProcessingCheckBox implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        setCheck(setTab(ProcessingTab.getNumberTab()));
    }

    private TabCutter setTab(int numberTab) {
        TabCutter tab = null;
        Set<Map.Entry<Integer, TabCutter>> dataTab = DataGF.LIST_TAB.entrySet();
        for (Map.Entry<Integer, TabCutter> value : dataTab) {
            if (numberTab == value.getKey()) {
                tab = value.getValue();
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
