package engineeringtechnology.cuttingmodes.tool;

import engineeringtechnology.cuttingmodes.AbstractTool;

/**
 * Класс инструмент сверло
 */
public class Drill extends AbstractTool {
    /**
     * Конструктор инструмента сверло
     */
    public Drill() {
        super(18,0.2, 7, 50, 0.1, 0.3);
    }

    /**
     * Метод рассчитывает длинну острой части сверла
     * @param toolDiameter диаметр инструмента - сверла
     * @return возвращает длинну острой части сверла
     */
    public double lengthPointDrill(double toolDiameter) {
        return 0.3 * toolDiameter;
    }
}
