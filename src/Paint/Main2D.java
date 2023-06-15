package Paint;

import beau.Info;
import javax.swing.*;
import java.awt.*;

import static beau.CustomLookAndFeel.*;

public class Main2D {
    JFrame mainFrame;
    public static void main(String[] args) {
        new Main2D().show();
    }

    public void show() {
        mainFrame = new JFrame("2D Editor");
        mainFrame.setSize(600, 200);
        mainFrame.getContentPane().setBackground(lightGreen);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null); // center the frame
        mainFrame.setIconImage(new ImageIcon("Images/logoIcon.jpg").getImage());
        mainFrame.setLayout(new FlowLayout());

        JLabel mainLabel = new JLabel("Welcome to 2D Editor: 3 Lines Natrix!\n\n");
        mainLabel.setFont(new Font("Code Pro", Font.PLAIN, 30));

        // Set the buttons side by side
        JButton PaintBtn = new JButton("2D Paint");
        PaintBtn.setFont(new Font("Code Pro", Font.PLAIN, 20));
        PaintBtn.setBackground(orange);

        JButton SVGBtn = new JButton("SVG Editor");
        SVGBtn.setFont(new Font("Code Pro", Font.PLAIN, 20));
        SVGBtn.setBackground(green);

        PaintBtn.addActionListener(e -> {
            mainFrame.setVisible(false);
            Paint.main(null);
        });
        SVGBtn.addActionListener(e -> {
            mainFrame.setVisible(false);
            //Main.main(null); // Open SVG
            System.out.println("Sorry, under construction!");
            // exit
            System.exit(0);
        });

        // put image in the button
        //ImageIcon infoIcon = new ImageIcon("Images/infoIcon.png");
        JButton infoBtn = new JButton("Info");
        infoBtn.setFont(new Font("Code Pro", Font.PLAIN, 20));
        infoBtn.setBackground(darkGreen);
        infoBtn.addActionListener(e -> {
            Info info = new Info();
            info.show();
        });

        mainFrame.add(mainLabel);
        mainFrame.add(PaintBtn);
        mainFrame.add(SVGBtn);
        mainFrame.add(mainLabel = new JLabel("         "));
        mainFrame.add(infoBtn);

        mainFrame.setVisible(true);
    }
}
