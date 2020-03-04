package engineeringtechnology.cuttingmodes.tool;

import engineeringtechnology.cuttingmodes.AbstractTool;

public class Cutter extends AbstractTool {

    public Cutter(int speed, double feed, double minDiameter, double maxDiameter, double minFeed, double maxFeed) {
        super(speed, feed, minDiameter, maxDiameter, minFeed, maxFeed);
    }
}
