package engineeringtechnology.graphicfield.tabs;

import listener.ComboBoxActionListener;

import javax.swing.*;

/**
 * Класс вкладка развертка
 */
public class TabSweep extends TabCutter {

    /**
     * Метод создает выподающий список разверток
     * @return возвращает выподающий список разверток
     */
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
