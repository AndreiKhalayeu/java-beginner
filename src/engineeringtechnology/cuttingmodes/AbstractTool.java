package engineeringtechnology.cuttingmodes;

public abstract class AbstractTool implements CuttingConditions {
    protected final int speed;
    protected final double feed ;
    protected final double minDiameter;
    protected final double maxDiameter;
    protected final double minFeed;
    protected final double maxFeed;
    protected double toolFeed;

    public AbstractTool(int speed, double feed, double minDiameter, double maxDiameter, double minFeed, double maxFeed) {
        this.speed = speed;
        this.feed = feed;
        this.minDiameter = minDiameter;
        this.maxDiameter = maxDiameter;
        this.minFeed = minFeed;
        this.maxFeed = maxFeed;
    }

    @Override
    public int calculateTurns(int toolDiameter) {
        return (int)(1000 * speed / 3.14 / toolDiameter);
    }

    @Override
    public int calculateFeed(int turns) {
        return (int)(turns * feed);
    }

    @Override
    public int calculateFeed(double toolFeed, int turns) {
        return (int)(turns * toolFeed);
    }

    public int getSpeed() {
        return speed;
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

    public double getToolFeed() {
        return toolFeed;
    }
}
