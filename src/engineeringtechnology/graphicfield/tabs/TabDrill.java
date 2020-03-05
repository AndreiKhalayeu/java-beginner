package engineeringtechnology.graphicfield.tabs;

import javax.swing.*;
import java.awt.*;

public class TabDrill extends TabCutter {
    private JFormattedTextField fieldBlade;

    public TabDrill() {
        super();
        createLabelLengthBlade();
        createFieldBlade();
    }

    protected void createFieldBlade() {
        fieldBlade = new JFormattedTextField("0");
        add(fieldBlade);
        fieldBlade.setPreferredSize(new Dimension(45,20));
        fieldBlade.setEditable(false);
    }

    private void createLabelLengthBlade() {
        JLabel labelLengthBlade = new JLabel(">,мм: ");
        add(labelLengthBlade);
    }

    public JFormattedTextField getFieldBlade() {
        return fieldBlade;
    }
}
