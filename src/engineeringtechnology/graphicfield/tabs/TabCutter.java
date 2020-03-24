package engineeringtechnology.graphicfield.tabs;

import engineeringtechnology.graphicfield.ProcessingCheckBox;
import engineeringtechnology.graphicfield.ProcessingComboBox;

import javax.swing.*;
import java.awt.*;

public class TabCutter extends JPanel {
    protected boolean check = false;
    protected int numberBox;
    private JFormattedTextField fieldDiameter;
    private JFormattedTextField fieldFeed;
    private JFormattedTextField fieldTurns;
    private JFormattedTextField fieldMachineFeed;
    private JCheckBox jCheckBox;
    protected JComboBox<String> comboBoxName;
    private JLabel labelFormulaTurnsFeed;

    public TabCutter() {
        createFlowLayoutTab();
    }

    protected void createFlowLayoutTab() {
        FlowLayout flowLayout = new FlowLayout();
        this.setLayout(flowLayout);
        this.add(createPanelBorderLayoutTabLeft());
        this.add(createPanelBorderLayoutTabCenter());
        this.add(createPanelBorderLayoutTabRight());
        flowLayout.setAlignment(FlowLayout.LEFT);
    }

    protected JPanel createPanelBorderLayoutTabLeft() {
        JPanel panelBorderLayoutTabLeft = new JPanel();
        panelBorderLayoutTabLeft.setLayout(new BorderLayout());
        panelBorderLayoutTabLeft.add("Center", createFieldName());
        panelBorderLayoutTabLeft.add("South", createCheckBox());
        panelBorderLayoutTabLeft.setPreferredSize(new Dimension(220,50));
        return panelBorderLayoutTabLeft;
    }

    protected JPanel createPanelBorderLayoutTabCenter() {
        JPanel panelBorderLayoutTabCenter = new JPanel();
        panelBorderLayoutTabCenter.setLayout(new BorderLayout());
        panelBorderLayoutTabCenter.add("Center", createPanelFlowLayoutTabCenter());
        panelBorderLayoutTabCenter.add("South", createLabelFormulaTurnsFeed());
        return panelBorderLayoutTabCenter;
    }

    protected JPanel createPanelFlowLayoutTabCenter() {
        JPanel panelFlowLayoutTabCenter = new JPanel();
        panelFlowLayoutTabCenter.setLayout(new FlowLayout());
        panelFlowLayoutTabCenter.add(createLabelDiameter());
        panelFlowLayoutTabCenter.add(createFieldDiameter());
        panelFlowLayoutTabCenter.add(createLabelFeed());
        panelFlowLayoutTabCenter.add(createFieldFeed());
        panelFlowLayoutTabCenter.add(createLabelMachineFeed());
        panelFlowLayoutTabCenter.add(createFieldMachineFeed());
        panelFlowLayoutTabCenter.add(createLabelTurns() );
        panelFlowLayoutTabCenter.add(createFieldTurns());
        return panelFlowLayoutTabCenter;
    }

    protected JPanel createPanelBorderLayoutTabRight() {
        JPanel panelBorderLayoutTabRight = new JPanel();
        panelBorderLayoutTabRight.setLayout(new BorderLayout());
        panelBorderLayoutTabRight.add("Center", createPanelFlowLayoutTabRight());
        return panelBorderLayoutTabRight;
    }

    protected JPanel createPanelFlowLayoutTabRight() {
        JPanel rightPanelBorderLayout = new JPanel();
        rightPanelBorderLayout.setLayout(new FlowLayout());
        return rightPanelBorderLayout;
    }

    protected JComboBox<String> createFieldName() {
        ProcessingComboBox processingComboBox = new ProcessingComboBox();
        comboBoxName = new JComboBox<>();
        comboBoxName.addItem("Концевая фреза");
        comboBoxName.addItem("Торцевая фреза");
        add(comboBoxName);
        comboBoxName.addActionListener(processingComboBox);
        return comboBoxName;
    }

    protected JCheckBox createCheckBox() {
        ProcessingCheckBox processingCheckBox = new ProcessingCheckBox();
        jCheckBox = new JCheckBox("ГФ2171");
        add(jCheckBox);
        jCheckBox.addActionListener(processingCheckBox);
        return jCheckBox;
    }

    protected JLabel createLabelDiameter() {
        JLabel labelDiameter = new JLabel("D,мм: ");
        add(labelDiameter);
        return labelDiameter;
    }

    protected JFormattedTextField createFieldDiameter() {
        fieldDiameter = new JFormattedTextField();
        add(fieldDiameter);
        fieldDiameter.setPreferredSize(new Dimension(45,20));
        return fieldDiameter;
    }

    protected JLabel createLabelFeed() {
        JLabel labelFeed = new JLabel("s,мм/об: ");
        add(labelFeed);
        return labelFeed;
    }

    private JFormattedTextField createFieldFeed() {
        fieldFeed = new JFormattedTextField();
        add(fieldFeed);
        fieldFeed.setPreferredSize(new Dimension(45,20));
        return fieldFeed;
    }

    protected JLabel createLabelMachineFeed() {
        JLabel labelMachineFeed = new JLabel("F,мм/мин: ");
        add(labelMachineFeed);
        return labelMachineFeed;
    }

    protected JFormattedTextField createFieldMachineFeed() {
        fieldMachineFeed = new JFormattedTextField("0");
        add(fieldMachineFeed);
        fieldMachineFeed.setPreferredSize(new Dimension(45,20));
        fieldMachineFeed.setEditable(false);
        return fieldMachineFeed;
    }

    protected JLabel createLabelTurns() {
        JLabel labelTurns = new JLabel("n,об/мин: ");
        add(labelTurns);
        return labelTurns;
    }

    protected JFormattedTextField createFieldTurns() {
        fieldTurns = new JFormattedTextField("0");
        add(fieldTurns);
        fieldTurns.setPreferredSize(new Dimension(45,20));
        fieldTurns.setEditable(false);
        return fieldTurns;
    }

    private JLabel createLabelFormulaTurnsFeed() {
        labelFormulaTurnsFeed = new JLabel("");
        add(labelFormulaTurnsFeed);
        labelFormulaTurnsFeed.setForeground(Color.gray);
        return labelFormulaTurnsFeed;
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


    public JComboBox<String> getComboBoxName() {
        return comboBoxName;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public int getNumberBox() {
        return numberBox;
    }

    public void setNumberBox(int numberBox) {
        this.numberBox = numberBox;
    }

    public JLabel getLabelFormulaTurnsFeed() {
        return labelFormulaTurnsFeed;
    }
}
