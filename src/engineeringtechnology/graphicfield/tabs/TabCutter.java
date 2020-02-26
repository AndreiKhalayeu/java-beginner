package engineeringtechnology.graphicfield.tabs;

import javax.swing.*;
import java.awt.*;

public class TabCutter extends JPanel {
    private JLabel labelDiameter;
    private JLabel labelFeed;
    private JLabel labelTurns;
    private JLabel labelMachineFeed;

    public TabCutter() {
        createLabelDiameter();
        createField();
        createLabelFeed();
        createField();
        createLabelTurns();
        createField();
        createLabelMachineFeed();
        createField();
    }

    protected void createField() {
        JFormattedTextField fieldDiameter = new JFormattedTextField();
        add(fieldDiameter);
        fieldDiameter.setPreferredSize(new Dimension(45,20));
    }

    private void createLabelDiameter() {
        labelDiameter = new JLabel("D,мм: ");
        add(labelDiameter);
    }

    private void createLabelFeed() {
        labelFeed = new JLabel("s,мм/об: ");
        add(labelFeed);
    }

    private void createLabelTurns() {
        labelTurns = new JLabel("n,об/мин: ");
        add(labelTurns);
    }

    private void createLabelMachineFeed() {
        labelMachineFeed = new JLabel("F,мм/мин: ");
        add(labelMachineFeed);
    }
}
