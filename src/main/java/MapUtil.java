import java.awt.*;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class MapUtil {

    public static Map<Integer, Double> getSimProbMap(int i) {
        Properties prop = getSimProperties(i);
        Map<Integer, Double> probMap = new HashMap<Integer, Double>();
        for (int state = 1; state < Integer.parseInt(prop.getProperty("states"))+1; state++) {
            probMap.put(state,Double.valueOf(prop.getProperty(String.format("state.%s.prob", state))));
        }

        return probMap;
    }

    public static Map<Integer, Color>  getSimColourMap(int i) {
        Properties prop = getSimProperties(i);
        Map<Integer, Color> colourMap = new HashMap<Integer, Color>();
        for (int state = 1; state < Integer.parseInt(prop.getProperty("states"))+1;state++) {
            System.out.println(prop.getProperty(String.format("state.%s.colour", state)));
            colourMap.put(state, Color.decode(prop.getProperty(String.format("state.%s.colour", state))));
        }
        return colourMap;
    }

    private static Properties getSimProperties(int i) {
        Properties prop = new Properties();
        String propFileName = getPropertiesMap().get(i);
        InputStream inputStream = MapUtil.class.getClassLoader().getResourceAsStream(propFileName);
        try {
            prop.load(inputStream);
        } catch (Exception e) {
            // TODO: manage property exceptions
        }
        return prop;
    }

    private static Map<Integer, String> getPropertiesMap() {
        Map<Integer, String> propertiesMap = new HashMap<Integer, String>();
        propertiesMap.put(1, "sim-gameoflife.properties");
        propertiesMap.put(2, "sim-wartor.properties");
        propertiesMap.put(3, "sim-fire.properties");

        return propertiesMap;
    }
}
