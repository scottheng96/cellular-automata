package model.GameOfLife.rules;

import model.Cell;
import model.Rule;

//1 is dead, 2 is live
public class DeadWithNeighboursRule implements Rule {

    @Override
    public void validate(Cell cell) {
        int activeNeighbours = 0;
        for (Cell neighbour: cell.getNeighbours()) {
            if (neighbour.getState() == 2) {
                activeNeighbours ++;
            }
        }

        if (cell.getState()== 1 && (activeNeighbours == 3)) cell.setState(2);
    }
}
