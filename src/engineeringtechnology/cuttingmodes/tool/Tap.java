package engineeringtechnology.cuttingmodes.tool;

import engineeringtechnology.cuttingmodes.AbstractTool;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс инструмент метчик
 */
public class Tap extends AbstractTool {

    /**
     * Поле список возможных подач
     */
    public static final List<Double> LIST_FEED = new ArrayList<>();
    static {
        LIST_FEED.add(0.5);
        LIST_FEED.add(0.75);
        LIST_FEED.add(1.0);
        LIST_FEED.add(1.25);
        LIST_FEED.add(1.5);
        LIST_FEED.add(1.75);
        LIST_FEED.add(2.0);
        LIST_FEED.add(2.5);
        LIST_FEED.add(3.0);
        LIST_FEED.add(3.5);
    }

    /**
     * Конструктор инструмента метчик
     */
    public Tap() {
        super(6,8,30);
    }

    @Override
    public int calculateFeed(double numberFeed, int turns) {
        return (int)(turns * numberFeed * 0.9);
    }

    /**
     * Метод расчитывает диаметр сверла под метчик
     * @param numberDiameter диаметр метчика
     * @return возвращает диаметр сверла под метчик
     */
    public double calculateDiameterDrill(double numberDiameter, double numberFeed) {
        if (isFeed(numberFeed)) {
            return numberDiameter - numberFeed;
        } else {
            return numberDiameter;
        }
    }

    /**
     * Метод проверяет есть ли подача в списке
     * @param numberFeed подача
     * @return возвращает true если есть подача, false если нет подачи
     */
    public boolean isFeed(double numberFeed) {
        for (Double feed : LIST_FEED) {
            if (numberFeed == feed) {
                return true;
            }
        }
        return false;
    }
}
