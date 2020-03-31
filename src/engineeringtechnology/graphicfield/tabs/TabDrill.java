package engineeringtechnology.graphicfield.tabs;

import listener.ComboBoxActionListener;

import javax.swing.*;
import java.awt.*;

public class TabDrill extends TabCutter {
    private JFormattedTextField fieldBlade;

    /**
     * Метод создает панель по линейной схеме расположения поля: надпись длинны острой части сверла,
     * поле длинны острой части сверла
     * @return возвращает созданную панель
     */
    @Override
    protected JPanel createPanelFlowLayoutTabRight() {
        JPanel rightPanelBorderLayout = new JPanel();
        rightPanelBorderLayout.setLayout(new FlowLayout());
        rightPanelBorderLayout.add(createLabelLengthBlade());
        rightPanelBorderLayout.add(createFieldBlade());
        return rightPanelBorderLayout;
    }

    /**
     * Метод создает выподающий список сверл
     * @return возвращает выподающий список сверл
     */
    @Override
    protected JComboBox<String> createFieldName() {
        ComboBoxActionListener comboBoxActionListener = new ComboBoxActionListener();
        comboBoxName = new JComboBox<>();
        comboBoxName.addItem("Сверло");
        add(comboBoxName);
        comboBoxName.addActionListener(comboBoxActionListener);
        return comboBoxName;
    }

    /**
     * Метод создает надпись длинны острой части сверла
     * @return возвращает надпись длинны острой части сверла
     */
    private JLabel createLabelLengthBlade() {
        JLabel labelLengthBlade = new JLabel(">,мм: ");
        add(labelLengthBlade);
        return labelLengthBlade;
    }

    /**
     * Метод создает поле длинны острой части сверла
     * @return возвращает поле длинны острой части сверла
     */
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
}
