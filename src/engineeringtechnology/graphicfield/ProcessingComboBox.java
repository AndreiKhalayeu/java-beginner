package engineeringtechnology.graphicfield;

import engineeringtechnology.graphicfield.tabs.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProcessingComboBox implements ActionListener {
    private TabCutter tabCutter;
    private static String nameComboBoxCutter = "Концевая фреза";
    private static String nameComboBoxDrill = "Сверло";
    private static String nameComboBoxCountersink = "Цилиндр. зенкер";
    private static String nameComboBoxSweep = "Цилиндр. развертка";
    private static String nameComboBoxTap = "Метр. резьба ГОСТ 24705-81";

    public ProcessingComboBox(TabCutter tabCutter) {
        this.tabCutter = tabCutter;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if ("фреза".equals(ProcessingTab.getNameTab()) && tabCutter.getComboBoxNameCutter().getSelectedIndex() == 0) {
            nameComboBoxCutter = "Концевая фреза";
        }
        if ("фреза".equals(ProcessingTab.getNameTab()) && tabCutter.getComboBoxNameCutter().getSelectedIndex() == 1) {
            nameComboBoxCutter = "Торцевая фреза";
        }
        if ("Сверло".equals(ProcessingTab.getNameTab()) && tabCutter.getComboBoxNameCutter().getSelectedIndex() == 0) {
            nameComboBoxDrill = "Сверло";
        }
        if ("зенкер".equals(ProcessingTab.getNameTab()) && tabCutter.getComboBoxNameCutter().getSelectedIndex() == 0) {
            nameComboBoxCountersink = "Цилиндр. зенкер";
        }
        if ("зенкер".equals(ProcessingTab.getNameTab()) && tabCutter.getComboBoxNameCutter().getSelectedIndex() == 1) {
            nameComboBoxCountersink = "Торц. зенкер";
        }
        if ("развертка".equals(ProcessingTab.getNameTab()) && tabCutter.getComboBoxNameCutter().getSelectedIndex() == 0) {
            nameComboBoxSweep = "Цилиндр. развертка";
        }
        if ("развертка".equals(ProcessingTab.getNameTab()) && tabCutter.getComboBoxNameCutter().getSelectedIndex() == 1) {
            nameComboBoxSweep = "Конич. развертка";
        }
        if ("метчик".equals(ProcessingTab.getNameTab()) && tabCutter.getComboBoxNameCutter().getSelectedIndex() == 0) {
            nameComboBoxTap = "Метр. резьба ГОСТ 24705-81";
        }
        if ("метчик".equals(ProcessingTab.getNameTab()) && tabCutter.getComboBoxNameCutter().getSelectedIndex() == 1) {
            nameComboBoxTap = "Конич. резьба ГОСТ 6111-52";
        }
        if ("метчик".equals(ProcessingTab.getNameTab()) && tabCutter.getComboBoxNameCutter().getSelectedIndex() == 2) {
            nameComboBoxTap = "Тр. цилиндр. резьба ГОСТ 21348-75";
        }
        if ("метчик".equals(ProcessingTab.getNameTab()) && tabCutter.getComboBoxNameCutter().getSelectedIndex() == 3) {
            nameComboBoxTap = "Тр. конич. резьба ГОСТ 21350-75";
        }
    }

    public static String getNameComboBoxCutter() {
        return nameComboBoxCutter;
    }

    public static String getNameComboBoxDrill() {
        return nameComboBoxDrill;
    }

    public static String getNameComboBoxCountersink() {
        return nameComboBoxCountersink;
    }

    public static String getNameComboBoxSweep() {
        return nameComboBoxSweep;
    }

    public static String getNameComboBoxTap() {
        return nameComboBoxTap;
    }
}
