package engineeringtechnology.cuttingmodes;

public interface CuttingConditions {
    int calculateTurns(int cuttingSpeed, int toolDiameter);
    int calculateFeed(int turns, double feed);
}
