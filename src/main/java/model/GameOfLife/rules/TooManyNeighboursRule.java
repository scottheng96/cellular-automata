package model.GameOfLife.rules;

import model.GameOfLife.Cell;
import model.Rule;

import static model.GameOfLife.Cell.State.DEAD;
import static model.GameOfLife.Cell.State.LIVE;

public class TooManyNeighboursRule implements Rule {

    @Override
    public void validate(Cell cell) {
        int activeNeighbours = 0;
        for (Cell neighbour: cell.getNeighbours()) {
            if (neighbour.getState() == LIVE) {
                activeNeighbours ++;
            }
        }

        if (activeNeighbours > 3) cell.setState(DEAD);
    }
}
