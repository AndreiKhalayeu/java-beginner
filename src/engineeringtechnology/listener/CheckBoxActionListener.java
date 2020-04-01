package engineeringtechnology.listener;

import engineeringtechnology.cuttingmodes.data.Data;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Класс слушатель флажка
 */
public class CheckBoxActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        verifyCheckBox(TabActionListener.getNumberTab());
    }

    /**
     *Метод проверяет установлен ли флажек
     * @param numberTab номер вкладки
     */
    private void verifyCheckBox(int numberTab) {
        if (Data.LIST_TAB.get(numberTab).isCheckBox()) {
            Data.LIST_TAB.get(numberTab).setCheckBox(false);
        } else {
            Data.LIST_TAB.get(numberTab).setCheckBox(true);
        }
    }
}
