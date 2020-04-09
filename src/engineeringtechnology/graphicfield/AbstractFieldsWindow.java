package engineeringtechnology.graphicfield;

import engineeringtechnology.listener.ButtonActionListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public abstract class AbstractFieldsWindow implements FieldsWindow {

    /**
     * Поле кннопка рассчитать
     */
    private JButton buttonStart;

    /**
     * Поле кнопка сброс
     */
    private JButton buttonStop;

    /**
     * поле кнопочный слушатель
     */
    protected ButtonActionListener buttonActionListener;

    public AbstractFieldsWindow() {
        createFrame();
    }

    abstract Map<String, JPanel> getLocationPanel();

    abstract ArrayList<JButton> getButton();

    abstract JTabbedPane getTab();

    @Override
    public void createFrame() {
        JFrame frame = new JFrame("Calculation of modes");
        frame.setContentPane(createMainPanel());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //frame.setSize(700, 200);
        frame.setVisible(true);
        frame.setBounds(600,400,785,180);
        frame.setResizable(false);
    }

    @Override
    public JPanel createMainPanel() {
        JPanel mainPanel = new JPanel();
        BorderLayout layout = new BorderLayout();
        mainPanel.setLayout(layout);
        Set<Map.Entry<String, JPanel>> locationPanel = getLocationPanel().entrySet();
        for (Map.Entry<String, JPanel> value : locationPanel) {
            mainPanel.add(value.getKey(), value.getValue());
        }
        return mainPanel;
    }

    @Override
    public JPanel createCenterPanel() {
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.BLACK);
        centerPanel.add(createTads());
        return centerPanel;
    }

    @Override
    public JPanel createSouthPanel() {
        JPanel southPanel = new JPanel();
        southPanel.setBackground(Color.BLACK);
        for (JButton button : getButton()) {
            southPanel.add(button);
        }
        return southPanel;
    }

    @Override
    public JButton createButtonStart() {
        buttonStart = new JButton("Расчитать");
        buttonStart.setBackground(Color.LIGHT_GRAY);
        buttonStart.addActionListener(buttonActionListener);
        return buttonStart;
    }

    @Override
    public JButton createButtonStop() {
        buttonStop = new JButton("Сброс");
        buttonStop.setBackground(Color.LIGHT_GRAY);
        buttonStop.addActionListener(buttonActionListener);
        return buttonStop;
    }

    @Override
    public JTabbedPane createTads() {
        return getTab();
    }

    public JButton getButtonStart() {
        return buttonStart;
    }

    public JButton getButtonStop() {
        return buttonStop;
    }
}
