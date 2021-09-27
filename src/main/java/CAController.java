import model.*;
import view.BaseFrame;
import view.shapes.Square;

import java.io.InputStream;
import java.util.Properties;
import java.awt.*;
import java.util.*;

public class CAController extends TimerTask {
    Properties prop;
    AbstractGrid myModel;

    BaseFrame myView;
    Map<Cell, Square> myModelViewMap;
    Map<Integer, Color> stateColorMap;

    int cellSize = 20;

    public CAController(int i) {
        // i = 0 | Game Of Life
        // i = 1 | War-Tor
        boolean hasLife = i==1;

        // load config
        loadProperties();

        // TODO: use appX and appY in baseFrame configuration
        int baseX = Integer.parseInt(prop.getProperty("squareGridX"));
        int baseY = Integer.parseInt(prop.getProperty("squareGridY"));
        int cellsPerRow = Integer.parseInt(prop.getProperty("squareCellsPerRow"));
        int cellsPerColumn = Integer.parseInt(prop.getProperty("squareCellsPerColumn"));

        // set rules | based on game
        RuleSetFactory myRuleSetFactory = new RuleSetFactory();
        RuleSet myRuleSet = myRuleSetFactory.getRuleSet(i);

        // state map
        Map<Integer, Double> tempMap = MapUtil.getSimProbMap(i);

        // create model | based on game
        myModel = new SquareGridClosed(cellsPerRow,cellsPerColumn, tempMap, hasLife);

        // set rules
        myModel.setRuleSet(myRuleSet);

        // find colours for view | based on game
        stateColorMap = MapUtil.getSimColourMap(i);

        // SETTING VIEW

        // model to link to a map of view cells
        myModelViewMap = buildSquareViewModelMap(myModel, cellsPerRow);

        //build the view from the model
        myView = new BaseFrame(myModelViewMap.values(), baseX, baseY);
    }

    public void run() {
        // at every timer step
        System.out.println(countAlive());

        //update the model
        myModel.updateGrid();

        //update the view
        updateView();

        //show the frame
        myView.showFrame();
    }

    public Map<Cell, Square>  buildSquareViewModelMap(AbstractGrid myModel, int row) {
        Map<Cell, Square> viewModelMap = new HashMap<Cell, Square>();
        Cell[] cells = myModel.getCells();

        for (int i=0;i<cells.length;i++) {
            int x = i%(row);
            int y = i/(row);
            viewModelMap.put(cells[i], new Square(cellSize, x*cellSize, y*cellSize, Color.white));
        }
        return viewModelMap;
    }

    public void updateView() {
        for (Cell cell : myModelViewMap.keySet()) {
            Square mySquare = myModelViewMap.get(cell);
            mySquare.updateSquare(stateColorMap.get(cell.getState()));
        }
    }

    private void loadProperties() {
        prop = new Properties();
        String propFileName = "config.properties";

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        try {
            prop.load(inputStream);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private int countAlive() {
        int count = 0;
        for (Cell cell: myModel.getCells()) {
            if (cell.getState() == 2) {
                count += 1;
            }
        }
        return count;
    }
}
