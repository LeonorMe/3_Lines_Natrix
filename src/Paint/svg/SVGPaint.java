package Paint.svg;

import javax.swing.*;
import java.awt.*;

public class SVGPaint {
    public static DrawArea drawArea;
    Menu menu;
    Controls controls;
    public static JFrame paintFrame;

    private Dimension imageSize = new Dimension(900, 600);

    public static void main(String[] args) {
        new SVGPaint().show();
    }

    private void show() {
        //create main frame
        paintFrame = new JFrame("SVG Editor");
        Icon icon = new ImageIcon("Images/logoIcon.jpg");
        paintFrame.setIconImage(((ImageIcon) icon).getImage());

        Container content = paintFrame.getContentPane();
        content.setBackground(Color.DARK_GRAY);

        //set layout on content pane
        content.setLayout(new BorderLayout());

        // TODO ask if wants to create a new file or open an existing one

        // Ask for the size of the image
        startImage();
        //create draw area
        this.drawArea = new DrawArea(imageSize);
        this.controls = new Controls();
        this.menu = new Menu();
        //add to content pane
        content.add(drawArea, BorderLayout.CENTER);
        content.add(controls, BorderLayout.WEST);
        content.add(menu, BorderLayout.NORTH);

        JScrollBar scrollBarH = new JScrollBar(JScrollBar.HORIZONTAL);
        content.add(scrollBarH, BorderLayout.SOUTH);
        JScrollBar scrollBarV = new JScrollBar(JScrollBar.VERTICAL);
        content.add(scrollBarV, BorderLayout.EAST);


        paintFrame.setSize(1080, 720);
        paintFrame.setLocationRelativeTo(null);
        paintFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        paintFrame.setVisible(true);
    }

    private void startImage() {
        // ask if new image or open existing one

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Open Image");
        int userSelection = JOptionPane.showConfirmDialog(null, "New image - Y; or open existing one - N? (Y/N)");
        if (userSelection == JOptionPane.NO_OPTION) {
            SVGPaint.paintFrame.setVisible(false);
            SVGPaint.paintFrame.dispose();
            SVGPaint.main(null);
            JOptionPane.showMessageDialog(null,
                    "Open\n\n" + "Your work as been sucefully opened\n");
        } else if (userSelection == JOptionPane.YES_OPTION) {
            // ask size of new image
            String askSize = JOptionPane.showInputDialog(null, "Enter the Width*Height of the image (900x600):");
            String[] parts = askSize.split("x"); // Integer.parseInt(askSize);
            this.imageSize.width = Integer.parseInt(parts[0]);
            this.imageSize.height = Integer.parseInt(parts[1]);
        } else{
            JOptionPane.showMessageDialog(null, "Thank you fo using our program!");
            System.exit(0);
        }
    }
}
