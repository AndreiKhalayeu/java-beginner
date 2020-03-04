package engineeringtechnology.cuttingmodes.tool;

import engineeringtechnology.cuttingmodes.AbstractTool;

public class Drill extends AbstractTool {

    public Drill(int speed, double feed, double minDiameter, double maxDiameter, double minFeed, double maxFeed) {
        super(speed, feed, minDiameter, maxDiameter, minFeed, maxFeed);
    }

    public double tipDrill(int toolDiameter) {
        return 0.3 * toolDiameter;
    }
}
