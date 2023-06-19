package Paint;

import Paint.svg.SVGPaint;
import Paint.normal.Paint;
import beau.Info;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import static beau.CustomLookAndFeel.*;

/*
 * Drawing software with 2D and SVG editor
 *
 * @autor: Leonor Medeiros
 *
 */

public class Main2D {
    JFrame mainFrame;
    public static void main(String[] args) {
        new Main2D().show();
    }

    public void show() {
        mainFrame = new JFrame("2D Editor -  3 Lines Natrix");
        mainFrame.setSize(600, 200);
        mainFrame.getContentPane().setBackground(lightGreen);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null); // center the frame
        mainFrame.setIconImage(new ImageIcon("Images/logoIcon.jpg").getImage());
        mainFrame.setLayout(new FlowLayout());

        JLabel mainLabel = new JLabel("Welcome to 2D Editor - 3 Lines Natrix!\n\n");
        mainLabel.setFont(new Font("Code Pro", Font.PLAIN, 30));

        // Set the buttons side by side
        JButton PaintBtn = new JButton("2D Paint");
        PaintBtn.setFont(new Font("Code Pro", Font.PLAIN, 20));
        PaintBtn.setBackground(darkGreen);
        PaintBtn.setForeground(Color.WHITE);

        JButton SVGBtn = new JButton("SVG Editor");
        SVGBtn.setFont(new Font("Code Pro", Font.PLAIN, 20));
        SVGBtn.setBackground(darkGreen);
        SVGBtn.setForeground(Color.WHITE);

        playAppSound("Sound/AppSound1.wav");

        PaintBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (PaintBtn.contains(e.getPoint())) {
                    PaintBtn.setBackground(orange);
                    PaintBtn.setForeground(Color.BLACK);
                }
            }
            @Override
            public void mouseExited(MouseEvent e) {
                if (!PaintBtn.contains(e.getPoint())) {
                    PaintBtn.setBackground(darkGreen);
                    PaintBtn.setForeground(Color.WHITE);
                }
            }
        });
        SVGBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (SVGBtn.contains(e.getPoint())) {
                    SVGBtn.setBackground(orange);
                    SVGBtn.setForeground(Color.BLACK);
                }
            }
            @Override
            public void mouseExited(MouseEvent e) {
                if (!SVGBtn.contains(e.getPoint())) {
                    SVGBtn.setBackground(darkGreen);
                    SVGBtn.setForeground(Color.WHITE);
                }
            }
        });
        PaintBtn.addActionListener(e -> {
            playAppSound("Sound/AppSound2.wav");
            mainFrame.setVisible(false);
            Paint.main(null);
        });
        SVGBtn.addActionListener(e -> {
            playAppSound("Sound/AppSound2.wav");
            mainFrame.setVisible(false);
            SVGPaint.main(null);
        });


        ImageIcon infoIcon = new ImageIcon("Images/infoIcon40x40.png");
        JButton infoBtn = new JButton(infoIcon);
        //infoBtn.setFont(new Font("Code Pro", Font.PLAIN, 20));
        infoBtn.setPreferredSize(new Dimension(45, 45));
        infoBtn.setBackground(Color.WHITE);
        infoBtn.addActionListener(e -> {
            Info info = new Info();
            String infoText = info.show();
            JOptionPane.showMessageDialog(null, infoText, "Info", JOptionPane.INFORMATION_MESSAGE);
        });

        mainFrame.add(mainLabel);
        mainFrame.add(PaintBtn);
        mainFrame.add(SVGBtn);
        mainFrame.add(mainLabel = new JLabel("         "));
        mainFrame.add(infoBtn);

        mainFrame.setVisible(true);
    }

    public static void playAppSound(String soundFileName) {
        try {
            AudioInputStream sound = AudioSystem.getAudioInputStream(new File(soundFileName));
            Clip clip = AudioSystem.getClip();
            clip.open(sound);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
