package engineeringtechnology.cuttingmodes.data;

import engineeringtechnology.cuttingmodes.AbstractTool;
import engineeringtechnology.cuttingmodes.tool.*;
import engineeringtechnology.graphicfield.tabs.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Класс содержащий данные
 */
public class Data {
    /**
     * Поле список подач для станка ГФ2171
     */
    public static final Map<Integer, Integer> LIST_TURNS = new TreeMap<>();
    static {
        LIST_TURNS.put(56, 50);
        LIST_TURNS.put(71, 63);
        LIST_TURNS.put(89, 80);
        LIST_TURNS.put(112, 100);
        LIST_TURNS.put(142, 125);
        LIST_TURNS.put(179, 160);
        LIST_TURNS.put(224, 200);
        LIST_TURNS.put(282, 250);
        LIST_TURNS.put(357, 315);
        LIST_TURNS.put(449, 400);
        LIST_TURNS.put(564, 500);
        LIST_TURNS.put(714, 630);
        LIST_TURNS.put(899, 800);
        LIST_TURNS.put(1124, 1000);
        LIST_TURNS.put(1424, 1250);
        LIST_TURNS.put(1799, 1600);
        LIST_TURNS.put(2249, 2000);
        LIST_TURNS.put(2500, 2500);
    }

    /**
     * Поле список вкладок
     */
    public static final List<TabCutter> LIST_TAB = new ArrayList<>();
    static {
        LIST_TAB.add(new TabCutter());
        LIST_TAB.add(new TabDrill());
        LIST_TAB.add(new TabCountersink());
        LIST_TAB.add(new TabSweep());
        LIST_TAB.add(new TabTap());
    }

    /**
     * Поле список фрез
     */
    public static final List<AbstractTool> LIST_CUTTER = new ArrayList<>();
    static {
        LIST_CUTTER.add(new Cutter());
        LIST_CUTTER.add(new CutterButt());
    }

    /**
     * Поле список сверл
     */
    public static final List<AbstractTool> LIST_DRILL = new ArrayList<>();
    static {
        LIST_DRILL.add(new Drill());
    }

    /**
     * Поле список зенкеров
     */
    public static final List<AbstractTool> LIST_COUNTERSINK = new ArrayList<>();
    static {
        LIST_COUNTERSINK.add(new Countersink());
    }

    /**
     * Поле список разверток
     */
    public static final List<AbstractTool> LIST_SWEEP = new ArrayList<>();
    static {
        LIST_SWEEP.add(new Sweep());
    }

    /**
     * Поле список метчиков
     */
    public static final List<AbstractTool> LIST_TAP = new ArrayList<>();
    static {
        LIST_TAP.add(new Tap());
    }

    /**
     * Поле список групп инструментов
     */
    public static final List<List<AbstractTool>> LIST_TOOL = new ArrayList<>();
    static {
        LIST_TOOL.add(LIST_CUTTER);
        LIST_TOOL.add(LIST_DRILL);
        LIST_TOOL.add(LIST_COUNTERSINK);
        LIST_TOOL.add(LIST_SWEEP);
        LIST_TOOL.add(LIST_TAP);
    }
}
