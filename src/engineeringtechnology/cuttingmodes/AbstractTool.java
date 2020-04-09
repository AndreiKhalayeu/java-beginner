package engineeringtechnology.cuttingmodes;

import engineeringtechnology.cuttingmodes.data.Data;

import java.util.Map;
import java.util.Set;

/**
 * Абстрактный класс инструмент
 */
public abstract class AbstractTool implements CuttingConditions {

    /**
     * Поле число диаметра
     */
    protected double numberDiameter;

    /**
     * Поле число подачи
     */
    private double numberFeed;

    /**
     * Поле скорость
     */
    protected final int speed;

    /**
     * Поле минимальный диаметр
     */
    protected double minDiameter;

    /**
     * Поле максимальный диаметр
     */
    protected double maxDiameter;

    /**
     * Поле подача
     */
    protected double feed;

    /**
     * Поле минимальная подача
     */
    protected double minFeed;

    /**
     * Поле максимальная подача
     */
    protected double maxFeed;

    /**
     * Конструктор принимает на вход скорость, минимальный диаметр, максимальный диаметр
     */
    public AbstractTool(int speed, double minDiameter, double maxDiameter) {
        this.speed = speed;
        this.minDiameter = minDiameter;
        this.maxDiameter = maxDiameter;
    }

    /**
     * Конструктор принимает на вход скорость, подачу, минимальный диаметр, максимальный диаметр,
     * минимальную подачу, максимальную подачу
     */
    public AbstractTool(int speed, double feed, double minDiameter, double maxDiameter, double minFeed, double maxFeed) {
        this.speed = speed;
        this.feed = feed;
        this.minDiameter = minDiameter;
        this.maxDiameter = maxDiameter;
        this.minFeed = minFeed;
        this.maxFeed = maxFeed;
    }

    @Override
    public int calculateTurns(double toolDiameter) {
        return (int)(1000 * speed / (Math.PI * toolDiameter));
    }

    @Override
    public int calculateTurnsGF(int turns) {
        Set<Map.Entry<Integer, Integer>> data = Data.MAP_TURNS.entrySet();
        for (Map.Entry<Integer, Integer> value : data) {
            if (turns <= value.getKey()) {
                return value.getValue();
            }
        }
        return 0;
    }

    @Override
    public int calculateFeed(int turns) {
        return (int)(turns * feed);
    }

    @Override
    public int calculateFeed(double toolFeed, int turns) {
        return (int)(turns * toolFeed);
    }

    public double getFeed() {
        return feed;
    }

    public double getMinDiameter() {
        return minDiameter;
    }

    public double getMaxDiameter() {
        return maxDiameter;
    }

    public double getMinFeed() {
        return minFeed;
    }

    public double getMaxFeed() {
        return maxFeed;
    }

    public int getSpeed() {
        return speed;
    }

    public double getNumberDiameter() {
        return numberDiameter;
    }

    public void setNumberDiameter(double numberDiameter) {
        this.numberDiameter = numberDiameter;
    }

    public double getNumberFeed() {
        return numberFeed;
    }

    public void setNumberFeed(double numberFeed) {
        this.numberFeed = numberFeed;
    }
}
