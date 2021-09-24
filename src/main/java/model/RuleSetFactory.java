package model;

import model.GameOfLife.rules.DeadWithNeighboursRule;
import model.GameOfLife.rules.LackOfNeighboursRule;
import model.GameOfLife.rules.TooManyNeighboursRule;
import model.GameOfLife.rules.TwoThreeNeighboursRule;
import model.WarTor.rules.FishMovementRule;
import model.WarTor.rules.SharkMovementRule;

import java.util.HashSet;
import java.util.Set;

public class RuleSetFactory {

    public RuleSet getRuleSet(int i) {
        RuleSet myRuleSet = new RuleSet();
        Set<Rule> myRules = new HashSet<Rule>();

        // Game Of Life Rules
        if (i==0) {
            Rule deadWithNeighboursRule = new DeadWithNeighboursRule();
            Rule lackOfNeighboursRule = new LackOfNeighboursRule();
            Rule tooManyNeighboursRule = new TooManyNeighboursRule();
            Rule twoThreeNeighboursRule = new TwoThreeNeighboursRule();

            myRules.add(deadWithNeighboursRule);
            myRules.add(lackOfNeighboursRule);
            myRules.add(tooManyNeighboursRule);
            myRules.add(twoThreeNeighboursRule);
        }

        if (i==1) {
            Rule SharkMovementRule = new SharkMovementRule();
            Rule fishMovementRule = new FishMovementRule();

            myRules.add(fishMovementRule);
            myRules.add(SharkMovementRule);
        }

        myRuleSet.setRules(myRules);
        return myRuleSet;
    }
}
