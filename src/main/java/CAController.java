import model.GameOfLife.SquareGrid;
import model.GameOfLife.rules.DeadWithNeighboursRule;
import model.GameOfLife.rules.LackOfNeighboursRule;
import model.GameOfLife.rules.TooManyNeighboursRule;
import model.GameOfLife.rules.TwoThreeNeighboursRule;
import model.Rule;
import model.RuleSet;
import view.BaseFrame;

import java.util.HashSet;
import java.util.Set;
import java.util.TimerTask;

public class CAController extends TimerTask {
    SquareGrid myModel;
    BaseFrame myView;

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

        myView = new BaseFrame(500,500,50,50);
    }

    public void run() {
        myView.showFrame();
    }
}
