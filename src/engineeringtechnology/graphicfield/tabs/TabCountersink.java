package engineeringtechnology.graphicfield.tabs;


import engineeringtechnology.graphicfield.ProcessingCheckBox;

import javax.swing.*;
import java.awt.*;

public class TabCountersink extends TabCutter {
    public TabCountersink() {
    }

    @Override
    protected void createCheckBox() {
        ProcessingCheckBox processingCheckBox = new ProcessingCheckBox(this);
        JCheckBox checkBox = new JCheckBox("ГФ2171");
        add(checkBox);
        checkBox.addActionListener(processingCheckBox);
    }

    @Override
    protected void createLabelFormulaTurnsFeed() {
        JLabel labelFormulaTurnsFeed = new JLabel("n = 1000*12 / 3.14*D, об/мин  F = n*s, мм/мин  s = 0.2...0.4, мм/об");
        add(labelFormulaTurnsFeed);
        labelFormulaTurnsFeed.setForeground(Color.gray);
    }
}
