package engineeringtechnology.cuttingmodes.tool;

import engineeringtechnology.cuttingmodes.AbstractTool;

public class Drill extends Cutter {
    private int speed = 18;
    private double feed = 0.2;

    public double tipDrill(int toolDiameter) {
        return 0.3 * toolDiameter;
    }

    public int getSpeed() {
        return speed;
    }

    public double getFeed() {
        return feed;
    }
}
