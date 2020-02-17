package Task1;

import javax.swing.*;
import java.awt.*;

public class SimpleCalculator {

    public static void main(String[] args) {

        //создаем панель

        JPanel windowContent = new JPanel();

        //Задаем менеджер отображения для этой панели(схема расположения)

        //FlowLayout fl = new FlowLayout();
        //windowContent.setLayout(fl);

        GridLayout gr = new GridLayout(4, 2);
        windowContent.setLayout(gr);

        //Создаем компонены в памяти

        JLabel label1 = new JLabel("Number 1:");
        JTextField field1 = new JTextField(10);
        JLabel label2 = new JLabel("Number 2:");
        JTextField field2 = new JTextField(10);
        JLabel label3 = new JLabel("Sum:");
        JTextField result = new JTextField(10);
        JButton go = new JButton("Add");

        //Добавляем компоненты на панель

        windowContent.add(label1);
        windowContent.add(field1);
        windowContent.add(label2);
        windowContent.add(field2);
        windowContent.add(label3);
        windowContent.add(result);
        windowContent.add(go);

        //Создаем фрейм(рамку) и задаем для него панель

        JFrame frame = new JFrame("My First Calculator");
        frame.setContentPane(windowContent);

        //Задаем размер и делаем фрейм видимым
        frame.setSize(400,100);
        frame.setVisible(true);
    }
}
