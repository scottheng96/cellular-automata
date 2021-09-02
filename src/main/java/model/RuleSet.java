package model;

import java.util.HashSet;
import java.util.Set;

public class RuleSet {
    Set<Rule> rules;
    Set<Integer> states;

    public RuleSet(Set<Rule> rules, Set<Integer> states) {
        this.rules = rules;
        this.states = states;
    }
}
