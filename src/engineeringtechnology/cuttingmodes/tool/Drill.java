package engineeringtechnology.cuttingmodes.tool;

import engineeringtechnology.cuttingmodes.AbstractTool;

public class Drill extends AbstractTool {

    public Drill() {
        super(18,0.2, 4, 50, 0.1, 0.3);
    }

    public double lengthPointDrill(int toolDiameter) {
        return 0.3 * toolDiameter;
    }
}
