package Paint;

import javax.swing.*;
import java.awt.*;

/*
 * Component for drawing !
 *
 * @autor: Leonor Medeiros
 *
 */

public class Paint {

    public static DrawArea drawArea;
    Controls controls;
    Menu menu;

    private Dimension imageSize = new Dimension(1080, 720);
    public static void main(String[] args) {
        new Paint().show();
    }

    public void show(){
        //create main frame
        JFrame frame = new JFrame("Swing Paint");
        Container content = frame.getContentPane();
        content.setBackground(Color.DARK_GRAY);
        //set layout on content pane
        content.setLayout(new BorderLayout());

        // Ask for the size of the image
        getImageSize();
        //create draw area
        this.drawArea = new DrawArea(imageSize);
        this.controls = new Controls();
        this.menu = new Menu();
        //add to content pane
        content.add(drawArea, BorderLayout.CENTER);
        content.add(controls, BorderLayout.EAST);

        frame.setSize(1080, 720);
        //can close frame
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //show the swing paint result
        frame.setVisible(true);
    }

    private void getImageSize() {
        String askWidth = JOptionPane.showInputDialog(null, "Enter the Width of the image:");
        this.imageSize.width = Integer.parseInt(askWidth);
        String askHeight = JOptionPane.showInputDialog(null, "Enter the Height of the image:");
        this.imageSize.height = Integer.parseInt(askHeight);
    }
}
