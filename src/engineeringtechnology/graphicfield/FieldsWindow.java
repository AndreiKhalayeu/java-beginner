package engineeringtechnology.graphicfield;

import javax.swing.*;

public interface FieldsWindow {

    /**
     * Метод создает фрейм
     */
    void createFrame();

    /**
     * Метод создает панель с полярным расположением панелей(северная, центральная, южная)
     * @return возвращает панель с полярным расположением панелей
     */
    JPanel createMainPanel();

    /**
     * Метод создает северную панель
     * @return возвращает северную панель
     */
    JPanel createNorthPanel();

    /**
     * Метод создает центральную панель
     * @return возвращает центральную панель
     */
    JPanel createCenterPanel();

    /**
     * Метод создает южную панель
     * @return возвращает южную панель
     */
    JPanel createSouthPanel();

    /**
     * Метод создает кнопку рассчитать
     * @return возвращает кнопку рассчитать
     */
    JButton createButtonStart();

    /**
     * Метод создает кнопку сброс
     * @return возвращает кнопку сброс
     */
    JButton createButtonStop();

    /**
     * Метод создает панель вкладок
     * @return возвращает панель вкладок
     */
    JTabbedPane createTads();
}
