package model.GameOfLife;

import model.Rule;
import model.RuleSet;

import java.util.HashSet;
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
                grid[row][col] = new Cell();
            }
        }
        //set neighbours for all the cells
        setNeighbours();
    }

    public Cell[][] getGrid() {
        return grid;
    }

    public void updateGrid() {
        for (Cell[] row: grid) {
            for (Cell cell: row) {
                updateCell(cell);
            }
        }
    }

    public void setRules(RuleSet rules) {
        this.rules = rules;
    }

    private void setNeighbours() {
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
                            //TODO: better logs for out of bounds neighbours
//                            System.out.println("Index out of bounds" );
                        }
                        current.setNeighbours(neighbours);
                    }
                }
            }
        }
    }

    private void updateCell(Cell cell) {
        for (Rule rule: rules.getRules()) rule.validate(cell);
    }
}
