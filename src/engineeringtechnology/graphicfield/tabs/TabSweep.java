package engineeringtechnology.graphicfield.tabs;

import engineeringtechnology.listener.ComboBoxActionListener;

import javax.swing.*;

/**
 * Класс вкладка развертка
 */
public class TabSweep extends AbstractTab {

    public TabSweep() {
        super();
    }

    @Override
    public JComboBox<String> createFieldName() {
        ComboBoxActionListener comboBoxActionListener = new ComboBoxActionListener();
        comboBoxName = new JComboBox<>();
        comboBoxName.addItem("Цилиндр. развертка");
        add(comboBoxName);
        comboBoxName.addActionListener(comboBoxActionListener);
        return comboBoxName;
    }
}
