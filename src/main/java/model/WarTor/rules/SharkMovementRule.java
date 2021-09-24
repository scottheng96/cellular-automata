package model.WarTor.rules;

import model.Cell;
import model.Rule;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//1 is water, 2 is fish, 3 is shark
public class SharkMovementRule implements Rule {
    @Override
    public void validate(Cell cell) {
        if (cell.getState()==3) {
            //decrease cell life
            cell.setLife(cell.getLife()-1);

            //get available neighbours
            List<Cell> availableNeighbours = new ArrayList<Cell>();
            List<Cell> fishNeighbours = new ArrayList<Cell>();

            for (Cell neighbour: cell.getNeighbours()) {
                if (neighbour.getState() == 2) fishNeighbours.add(neighbour);
                if (neighbour.getState() == 1) availableNeighbours.add(neighbour);
            }

            Random r = new Random();

            //check if can eat fish or move
            Cell fishNeighbour = (!fishNeighbours.isEmpty()) ? fishNeighbours.get(r.nextInt(fishNeighbours.size())) : null;
            Cell availableNeighbour = (!availableNeighbours.isEmpty()) ? availableNeighbours.get(r.nextInt(availableNeighbours.size())) : null;


            if (fishNeighbour != null) {
                //eat fish
                fishNeighbour.setState(3);
                fishNeighbour.setLife(cell.getLife() + cell.getFood());
                cell.setState(1);
                cell.setLife(0);

            } else if (cell.getLife() < 0) {
                // if shark is dead
                cell.setState(1);
                cell.setLife(0);
            } else if (availableNeighbour != null) {
                // move shark
                availableNeighbour.setState(3);
                availableNeighbour.setLife(cell.getLife());
                cell.setState(1);
                cell.setLife(0);
            }

        }


    }




}
