package model.WarTor.rules;

import model.Cell;
import model.Rule;

import java.util.*;

//1 is water, 2 is fish, 3 is shark
public class FishMovementRule implements Rule {
    @Override
    public void validate(Cell cell) {
        int state = cell.getState();

        if (state==2) {
            //increase cell life
            cell.setLife(cell.getLife()+1);

            //get available neighbours
            List<Cell> availableNeighbours = new ArrayList<Cell>();
            for (Cell neighbour: cell.getNeighbours()) {
                if (neighbour.getState() == 1) availableNeighbours.add(neighbour);
            }

            //random select next available space
            Random r = new Random();
            Cell nextNeighbour = (availableNeighbours.size() > 0 ) ? availableNeighbours.get(r.nextInt(availableNeighbours.size())) : null;


            // check if can move/reproduce
            if (nextNeighbour != null) {
                nextNeighbour.setState(2);

                if (cell.canReproduce()) {
                    // check if can reproduce
                    nextNeighbour.setState(2);
                    nextNeighbour.setLife(1);
                    cell.setLife(1);
                } else {
                    // move kill current
                    nextNeighbour.setLife(cell.getLife());
                    nextNeighbour.setState(2);
                    cell.setState(1);
                    cell.setLife(0);
                }
            }

        }
    }
}
