package engineeringtechnology.graphicfield;

import engineeringtechnology.graphicfield.tabs.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProcessingField implements ActionListener {
    private Field field;
    private TabCutter cutter;

    ProcessingField(Field field, TabCutter cutter) {
        this.field = field;
        this.cutter = cutter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton clickedButton = (JButton) e.getSource();

        if (clickedButton == field.getButtonStart()) {
            cutter.getFieldDiameter().setText("20");
        }
    }
}
