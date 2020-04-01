package engineeringtechnology.listener;

import engineeringtechnology.cuttingmodes.data.Data;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Класс слушатель выпадающего списка
 */
public class ComboBoxActionListener implements ActionListener {
    /**
     * Поле номер выподающего списка
     */
    private int numberComboBox;

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox<String> clickedComboBox = (JComboBox) e.getSource();
        numberComboBox = clickedComboBox.getSelectedIndex();
        setNumberComboBox(TabActionListener.getNumberTab());
    }

    /**
     * Метод для установки номера выподающего списка
     * @param numberTab номер выподающего списка
     */
    private void setNumberComboBox(int numberTab) {
        for (int i = 0; i < Data.LIST_TAB.size(); i++) {
            if (numberTab == i) {
                Data.LIST_TAB.get(i).setNumberComboBox(numberComboBox);
            }
        }
    }
}
