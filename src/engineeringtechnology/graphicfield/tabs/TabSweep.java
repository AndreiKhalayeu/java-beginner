package engineeringtechnology.graphicfield.tabs;

import listener.ComboBoxActionListener;

import javax.swing.*;

public class TabSweep extends TabCutter {

    @Override
    protected JComboBox<String> createFieldName() {
        ComboBoxActionListener comboBoxActionListener = new ComboBoxActionListener();
        comboBoxName = new JComboBox<>();
        comboBoxName.addItem("Цилиндр. развертка");
        add(comboBoxName);
        comboBoxName.addActionListener(comboBoxActionListener);
        return comboBoxName;
    }

}
