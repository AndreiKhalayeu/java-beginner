package engineeringtechnology.cuttingmodes;

public interface CuttingConditions {
    int calculateTurns(int toolDiameter);
    int calculateFeed(double toolFeed, int turns);
    int calculateFeed(int turns);
}
