package engineeringtechnology.graphicfield.tabs;


import engineeringtechnology.graphicfield.ProcessingField;

import javax.swing.*;

public class TabSweep extends TabCutter {
    private JComboBox<String> comboBoxNameSweep;
    public TabSweep() {
    }

    @Override
    protected void createFieldName() {
        ProcessingField processingField = new ProcessingField();
        comboBoxNameSweep = new JComboBox<>();
        comboBoxNameSweep.addItem("Цилиндр. развертка");
        comboBoxNameSweep.addItem("Конич. развертка");
        add(comboBoxNameSweep);
        comboBoxNameSweep.addActionListener(processingField);
    }

    @Override
    protected void createLabelFormulaTurnsFeed() {
        JLabel labelFormulaTurnsFeed = new JLabel("n = 1000*8 / 3.14*D, об/мин  F = n*s, мм/мин  s = 0.4...0.6, мм/об");
        add(labelFormulaTurnsFeed);
    }

    public JComboBox<String> getComboBoxNameSweep() {
        return comboBoxNameSweep;
    }
}
