package Task1;

public class Fish extends Pet {
    int currentDepth = 0;

    public int dive(int howDeep) {
        currentDepth += howDeep;
        if (currentDepth > 100) {
            System.out.println("Я маленькая рыбка " + "и не могу плавать глубже 100 метров");
            currentDepth -= howDeep;
        } else {
            System.out.println("Погружаюсь еще на " + howDeep + " метров");
            System.out.println("Я на глубине " + currentDepth + " метров");
        }
        return currentDepth;
    }

    @Override
    public String say(String something) {
        return "Ты че не знаешь, что рыбы не разговаривают";
    }
}
