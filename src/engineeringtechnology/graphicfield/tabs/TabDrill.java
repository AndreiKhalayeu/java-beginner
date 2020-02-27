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
        JFormattedTextField fieldBlade = new JFormattedTextField();
        add(fieldBlade);
        fieldBlade.setPreferredSize(new Dimension(45,20));
    }

    private void createLabelLengthBlade() {
        JLabel labelLengthBlade = new JLabel(">: ");
        add(labelLengthBlade);
    }

    public JFormattedTextField getFieldBlade() {
        return fieldBlade;
    }

    public void setFieldBlade(JFormattedTextField fieldBlade) {
        this.fieldBlade = fieldBlade;
    }
}
