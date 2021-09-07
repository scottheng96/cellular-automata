import model.GameOfLife.Cell;
import model.GameOfLife.SquareGrid;
import model.GameOfLife.rules.DeadWithNeighboursRule;
import model.GameOfLife.rules.LackOfNeighboursRule;
import model.GameOfLife.rules.TooManyNeighboursRule;
import model.GameOfLife.rules.TwoThreeNeighboursRule;
import model.Rule;
import model.RuleSet;
import view.BaseFrame;
import view.shapes.Square;

import java.io.InputStream;
import java.util.Properties;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class CAController extends TimerTask {
    Properties prop;
    SquareGrid myModel;
    BaseFrame myView;
    Map<Cell, Square> myModelViewMap;
    Map<Cell.State, Color> stateColorMap;

    int cellSize = 10;

    public CAController(int i) {

        loadProperties();

        //temp variables
        int cellsPerRow = 50;
        int cellsPerColumn = 50;

        stateColorMap = new HashMap<Cell.State, Color>();
        stateColorMap.put(Cell.State.LIVE, Color.black);
        stateColorMap.put(Cell.State.DEAD, Color.white);

        Rule deadWithNeighboursRule = new DeadWithNeighboursRule();
        Rule lackOfNeighboursRule = new LackOfNeighboursRule();
        Rule tooManyNeighboursRule = new TooManyNeighboursRule();
        Rule twoThreeNeighboursRule = new TwoThreeNeighboursRule();
        Set<Rule> myRules = new HashSet<Rule>();
        myRules.add(deadWithNeighboursRule);
        myRules.add(lackOfNeighboursRule);
        myRules.add(tooManyNeighboursRule);
        myRules.add(twoThreeNeighboursRule);

        RuleSet myRuleSet = new RuleSet(myRules);

        myModel = new SquareGrid(cellsPerRow,cellsPerColumn,myRuleSet);

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
        for (Cell cell: myModelViewMap.keySet()) {
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
