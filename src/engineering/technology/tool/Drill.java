package engineering.technology.tool;

import engineering.technology.cutting.modes.Tool;

public class Drill extends Tool {
    static final int SPEED = 18;
    static final double FEED = 0.2;

    public double tipDrill(int toolDiameter) {
        return 0.3 * toolDiameter;
    }
}
