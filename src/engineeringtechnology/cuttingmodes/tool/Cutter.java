package engineeringtechnology.cuttingmodes.tool;

import engineeringtechnology.cuttingmodes.AbstractTool;

public class Cutter extends AbstractTool {
    private int speed = 25;
    private double feed = 0.2;


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
