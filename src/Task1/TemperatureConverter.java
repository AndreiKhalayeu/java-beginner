package Task1;

public class TemperatureConverter {

    public static String convertTemp(int temperature, char convertTo) {
        double grade = 0;
        String conversion = "не задано значение";

        if (convertTo == 'F') {
            grade = temperature * 9.0 / 5.0 + 32.0;
            conversion = "Цельсия в Фаренгейты";
        } else if (convertTo == 'C') {
            grade = 5.0 / 9.0 * (temperature - 32.0);
            conversion = "Фаренгейты в Цельсия";
        }
        return  conversion + " " + grade;
    }

    public static void main(String[] args) {
        System.out.println(TemperatureConverter.convertTemp(200, 'H'));
    }
}
