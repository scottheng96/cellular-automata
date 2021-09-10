package view.shapes;

import javax.swing.*;
import java.awt.*;

public class Square {
    JPanel square;
    public Square(int size, int x, int y, Color color) {
        square = new JPanel();
        square.setBounds(x,y,size,size);
        square.setBackground(color);
        square.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public JPanel getSquare() {
        return this.square;
    }

    public void updateSquare(Color color) {
        square.setBackground(color);
    }
}
