package model;

import java.util.*;

public abstract class AbstractGrid {
    RuleSet ruleSet;
    Map<Integer, Double> probMap;
    Cell[] cells;
    boolean hasLife;

    public void setRuleSet(RuleSet ruleSet) {
        this.ruleSet = ruleSet;
    }

    abstract void createNeighbours();

    public void updateGrid() {
        for (Cell cell: cells) {
            updateCell(cell);
        }
    }

    void updateCell(Cell cell) {
        for (Rule rule: ruleSet.getRules()) {
            rule.validate(cell);
        }
    }

    void setInitialCellState(Cell cell) {
        Random r = new Random();
        List<Integer> keys = new ArrayList<Integer>(probMap.keySet());
        double prob = r.nextDouble();

        double threshold = 0;

        for (int i=1; i<keys.size()+1;i++) {
            threshold += probMap.get(i);
            if (prob<threshold) {
                cell.setState(i);
                if (hasLife) {
                    cell.setLife(setWarTorLife(i));
                }
                break;
            }
        }
    }

    public Cell[] getCells() {
        return cells;
    }

    private int setWarTorLife(int i) {
        if (i==1) return 0;
        else if (i==2) return 1;
        return 3;
    }
}
