package model.GameOfLife.rules;

import model.GameOfLife.Cell;
import model.Rule;

import static model.GameOfLife.Cell.State.LIVE;

public class TwoThreeNeighboursRule implements Rule {

    @Override
    public void validate(Cell cell) {
        int activeNeighbours = 0;
        for (Cell neighbour: cell.getNeighbours()) {
            if (neighbour.getState() == LIVE) {
                activeNeighbours ++;
            }
        }

        if (cell.getState()==LIVE && (2 <= activeNeighbours && activeNeighbours <= 3)) cell.setState(LIVE);
    }
}
