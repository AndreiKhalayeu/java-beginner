package myCalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorEngine implements ActionListener {
    private Calculator parent; //ссылка на окно калькулятора
    private String selectedAction = "";
    private double currentResult;
    private double displayValue;
    private String displayFieldText;
    private JButton clickedButton;


    CalculatorEngine(Calculator parent) {
        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Получаем источник события(действия)
        clickedButton = (JButton) e.getSource();

        //Получить текущий текст из поля вывода ("дисплея") калькулятора
        displayFieldText = parent.getGetDisplayFormattedField().getText();

        displayValue = resultNumberDisplay(displayFieldText);

        if (clickedButton == parent.getButtons()[0] && displayFieldText.equals("0")) {
            buttonNull();
        } else if (clickedButton == parent.getButtonDeleteAll()) {
            buttonDeleteAll();
        } else if (clickedButton == parent.getButtonPoint()) {
            buttonPoint();
        } else if (clickedButton == parent.getButtonPlusMinus()) {
            buttonPlusMinus();
        } else if (clickedButton == parent.getButtonDeleteLast()) {
            buttonDeleteLast();
        } else if (clickedButton == parent.getButtonPercent()) {
            buttonPercent();
        } else if (clickedButton == parent.getButtonPlus()) {
            buttonHandler("+");
        } else if (clickedButton == parent.getButtonMinus()) {
            buttonHandler("-");
        } else if (clickedButton == parent.getButtonDivision()) {
            buttonHandler("/");
        } else if (clickedButton == parent.getButtonMultiplication()) {
            buttonHandler("*");
        } else if (clickedButton == parent.getButtonEqual()) {
            buttonEqual();
        } else {
            button();
        }
        //Добавляем надпись на кнопке к тексту окна сообщения
        //JOptionPane.showConfirmDialog(null,
        //        "You pressed " + clickedButtonLabel, "Just a test",
        //        JOptionPane.PLAIN_MESSAGE);
    }

    //Получить число из дисплея калькулятора
    public static double resultNumberDisplay(String text) {
        double number = 0;
        if ("Деление на ноль невозможно".equals(text)) {
            number = 0;
        } else if (!"".equals(text)) {
            number = Double.parseDouble(text);
        }
        return number;
    }

    //Проверка на повторение точки
    public boolean checkPoint(String text) {
        char[] elements = text.toCharArray();

        for (char element : elements) {
            if (element == '.') {
                return true;
            }
        }
        return false;
    }

    //Отбросить нули после запятой
    public static String deleteLastNull(double value) {
        String s = Double.toString(value);
        char[] array = s.toCharArray();
        int counter = 0;
        String result;

        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] =='.') {
                counter = array.length - 1 - i;
            }
        }

        if (counter == 1 && array[array.length - 1] == '0') {
            result = String.format("%.0f", value);
            System.out.println(result);
        } else {
            result = new String(array);
        }
        return result;
    }

    //убрать последнюю цифру
    public static String deleteLastNumber(double value) {
        String s = deleteLastNull(value);
        char[] arrayOld = s.toCharArray();
        char[] arrayNew = new char[arrayOld.length - 1];
        String result;

        for (int i = 0; i < arrayNew.length; i++) {
            arrayNew[i] = arrayOld[i];
        }
        result = new String(arrayNew);
        return result;
    }

    //Действия при нажатии кнопки
    public void buttonDeleteAll() {
        currentResult = 0;
        parent.getGetDisplayFormattedField().setText("");
    }

    public void buttonNull() {
        String clickedButtonLabel = clickedButton.getText();
        parent.getGetDisplayFormattedField().setText(clickedButtonLabel);
    }

    public void buttonPoint() {
        if (checkPoint(displayFieldText)) {
            parent.getGetDisplayFormattedField().setText(displayFieldText);
        } else {
            String clickedButtonLabel = clickedButton.getText();
            parent.getGetDisplayFormattedField().setText(displayFieldText + clickedButtonLabel);
        }
    }

    public void buttonPlusMinus() {
        if (displayValue > 0) {
            parent.getGetDisplayFormattedField().setText("-" + displayValue);
            currentResult = -displayValue;
        } else {
            currentResult = displayValue;
            parent.getGetDisplayFormattedField().setText("" + displayValue * (-1));
        }
    }

    public void buttonDeleteLast() {
        selectedAction = "<-";
        parent.getGetDisplayFormattedField().setText(deleteLastNumber(displayValue));
    }

    public void buttonPercent() {
        displayValue = displayValue / 100;
        parent.getGetDisplayFormattedField().setText("" + displayValue);
    }

    public void buttonHandler(String symbol) {
        selectedAction = symbol;
        currentResult = displayValue;
        parent.getGetDisplayFormattedField().setText("");
    }

    public void buttonEqual() {
        if (selectedAction.equals("+")) {
            currentResult += displayValue;
            parent.getGetDisplayFormattedField().setText(deleteLastNull(currentResult));
        } else if (selectedAction.equals("-")) {
            currentResult -= displayValue;
            parent.getGetDisplayFormattedField().setText(deleteLastNull(currentResult));
        } else if (selectedAction.equals("/")) {
            divisionNull();
        } else if (selectedAction.equals("*")) {
            currentResult *= displayValue;
            parent.getGetDisplayFormattedField().setText(deleteLastNull(currentResult));
        }
    }

    public void button() {
        // Получаем надпись на кнопке
        String clickedButtonLabel = clickedButton.getText();

        //Для всех цифровых кнопок присоединить надпись на кнопке к надписи в дисплее
        parent.getGetDisplayFormattedField().setText(displayFieldText + clickedButtonLabel);
    }

    public void divisionNull() {
        if (displayValue == 0) {
            parent.getGetDisplayFormattedField().setText("Деление на ноль невозможно");
        } else {
            currentResult /= displayValue;
            parent.getGetDisplayFormattedField().setText(deleteLastNull(currentResult));
        }
    }
}
