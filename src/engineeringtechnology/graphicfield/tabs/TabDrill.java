package engineeringtechnology.graphicfield.tabs;

import engineeringtechnology.graphicfield.ProcessingComboBox;

import javax.swing.*;
import java.awt.*;

public class TabDrill extends TabCutter {
//    private boolean check = false;
//    private int numberBox;
    private JFormattedTextField fieldBlade;

    @Override
    protected JPanel createPanelFlowLayoutTabRight() {
        JPanel rightPanelBorderLayout = new JPanel();
        rightPanelBorderLayout.setLayout(new FlowLayout());
        rightPanelBorderLayout.add(createLabelLengthBlade());
        rightPanelBorderLayout.add(createFieldBlade());
        return rightPanelBorderLayout;
    }

    @Override
    protected JComboBox<String> createFieldName() {
        ProcessingComboBox processingComboBox = new ProcessingComboBox();
        comboBoxName = new JComboBox<>();
        comboBoxName.addItem("Сверло");
        add(comboBoxName);
        comboBoxName.addActionListener(processingComboBox);
        return comboBoxName;
    }

    private JLabel createLabelLengthBlade() {
        JLabel labelLengthBlade = new JLabel(">,мм: ");
        add(labelLengthBlade);
        return labelLengthBlade;
    }

    private JFormattedTextField createFieldBlade() {
        fieldBlade = new JFormattedTextField("0");
        add(fieldBlade);
        fieldBlade.setPreferredSize(new Dimension(45,20));
        fieldBlade.setEditable(false);
        return fieldBlade;
    }

    public JFormattedTextField getFieldBlade() {
        return fieldBlade;
    }

//    public boolean isCheck() {
//        return check;
//    }
//
//    public void setCheck(boolean check) {
//        this.check = check;
//    }
//
//    public int getNumberBox() {
//        return numberBox;
//    }
//
//    public void setNumberBox(int numberBox) {
//        this.numberBox = numberBox;
//    }
}
