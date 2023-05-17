package painels;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class Start extends JPanel{
    JPanel start = new JPanel();

    public Start() { // TODO
        // ADD BACKGROUND IMAGE
        //BufferImage bufferImage = ImageIO.read(new URL("https://...));
        //JLabel image = new JLabel(new ImageIcon("beach.jpg"));

        // ADD START BUTTON
        JButton button = new JButton("Play");
        start.add(button);
        button.addActionListener(e ->{
            System.out.println("A iniciar...");
        });

        // ADD SOUND
        /*
        AudioInputStream stream = AudioSystem.getAudioInputStream(new File("ImperialMarch60.wav"));
        Clip clip = AudioSystem.getClip();
        clip.open(stream);
        clip.start();
         */
    }

    @Override
    protected void paintComponent(Graphics g) { // parte da pintura
        super.paintComponent(g);
        //g.drawLine(p1.x, p1.y, p2.x, p2.y);
    }
}