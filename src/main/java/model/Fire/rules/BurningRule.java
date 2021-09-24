package model.Fire.rules;

import model.Cell;
import model.Rule;

public class BurningRule implements Rule {
    public void validate(Cell cell) {
        if (cell.getState()==3) cell.setState(4);
    }
}
