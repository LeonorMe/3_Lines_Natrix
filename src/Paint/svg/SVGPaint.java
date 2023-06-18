package Paint.svg;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;

public class SVGPaint {

    public static void main(String[] args) {
        GUI();
    }

    private static void GUI(){
        JFrame frame = new JFrame("SVG Software: 3 Lines Natrix");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1080, 720);
        frame.setBackground(Color.DARK_GRAY);

        JPanel menu = new A_Menu();
        //JPanel canva = new A_Canva();
        frame.setLayout(new BorderLayout());

        frame.add(menu, BorderLayout.NORTH);
       // frame.add(canva, BorderLayout.CENTER);

        //ImageIcon icon = new ImageIcon("Images/logoIcon.jpg");
        //frame.setIconImage(icon.getImage());

        //SwingUtilities.updateComponentTreeUI(frame);
        frame.setVisible(true);
    }

}
