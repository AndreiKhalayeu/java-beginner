package listener;

import engineeringtechnology.cuttingmodes.data.Data;
import engineeringtechnology.cuttingmodes.tool.Tap;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboBoxFeedActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox<String> clickedComboBoxFeed = (JComboBox) e.getSource();
        int numberComboBoxFeed = clickedComboBoxFeed.getSelectedIndex();
        setFeedTap(numberComboBoxFeed);
    }

    private void setFeedTap(int numberComboBoxFeed) {
        for (int i = 0; i < Tap.FEED.size(); i++) {
            if (numberComboBoxFeed == i) {
                Tap.setFeedTap(Tap.FEED.get(i));
            }
        }
    }
}
