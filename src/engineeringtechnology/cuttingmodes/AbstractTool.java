package engineeringtechnology.cuttingmodes;

import engineeringtechnology.cuttingmodes.data.DataGF;

import java.util.Map;
import java.util.Set;

public abstract class AbstractTool implements CuttingConditions {
    protected final int speed;
    protected final double minDiameter;
    protected final double maxDiameter;
    protected double feed;
    protected double minFeed;
    protected double maxFeed;

    protected double toolFeed;

    public AbstractTool(int speed, double minDiameter, double maxDiameter) {
        this.speed = speed;
        this.minDiameter = minDiameter;
        this.maxDiameter = maxDiameter;
    }

    public AbstractTool(int speed, double feed, double minDiameter, double maxDiameter, double minFeed, double maxFeed) {
        this.speed = speed;
        this.feed = feed;
        this.minDiameter = minDiameter;
        this.maxDiameter = maxDiameter;
        this.minFeed = minFeed;
        this.maxFeed = maxFeed;
    }

    @Override
    public int calculateTurns(double toolDiameter) {
        return (int)(1000 * speed / 3.14 / toolDiameter);
    }

    @Override
    public int calculateTurnsGF(int turns) {
        int turnsGF = 0;
        Set<Map.Entry<Integer, Integer>> data = DataGF.LIST_TURNS.entrySet();
        for (Map.Entry<Integer, Integer> value : data) {
            if (turns <= value.getKey()) {
                turnsGF = value.getValue();
                break;
            }
        }
        return  turnsGF;
    }

    @Override
    public int calculateFeed(int turns) {
        return (int)(turns * feed);
    }

    @Override
    public int calculateFeed(double toolFeed, int turns) {
        return (int)(turns * toolFeed);
    }

    public double getFeed() {
        return feed;
    }

    public double getMinDiameter() {
        return minDiameter;
    }

    public double getMaxDiameter() {
        return maxDiameter;
    }

    public double getMinFeed() {
        return minFeed;
    }

    public double getMaxFeed() {
        return maxFeed;
    }
}
