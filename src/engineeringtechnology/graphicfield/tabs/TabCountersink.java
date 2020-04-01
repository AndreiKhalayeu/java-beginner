package engineeringtechnology.graphicfield.tabs;

import engineeringtechnology.listener.ComboBoxActionListener;

import javax.swing.*;

/**
 * Класс вкладка зенкер
 */
public class TabCountersink extends AbstractTab {

    public TabCountersink() {
        super();
    }

    @Override
    public JComboBox<String> createFieldName() {
        ComboBoxActionListener comboBoxActionListener = new ComboBoxActionListener();
        comboBoxName = new JComboBox<>();
        comboBoxName.addItem("Цилиндр. зенкер");
        add(comboBoxName);
        comboBoxName.addActionListener(comboBoxActionListener);
        return comboBoxName;
    }
}
