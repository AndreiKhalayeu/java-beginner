package engineeringtechnology.cuttingmodes.tool;

import engineeringtechnology.cuttingmodes.AbstractTool;

public class Tap extends Cutter {
    private int speed = 6;
    //    private double feed;

    @Override
    public int calculateFeed(int turns, double feed) {
        return (int)(turns * feed * 0.9);
    }

    public int getSpeed() {
        return speed;
    }
}
