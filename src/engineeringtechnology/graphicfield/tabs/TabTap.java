package engineeringtechnology.graphicfield.tabs;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс вкладка метчик
 */
public class TabTap extends AbstractTab {
    /**
     * поле сверло
     */
    private JFormattedTextField fieldDrill;

    public TabTap() {
        super();
    }

    @Override
    protected String[] getItems() {
        return new String[] {"Метр. резьба ГОСТ 24705-81"};
    }

    @Override
    protected Map<JLabel, JFormattedTextField> getComponent() {
        Map<JLabel, JFormattedTextField> map = new HashMap<>();
        map.put(createLabelDrill(), createFieldDrill());
        return map;
    }

    private JLabel createLabelDrill() {
        JLabel labelDrill = new JLabel("Сверло D,мм: ");
        add(labelDrill);
        return labelDrill;
    }

    private JFormattedTextField createFieldDrill() {
        fieldDrill = new JFormattedTextField("0");
        add(fieldDrill);
        fieldDrill.setPreferredSize(new Dimension(45,20));
        fieldDrill.setEditable(false);
        return fieldDrill;
    }

    public JFormattedTextField getFieldDrill() {
        return fieldDrill;
    }
}
