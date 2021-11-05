package model.Fire.rules;

import model.Cell;
import model.Rule;

import java.io.InputStream;
import java.util.Properties;
import java.util.Random;

// 1 is stone(can't be burnt) | 2 is vegetation | 3 is burning | 4 is burnt
public class SpreadFireRule implements Rule {

    @Override
    public void validate(Cell cell) {
        if (cell.getState()==2) {
            for (Cell neighbour: cell.getNeighbours()) {
                if (neighbour.getState() == 3) {
                    if (catchesFire()) cell.setState(3);
                }
            }
        }
    }

    private boolean catchesFire() {
        double catchesFireProb= 0.75;
        Random r = new Random();
        System.out.println("testing catches fire");
        return r.nextDouble() < catchesFireProb;
    }
}
