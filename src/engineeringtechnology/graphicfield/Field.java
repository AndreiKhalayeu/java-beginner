package engineeringtechnology.graphicfield;

import engineeringtechnology.cuttingmodes.data.Data;
import engineeringtechnology.graphicfield.tabs.*;
import engineeringtechnology.listener.ButtonActionListener;
import engineeringtechnology.listener.TabActionListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс поле создает графическую оболочку
 */
public class Field extends AbstractFieldsWindow{

    /**
     * Поле список кнопок
     */
    private ArrayList<JButton> listButton;

    /**
     * Конструктор графической оболочки
     */
    Field() {
        super();
    }

    @Override
    Map<String, JPanel> getLocationPanel() {
        Map<String, JPanel> locationPanel = new HashMap<>();
        locationPanel.put(CENTER, createCenterPanel());
        locationPanel.put(SOUTH, createSouthPanel());
        return locationPanel;
    }

    @Override
    JTabbedPane getTab() {
        JTabbedPane tab = new JTabbedPane();
        TabCutter tabCutter = (TabCutter) Data.LIST_TAB.get(0);
        TabDrill tabDrill = (TabDrill) Data.LIST_TAB.get(1);
        TabCountersink tabCountersink = (TabCountersink) Data.LIST_TAB.get(2);
        TabSweep tabSweep = (TabSweep) Data.LIST_TAB.get(3);
        TabTap tabTap = (TabTap) Data.LIST_TAB.get(4);
        buttonActionListener = new ButtonActionListener(this, tabCountersink, tabCutter, tabDrill, tabSweep, tabTap);
        tab.add("Фреза", tabCutter);
        tab.add("Сверло", tabDrill);
        tab.add("Зенкер", tabCountersink);
        tab.add("Развертка", tabSweep);
        tab.add("Метчик", tabTap);
        tab.addChangeListener(new TabActionListener());
        tab.setBackground(Color.gray);
        tab.setForeground(Color.BLACK);
        tab.setPreferredSize(new Dimension(775,110));
        return tab;
    }

    @Override
    ArrayList<JButton> createButtons() {
        listButton = new ArrayList<>();
        listButton.add(new JButton("Рассчитать"));
        listButton.add(new JButton("Сброс"));
        return listButton;
    }

    public ArrayList<JButton> getListButton() {
        return listButton;
    }

    public static void main(String[] args) {
        new Field();
    }
}
