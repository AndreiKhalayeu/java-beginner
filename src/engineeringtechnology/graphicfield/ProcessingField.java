package engineeringtechnology.graphicfield;

import engineeringtechnology.cuttingmodes.tool.Countersink;
import engineeringtechnology.cuttingmodes.tool.Cutter;
import engineeringtechnology.graphicfield.tabs.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProcessingField implements ActionListener {
    private Field field;
    private TabCountersink countersink;
    private TabCutter cutter;
    private TabDrill drill;
    private TabSweep sweep;
    private TabTap tap;

    ProcessingField(Field field, TabCountersink countersink, TabCutter cutter, TabDrill drill,
                    TabSweep sweep, TabTap tap) {
        this.field = field;
        this.countersink = countersink;
        this.cutter = cutter;
        this.drill = drill;
        this.sweep = sweep;
        this.tap = tap;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton clickedButton = (JButton) e.getSource();

        if (clickedButton == field.getButtonStart()) {
            calculationModes();
        } else if (clickedButton == field.getButtonStop()){
            deleteContentField();
        }
    }

    private void calculationModes() {
        Cutter cut = new Cutter();
        Countersink countersink = new Countersink();
        try {
            if (!cutter.getFieldDiameter().getText().equals(" ") && Integer.parseInt(cutter.getFieldDiameter().getText()) > 9
                    && Integer.parseInt(cutter.getFieldDiameter().getText()) < 51) {
                cutter.getFieldTurns().setText("" + cut.calculateTurns(Cutter.SPEED, Integer.parseInt(cutter.getFieldDiameter().getText())));
            }

        } catch (NumberFormatException e) {
            cutter.getFieldTurns().setText("");
        }
//        if (!cutter.getFieldFeed().getText().equals(" ")) {
//            cutter.getFieldMachineFeed().setText("" + cut.calculateFeed(Cutter.FEED, Integer.parseInt(cutter.getFieldDiameter().getText())));
//        }
    }

    private void deleteContentField() {
        cutter.getFieldDiameter().setText("");
        cutter.getFieldTurns().setText("");
        cutter.getFieldMachineFeed().setText("");
    }
}
