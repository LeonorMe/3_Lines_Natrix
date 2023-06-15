package Paint;

import javax.swing.*;
import java.awt.*;

/*
 * Component for drawing !
 *
 * @autor: Leonor Medeiros
 *
 */

public class SwingPaint {

    public static DrawArea drawArea;
    Controls controls;
    public static void main(String[] args) {
        new SwingPaint().show();
    }

    public void show(){
        //create main frame
        JFrame frame = new JFrame("Swing Paint");
        Container content = frame.getContentPane();
        //set layout on content pane
        content.setLayout(new BorderLayout());
        //create draw area
        this.drawArea = new DrawArea();
        this.controls = new Controls();
        //add to content pane
        content.add(drawArea, BorderLayout.CENTER);
        content.add(controls, BorderLayout.NORTH);

        frame.setSize(800, 800);
        //can close frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //show the swing paint result
        frame.setVisible(true);
    }
}
