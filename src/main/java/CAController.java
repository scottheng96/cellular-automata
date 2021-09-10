import model.Cell;
import model.SquareGrid;
import model.RuleSet;
import model.RuleSetFactory;
import view.BaseFrame;
import view.shapes.Square;

import java.io.InputStream;
import java.util.Properties;
import java.awt.*;
import java.util.*;

public class CAController extends TimerTask {
    Properties prop;
    SquareGrid myModel;

    BaseFrame myView;
    Map<Cell, Square> myModelViewMap;
    Map<Integer, Color> stateColorMap;

    int cellSize = 20;

    public CAController(int i) {
        // i = 0 | Game Of Life
        // i = 1 | War-Tor

        // load config
        loadProperties();

        // TODO: use appX and appY in baseFrame configuration
        int appX = Integer.parseInt(prop.getProperty("squareGridX"));
        int appY = Integer.parseInt(prop.getProperty("squareGridY"));
        int cellsPerRow = Integer.parseInt(prop.getProperty("squareCellsPerRow"));
        int cellsPerColumn = Integer.parseInt(prop.getProperty("squareCellsPerColumn"));

        // set rules
        RuleSetFactory myRuleSetFactory = new RuleSetFactory();
        RuleSet myRuleSet = myRuleSetFactory.getRuleSet(i);

        // create model
        myModel = new SquareGrid(cellsPerRow,cellsPerColumn,myRuleSet);

        // find colours for view
        stateColorMap = stateColourMapUtil.getStateColourMap(i);

        // model to link to a map of view cells
        myModelViewMap = buildViewModelMap(myModel);

        //build the view from the model
        myView = new BaseFrame(myModelViewMap.values());
    }

    public Map<Cell, Square>  buildViewModelMap(SquareGrid myModel) {
        Map<Cell, Square> viewModelMap = new HashMap<Cell, Square>();
        Cell[][] myGrid = myModel.getGrid();
        for (int x=0; x<myGrid.length;x++) {
            for (int y=0; y<myGrid[0].length;y++) {
                viewModelMap.put(myGrid[x][y], new Square(cellSize, y*cellSize,x*cellSize, Color.black));
            }
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
        for (Cell[] row: myModel.getGrid()) {
            for (Cell cell: row) {
                if (cell.getState()==2) {
                    count += 1;
                }
            }
        }
        return count;
    }

    public void run() {
        // at every timer step

        //update the model
        myModel.updateGrid();

        //update the view
        updateView();

        //show the frame
        myView.showFrame();
    }
}
