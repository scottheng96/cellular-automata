package model;

import model.GameOfLife.rules.DeadWithNeighboursRule;
import model.GameOfLife.rules.LackOfNeighboursRule;
import model.GameOfLife.rules.TooManyNeighboursRule;
import model.GameOfLife.rules.TwoThreeNeighboursRule;

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
        myRuleSet.setRules(myRules);
        return myRuleSet;
    }
}
