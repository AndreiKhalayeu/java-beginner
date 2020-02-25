package engineering.technology.graphic.field;

import javax.swing.*;
import java.awt.*;

public class Field {
    private JButton start;
    Field() {
        JPanel windowContent = new JPanel();
        BorderLayout layout = new BorderLayout();
        windowContent.setLayout(layout);

        createButtonStart();







        createFrame(windowContent);
    }

    private void createFrame(JPanel windowContent) {
        JFrame frame = new JFrame("Calculation of modes");
        frame.setContentPane(windowContent);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createButtonStart() {
        start = new JButton("Start");

    }

    public static void main(String[] args) {
        new Field();
    }

}
