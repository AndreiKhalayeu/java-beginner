package engineering.technology.cutting.modes;

public interface CuttingConditions {
    int calculateTurns(int cuttingSpeed, int toolDiameter);
    int calculateFeed(int turns, double feed);
}
