package engineeringtechnology.graphicfield;

import engineeringtechnology.graphicfield.tabs.*;

import javax.swing.*;
import java.awt.*;

public class Field {
    private JButton buttonStart;
    private JButton buttonStop;
    private TabCountersink countersink;
    private TabCutter cutter;
    private TabDrill drill;
    private TabSweep sweep;
    private TabTap tap;
    private ProcessingField processingField;

    Field() {
        createFrame();
    }

    private void createFrame() {
        JFrame frame = new JFrame("Calculation of modes");
        frame.setContentPane(createMainPanel());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //frame.setSize(700, 200);
        frame.setVisible(true);
        frame.setBounds(650,400,700,200);
        frame.setResizable(false);
    }

    private JPanel createMainPanel() {
        JPanel mainPanel = new JPanel();
        BorderLayout layout = new BorderLayout();
        mainPanel.setLayout(layout);
        mainPanel.add("North", createNorthPanel());
        mainPanel.add("Center", createCenterPanel());
        mainPanel.add("South", createSouthPanel());
        return mainPanel;
    }

    private JPanel createNorthPanel() {
        JPanel northPanel = new JPanel();
        northPanel.setBackground(Color.BLACK);
        return northPanel;
    }

    private JPanel createCenterPanel() {
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.BLACK);
        centerPanel.add(createTads());
        return centerPanel;
    }

    private JPanel createSouthPanel() {
        JPanel southPanel = new JPanel();
        southPanel.setBackground(Color.BLACK);
        southPanel.add(createButtonStart());
        southPanel.add(createButtonStop());
        return southPanel;
    }

    private JButton createButtonStart() {
        buttonStart = new JButton("Расчитать");
        buttonStart.setBackground(Color.LIGHT_GRAY);
        buttonStart.addActionListener(processingField);
        return buttonStart;
    }

    private JButton createButtonStop() {
        buttonStop = new JButton("Сброс");
        buttonStop.setBackground(Color.LIGHT_GRAY);
        buttonStop.addActionListener(processingField);
        return buttonStop;
    }

    private JTabbedPane createTads() {
        JTabbedPane tab = new JTabbedPane();
        countersink = new TabCountersink();
        cutter = new TabCutter();
        drill = new TabDrill();
        sweep = new TabSweep();
        tap = new TabTap();
        createProcessing(countersink, cutter, drill, sweep, tap);
        tab.add("Зенкер", countersink);
        tab.add("Фреза", cutter);
        tab.add("Сверло", drill);
        tab.add("Развертка", sweep);
        tab.add("Метчик", tap);
        tab.setBackground(Color.gray);
        tab.setForeground(Color.BLACK);
        tab.setPreferredSize(new Dimension(650,100));
        return tab;
    }

    private void createProcessing(TabCountersink countersink, TabCutter cutter,
                                  TabDrill drill, TabSweep sweep, TabTap tap) {
        processingField = new ProcessingField(this, countersink, cutter, drill, sweep, tap);
    }

    public JButton getButtonStart() {
        return buttonStart;
    }

    public JButton getButtonStop() {
        return buttonStop;
    }

    public JPanel getCountersink() {
        return countersink;
    }

    public JPanel getCutter() {
        return cutter;
    }

    public JPanel getDrill() {
        return drill;
    }

    public JPanel getSweep() {
        return sweep;
    }

    public JPanel getTap() {
        return tap;
    }

    public static void main(String[] args) {
        new Field();
    }
}
