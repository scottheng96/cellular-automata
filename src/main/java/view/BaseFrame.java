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
    int baseFrameX;
    int baseFrameY;
    JFrame f;

    public BaseFrame(Collection<Square> cells) {
        borderBuffer = 100;
        baseFrameX = 1000;
        baseFrameY = 1000;

        f = new JFrame();
        for (Square square: cells) {
            f.add(square.getSquare());
        }
    }

    public void showFrame() {
        f.setSize(baseFrameX,baseFrameY);
        f.setLayout(null);
        f.setVisible(true);
    }
}
