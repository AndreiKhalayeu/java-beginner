package engineeringtechnology.graphicfield.tabs;

import engineeringtechnology.graphicfield.ProcessingComboBox;

import javax.swing.*;

public class TabSweep extends TabCutter {
//    private boolean check = false;
//    private int numberBox;

    @Override
    protected JComboBox<String> createFieldName() {
        ProcessingComboBox processingComboBox = new ProcessingComboBox();
        comboBoxName = new JComboBox<>();
        comboBoxName.addItem("Цилиндр. развертка");
        comboBoxName.addItem("Конич. развертка");
        add(comboBoxName);
        comboBoxName.addActionListener(processingComboBox);
        return comboBoxName;
    }

//    public boolean isCheck() {
//        return check;
//    }
//
//    public void setCheck(boolean check) {
//        this.check = check;
//    }
//
//    public int getNumberBox() {
//        return numberBox;
//    }
//
//    public void setNumberBox(int numberBox) {
//        this.numberBox = numberBox;
//    }
}
