package SVGPaint;

import javax.swing.*;
import java.awt.*;

public class A_Menu extends JPanel {
    private static int DrawMode = 0;
    public A_Menu() {
        setBackground(Color.decode("#7B9F47"));
        JLabel label = new JLabel("Menu");
        add(label);

        Icon lineIcon = new ImageIcon("Images/lineIcon.jpg");
        Icon circleIcon = new ImageIcon("Images/circleIcon.jpg");
        JButton lineButton = new JButton(lineIcon); // "Line"
        JButton circleButton = new JButton(circleIcon); // "Circle"
        add(lineButton);
        add(circleButton);

        lineButton.addActionListener(e -> {
            System.out.println("Line button pressed");
            this.DrawMode = 0;
        });
        circleButton.addActionListener(e -> {
            System.out.println("Circle button pressed");
            this.DrawMode = 1;
        });
    }

    public static int getDrawMode(){
        return DrawMode;
    }
}
