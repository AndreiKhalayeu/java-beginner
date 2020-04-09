package engineeringtechnology.graphicfield.tabs;

import engineeringtechnology.listener.CheckBoxActionListener;
import engineeringtechnology.listener.ComboBoxActionListener;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class AbstractTab extends JPanel implements FieldsTab {

    /**
     * Поле сообщение ошибки
     */
    protected JLabel messageError;

    /**
     * Поле флажек
     */
    protected boolean checkBox = false;

    /**
     * Поле номер в выпадающем списке
     */
    protected int numberComboBox;

    /**
     * Поле для ввода подачи
     */
    protected JFormattedTextField fieldFeed;

    /**
     * Поле имя выпадающего списка
     */
    protected JComboBox<String> comboBoxName;

    /**
     * Поле для ввода диаметра
     */
    private JFormattedTextField fieldDiameter;

    /**
     * Поле для вывода машинной подачи
     */
    private JFormattedTextField fieldMachineFeed;

    /**
     * Поле для вывода оборотов
     */
    private JFormattedTextField fieldTurns;

    /**
     * Поле надпись формул оборотов и подачи
     */
    private JLabel labelFormulaTurnsFeed;

    public AbstractTab() {
        createFlowLayoutTab();
    }

    protected abstract String[] getItems();

    protected Map<JLabel, JFormattedTextField> getComponent() {
        return new HashMap<>();
    }

    @Override
    public void createFlowLayoutTab() {
        FlowLayout flowLayout = new FlowLayout();
        this.setLayout(flowLayout);
        this.add(createPanelBorderLayoutTabLeft());
        this.add(createPanelBorderLayoutTabCenter());
        this.add(createPanelBorderLayoutTabRight());
        flowLayout.setAlignment(FlowLayout.LEFT);
    }

    @Override
    public JPanel createPanelBorderLayoutTabLeft() {
        JPanel panelBorderLayoutTabLeft = new JPanel();
        panelBorderLayoutTabLeft.setLayout(new BorderLayout());
        panelBorderLayoutTabLeft.add("Center", createFieldName());
        panelBorderLayoutTabLeft.add("South", createCheckBox());
        panelBorderLayoutTabLeft.setPreferredSize(new Dimension(195,50));
        return panelBorderLayoutTabLeft;
    }

    @Override
    public JPanel createPanelBorderLayoutTabCenter() {
        JPanel panelBorderLayoutTabCenter = new JPanel();
        panelBorderLayoutTabCenter.setLayout(new BorderLayout());
        panelBorderLayoutTabCenter.add("North", createMessageError());
        panelBorderLayoutTabCenter.add("Center", createPanelFlowLayoutTabCenter());
        panelBorderLayoutTabCenter.add("South", createLabelFormulaTurnsFeed());
        return panelBorderLayoutTabCenter;
    }

    @Override
    public JPanel createPanelFlowLayoutTabCenter() {
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
    public JPanel createPanelBorderLayoutTabRight() {
        JPanel panelBorderLayoutTabRight = new JPanel();
        panelBorderLayoutTabRight.setLayout(new BorderLayout());
        panelBorderLayoutTabRight.add("Center", createPanelFlowLayoutTabRight());
        return panelBorderLayoutTabRight;
    }

    @Override
    public JPanel createPanelFlowLayoutTabRight() {
        JPanel rightPanelBorderLayout = new JPanel();
        rightPanelBorderLayout.setLayout(new FlowLayout());
        Set<Map.Entry<JLabel, JFormattedTextField>> data = getComponent().entrySet();
        for (Map.Entry<JLabel, JFormattedTextField> value : data) {
            rightPanelBorderLayout.add(value.getKey());
            rightPanelBorderLayout.add(value.getValue());
        }
        return rightPanelBorderLayout;
    }

    @Override
    public JPanel createMessageError() {
        JPanel error = new JPanel();
        messageError = new JLabel("");
        error.add(messageError);
        messageError.setPreferredSize(new Dimension(350, 15));
        return error;
    }

    @Override
    public JComboBox<String> createFieldName() {
        ComboBoxActionListener comboBoxActionListener = new ComboBoxActionListener();
        comboBoxName = new JComboBox<>();
        for (String item : getItems()) {
            comboBoxName.addItem(item);
        }
        add(comboBoxName);
        comboBoxName.addActionListener(comboBoxActionListener);
        return comboBoxName;
    }

    @Override
    public JCheckBox createCheckBox() {
        CheckBoxActionListener processingCheckBox = new CheckBoxActionListener();
        JCheckBox jCheckBox = new JCheckBox("ГФ2171");
        add(jCheckBox);
        jCheckBox.addActionListener(processingCheckBox);
        return jCheckBox;
    }

    @Override
    public JLabel createLabelDiameter() {
        JLabel labelDiameter = new JLabel("D,мм: ");
        add(labelDiameter);
        return labelDiameter;
    }

    @Override
    public JFormattedTextField createFieldDiameter() {
        fieldDiameter = new JFormattedTextField();
        add(fieldDiameter);
        fieldDiameter.setPreferredSize(new Dimension(45,20));
        return fieldDiameter;
    }

    @Override
    public JLabel createLabelFeed() {
        JLabel labelFeed = new JLabel("s,мм/об: ");
        add(labelFeed);
        return labelFeed;
    }

    @Override
    public JFormattedTextField createFieldFeed() {
        fieldFeed = new JFormattedTextField();
        add(fieldFeed);
        fieldFeed.setPreferredSize(new Dimension(45,20));
        return fieldFeed;
    }

    @Override
    public JLabel createLabelMachineFeed() {
        JLabel labelMachineFeed = new JLabel("F,мм/мин: ");
        add(labelMachineFeed);
        return labelMachineFeed;
    }

    @Override
    public JFormattedTextField createFieldMachineFeed() {
        fieldMachineFeed = new JFormattedTextField("0");
        add(fieldMachineFeed);
        fieldMachineFeed.setPreferredSize(new Dimension(45,20));
        fieldMachineFeed.setEditable(false);
        return fieldMachineFeed;
    }

    @Override
    public JLabel createLabelTurns() {
        JLabel labelTurns = new JLabel("n,об/мин: ");
        add(labelTurns);
        return labelTurns;
    }

    @Override
    public JFormattedTextField createFieldTurns() {
        fieldTurns = new JFormattedTextField("0");
        add(fieldTurns);
        fieldTurns.setPreferredSize(new Dimension(45,20));
        fieldTurns.setEditable(false);
        return fieldTurns;
    }

    @Override
    public JLabel createLabelFormulaTurnsFeed() {
        labelFormulaTurnsFeed = new JLabel("");
        add(labelFormulaTurnsFeed);
        labelFormulaTurnsFeed.setForeground(Color.gray);
        labelFormulaTurnsFeed.setPreferredSize(new Dimension(350, 15));
        return labelFormulaTurnsFeed;
    }

    public JFormattedTextField getFieldDiameter() {
        return fieldDiameter;
    }

    public JFormattedTextField getFieldMachineFeed() {
        return fieldMachineFeed;
    }

    public JFormattedTextField getFieldTurns() {
        return fieldTurns;
    }

    public JLabel getLabelFormulaTurnsFeed() {
        return labelFormulaTurnsFeed;
    }

    public JFormattedTextField getFieldFeed() {
        return fieldFeed;
    }

    public boolean isCheckBox() {
        return checkBox;
    }

    public void setCheckBox(boolean checkBox) {
        this.checkBox = checkBox;
    }

    public int getNumberComboBox() {
        return numberComboBox;
    }

    public void setNumberComboBox(int numberComboBox) {
        this.numberComboBox = numberComboBox;
    }

    public JLabel getMessageError() {
        return messageError;
    }
}
