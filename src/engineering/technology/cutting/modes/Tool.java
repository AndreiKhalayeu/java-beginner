package engineering.technology.cutting.modes;

public class Tool implements CuttingConditions {
    static final double Pi = 3.14;
    private int diameter;

    @Override
    public int calculateTurns(int cuttingSpeed, int toolDiameter) {
        return (int)(1000 * cuttingSpeed / Pi * toolDiameter);
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
