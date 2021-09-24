package model.Fire.rules;

import model.Cell;
import model.Rule;

import java.io.InputStream;
import java.util.Properties;
import java.util.Random;

// 1 is stone(can't be burnt) | 2 is vegetation | 3 is burning | 4 is burnt
public class SpreadFireRule implements Rule {
    Double prob;

    public SpreadFireRule() {
        loadProperties();
    }
    public void validate(Cell cell) {
        for (Cell neighbour: cell.getNeighbours()) {
            if (neighbour.getState() == 2) {
                if (catchesFire()) cell.setState(3);
            }
        }
    }

    private boolean catchesFire() {
        double catchesFireProb= 0.75;
        Random r = new Random();
        return r.nextDouble() < catchesFireProb;

    }

    private void loadProperties() {
        Properties prop = new Properties();
        String propFileName = "sim-fire.properties";

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        try {
            prop.load(inputStream);
            prob = Double.valueOf(prop.getProperty("catchesfireprob"));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
