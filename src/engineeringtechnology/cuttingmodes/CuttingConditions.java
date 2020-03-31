package engineeringtechnology.cuttingmodes;

/**
 * Интерфейс режимы резания
 */
public interface CuttingConditions {
    /**
     * Метод рассчитывает обороты на инструмент
     * @param toolDiameter диаметр инструмента
     * @return возвращает обороты на инструмент
     */
    int calculateTurns(double toolDiameter);

    /**
     * Метод рассчитывает обороты на инструмент для станка ГФ2171
     * @param turns обороты на инструмент
     * @return возвращает обороты на инструмент для станка ГФ2171
     */
    int calculateTurnsGF(int turns);

    /**
     * Метод расчитывает машинную подачу на инструмент
     * @param toolFeed подача на инструмент
     * @param turns обороты на инструмент
     * @return возвращает машинную подачу на инструмент
     */
    int calculateFeed(double toolFeed, int turns);

    /**
     * Метод расчитывает машинную подачу на инструмент
     * @param turns обороты на инструмент
     * @return возвращает машинную подачу на инструмен
     */
    int calculateFeed(int turns);
}
