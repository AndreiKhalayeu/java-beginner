package engineeringtechnology.cuttingmodes;

import engineeringtechnology.cuttingmodes.data.Data;

import java.util.Map;
import java.util.Set;

public abstract class AbstractTool implements CuttingConditions {
    protected final int speed;
    protected double minDiameter;
    protected double maxDiameter;
    protected double feed;
    protected double minFeed;
    protected double maxFeed;

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
        return (int)(1000 * speed / (Math.PI * toolDiameter));
    }

    @Override
    public int calculateTurnsGF(int turns) {
        Set<Map.Entry<Integer, Integer>> data = Data.LIST_TURNS.entrySet();
        for (Map.Entry<Integer, Integer> value : data) {
            if (turns <= value.getKey()) {
                return value.getValue();
            }
        }
        return 0;
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

    public int getSpeed() {
        return speed;
    }
}
