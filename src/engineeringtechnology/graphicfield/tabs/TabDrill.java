package engineeringtechnology.graphicfield.tabs;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class TabDrill extends AbstractTab {
    private JFormattedTextField fieldBlade;

    public TabDrill() {
        super();
    }

    @Override
    protected String[] getItems() {
        return new String[] {"Сверло"};
    }

    @Override
    protected Map<JLabel, JFormattedTextField> getComponent() {
        Map<JLabel, JFormattedTextField> map = new HashMap<>();
        map.put(createLabelLengthBlade(), createFieldBlade());
        return map;
    }

    private JLabel createLabelLengthBlade() {
        JLabel labelLengthBlade = new JLabel(">,мм: ");
        add(labelLengthBlade);
        return labelLengthBlade;
    }

    private JFormattedTextField createFieldBlade() {
        fieldBlade = new JFormattedTextField("0");
        add(fieldBlade);
        fieldBlade.setPreferredSize(new Dimension(45,20));
        fieldBlade.setEditable(false);
        return fieldBlade;
    }

    public JFormattedTextField getFieldBlade() {
        return fieldBlade;
    }
}
