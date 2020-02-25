package engineeringtechnology.graphicfield;

import engineeringtechnology.graphicfield.tabs.*;

import javax.swing.*;
import java.awt.*;

public class Field {
    private JPanel mainPanel;
    private JPanel southPanel;
    private JPanel northPanel;
    private JPanel centerPanel;
    private JButton buttonStart;
    private JPanel panelStart;

    private JPanel panel;

    Field() {
        createMainPanel();
        createFrame();
        createNorthPanel();
        createCenterPanel();
        createSouthPanel();
        createButtonStart();
        createTads();


    }

    private void createFrame() {
        JFrame frame = new JFrame("Calculation of modes");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(700, 200);
        frame.setVisible(true);
    }

    private void createMainPanel() {
        mainPanel = new JPanel();
        BorderLayout layout = new BorderLayout();
        mainPanel.setLayout(layout);
       // panelStart.add(panelStart, "South");
    }

    private void createNorthPanel() {
        northPanel = new JPanel();
        mainPanel.add("North", northPanel);
        northPanel.setBackground(Color.BLACK);
    }

    private void createCenterPanel() {
        centerPanel = new JPanel();
        mainPanel.add("Center", centerPanel);
        centerPanel.setBackground(Color.BLACK);
    }

    private void createSouthPanel() {
        southPanel = new JPanel();
        mainPanel.add("South", southPanel);
        southPanel.setBackground(Color.BLACK);
    }

    private void createButtonStart() {
        buttonStart = new JButton("Start");
        southPanel.add(buttonStart);
        buttonStart.setBackground(Color.LIGHT_GRAY);
    }

    private void createTads() {
        JTabbedPane tab = new JTabbedPane();
        tab.add("Countersink", new TabCountersink());
        tab.add("Cutter", new TabCutter());
        tab.add("Drill", new TabDrill());
        tab.add("Sweep", new TabSweep());
        tab.add("Tap", new TabTap());
        centerPanel.add(tab);
        tab.setBackground(Color.gray);
        tab.setForeground(Color.BLACK);
    }

    public static void main(String[] args) {
        new Field();
    }

}
