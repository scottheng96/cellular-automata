package model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SquareGridClosed extends AbstractGrid{
    int row;
    int col;
    Cell[] cellArr;

    /**
     *
     * @param row: number of cells per row
     * @param col: number of cells per column
     * @param probMap: probability of state creation where key=state, value=probability
     *                  - probability values should add up to 1
     *                  - states should be incremental from 1 onwards depending on simulation
     */
    public SquareGridClosed(int row, int col, Map<Integer, Double> probMap, boolean hasLife) {
        super.probMap = probMap;
        super.hasLife = hasLife;

        int numOfCells = row * col;
        cellArr = new Cell[numOfCells];

        super.cells = cellArr;

        for (int i = 0 ; i<numOfCells ; i++) {
            cellArr[i] = new Cell();
            super.setInitialCellState(cellArr[i]);
        }

        this.row = row;
        this.col = col;

        createNeighbours();
    }
    
    public void createNeighbours() {
        Map<Cell,Set<Cell>> gridMap = new HashMap<Cell,Set<Cell>>();

        for (int i=0;i<cellArr.length;i++) {
            Set<Cell> neighbours = new HashSet<Cell>();

            if (i%row==0) {
                try {
                    neighbours.add(cellArr[i-row]);
                    neighbours.add(cellArr[i-row+1]);
                    neighbours.add(cellArr[i+1]);
                    neighbours.add(cellArr[i+row]);
                    neighbours.add(cellArr[i+row+1]);
                } catch (Exception e) {
                    // empty exception
                }
            } else if (i%row==(row-1)) {
                try {
                    neighbours.add(cellArr[i-row]);
                    neighbours.add(cellArr[i-row-1]);
                    neighbours.add(cellArr[i-1]);
                    neighbours.add(cellArr[i+row]);
                    neighbours.add(cellArr[i+row-1]);
                } catch (Exception e) {
                    //empty exception
                }
            } else {
                try{
                    neighbours.add(cellArr[i-row-1]);
                    neighbours.add(cellArr[i-row]);
                    neighbours.add(cellArr[i-row+1]);
                    neighbours.add(cellArr[i-1]);
                    neighbours.add(cellArr[i+1]);
                    neighbours.add(cellArr[i+row-1]);
                    neighbours.add(cellArr[i+row]);
                    neighbours.add(cellArr[i+row+1]);
                } catch (Exception e) {
                    //empty exception
                }
            }
            cellArr[i].setNeighbours(neighbours);
        }
    }
}
