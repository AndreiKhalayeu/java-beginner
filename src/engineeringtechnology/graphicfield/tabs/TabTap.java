package engineeringtechnology.graphicfield.tabs;


import engineeringtechnology.cuttingmodes.tool.Tap;
import engineeringtechnology.graphicfield.ProcessingField;

import javax.swing.*;
import java.awt.*;

public class TabTap extends TabCutter {
    private JFormattedTextField fieldDrill;
    private JComboBox<String> comboBoxNameTap;

    public TabTap() {
    }

    @Override
    protected void createFieldName() {
        ProcessingField processingField = new ProcessingField(this);
        comboBoxNameTap = new JComboBox<>();
        comboBoxNameTap.addItem("Метр. резьба ГОСТ 24705-81");
        comboBoxNameTap.addItem("Конич. резьба ГОСТ 6111-52");
        comboBoxNameTap.addItem("Тр. цилиндр. резьба ГОСТ 21348-75");
        comboBoxNameTap.addItem("Тр. конич. резьба ГОСТ 21350-75");
        add(comboBoxNameTap);
        comboBoxNameTap.addActionListener(processingField);
    }

    @Override
    protected void createFieldFeed() {
        JComboBox<String> comboBoxFeed = new JComboBox<>();
        for (String feed : Tap.FEED) {
            comboBoxFeed.addItem(feed);
        }
        add(comboBoxFeed);
    }

    private void createFieldDrill() {
        fieldDrill = new JFormattedTextField();
        add(fieldDrill);
        fieldDrill.setPreferredSize(new Dimension(45,20));
        fieldDrill.setEditable(false);
    }

    private void createLabelDrill() {
        JLabel labelDrill = new JLabel("Сверло D,мм: ");
        add(labelDrill);
    }

    @Override
    protected void createLabelFormulaTurnsFeed() {
        createLabelDrill();
        createFieldDrill();
        JLabel labelFormulaTurnsFeed = new JLabel("       n = 1000*6 / 3.14*D, об/мин  F = n*s*0.9, мм/мин");
        add(labelFormulaTurnsFeed);
        labelFormulaTurnsFeed.setForeground(Color.gray);
    }

    public JComboBox<String> getComboBoxNameTap() {
        return comboBoxNameTap;
    }

    public JFormattedTextField getFieldDrill() {
        return fieldDrill;
    }
}
