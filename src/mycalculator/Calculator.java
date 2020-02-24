package mycalculator;

import javax.swing.*;
import java.awt.*;

public class Calculator {
    private JFormattedTextField getDisplayFormattedField;
    private JButton[] buttons;
    private JButton buttonPoint;
    private JButton buttonEqual;
    private JButton buttonPlus;
    private JButton buttonMinus;
    private JButton buttonDivision;
    private JButton buttonMultiplication;
    private JButton buttonDeleteAll;
    private JButton buttonDeleteLast;
    private JButton buttonPercent;
    private JButton buttonPlusMinus;

    //В конструкторе создаются все компоненты
    //и добавляются на фрейм с помощью комбинации
    //BorderLayout и GridLayout
    Calculator() {
        JPanel windowContent = new JPanel();

        //Задаем схему для этой панели
        BorderLayout border = new BorderLayout();
        windowContent.setLayout(border);

        //Создаем и отображаем поле
        //Добавляем его в северную область окна
        getDisplayFormattedField = new JFormattedTextField();
        getDisplayFormattedField.setHorizontalAlignment(SwingConstants.RIGHT);
        windowContent.add("North", getDisplayFormattedField);

        //Создаем кнопки, который принимает текст
        //кнопки в качестве параметра
        buttons = new JButton[10];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton("" + i);
        }

        buttonPoint = new JButton(".");
        buttonEqual = new JButton("=");
        buttonPlus = new JButton("+");
        buttonMinus = new JButton("-");
        buttonDivision = new JButton("/");
        buttonMultiplication = new JButton("*");
        buttonDeleteAll = new JButton("c");
        buttonDeleteLast = new JButton("<-");
        buttonPercent = new JButton("%");
        buttonPlusMinus = new JButton("+-");

        //Создаем панель с GridLayout
        //которая содержит 12 кнопок: 0-9 . =
        JPanel panel1 = new JPanel();
        GridLayout grid = new GridLayout(4, 4);
        panel1.setLayout(grid);

        //Добавляем кнопки на панель panel1
        panel1.add(buttonDeleteAll);
        panel1.add(buttonDeleteLast);
        panel1.add(buttonPercent);
        panel1.add(buttonPlusMinus);

        for (int i = 0; i < buttons.length; i++) {
            panel1.add(buttons[i]);
        }

        panel1.add(buttonPoint);
        panel1.add(buttonEqual);

        //Помещаем панель panel1 в центральную область окна
        windowContent.add("Center", panel1);

        //Создаем панель с GridLayout
        //которая содержит 4 кнопки: + - / *
        JPanel panel2 = new JPanel();
        GridLayout grid2 = new GridLayout(4, 1);
        panel2.setLayout(grid2);

        //Добавляем кнопки на панель panel2
        panel2.add(buttonPlus);
        panel2.add(buttonMinus);
        panel2.add(buttonDivision);
        panel2.add(buttonMultiplication);

        //Помещаем панель panel2 в восточную область окна
        windowContent.add("East", panel2);

        //Создаем фрейм и задаем его основную панель
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(windowContent);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //делаем размер окна достаточным для того, чтобы вместить все компоненты
        frame.pack();

        //Отображаем окно
        frame.setVisible(true);

        //связка кнопок с классом вывода сообщения
        CalculatorEngine calcEngine = new CalculatorEngine(this);

        for (int i = 0; i < buttons.length; i++) {
            buttons[i].addActionListener(calcEngine);
        }

        buttonPoint.addActionListener(calcEngine);
        buttonEqual.addActionListener(calcEngine);
        buttonPlus.addActionListener(calcEngine);
        buttonMinus.addActionListener(calcEngine);
        buttonDivision.addActionListener(calcEngine);
        buttonMultiplication.addActionListener(calcEngine);
        buttonDeleteAll.addActionListener(calcEngine);
        buttonDeleteLast.addActionListener(calcEngine);
        buttonPercent.addActionListener(calcEngine);
        buttonPlusMinus.addActionListener(calcEngine);
    }

    public static void main(String[] args) {
        new Calculator();
    }

    public JFormattedTextField getGetDisplayFormattedField() {
        return getDisplayFormattedField;
    }

    public JButton[] getButtons() {
        return buttons;
    }

    public JButton getButtonPoint() {
        return buttonPoint;
    }

    public JButton getButtonEqual() {
        return buttonEqual;
    }

    public JButton getButtonPlus() {
        return buttonPlus;
    }

    public JButton getButtonMinus() {
        return buttonMinus;
    }

    public JButton getButtonDivision() {
        return buttonDivision;
    }

    public JButton getButtonMultiplication() {
        return buttonMultiplication;
    }

    public JButton getButtonDeleteAll() {
        return buttonDeleteAll;
    }

    public JButton getButtonDeleteLast() {
        return buttonDeleteLast;
    }

    public JButton getButtonPercent() {
        return buttonPercent;
    }

    public JButton getButtonPlusMinus() {
        return buttonPlusMinus;
    }
}
