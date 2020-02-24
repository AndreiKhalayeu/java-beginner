package task1;

public class FishMaster {
    public static void main(String[] args) {
        Fish myFish = new Fish();
        myFish.dive(2);
        myFish.dive(97);
        myFish.dive(3);
        myFish.sleep();
        System.out.println(myFish.say("Привет"));
    }
}
