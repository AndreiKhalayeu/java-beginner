package engineeringtechnology.cuttingmodes;

public abstract class AbstractTool implements CuttingConditions {
    private int speed;
    private double feed ;

    @Override
    public abstract int calculateTurns(int toolDiameter);

    @Override
    public abstract int calculateFeed(int turns);

    public int getSpeed() {
        return speed;
    }

    public double getFeed() {
        return feed;
    }
}
