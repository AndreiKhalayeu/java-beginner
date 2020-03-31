package engineeringtechnology.graphicfield.tabs;

import engineeringtechnology.cuttingmodes.tool.Tap;
import listener.ComboBoxActionListener;
import listener.ComboBoxFeedActionListener;

import javax.swing.*;
import java.awt.*;

/**
 * Класс вкладка метчик
 */
public class TabTap extends TabCutter {
    /**
     * поле сверло
     */
    private JFormattedTextField fieldDrill;

    /**
     * Метод создает понель по линейной схеме расположения поля: надпись диаметра, поле диаметра, надпись
     * подачи, поле подачи, надпись машинной подачи, поле машинной подачи, надпись оборотов, поле оборотов
     * @return возвращает созданную панель
     */
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

    /**
     * Метод создает панель по линейной схеме расположения поля: надпись диаметра под метчик,
     * поле диаметра под метчик
     * @return возвращает созданную панель
     */
    @Override
    protected JPanel createPanelFlowLayoutTabRight() {
        JPanel rightPanelBorderLayout = new JPanel();
        rightPanelBorderLayout.setLayout(new FlowLayout());
        rightPanelBorderLayout.add(createLabelDrill());
        rightPanelBorderLayout.add(createFieldDrill());
        return rightPanelBorderLayout;
    }

    /**
     * Метод создает выподающий список метчиков
     * @return возвращает выподающий список метчиков
     */
    @Override
    protected JComboBox<String> createFieldName() {
        ComboBoxActionListener comboBoxActionListener = new ComboBoxActionListener();
        comboBoxName = new JComboBox<>();
        comboBoxName.addItem("Метр. резьба ГОСТ 24705-81");
        add(comboBoxName);
        comboBoxName.addActionListener(comboBoxActionListener);
        return comboBoxName;
    }

    /**
     * Метод создает выподающий список подач
     * @return возвращает выподающий список подач
     */
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

    /**
     * Метод создает надпись диаметра под метчик
     * @return возвращает надпись диаметра под метчик
     */
    private JLabel createLabelDrill() {
        JLabel labelDrill = new JLabel("Сверло D,мм: ");
        add(labelDrill);
        return labelDrill;
    }

    /**
     * Метод создает поле диаметра под метчик
     * @return возвращает поле диаметра под метчик
     */
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
