package engineeringtechnology.graphicfield.tabs;


import javax.swing.*;

public class TabTap extends TabCutter {
    private JLabel labelDrill;
    public TabTap() {
        super();
        createLabelDrill();
        createField();
        createComboBox();
    }

    private void createLabelDrill() {
        labelDrill = new JLabel("Сверло под метчик D,мм: ");
        add(labelDrill);
    }

    private void createComboBox() {
        JComboBox<String> comboBox = new JComboBox<String>();
        comboBox.addItem("метрическая резьба");
        comboBox.addItem("Коническая резьба");
        add(comboBox);
    }
}
