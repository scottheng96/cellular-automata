package model;

import model.GameOfLife.Cell;

public class SquareGrid {
    Cell[][] grid;
    int defaultState = 0;
    RuleSet rules;

    public SquareGrid(int numRow, int numCol, RuleSet rules) {
        grid = new Cell[numRow][numCol];
        this.rules = rules;
        for (int row=0; row<numRow; row++) {
            for (int col=0; col<numCol;col++) {
                grid[row][col] = new Cell(defaultState);
            }
        }
    }

    public void updateGrid() {
        for (Cell[] row: grid) {
            for (Cell cell: row) {
                updateCell(cell);
            }
        }
    }

    public void updateCell(Cell cell) {

    }

    public void setRules(RuleSet rules) {
        this.rules = rules;
    }

}
