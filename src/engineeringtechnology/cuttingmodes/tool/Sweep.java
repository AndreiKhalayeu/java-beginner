package engineeringtechnology.cuttingmodes.tool;

import engineeringtechnology.cuttingmodes.AbstractTool;

public class Sweep extends Cutter {
    private int speed = 8;
    private double feed = 0.5;

    @Override
    public int calculateTurns(int toolDiameter) {
        return (int)(1000 * speed / 3.14 / toolDiameter);
    }

    @Override
    public int calculateFeed(int turns) {
        return (int)(turns * feed);
    }

    public int getSpeed() {
        return speed;
    }

    public double getFeed() {
        return feed;
    }
}
