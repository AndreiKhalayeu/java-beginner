package engineeringtechnology.graphicfield;

import engineeringtechnology.cuttingmodes.data.DataGF;
import engineeringtechnology.graphicfield.tabs.*;

import javax.swing.*;
import java.awt.*;

public class Field {
    private JButton buttonStart;
    private JButton buttonStop;
    private ProcessingButton processingButton;
    private JLabel messageError;

    Field() {
        createFrame();
    }

    private void createFrame() {
        JFrame frame = new JFrame("Calculation of modes");
        frame.setContentPane(createMainPanel());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //frame.setSize(700, 200);
        frame.setVisible(true);
        frame.setBounds(600,400,840,180);
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
        messageError = new JLabel("");
        northPanel.add(messageError);
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
        buttonStart.addActionListener(processingButton);
        return buttonStart;
    }

    private JButton createButtonStop() {
        buttonStop = new JButton("Сброс");
        buttonStop.setBackground(Color.LIGHT_GRAY);
        buttonStop.addActionListener(processingButton);
        return buttonStop;
    }

    private JTabbedPane createTads() {
        JTabbedPane tab = new JTabbedPane();
        TabCutter tabCutter = DataGF.LIST_TAB.get(0);
        TabDrill tabDrill = (TabDrill) DataGF.LIST_TAB.get(1);
        TabCountersink tabCountersink = (TabCountersink) DataGF.LIST_TAB.get(2);
        TabSweep tabSweep = (TabSweep) DataGF.LIST_TAB.get(3);
        TabTap tabTap = (TabTap) DataGF.LIST_TAB.get(4);
        processingButton = new ProcessingButton(this, tabCountersink, tabCutter, tabDrill, tabSweep, tabTap);
        tab.add("Фреза", tabCutter);
        tab.add("Сверло", tabDrill);
        tab.add("Зенкер", tabCountersink);
        tab.add("Развертка", tabSweep);
        tab.add("Метчик", tabTap);
        tab.addChangeListener(new ProcessingTab());
        tab.setBackground(Color.gray);
        tab.setForeground(Color.BLACK);
        tab.setPreferredSize(new Dimension(830,90));
        return tab;
    }

    public JButton getButtonStart() {
        return buttonStart;
    }

    public JButton getButtonStop() {
        return buttonStop;
    }

    public JLabel getMessageError() {
        return messageError;
    }

    public static void main(String[] args) {
        new Field();
    }
}
