package engineeringtechnology.graphicfield;

import engineeringtechnology.cuttingmodes.tool.Countersink;
import engineeringtechnology.cuttingmodes.tool.Cutter;
import engineeringtechnology.graphicfield.tabs.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProcessingField implements ActionListener {
    private Field field;
    private TabCountersink tabCountersink;
    private TabCutter tabCutter;
    private TabDrill tabDrill;
    private TabSweep tabSweep;
    private TabTap tabTap;

    ProcessingField(Field field, TabCountersink tabCountersink, TabCutter tabCutter, TabDrill tabDrill,
                    TabSweep tabSweep, TabTap tabTap) {
        this.field = field;
        this.tabCountersink = tabCountersink;
        this.tabCutter = tabCutter;
        this.tabDrill = tabDrill;
        this.tabSweep = tabSweep;
        this.tabTap = tabTap;
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
        Cutter cutter = new Cutter();
        Countersink countersink = new Countersink();
        try {
            if (!tabCutter.getFieldDiameter().getText().equals(" ") && Integer.parseInt(tabCutter.getFieldDiameter().getText()) > 9
                    && Integer.parseInt(tabCutter.getFieldDiameter().getText()) < 51) {
                tabCutter.getFieldTurns().setText("" + cutter.calculateTurns(Cutter.SPEED, Integer.parseInt(tabCutter.getFieldDiameter().getText())));
            }

        } catch (NumberFormatException e) {
            tabCutter.getFieldTurns().setText("");
        }
//        if (!cutter.getFieldFeed().getText().equals(" ")) {
//            cutter.getFieldMachineFeed().setText("" + cut.calculateFeed(Cutter.FEED, Integer.parseInt(cutter.getFieldDiameter().getText())));
//        }
    }

    private void deleteContentField() {
        tabCutter.getFieldDiameter().setText("");
        tabCutter.getFieldTurns().setText("");
        tabCutter.getFieldMachineFeed().setText("");
    }
}
