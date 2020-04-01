package engineeringtechnology.cuttingmodes.tool;

import engineeringtechnology.cuttingmodes.AbstractTool;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс инструмент метчик
 */
public class Tap extends AbstractTool {
    /**
     * Поле подача
     */
    private static double feedTap = 0.5;

    /**
     * Поле список подач
     */
    public static final List<Double> FEED = new ArrayList<>();
    static {
        FEED.add(0.5);
        FEED.add(0.75);
        FEED.add(1.0);
        FEED.add(1.25);
        FEED.add(1.5);
        FEED.add(1.75);
        FEED.add(2.0);
        FEED.add(2.5);
        FEED.add(3.0);
        FEED.add(3.5);
    }

    /**
     * Конструктор инструмента метчик
     */
    public Tap() {
        super(6,8,30);
    }

    @Override
    public int calculateFeed(int turns) {
        return (int)(turns * feedTap * 0.9);
    }

    /**
     * Метод расчитывает диаметр сверла под метчик
     * @param number диаметр метчика
     * @return возвращает диаметр сверла под метчик
     */
    public double calculateDiameterDrill(double number) {
        return number - feedTap;
    }

    public static double getFeedTap() {
        return feedTap;
    }

    public static void setFeedTap(double feedTap) {
        Tap.feedTap = feedTap;
    }
}
