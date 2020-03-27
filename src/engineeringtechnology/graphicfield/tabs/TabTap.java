package engineeringtechnology.graphicfield.tabs;

import engineeringtechnology.cuttingmodes.tool.Tap;
import listener.ComboBoxActionListener;
import listener.ComboBoxFeedActionListener;

import javax.swing.*;
import java.awt.*;

public class TabTap extends TabCutter {
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
        ComboBoxActionListener comboBoxActionListener = new ComboBoxActionListener();
        comboBoxName = new JComboBox<>();
        comboBoxName.addItem("Метр. резьба ГОСТ 24705-81");
        add(comboBoxName);
        comboBoxName.addActionListener(comboBoxActionListener);
        return comboBoxName;
    }

    private JComboBox<Double> createFieldFeed() {
        ComboBoxFeedActionListener comboBoxFeedActionListener = new ComboBoxFeedActionListener();
        JComboBox<Double> comboBoxFeed = new JComboBox<>();
        for (Double feed : Tap.FEED) {
            comboBoxFeed.addItem(feed);
        }
        add(comboBoxFeed);
        comboBoxFeed.addActionListener(comboBoxFeedActionListener);
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
}
