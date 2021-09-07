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
import java.util.Timer;

public class App {


    public static void main(String[] args) {
        System.out.println("Hello World!");

        CAController ca = new CAController(0);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(ca,3000,1000);
    }
}
