package engineeringtechnology.cuttingmodes.tool;

import engineeringtechnology.cuttingmodes.AbstractTool;

public class Countersink extends Cutter {
    private int speed = 12;
    private double feed = 0.3;

    public int getSpeed() {
        return speed;
    }

    public double getFeed() {
        return feed;
    }
}
