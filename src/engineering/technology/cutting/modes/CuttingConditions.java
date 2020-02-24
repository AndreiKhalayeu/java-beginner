package engineering.technology.cutting.modes;

public interface CuttingConditions {
    void calculateTurns(int cuttingSpeed, double toolDiameter);
    void calculateFeed(int turns, double feed);
}
