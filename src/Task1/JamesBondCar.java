package Task1;

public class JamesBondCar extends Car {
    @Override
    public int drive(int howlong) {
        distance = howlong * 180;
        System.out.println("Проехали " + distance);
        return distance;
    }
}
