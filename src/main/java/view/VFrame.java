package view;

import view.shapes.Square;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class VFrame {
    int cellSize;
    Set<JPanel> cells;

    //TODO: Fix handling of border
    public VFrame(int x, int y, int numRow, int numCol, int b) {
        // x and y should be the same for now
        cellSize = x/numRow;
        cells = new HashSet<JPanel>();

        for (int i=0; i<numRow; i++) {
            for (int j=0;j<numCol; j++) {
                Square s = new Square(cellSize, j*cellSize+b, i*cellSize+b, Color.blue);
                cells.add(s.getSquare());
            }
        }
    }

    public Set<JPanel> getVFrame() {
        return cells;
    }
}
