package engineeringtechnology.graphicfield.tabs;

import engineeringtechnology.listener.ComboBoxActionListener;

import javax.swing.*;
import java.awt.*;

/**
 * Класс вкладка метчик
 */
public class TabTap extends AbstractTab {
    /**
     * поле сверло
     */
    private JFormattedTextField fieldDrill;

    public TabTap() {
        super();
    }

    @Override
    public JPanel createPanelFlowLayoutTabRight() {
        JPanel rightPanelBorderLayout = new JPanel();
        rightPanelBorderLayout.setLayout(new FlowLayout());
        rightPanelBorderLayout.add(createLabelDrill());
        rightPanelBorderLayout.add(createFieldDrill());
        return rightPanelBorderLayout;
    }

    @Override
    public JComboBox<String> createFieldName() {
        ComboBoxActionListener comboBoxActionListener = new ComboBoxActionListener();
        comboBoxName = new JComboBox<>();
        comboBoxName.addItem("Метр. резьба ГОСТ 24705-81");
        add(comboBoxName);
        comboBoxName.addActionListener(comboBoxActionListener);
        return comboBoxName;
    }

    private JLabel createLabelDrill() {
        JLabel labelDrill = new JLabel("Сверло D,мм: ");
        add(labelDrill);
        return labelDrill;
    }

    private JFormattedTextField createFieldDrill() {
        fieldDrill = new JFormattedTextField("0");
        add(fieldDrill);
        fieldDrill.setPreferredSize(new Dimension(45,20));
        fieldDrill.setEditable(false);
        return fieldDrill;
    }

    public JFormattedTextField getFieldDrill() {
        return fieldDrill;
    }
}
