package engineeringtechnology.graphicfield.tabs;

import javax.swing.*;
import java.awt.*;

public class TabDrill extends TabCutter {
    private JFormattedTextField fieldBlade;

    public TabDrill() {
    }

    @Override
    protected void createCheckBox() {
        JCheckBox checkBox = new JCheckBox("ГФ2171");
        add(checkBox);
    }

    private void createFieldBlade() {
        fieldBlade = new JFormattedTextField("0");
        add(fieldBlade);
        fieldBlade.setPreferredSize(new Dimension(45,20));
        fieldBlade.setEditable(false);
    }

    private void createLabelLengthBlade() {
        JLabel labelLengthBlade = new JLabel(">,мм: ");
        add(labelLengthBlade);
    }

    @Override
    protected void createLabelFormulaTurnsFeed() {
        createLabelLengthBlade();
        createFieldBlade();
        JLabel labelFormulaTurnsFeed = new JLabel("n = 1000*18 / 3.14*D, об/мин  F = n*s, мм/мин  s = 0.1...0.3, мм/об");
        add(labelFormulaTurnsFeed);
        labelFormulaTurnsFeed.setForeground(Color.gray);
    }

    public JFormattedTextField getFieldBlade() {
        return fieldBlade;
    }
}
