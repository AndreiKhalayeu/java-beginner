package engineeringtechnology.graphicfield.tabs;

import engineeringtechnology.listener.CheckBoxActionListener;
import engineeringtechnology.listener.ComboBoxActionListener;

import javax.swing.*;
import java.awt.*;

/**
 * Класс вкладка фреза
 */
public class TabCutter extends JPanel {
    /**
     * Поле флажек
     */
    protected boolean checkBox = false;

    /**
     * Поле номер в выпадающем списке
     */
    protected int numberComboBox;

    /**
     * Поле для ввода диаметра
     */
    private JFormattedTextField fieldDiameter;

    /**
     * Поле для ввода подачи
     */
    private JFormattedTextField fieldFeed;

    /**
     * Поле для вывода оборотов
     */
    private JFormattedTextField fieldTurns;

    /**
     * Поле для вывода машинной подачи
     */
    private JFormattedTextField fieldMachineFeed;

    /**
     * Поле имя выпадающего списка
     */
    protected JComboBox<String> comboBoxName;

    /**
     * Поле надпись формул оборотов и подачи
     */
    private JLabel labelFormulaTurnsFeed;

    /**
     * Конструктор вкладка фреза
     */
    public TabCutter() {
        createFlowLayoutTab();
    }

    /**
     * Метод создает линейную схему расположения с тремя панелями
     */
    protected void createFlowLayoutTab() {
        FlowLayout flowLayout = new FlowLayout();
        this.setLayout(flowLayout);
        this.add(createPanelBorderLayoutTabLeft());
        this.add(createPanelBorderLayoutTabCenter());
        this.add(createPanelBorderLayoutTabRight());
        flowLayout.setAlignment(FlowLayout.LEFT);
    }

    /**
     * Метод создает левую панель с полярным расположением панелей (центральная, южная)
     * @return возвращает созданную панель
     */
    protected JPanel createPanelBorderLayoutTabLeft() {
        JPanel panelBorderLayoutTabLeft = new JPanel();
        panelBorderLayoutTabLeft.setLayout(new BorderLayout());
        panelBorderLayoutTabLeft.add("Center", createFieldName());
        panelBorderLayoutTabLeft.add("South", createCheckBox());
        panelBorderLayoutTabLeft.setPreferredSize(new Dimension(220,50));
        return panelBorderLayoutTabLeft;
    }

    /**
     * Метод создает центральную панель с полярным расположением панелей (центральная, южная)
     * @return возвращает созданную панель
     */
    protected JPanel createPanelBorderLayoutTabCenter() {
        JPanel panelBorderLayoutTabCenter = new JPanel();
        panelBorderLayoutTabCenter.setLayout(new BorderLayout());
        panelBorderLayoutTabCenter.add("Center", createPanelFlowLayoutTabCenter());
        panelBorderLayoutTabCenter.add("South", createLabelFormulaTurnsFeed());
        return panelBorderLayoutTabCenter;
    }


    /**
     * Метод создает понель по линейной схеме расположения поля: надпись диаметра, поле диаметра, надпись
     * подачи, поле подачи, надпись машинной подачи, поле машинной подачи, надпись оборотов, поле оборотов
     * @return возвращает созданную панель
     */
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
     * Метод создает правую панель с полярным расположением панелей (центральная)
     * @return возвращает созданную панель
     */
    protected JPanel createPanelBorderLayoutTabRight() {
        JPanel panelBorderLayoutTabRight = new JPanel();
        panelBorderLayoutTabRight.setLayout(new BorderLayout());
        panelBorderLayoutTabRight.add("Center", createPanelFlowLayoutTabRight());
        return panelBorderLayoutTabRight;
    }

    /**
     * Метод создает панель по линейной схеме расположения
     * @return возвращает созданную панель
     */
    protected JPanel createPanelFlowLayoutTabRight() {
        JPanel rightPanelBorderLayout = new JPanel();
        rightPanelBorderLayout.setLayout(new FlowLayout());
        return rightPanelBorderLayout;
    }

    /**
     * Метод создает выподающий список фрез
     * @return возвращает выподающий список фрез
     */
    protected JComboBox<String> createFieldName() {
        ComboBoxActionListener comboBoxActionListener = new ComboBoxActionListener();
        comboBoxName = new JComboBox<>();
        comboBoxName.addItem("Концевая фреза");
        comboBoxName.addItem("Торцевая фреза");
        add(comboBoxName);
        comboBoxName.addActionListener(comboBoxActionListener);
        return comboBoxName;
    }

    /**
     * Метод создает флажек
     * @return возвращает флажек
     */
    protected JCheckBox createCheckBox() {
        CheckBoxActionListener processingCheckBox = new CheckBoxActionListener();
        JCheckBox jCheckBox = new JCheckBox("ГФ2171");
        add(jCheckBox);
        jCheckBox.addActionListener(processingCheckBox);
        return jCheckBox;
    }

    /**
     * Метод создает надпись диаметра
     * @return возвращает надпись диаметра
     */
    protected JLabel createLabelDiameter() {
        JLabel labelDiameter = new JLabel("D,мм: ");
        add(labelDiameter);
        return labelDiameter;
    }

    /**
     * Метод создает поле диаметра
     * @return возвращает поле диаметра
     */
    protected JFormattedTextField createFieldDiameter() {
        fieldDiameter = new JFormattedTextField();
        add(fieldDiameter);
        fieldDiameter.setPreferredSize(new Dimension(45,20));
        return fieldDiameter;
    }

    /**
     * Метод создает надпись подачи
     * @return возвращает надпись подачи
     */
    protected JLabel createLabelFeed() {
        JLabel labelFeed = new JLabel("s,мм/об: ");
        add(labelFeed);
        return labelFeed;
    }

    /**
     * Метод создает поле подачи
     * @return возвращает поле подачи
     */
    private JFormattedTextField createFieldFeed() {
        fieldFeed = new JFormattedTextField();
        add(fieldFeed);
        fieldFeed.setPreferredSize(new Dimension(45,20));
        return fieldFeed;
    }

    /**
     * Метод создает надпись машинной подачи
     * @return возвращает надпись машинной подачи
     */
    protected JLabel createLabelMachineFeed() {
        JLabel labelMachineFeed = new JLabel("F,мм/мин: ");
        add(labelMachineFeed);
        return labelMachineFeed;
    }

    /**
     * Метод создает поле машинной подачи
     * @return возвращает поле машинной подачи
     */
    protected JFormattedTextField createFieldMachineFeed() {
        fieldMachineFeed = new JFormattedTextField("0");
        add(fieldMachineFeed);
        fieldMachineFeed.setPreferredSize(new Dimension(45,20));
        fieldMachineFeed.setEditable(false);
        return fieldMachineFeed;
    }

    /**
     * Метод создает надпись оборотов
     * @return возвращает надпись оборотов
     */
    protected JLabel createLabelTurns() {
        JLabel labelTurns = new JLabel("n,об/мин: ");
        add(labelTurns);
        return labelTurns;
    }

    /**
     * Метод создает поле оборотов
     * @return возвращает поле оборотов
     */
    protected JFormattedTextField createFieldTurns() {
        fieldTurns = new JFormattedTextField("0");
        add(fieldTurns);
        fieldTurns.setPreferredSize(new Dimension(45,20));
        fieldTurns.setEditable(false);
        return fieldTurns;
    }

    /**
     * Метод создает надпись формулы оборотов и подачи
     * @return возвращает надпись формулы оборотов и подачи
     */
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

    public JLabel getLabelFormulaTurnsFeed() {
        return labelFormulaTurnsFeed;
    }
}
