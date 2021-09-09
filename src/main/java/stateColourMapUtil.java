import model.GameOfLife.Cell;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class stateColourMapUtil {
    public static Map<Cell.State, Color> getGameOfLifeColours() {
        Map<Cell.State, Color> stateColourMap = new HashMap<Cell.State, Color>();
        stateColourMap.put(Cell.State.LIVE, Color.black);
        stateColourMap.put(Cell.State.DEAD, Color.white);
        return stateColourMap;
    }
}
