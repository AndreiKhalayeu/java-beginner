package engineeringtechnology.cuttingmodes.tool;

import engineeringtechnology.cuttingmodes.AbstractTool;

public class Tap extends AbstractTool {
    public static final int SPEED = 6;
    private double feed;

    @Override
    public int calculateFeed(int turns, double feed) {
        return (int)(turns * feed * 0.9);
    }

    public double getFeed() {
        return feed;
    }

    public void setFeed(double feed) {
        this.feed = feed;
    }
}
