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
    public static JFrame paintFrame;

    private Dimension imageSize = new Dimension(1000, 800);
    public static void main(String[] args) {
        new Paint().show();
    }

    public void show(){
        //create main frame
        paintFrame = new JFrame("2D Paint");
        Container content = paintFrame.getContentPane();
        content.setBackground(Color.DARK_GRAY);
        //set layout on content pane
        content.setLayout(new BorderLayout());

        Icon icon = new ImageIcon("Images/logoIcon.jpg");
        paintFrame.setIconImage(((ImageIcon) icon).getImage());

        // Ask for the size of the image
        getImageSize();
        //create draw area
        this.drawArea = new DrawArea(imageSize);
        this.controls = new Controls();
        this.menu = new Menu();
        //add to content pane
        content.add(drawArea, BorderLayout.CENTER);
        content.add(controls, BorderLayout.EAST);
        content.add(menu, BorderLayout.NORTH);

        paintFrame.setSize(1080, 720);
        //can close frame
        paintFrame.setLocationRelativeTo(null);
        paintFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //show the swing paint result
        paintFrame.setVisible(true);
    }

    private void getImageSize() {
        String askWidth = JOptionPane.showInputDialog(null, "Enter the Width of the image:");
        this.imageSize.width = Integer.parseInt(askWidth);
        String askHeight = JOptionPane.showInputDialog(null, "Enter the Height of the image:");
        this.imageSize.height = Integer.parseInt(askHeight);
    }
}
