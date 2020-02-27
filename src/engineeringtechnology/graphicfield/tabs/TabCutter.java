package engineeringtechnology.graphicfield.tabs;

import javax.swing.*;
import java.awt.*;

public class TabCutter extends JPanel {
    private JFormattedTextField fieldDiameter;
    private JFormattedTextField fieldFeed;
    private JFormattedTextField fieldTurns;
    private JFormattedTextField fieldMachineFeed;

    public TabCutter() {
        createLabelField();
        createFieldDiameter();
        createLabelFeed();
        createFieldFeed();
        createLabelTurns();
        createFieldTurns();
        createLabelMachineFeed();
        createFieldMachineFeed();
    }

    protected void createFieldDiameter() {
        JFormattedTextField fieldDiameter = new JFormattedTextField();
        add(fieldDiameter);
        fieldDiameter.setPreferredSize(new Dimension(45,20));
    }

    protected void createFieldFeed() {
        JFormattedTextField fieldFeed = new JFormattedTextField();
        add(fieldFeed);
        fieldFeed.setPreferredSize(new Dimension(45,20));
    }

    protected void createFieldTurns() {
        JFormattedTextField fieldTurns = new JFormattedTextField();
        add(fieldTurns);
        fieldTurns.setPreferredSize(new Dimension(45,20));
    }

    protected void createFieldMachineFeed() {
        JFormattedTextField fieldMachineFeed = new JFormattedTextField();
        add(fieldMachineFeed);
        fieldMachineFeed.setPreferredSize(new Dimension(45,20));
    }

    private void createLabelField() {
        JLabel labelDiameter = new JLabel("D,мм: ");
        add(labelDiameter);
    }

    private void createLabelFeed() {
        JLabel labelFeed = new JLabel("s,мм/об: ");
        add(labelFeed);
    }

    private void createLabelTurns() {
        JLabel labelTurns = new JLabel("n,об/мин: ");
        add(labelTurns);
    }

    private void createLabelMachineFeed() {
        JLabel labelMachineFeed = new JLabel("F,мм/мин: ");
        add(labelMachineFeed);
    }

    public void setFieldDiameter(JFormattedTextField fieldDiameter) {
        this.fieldDiameter = fieldDiameter;
    }

    public void setFieldFeed(JFormattedTextField fieldFeed) {
        this.fieldFeed = fieldFeed;
    }

    public void setFieldTurns(JFormattedTextField fieldTurns) {
        this.fieldTurns = fieldTurns;
    }

    public void setFieldMachineFeed(JFormattedTextField fieldMachineFeed) {
        this.fieldMachineFeed = fieldMachineFeed;
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
