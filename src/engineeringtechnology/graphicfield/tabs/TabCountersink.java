package engineeringtechnology.graphicfield.tabs;

import listener.ComboBoxActionListener;

import javax.swing.*;

public class TabCountersink extends TabCutter {

    @Override
    protected JComboBox<String> createFieldName() {
        ComboBoxActionListener comboBoxActionListener = new ComboBoxActionListener();
        comboBoxName = new JComboBox<>();
        comboBoxName.addItem("Цилиндр. зенкер");
        add(comboBoxName);
        comboBoxName.addActionListener(comboBoxActionListener);
        return comboBoxName;
    }
}
