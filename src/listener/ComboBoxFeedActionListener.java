package listener;

import engineeringtechnology.cuttingmodes.tool.Tap;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Класс слушатель выподающего списка подач
 */
public class ComboBoxFeedActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox<String> clickedComboBoxFeed = (JComboBox) e.getSource();
        int numberComboBoxFeed = clickedComboBoxFeed.getSelectedIndex();
        setFeedTap(numberComboBoxFeed);
    }

    /**
     * Метод для установки подачи
     * @param numberComboBoxFeed подача
     */
    private void setFeedTap(int numberComboBoxFeed) {
        for (int i = 0; i < Tap.FEED.size(); i++) {
            if (numberComboBoxFeed == i) {
                Tap.setFeedTap(Tap.FEED.get(i));
            }
        }
    }
}
