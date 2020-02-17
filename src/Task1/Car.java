package Task1;

public class Car {
    int distance;

    public void start() {
        System.out.println("Начинаем движение");
    }

    public void stop() {
        System.out.println("Закончили движение");
    }

    public int drive(int howLong) {
        distance = howLong * 60;
        System.out.println("Проехали " + distance);
        return distance;
    }
}
