package engineeringtechnology.graphicfield.tabs;

/**
 * Класс вкладка фреза
 */
public class TabCutter extends AbstractTab {

    public TabCutter() {
        super();
    }

    @Override
    protected String[] getItems() {
        return new String[] {"Концевая фреза", "Торцевая фреза"};
    }
}
