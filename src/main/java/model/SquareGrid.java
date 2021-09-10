package model;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class SquareGrid {

    Cell[][] grid;
    RuleSet rules;

    public SquareGrid(int numRow, int numCol, RuleSet rules) {
        grid = new Cell[numRow][numCol];
        this.rules = rules;

        //set grid with cells
        for (int row=0; row<numRow; row++) {
            for (int col=0; col<numCol;col++) {
//                grid[row][col] = new Cell(setLifeState());

                //war tor
                int state = setWarTorState();
                grid[row][col] = new Cell(state,setWarTorLife(state));
            }
        }
        //set neighbours for all the cells
//        createNeighbours();
        createDirectNeighbours();
    }

    public Cell[][] getGrid() {
        return grid;
    }

    public void updateGrid() {
        for (Cell[] row: grid) {
            for (Cell cell : row) {
                updateCell(cell);
            }
        }
    }

    public void setRules(RuleSet rules) {
        this.rules = rules;
    }

    private void createNeighbours() {
        int rows = grid.length;
        int cols = grid[0].length;
        for (int row=0 ; row < rows ; row++) {
            for (int col=0 ; col < cols ; col ++) {
                Cell current = grid[row][col];
                Set<Cell> neighbours = new HashSet<Cell>();

                //adding neighbours
                for (int iRow= row-1 ; iRow<=row+1 ; iRow++) {
                    for (int iCol= col-1 ; iCol<=col+1 ; iCol++) {
                        try {
                            if (current!= grid[iRow][iCol]) neighbours.add(grid[iRow][iCol]);
                        } catch (Exception e) {
                            // out of bounds exception
                        }

                    }
                }
                current.setNeighbours(neighbours);
            }
        }
    }

    private void createDirectNeighbours() {
        int rows = grid.length;
        int cols = grid[0].length;
        for (int row=0 ; row < rows ; row++) {
            for (int col=0 ; col < cols ; col ++) {
                Cell current = grid[row][col];
                Set<Cell> neighbours = new HashSet<Cell>();

                //adding neighbours
                if (row-1 >=0) neighbours.add(grid[row-1][col]);
                if (row+1 < rows) neighbours.add(grid[row+1][col]);
                if (col-1 >=0) neighbours.add(grid[row][col-1]);
                if (col+1 < cols) neighbours.add(grid[row][col+1]);

                current.setNeighbours(neighbours);
            }
        }
    }

    private void updateCell(Cell cell) {
        for (Rule rule: rules.getRules()) rule.validate(cell);
    }

    private int setLifeState() {
        Random rd = new Random();
        float prob = rd.nextFloat();
        if (prob < 0.6) return 1;
        return 2;
    }

    private int setWarTorState() {
        Random rd = new Random();
        float prob = rd.nextFloat();
        if (prob < 0.9) return 1;
        else if (prob < 0.97) return 2;
//        return 3;
        return 3;
    }

    private int setWarTorLife(int i) {
        if (i==1) return 0;
        else if (i==2) return 1;
        return 8;
    }
}



