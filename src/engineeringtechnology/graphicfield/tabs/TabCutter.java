package engineeringtechnology.graphicfield.tabs;

import engineeringtechnology.graphicfield.ProcessingField;

import javax.swing.*;
import java.awt.*;

public class TabCutter extends JPanel {
    private JFormattedTextField fieldDiameter;
    private JFormattedTextField fieldFeed;
    private JFormattedTextField fieldTurns;
    private JFormattedTextField fieldMachineFeed;

    public TabCutter() {
        createCheckBox();
        createLabelField();
        createFieldDiameter();
        createLabelFeed();
        createFieldFeed();
        createLabelMachineFeed();
        createFieldMachineFeed();
        createLabelTurns();
        createFieldTurns();
        createLabelFormulaTurnsFeed();
    }

    protected void createFieldName() {
        ProcessingField processingField = new ProcessingField();
        JComboBox<String> comboBoxNameCutter = new JComboBox<>();
        comboBoxNameCutter.addItem("Коническая фреза");
        comboBoxNameCutter.addItem("Торцевая фреза");
        add(comboBoxNameCutter);
        comboBoxNameCutter.addActionListener(processingField);
    }

    protected void createCheckBox() {
        createFieldName();
        JCheckBox checkBox = new JCheckBox("ГФ2171");
        add(checkBox);
    }

    protected void createFieldDiameter() {
        fieldDiameter = new JFormattedTextField();
        add(fieldDiameter);
        fieldDiameter.setPreferredSize(new Dimension(45,20));
    }

    protected void createFieldFeed() {
        fieldFeed = new JFormattedTextField();
        add(fieldFeed);
        fieldFeed.setPreferredSize(new Dimension(45,20));
    }

    protected void createFieldMachineFeed() {
        fieldMachineFeed = new JFormattedTextField("0");
        add(fieldMachineFeed);
        fieldMachineFeed.setPreferredSize(new Dimension(45,20));
        fieldMachineFeed.setEditable(false);
    }

    protected void createFieldTurns() {
        fieldTurns = new JFormattedTextField("0");
        add(fieldTurns);
        fieldTurns.setPreferredSize(new Dimension(45,20));
        fieldTurns.setEditable(false);
    }

    private void createLabelField() {
        JLabel labelDiameter = new JLabel("D,мм: ");
        add(labelDiameter);
    }

    private void createLabelFeed() {
        JLabel labelFeed = new JLabel("s,мм/об: ");
        add(labelFeed);
    }

    private void createLabelMachineFeed() {
        JLabel labelMachineFeed = new JLabel("F,мм/мин: ");
        add(labelMachineFeed);
    }

    private void createLabelTurns() {
        JLabel labelTurns = new JLabel("n,об/мин: ");
        add(labelTurns);
    }

    protected void createLabelFormulaTurnsFeed() {
        JLabel labelFormulaTurnsFeed = new JLabel("n = 1000*25 / 3.14*D, об/мин  F = n*s, мм/мин  s = 0.1...0.3, мм/об");
        add(labelFormulaTurnsFeed);
    }

    public JFormattedTextField getFieldDiameter() {
        return fieldDiameter;
    }

    public JFormattedTextField getFieldFeed() {
        return fieldFeed;
    }

    public JFormattedTextField getFieldTurns() {
        return fieldTurns;
    }

    public JFormattedTextField getFieldMachineFeed() {
        return fieldMachineFeed;
    }
}
