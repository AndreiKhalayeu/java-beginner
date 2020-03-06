package engineeringtechnology.cuttingmodes;

public interface CuttingConditions {
    int calculateTurns(double toolDiameter);
    int calculateTurnsGF(int turns);
    int calculateFeed(double toolFeed, int turns);
    int calculateFeed(int turns);
}
