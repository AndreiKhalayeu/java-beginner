package engineeringtechnology.graphicfield;

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
            calculationCutterModes();

        } else {
            cutter.getFieldDiameter().setText("");
            cutter.getFieldFeed().setText("");
            cutter.getFieldTurns().setText("");
            cutter.getFieldMachineFeed().setText("");
        }
    }

    private void calculationCutterModes() {
        Cutter cut = new Cutter();
        if (!cutter.getFieldDiameter().getText().equals(" ")) {
            cutter.getFieldTurns().setText("" + cut.calculateTurns(Cutter.SPEED, Integer.parseInt(cutter.getFieldDiameter().getText())));
        }
//        if (!cutter.getFieldFeed().getText().equals(" ")) {
//            cutter.getFieldMachineFeed().setText("" + cut.calculateFeed(Cutter.FEED, Integer.parseInt(cutter.getFieldDiameter().getText())));
//        }
    }
}
