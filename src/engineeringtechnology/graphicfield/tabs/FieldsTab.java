package engineeringtechnology.graphicfield.tabs;

import javax.swing.*;

public interface FieldsTab {
    /**
     * Метод создает линейную схему расположения с тремя панелями
     */
    void createFlowLayoutTab();

    /**
     * Метод создает левую панель с полярным расположением панелей (центральная, южная)
     * @return возвращает созданную панель
     */
    JPanel createPanelBorderLayoutTabLeft();

    /**
     * Метод создает центральную панель с полярным расположением панелей (центральная, южная)
     * @return возвращает созданную панель
     */
    JPanel createPanelBorderLayoutTabCenter();

    /**
     * Метод создает понель по линейной схеме расположения поля: надпись диаметра, поле диаметра, надпись
     * подачи, поле подачи, надпись машинной подачи, поле машинной подачи, надпись оборотов, поле оборотов
     * @return возвращает созданную панель
     */
    JPanel createPanelFlowLayoutTabCenter();

    /**
     * Метод создает правую панель с полярным расположением панелей (центральная)
     * @return возвращает созданную панель
     */
    JPanel createPanelBorderLayoutTabRight();

    /**
     * Метод создает панель по линейной схеме расположения
     * @return возвращает созданную панель
     */
    JPanel createPanelFlowLayoutTabRight();

    /**
     * Метод создает выподающий список инструментов
     * @return возвращает выподающий список инструментов
     */
    JComboBox<String> createFieldName();

    /**
     * Метод создает флажек
     * @return возвращает флажек
     */
    JCheckBox createCheckBox();

    /**
     * Метод создает надпись диаметра
     * @return возвращает надпись диаметра
     */
    JLabel createLabelDiameter();

    /**
     * Метод создает поле диаметра
     * @return возвращает поле диаметра
     */
    JFormattedTextField createFieldDiameter();

    /**
     * Метод создает надпись подачи
     * @return возвращает надпись подачи
     */
    JLabel createLabelFeed();

    /**
     * Метод создает поле подачи
     * @return возвращает поле подачи
     */
    JFormattedTextField createFieldFeed();

    /**
     * Метод создает надпись машинной подачи
     * @return возвращает надпись машинной подачи
     */
    JLabel createLabelMachineFeed();

    /**
     * Метод создает поле машинной подачи
     * @return возвращает поле машинной подачи
     */
    JFormattedTextField createFieldMachineFeed();

    /**
     * Метод создает надпись оборотов
     * @return возвращает надпись оборотов
     */
    JLabel createLabelTurns();

    /**
     * Метод создает поле оборотов
     * @return возвращает поле оборотов
     */
    JFormattedTextField createFieldTurns();

    /**
     * Метод создает надпись формулы оборотов и подачи
     * @return возвращает надпись формулы оборотов и подачи
     */
    JLabel createLabelFormulaTurnsFeed();
}
