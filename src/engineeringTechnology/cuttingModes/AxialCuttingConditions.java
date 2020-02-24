package engineeringTechnology.cuttingModes;

public interface AxialCuttingConditions {
    void calculateTurns(int cuttingSpeed, double toolDiameter);
    void calculateFeed(int turns, double feed);
}
