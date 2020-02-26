package engineeringtechnology.graphicfield;

import engineeringtechnology.graphicfield.tabs.*;

import javax.swing.*;
import java.awt.*;

public class Field {
    private JPanel mainPanel;
    private JPanel southPanel;
    private JPanel centerPanel;

    Field() {
        createMainPanel();
        createFrame();
        createNorthPanel();
        createCenterPanel();
        createSouthPanel();
        createButtonStart();
        createButtonStop();
        createTads();
    }

    private void createFrame() {
        JFrame frame = new JFrame("Calculation of modes");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //frame.setSize(700, 200);
        frame.setVisible(true);
        frame.setBounds(650,400,700,200);
        frame.setResizable(false);
    }

    private void createMainPanel() {
        mainPanel = new JPanel();
        BorderLayout layout = new BorderLayout();
        mainPanel.setLayout(layout);
    }

    private void createNorthPanel() {
        JPanel northPanel = new JPanel();
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
        JButton buttonStart = new JButton("Расчитать");
        southPanel.add(buttonStart);
        buttonStart.setBackground(Color.LIGHT_GRAY);
    }

    private void createButtonStop() {
        JButton buttonStop = new JButton("Сброс");
        southPanel.add(buttonStop);
        buttonStop.setBackground(Color.LIGHT_GRAY);
    }

    private void createTads() {
        JTabbedPane tab = new JTabbedPane();
        tab.add("Зенкер", new TabCountersink());
        tab.add("Фреза", new TabCutter());
        tab.add("Сверло", new TabDrill());
        tab.add("Развертка", new TabSweep());
        tab.add("Метчик", new TabTap());
        centerPanel.add(tab);
        tab.setBackground(Color.gray);
        tab.setForeground(Color.BLACK);
        tab.setPreferredSize(new Dimension(650,100));
    }

    public static void main(String[] args) {
        new Field();
    }

}
