package Paint.normal;

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
        Icon icon = new ImageIcon("Images/logoIcon.jpg");
        paintFrame.setIconImage(((ImageIcon) icon).getImage());

        Container content = paintFrame.getContentPane();
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
        content.add(controls, BorderLayout.WEST);
        content.add(menu, BorderLayout.NORTH);

        // ScrollBars
        /*
        JScrollPane scrPane = new JScrollPane(content);
        content.add(scrPane, BorderLayout.CENTER);
        content.setLayout(new GridBagLayout());
        content.add(scrPane, new GridBagConstraints());
        content.add(drawArea, new GridBagConstraints());
         */

        JScrollBar scrollBarH = new JScrollBar(JScrollBar.HORIZONTAL);
        content.add(scrollBarH, BorderLayout.SOUTH);
        JScrollBar scrollBarV = new JScrollBar(JScrollBar.VERTICAL);
        content.add(scrollBarV, BorderLayout.EAST);

/*
        content.add(new JLabel("Connectors example. You can drag the connected component to see how the line will be changed"),
                new GridBagConstraints(0, 0, 2, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 0, 5), 0, 0));
        //content.add(initConnectors(),
                //new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
        //content.add(props,
                //new GridBagConstraints(1, 1, 1, 1, 0, 1, GridBagConstraints.NORTHWEST, GridBagConstraints.VERTICAL, new Insets(5, 0, 5, 5), 0, 0));
        content.setSize(800, 600);
*/


        paintFrame.setSize(1080, 720);
        //can close frame
        paintFrame.setLocationRelativeTo(null);
        paintFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //show the swing paint result
        paintFrame.setVisible(true);
    }

    private void getImageSize() {
        String askSize = JOptionPane.showInputDialog(null, "Enter the Width*Height of the image (1000x800):");
        String[] parts = askSize.split("x"); // Integer.parseInt(askSize);
        this.imageSize.width = Integer.parseInt(parts[0]);
        this.imageSize.height = Integer.parseInt(parts[1]);
    }
}
