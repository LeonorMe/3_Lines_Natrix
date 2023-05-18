package painels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
public class Save extends JPanel {
    JPanel save = new JPanel();

    public Save() { // TODO

        // ADD Save BUTTON
        JButton button = new JButton("Save");
        save.add(button);
        button.addActionListener(e ->{
            System.out.println("Saving");
        });


    }
}
