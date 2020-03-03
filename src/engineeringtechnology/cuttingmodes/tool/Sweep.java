package engineeringtechnology.cuttingmodes.tool;

import engineeringtechnology.cuttingmodes.AbstractTool;

public class Sweep extends Cutter {
    private int speed = 8;
    private double feed = 0.5;

    public int getSpeed() {
        return speed;
    }

    public double getFeed() {
        return feed;
    }
}
