package engineeringtechnology.graphicfield;

import engineeringtechnology.listener.ButtonActionListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public abstract class AbstractFieldsWindow implements FieldsWindow {

    /**
     * Поле расположение центральной панели
     */
    protected static final String CENTER = "Center";

    /**
     * Поле расположение южной панели
     */
    protected static final String SOUTH = "South";

    /**
     * поле кнопочный слушатель
     */
    protected ButtonActionListener buttonActionListener;

    public AbstractFieldsWindow() {
        createFrame();
    }

    abstract Map<String, JPanel> getLocationPanel();

    abstract JTabbedPane getTab();

    abstract ArrayList<JButton> createButtons();

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
        for (JButton button : createButton()) {
            southPanel.add(button);
        }
        return southPanel;
    }

    @Override
    public ArrayList<JButton> createButton() {
        ArrayList<JButton> list = createButtons();
        for (JButton jButton : list) {
            jButton.setBackground(Color.LIGHT_GRAY);
            jButton.addActionListener(buttonActionListener);
        }
        return list;
    }


    @Override
    public JTabbedPane createTads() {
        return getTab();
    }
}
