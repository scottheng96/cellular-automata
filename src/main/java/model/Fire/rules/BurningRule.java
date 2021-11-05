package model.Fire.rules;

import model.Cell;
import model.Rule;

// 1 is stone(can't be burnt) | 2 is vegetation | 3 is burning | 4 is burnt
public class BurningRule implements Rule {

    @Override
    public void validate(Cell cell) {
        if (cell.getState()==3) cell.setState(4);
    }
}
