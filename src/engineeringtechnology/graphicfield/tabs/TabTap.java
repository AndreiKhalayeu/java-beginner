package engineeringtechnology.graphicfield.tabs;

import engineeringtechnology.cuttingmodes.tool.Tap;
import engineeringtechnology.graphicfield.ProcessingComboBox;

import javax.swing.*;
import java.awt.*;

public class TabTap extends TabCutter {
//    private boolean check = false;
    private JFormattedTextField fieldDrill;

    @Override
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

    @Override
    protected JPanel createPanelFlowLayoutTabRight() {
        JPanel rightPanelBorderLayout = new JPanel();
        rightPanelBorderLayout.setLayout(new FlowLayout());
        rightPanelBorderLayout.add(createLabelDrill());
        rightPanelBorderLayout.add(createFieldDrill());
        return rightPanelBorderLayout;
    }

    @Override
    protected JComboBox<String> createFieldName() {
        ProcessingComboBox processingComboBox = new ProcessingComboBox();
        comboBoxName = new JComboBox<>();
        comboBoxName.addItem("Метр. резьба ГОСТ 24705-81");
        comboBoxName.addItem("Конич. резьба ГОСТ 6111-52");
        comboBoxName.addItem("Тр. цилиндр. резьба ГОСТ 21348-75");
        comboBoxName.addItem("Тр. конич. резьба ГОСТ 21350-75");
        add(comboBoxName);
        comboBoxName.addActionListener(processingComboBox);
        return comboBoxName;
    }

    private JComboBox<String> createFieldFeed() {
        JComboBox<String> comboBoxFeed = new JComboBox<>();
        for (String feed : Tap.FEED) {
            comboBoxFeed.addItem(feed);
        }
        add(comboBoxFeed);
        return comboBoxFeed;
    }

    private JLabel createLabelDrill() {
        JLabel labelDrill = new JLabel("Сверло D,мм: ");
        add(labelDrill);
        return labelDrill;
    }

    private JFormattedTextField createFieldDrill() {
        fieldDrill = new JFormattedTextField();
        add(fieldDrill);
        fieldDrill.setPreferredSize(new Dimension(45,20));
        fieldDrill.setEditable(false);
        return fieldDrill;
    }

    public JFormattedTextField getFieldDrill() {
        return fieldDrill;
    }

//    public boolean isCheck() {
//        return check;
//    }
//
//    public void setCheck(boolean check) {
//        this.check = check;
//    }
}
