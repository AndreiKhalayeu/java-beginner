package engineeringtechnology.cuttingmodes.tool;

import engineeringtechnology.cuttingmodes.AbstractTool;

/**
 * Класс инструмент метчик
 */
public class Tap extends AbstractTool {

    /**
     * Конструктор инструмента метчик
     */
    public Tap() {
        super(6,8,30,0.5,3.5);
    }

    @Override
    public int calculateFeed(int turns) {
        return (int)(turns * feed * 0.9);
    }

    /**
     * Метод расчитывает диаметр сверла под метчик
     * @param numberDiameter диаметр метчика
     * @return возвращает диаметр сверла под метчик
     */
    public double calculateDiameterDrill(double numberDiameter, double numberFeed) {
        return numberDiameter - numberFeed;
    }
}
