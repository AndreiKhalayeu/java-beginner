package engineeringtechnology.graphicfield.tabs;

import engineeringtechnology.graphicfield.ProcessingComboBox;

import javax.swing.*;

public class TabSweep extends TabCutter {

    @Override
    protected JComboBox<String> createFieldName() {
        ProcessingComboBox processingComboBox = new ProcessingComboBox();
        comboBoxName = new JComboBox<>();
        comboBoxName.addItem("Цилиндр. развертка");
        comboBoxName.addItem("Конич. развертка");
        add(comboBoxName);
        comboBoxName.addActionListener(processingComboBox);
        return comboBoxName;
    }

}
