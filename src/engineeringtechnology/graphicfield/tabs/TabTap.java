package engineeringtechnology.graphicfield.tabs;


import javax.swing.*;
import java.awt.*;

public class TabTap extends TabCutter {
    private JFormattedTextField fieldDrill;

    public TabTap() {
        super();
        createLabelDrill();
        createFieldDrill();

    }

    protected void createFieldDrill() {
        fieldDrill = new JFormattedTextField();
        add(fieldDrill);
        fieldDrill.setPreferredSize(new Dimension(45,20));
    }

    private void createLabelDrill() {
        JLabel labelDrill = new JLabel("Сверло под метчик D,мм: ");
        add(labelDrill);
    }

    public JFormattedTextField getFieldDrill() {
        return fieldDrill;
    }

    public void setFieldDrill(JFormattedTextField fieldDrill) {
        this.fieldDrill = fieldDrill;
    }
}
