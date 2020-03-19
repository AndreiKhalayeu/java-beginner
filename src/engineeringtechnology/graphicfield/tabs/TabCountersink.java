package engineeringtechnology.graphicfield.tabs;

import engineeringtechnology.graphicfield.ProcessingComboBox;

import javax.swing.*;

public class TabCountersink extends TabCutter {

    @Override
    protected JComboBox<String> createFieldName() {
        ProcessingComboBox processingComboBox = new ProcessingComboBox();
        comboBoxName = new JComboBox<>();
        comboBoxName.addItem("Цилиндр. зенкер");
        comboBoxName.addItem("Торц. зенкер");
        add(comboBoxName);
        comboBoxName.addActionListener(processingComboBox);
        return comboBoxName;
    }
}
