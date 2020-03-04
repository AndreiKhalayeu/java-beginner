package engineeringtechnology.cuttingmodes.tool;

import engineeringtechnology.cuttingmodes.AbstractTool;

public class Tap extends AbstractTool {
    public Tap(int speed, double feed, double minDiameter, double maxDiameter, double minFeed, double maxFeed) {
        super(speed, feed, minDiameter, maxDiameter, minFeed, maxFeed);
    }

    @Override
    public int calculateFeed(int turns) {
        return (int)(turns * toolFeed * 0.9);
    }
}
