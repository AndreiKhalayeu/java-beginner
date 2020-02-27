package engineeringtechnology.cuttingmodes.tool;

import engineeringtechnology.cuttingmodes.AbstractTool;

public class Drill extends AbstractTool {
    public static final int SPEED = 18;
    public static final double FEED = 0.2;

    public double tipDrill(int toolDiameter) {
        return 0.3 * toolDiameter;
    }
}
