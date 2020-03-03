package engineeringtechnology.cuttingmodes.tool;

import engineeringtechnology.cuttingmodes.AbstractTool;

public class Cutter extends AbstractTool {
    private int speed = 25;
    private double feed = 0.2;

    public int getSpeed() {
        return speed;
    }

    public double getFeed() {
        return feed;
    }
}
