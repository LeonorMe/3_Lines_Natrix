package painels;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Load extends JPanel {
    JPanel load = new JPanel();
    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);

    public Load() {
        load.setLayout(new BoxLayout(load, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Loading...");
        frame.getContentPane().add(label);

        int delay = 3000;
        Timer timer = new Timer(delay, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("Finished!");
            }
        });
        frame.pack();
        setVisible(true);
        frame.add(load);

        timer.setRepeats(false);
        timer.start();

       if(!timer.isRunning()){
              frame.remove(load);
       }
    }
}
