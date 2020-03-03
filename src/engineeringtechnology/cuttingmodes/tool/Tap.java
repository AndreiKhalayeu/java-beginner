package engineeringtechnology.cuttingmodes.tool;

import engineeringtechnology.cuttingmodes.AbstractTool;

public class Tap extends Cutter {
    private int speed = 6;
    private double feed = 1;

    @Override
    public int calculateTurns(int toolDiameter) {
        return (int)(1000 * speed / 3.14 / toolDiameter);
    }

    @Override
    public int calculateFeed(int turns) {
        return (int)(turns * feed * 0.9);
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public double getFeed() {
        return feed;
    }
}
