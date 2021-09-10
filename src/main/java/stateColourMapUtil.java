import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class stateColourMapUtil {
    public static Map<Integer, Color> getStateColourMap(int i) {
        Map<Integer, Color> stateColourMap = new HashMap<Integer, Color>();
        if (i==0) stateColourMap = getGameOfLifeColours();
        if (i==1) stateColourMap = getWarTorColours();
        return stateColourMap;
    }

    // 1 = DEAD | 2 = LIVE
    public static Map<Integer, Color> getGameOfLifeColours() {
        Map<Integer, Color> stateColourMap = new HashMap<Integer, Color>();
        stateColourMap.put(1, Color.white);
        stateColourMap.put(2, Color.black);
        return stateColourMap;
    }

    // 1 = WATER | 2 = FISH | 3 = SHARK
    public static Map<Integer, Color> getWarTorColours() {
        Map<Integer, Color> stateColourMap = new HashMap<Integer, Color>();
        stateColourMap.put(1, Color.cyan);
        stateColourMap.put(2, Color.blue);
        stateColourMap.put(3, Color.darkGray);
        return stateColourMap;
    }
}
