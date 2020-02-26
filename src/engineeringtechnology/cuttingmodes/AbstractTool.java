package engineeringtechnology.cuttingmodes;

public abstract class AbstractTool implements CuttingConditions {
    private int diameter;

    @Override
    public int calculateTurns(int cuttingSpeed, int toolDiameter) {
        return (int)(1000 * cuttingSpeed / Math.PI * toolDiameter);
    }

    @Override
    public int calculateFeed(int turns, double feed) {
        return (int)(turns * feed);
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }
}
