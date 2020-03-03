package engineeringtechnology.cuttingmodes;

public abstract class AbstractTool implements CuttingConditions {
    private int speed;
    private double feed;

    @Override
    public int calculateTurns(int cuttingSpeed, int toolDiameter) {
        return (int)(1000 * cuttingSpeed / 3.14 / toolDiameter);
    }

    @Override
    public int calculateFeed(int turns, double feed) {
        return (int)(turns * feed);
    }

    public int getSpeed() {
        return speed;
    }

    public double getFeed() {
        return feed;
    }
}
