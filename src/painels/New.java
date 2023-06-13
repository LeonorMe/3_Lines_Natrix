package painels;

import javax.swing.*;
import java.awt.*;

public class New extends JPanel {
    public New(){
        setBackground(Color.WHITE);
        JLabel label = new JLabel("Create new image");
        // ask for image size
        // create new image

        JTextField answerField_width, answerField_height;
        JButton startButton;



        add(label);
    }

}
