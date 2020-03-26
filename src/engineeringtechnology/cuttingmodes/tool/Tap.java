package engineeringtechnology.cuttingmodes.tool;

import engineeringtechnology.cuttingmodes.AbstractTool;

import java.util.ArrayList;
import java.util.List;

public class Tap extends AbstractTool {
    public static final List<String> FEED = new ArrayList<>();
    static {
        FEED.add("0.8");
        FEED.add("1.0");
        FEED.add("1.25");
        FEED.add("1.5");
        FEED.add("1.75");
        FEED.add("2.0");
        FEED.add("2.5");
        FEED.add("3.0");
        FEED.add("3.5");
    }
    public Tap() {
        super(6,6,30);
    }

    @Override
    public int calculateFeed(int turns) {
        return (int)(turns * toolFeed * 0.9);
    }
}
