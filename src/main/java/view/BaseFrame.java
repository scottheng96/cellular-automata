package view;

import view.shapes.Square;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;

/* This is the main frame which the entire application will run on
* base frame takes into account the border
*
*/
public class BaseFrame {
    int borderBuffer;
    int baseX;
    int baseY;
    JFrame f;

    public BaseFrame(Collection<Square> cells, int baseX, int baseY) {
        borderBuffer = 100;
        this.baseX = baseX;
        this.baseY = baseY;

        f = new JFrame();
        for (Square square: cells) {
            f.add(square.getSquare());
        }
    }

    public void showFrame() {
        f.setSize(baseX,baseY);
        f.setLayout(null);
        f.setVisible(true);
    }
}
