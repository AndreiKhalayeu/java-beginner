package engineeringtechnology.graphicfield;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProcessingComboBox implements ActionListener {
    private static int numberBox;

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox<String> clickedComboBox = (JComboBox) e.getSource();
        numberBox = clickedComboBox.getSelectedIndex();
    }

    public static int getNumberBox() {
        return numberBox;
    }
}
