package engineering.technology.tool;

import engineering.technology.cutting.modes.Tool;

public class Tap extends Tool {
    static final int SPEED = 6;
    private double feed;

    @Override
    public int calculateFeed(int turns, double feed) {
        int f;
        return f = (int)(turns * feed * 0.9);
    }

    public double getFeed() {
        return feed;
    }

    public void setFeed(double feed) {
        this.feed = feed;
    }
}
