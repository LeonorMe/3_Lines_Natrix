package Paint.normal;

import shapes.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class DrawArea extends JComponent{
    public static Image image;
    private static Graphics2D g2;
    private int currentX, currentY, oldX, oldY; // Mouse coordinates

    private Color bgColor = Color.WHITE, lastColor = Color.BLACK;

    private Dimension imageSize  = new Dimension(900, 600);


    public DrawArea(Dimension imageSize) {
        this.imageSize = imageSize;

        setDoubleBuffered(false);
        addMouseListener(new MouseAdapter() { // ?

            public void mousePressed(MouseEvent e) {
                // save coord x,y when mouse is pressed
                oldX = e.getX();
                oldY = e.getY();
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                // coord x,y when drag mouse
                currentX = e.getX();
                currentY = e.getY();

                if (g2 != null) {
                    // draw line if g2 context not null
                    g2.drawLine(oldX, oldY, currentX, currentY);
                    // refresh draw area to repaint
                    repaint();
                    // store current coords x,y as olds x,y
                    oldX = currentX;
                    oldY = currentY;
                }
            }
        });
    }

    protected void paintComponent(Graphics g) {
        if (image == null) {
            // image to draw null
            image = createImage(this.imageSize.width, this.imageSize.height);
            g2 = (Graphics2D) image.getGraphics();
            // enable antialiasing
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            // clear draw area
            clear();
        }
        g.drawImage(image, 0, 0, null);
    }

    // now we create exposed methods
    public void clear() {
        g2.setPaint(Color.white);
        // draw white on entire draw area to clear
        g2.fillRect(0, 0, getSize().width, getSize().height);
        g2.setPaint(Color.black);
        repaint();
    }

    public void black() {
        g2.setPaint(Color.black);
        lastColor = Color.black;
    }

    public void rubber() {
        g2.setPaint(bgColor);
    }

    public void green() {
        g2.setPaint(Color.green);
        lastColor = Color.green;
    }

    public void gray() {
        g2.setPaint(Color.gray);
        lastColor = Color.gray;
    }

    public void otherColor() {
        lastColor = JColorChooser.showDialog(null, "Choose a color", lastColor);
        g2.setPaint(lastColor);

    }

    public void setThickness(int size) {
        g2.setStroke(new BasicStroke(size));
    }

    public void setBgColor() {
        bgColor = JColorChooser.showDialog(null, "Choose a color", Color.WHITE);
        g2.setPaint(bgColor);
        g2.fillRect(0, 0, getSize().width, getSize().height);
        g2.setPaint(Color.black);
        repaint();
    }

    public static void openImage(ImageIcon imageIcon){ // TODO
        Image newImage = imageIcon.getImage();
        image = new BufferedImage(newImage.getHeight(null), newImage.getWidth(null), BufferedImage.TYPE_INT_ARGB);
        g2.drawImage(image, 0, 0, null);
        JLabel imageLabel = new JLabel((Icon) newImage);
        imageLabel.setSize(newImage.getHeight(null), newImage.getWidth(null));
        imageLabel.setLocation(0, 0);
    }

}
