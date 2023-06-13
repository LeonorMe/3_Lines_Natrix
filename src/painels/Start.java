package painels;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;

public class Start extends JPanel{
    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                try {
                    UIManager.setLookAndFeel(new CustomLookAndFeel());
                    SwingUtilities.invokeLater(() -> {

                        new createGUI();

                    });
                } catch (UnsupportedLookAndFeelException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}



/*

    public Start() { // TODO
        JPanel startP = new JPanel();
        // ADD BACKGROUND IMAGE
        startP.setBackground(Color.GREEN);
        //BufferImage bufferImage = ImageIO.read(new URL("https://...));
        //JLabel image = new JLabel(new ImageIcon("beach.jpg"));

        // ADD LABEL
        JLabel welcomeLabel = new JLabel("Welcome to the SVG Software: 3 Lines Natrix!");
        welcomeLabel.setBounds(100, 50, 120, 80);
        startP.add(welcomeLabel);

        // ADD START BUTTON
        JButton button = new JButton("Play");
        startP.add(button);
        button.addActionListener(e ->{
            System.out.println("A iniciar...");
        });

        // ADD SOUND

        AudioInputStream stream = AudioSystem.getAudioInputStream(new File("ImperialMarch60.wav"));
        Clip clip = AudioSystem.getClip();
        clip.open(stream);
        clip.start();

    }

    @Override
    protected void paintComponent(Graphics g) { // parte da pintura
        super.paintComponent(g);
        //g.drawLine(p1.x, p1.y, p2.x, p2.y);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("3 Lines Natrix - test painel 0");
        frame.setSize(1920, 1018);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JPanel startP = new JPanel();
        // ADD BACKGROUND IMAGE
        startP.setBackground(Color.GREEN);
        startP.setBounds(0, 0, 1920, 1018);

        JLabel welcomeLabel = new JLabel("Welcome to the SVG Software: 3 Lines Natrix!");
        welcomeLabel.setBounds(100, 50, 120, 80);
        startP.add(welcomeLabel);

        // ADD START BUTTON
        JButton button = new JButton("Play");
        startP.add(button);

        frame.add(startP);

//====================== createP =============================
        JPanel createP = new JPanel();
        createP.setBackground(Color.WHITE);
        createP.add(new JLabel("Create"));

        JComboBox comboBox = new JComboBox();
        comboBox.addItem("New Project");
        comboBox.addItem("Open Project");
        createP.add(comboBox);
        JComboBox comboBox2 = new JComboBox();
        comboBox2.addItem("Reta");
        comboBox2.addItem("Triangulo");
        comboBox2.addItem("Retangulo");
        comboBox2.addItem("Poligono");
        createP.add(comboBox2);
//======================== // ================================

        button.addActionListener(e ->{
            JLabel iniciarLabel = new JLabel("A iniciar...");
            iniciarLabel.setBounds(100, 50, 120, 80);
            startP.add(iniciarLabel);
            frame.add(createP);
        });


        frame.setVisible(true);
    }

} */