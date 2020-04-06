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
     * Конструктор графической оболочки
     */
    Field() {
        super();
    }

    @Override
    Map<String, JPanel> getLocationPanel() {
        Map<String, JPanel> locationPanel = new HashMap<>();
        locationPanel.put("North", createNorthPanel());
        locationPanel.put("Center", createCenterPanel());
        locationPanel.put("South", createSouthPanel());
        return locationPanel;
    }

    @Override
    ArrayList<JButton> getButton() {
        ArrayList<JButton> listButton = new ArrayList<>();
        listButton.add(createButtonStart());
        listButton.add(createButtonStop());
        return listButton;
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
        tab.setPreferredSize(new Dimension(830,90));
        return tab;
    }

    public static void main(String[] args) {
        new Field();
    }
}
