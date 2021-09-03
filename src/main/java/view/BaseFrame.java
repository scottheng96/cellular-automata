package view;

import view.shapes.Square;

import javax.swing.*;
import java.awt.*;

/* This is the main frame which the entire application will run on
* base frame takes into account the border
*
*/
public class BaseFrame {
    int borderBuffer;
    int baseFrameX;
    int baseFrameY;
    JFrame f;

    public BaseFrame(int x, int y, int cpRow, int cpCol) {
        borderBuffer = 100;
        baseFrameX = 600;
        baseFrameY = 600;

        f = new JFrame();

        VFrame vFrame = new VFrame(x,y,cpRow,cpCol, borderBuffer);

        for (JPanel square: vFrame.getVFrame()) {
            f.add(square);
        }
    }

    public void showFrame() {
        f.setSize(baseFrameX + borderBuffer,baseFrameY + borderBuffer);
        f.setLayout(null);
        f.setVisible(true);
    }
}
