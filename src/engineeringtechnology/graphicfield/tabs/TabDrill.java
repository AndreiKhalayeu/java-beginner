package engineeringtechnology.graphicfield.tabs;

import javax.swing.*;
import java.awt.*;

public class TabDrill extends TabCutter {
    private JLabel labelLengthBlade;

    public TabDrill() {
        super();
        createLabelLengthBlade();
        createField();
    }

    private void createLabelLengthBlade() {
        labelLengthBlade = new JLabel(">: ");
        add(labelLengthBlade);
    }
}
