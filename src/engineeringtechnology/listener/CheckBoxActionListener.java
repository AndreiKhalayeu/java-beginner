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
        for (int i = 0; i < Data.LIST_TAB.size(); i++) {
            if (numberTab == i) {
                if (Data.LIST_TAB.get(i).isCheckBox()) {
                    Data.LIST_TAB.get(i).setCheckBox(false);
                } else {
                    Data.LIST_TAB.get(i).setCheckBox(true);
                }
            }
        }
    }
}
