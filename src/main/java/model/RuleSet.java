package model;

import java.util.HashSet;
import java.util.Set;

public class RuleSet {
    Set<Rule> rules;

    public RuleSet() {

    }

    public RuleSet(Set<Rule> rules) {
        this.rules = rules;
    }

    public void setRules(Set<Rule> rules) {
        this.rules = rules;
    }

    public Set<Rule> getRules() {
        return this.rules;
    }
}
