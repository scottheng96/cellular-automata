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

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class CAController extends TimerTask {
    SquareGrid myModel;
    BaseFrame myView;
    Map<Cell, Square> myModelViewMap;

    int cellSize = 10;

    public CAController(String visualizationName) {
        //temp variables
        int cellsPerRow = 50;
        int cellsPerColumn = 50;


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

    public void updateViewModelMap() {
        for (Cell cell: myModelViewMap.keySet()) {
            Square mySquare = myModelViewMap.get(cell);
            mySquare.updateSquare(cell.getState());
            myModelViewMap.put(cell, mySquare);
        }
    }

    public void run() {
        // at every timer step

        //update the model
        myModel.updateGrid();
        updateViewModelMap();
        //update the view
        // view is updated automatically
        //show the frame
        myView.showFrame();
    }
}
