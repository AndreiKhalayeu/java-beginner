package engineeringtechnology.graphicfield;

import javax.swing.*;
import java.util.ArrayList;

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
     * Метод создает кнопки
     * @return возвращает кнопку рассчитать
     */
    ArrayList<JButton> createButton();

    /**
     * Метод создает панель вкладок
     * @return возвращает панель вкладок
     */
    JTabbedPane createTads();
}
