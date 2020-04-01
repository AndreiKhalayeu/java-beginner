package engineeringtechnology.graphicfield.tabs;

import engineeringtechnology.listener.ComboBoxActionListener;

import javax.swing.*;

/**
 * Класс вкладка фреза
 */
public class TabCutter extends AbstractTab {

    public TabCutter() {
        super();
    }

    @Override
    public JComboBox<String> createFieldName() {
        ComboBoxActionListener comboBoxActionListener = new ComboBoxActionListener();
        comboBoxName = new JComboBox<>();
        comboBoxName.addItem("Концевая фреза");
        comboBoxName.addItem("Торцевая фреза");
        add(comboBoxName);
        comboBoxName.addActionListener(comboBoxActionListener);
        return comboBoxName;
    }
}
