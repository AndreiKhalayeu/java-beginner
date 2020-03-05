package engineeringtechnology.cuttingmodes.tool;

import engineeringtechnology.cuttingmodes.AbstractTool;

public class Tap extends AbstractTool {
    public Tap() {
        super(6, 1,6,30,0.8,3.5);
    }

    @Override
    public int calculateFeed(int turns) {
        return (int)(turns * toolFeed * 0.9);
    }
}
