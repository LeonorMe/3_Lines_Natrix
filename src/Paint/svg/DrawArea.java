package Paint.svg;

import shapes.*;
import shapes.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class DrawArea extends JComponent{
    public static Image image;
    public static ImageSVG imageSVG;
    private Graphics2D g2;
    private int currentX, currentY, oldX, oldY; // Mouse coordinates

    private Color bgColor = Color.WHITE, lastColor = Color.BLACK;

    private Dimension imageSize  = new Dimension(900, 600);

    private String styleString = "stroke:black;stroke-width:1";

    int tickness = 1, numberOfShapes = -1;

    int MODE = 0; // 0 - select, 1 - draw line, 2 - draw circle, 3 - draw rectangle, 4 - draw triangle, 5 - draw polygon, 6 - draw text, 7 - draw path;

    public DrawArea(Dimension imageSize) {
        this.imageSize = imageSize;

        imageSVG = new ImageSVG(imageSize.width, imageSize.height);
        // add a background
        imageSVG.addShape(new Rectangle(getId(), 0, 0, imageSize.width, imageSize.height, "fill:blue"));

        setDoubleBuffered(false);
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                // save coord x,y when mouse is pressed
                if(MODE == 0) {
                    currentX = e.getX();
                    currentY = e.getY();
                    // oldX = e.getX();
                    // oldY = e.getY();

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
        //g2.setPaint(Color.white);
        // draw white on entire draw area to clear
        //g2.fillRect(0, 0, getSize().width, getSize().height);
        //g2.setPaint(Color.black);
        //repaint();
        imageSVG.getShapes().get(0).setStyle("fill:white");
        redrawSVG();
    }

    public void rubber() {
        imageSVG.deleteShape(currentX, currentY);
        redrawSVG();
    }

    public void otherColor() {
        lastColor = JColorChooser.showDialog(null, "Choose a color", lastColor);
        g2.setPaint(lastColor);

    }

    public void setThickness(int size) {
        g2.setStroke(new BasicStroke(size));
        this.tickness = size;
    }

    public void setBgColor() {
        bgColor = JColorChooser.showDialog(null, "Choose a color", Color.WHITE);
        repaint();
        imageSVG.getShapes().get(0).setStyle("fill:" + bgColor.toString());
        redrawSVG();
    }

    public void select() {
        MODE = 0;
    }
    public void line() {
        MODE = 1;
        g2.drawLine(oldX, oldY, currentX, currentY);
        repaint();
        imageSVG.addShape(new Line("line_" + getId(),oldX, oldY, currentX, currentY, this.styleString));
    }
    public void circle() {
        MODE = 2;
        int raio = (int) Math.sqrt(currentX*currentX+currentY*currentY);
        g2.drawOval(oldX, oldY, raio, raio);
        repaint();
        imageSVG.addShape(new Circle("circle_" + getId(),oldX, oldY, raio, this.styleString));
    }
    public void rectangle() {
        MODE = 3;
        g2.drawRect(oldX, oldY, currentX, currentY);
        repaint();
        imageSVG.addShape(new shapes.Rectangle("rect_" + getId(),oldX, oldY, currentX, currentY, this.styleString));
    }

    /*
    public void triangle () { // TODO
        MODE = 4;
        g2.drawLine(oldX, oldY, currentX, currentY);
        g2.drawLine(oldX, oldY, currentX, currentY);
        g2.drawLine(oldX, oldY, currentX, currentY);
        repaint();
        //imageSVG.addShape(new Triangle("tri_" + getId(),oldX, oldY, currentX, currentY, this.styleString));
    }
     */

    public void polyline(){
        MODE = 5;
        ArrayList<Ponto> pontosList = new ArrayList<>(); //new int[]{oldX, currentX}, new int[]{oldY, currentY}
        addMouseListener(new MouseAdapter() { // ?
            @Override
            public void mouseClicked(MouseEvent e){
                if (SwingUtilities.isRightMouseButton(e)) {
                    // Right-click detected

                    int[] pontosX = new int[pontosList.size()], pontosY = new int[pontosList.size()];
                    for (int i=0; i<pontosList.size(); i++) {
                        pontosX[i] = (int) pontosList.get(i).getX();
                        pontosY[i] = (int) pontosList.get(i).getY();
                    }
                    //g2.drawPolyline(pontosX,pontosY ,pontos.size());
                    repaint();
                    imageSVG.addShape(new Polyline("polyline_" + getId(), pontosX[0], pontosY[0], pontosList, styleString));
                    pontosList.clear();

                } else if (SwingUtilities.isLeftMouseButton(e)) {
                    // Left-click detected
                    currentX = e.getX();
                    currentY = e.getY();
                    pontosList.add(new Ponto(currentX, currentY));
                    if (g2 != null) g2.drawLine(oldX, oldY, currentX, currentY);
                    repaint();// refresh draw area to repaint
                    oldX = currentX;
                    oldY = currentY;
                }
            }
        });
    }

    /*
    public void image() { // TODO
        g2.drawImage(image, oldX, oldY, currentX, currentY, null);
        repaint();
        //imageSVG.addShape(new ImageSVG("000",oldX, oldY, currentX, currentY, this.styleString));
    }
     */

    public String getStyle(){
        //"stroke:black;stroke-width:1"
        String style = "stroke:" + lastColor.toString() + ";stroke-width:" + this.tickness;
        return style;
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
            } else if(type.equals("fill")){//g2.fill();
                g2.setPaint(Color.decode(value));
                g2.fillRect(oldX, oldY, currentX, currentY);
                g2.setPaint(lastColor);
            }
        }
    }

    private String getId(){
        this.numberOfShapes++;
        return String.format("%03d", numberOfShapes);
    }

    public void redrawSVG(){
        clear();

        String oldStyle = this.styleString;
        for(AbstShape shape : imageSVG.getShapes()){
            setStyle(shape.getStyle());
            shape.drawShape(g2);
            //repaint(); TODO

            /*
            if(shape instanceof Line) {
                g2.drawLine(shape.getX(), shape.getY(), ((Line) shape).getX2(), ((Line) shape).getY2());
                repaint();
            }
            else if(shape instanceof Circle)
                shape.drawShape(g2);
            else if(shape instanceof shapes.Rectangle)
                shape.drawShape(g2);
            else if(shape instanceof Polyline)
                shape.drawShape(g2);
            else shape.drawShape(g2);
             */
        }
        setStyle(oldStyle);

        repaint();
    }
}
