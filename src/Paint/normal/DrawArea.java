package Paint.normal;

import shapes.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.*;

public class DrawArea extends JComponent{
    public static Image image;
    public static ImageSVG imageSVG;
    private Graphics2D g2;
    private int currentX, currentY, oldX, oldY; // Mouse coordinates

    private Color bgColor = Color.WHITE, lastColor = Color.BLACK;

    private Dimension imageSize  = new Dimension(1080, 720);

    private String styleString = "stroke:black;stroke-width:1";

    public DrawArea(Dimension imageSize) {
        this.imageSize = imageSize;

        imageSVG = new ImageSVG(imageSize.width, imageSize.height);

        setDoubleBuffered(false); // ?
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

    public void line() {
        g2.drawLine(oldX, oldY, currentX, currentY);
        repaint();
        imageSVG.addShape(new shapes.Line("000",oldX, oldY, currentX, currentY, this.styleString));
    }
    public void circle() {
        g2.drawOval(oldX, oldY, currentX, currentY);
        repaint();
        int raio = (int) Math.sqrt(currentX*currentX+currentY*currentY);
        //g2.getPaint().toString() ,g2.getStroke().toString()
        imageSVG.addShape(new shapes.Circle("000",oldX, oldY, raio, this.styleString));
    }
    public void rectangle() {
        g2.drawRect(oldX, oldY, currentX, currentY);
        repaint();
        imageSVG.addShape(new shapes.Rectangle("000",oldX, oldY, currentX, currentY, this.styleString));
    }

    public String getStyle(){
        //"stroke:black;stroke-width:1"
        return g2.getPaint().toString() + ";" + g2.getStroke().toString();
    }

    public void setStyle(String style){
        this.styleString = style;
        String[] parts = style.split(";");

        String type, value;
        for(String part : parts){
            type = part.split(":")[0];
            value = part.split(":")[1];

            if(type.equals("stroke")){
                Color color = Color.decode(value);
                g2.setPaint(color);
                lastColor = color;
            } else if(type.equals("stroke-width")){
                setThickness(Integer.parseInt((value)));
            } else if(type.equals("fill")){
                g2.setPaint(Color.decode(value));
                g2.fillRect(oldX, oldY, currentX, currentY);
                g2.setPaint(lastColor);
            }
        }

        //g2.fill();
    }

}
