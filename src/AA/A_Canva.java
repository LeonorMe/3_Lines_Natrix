package AA;

import shapes.*;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import AA.A_Menu.*;
import shapes.Image;

public class A_Canva extends JPanel {
    public A_Canva() throws ParserConfigurationException {
        setBackground(Color.WHITE);
        JLabel label = new JLabel("Canva");
        add(label);
        int height = 200, width = 200;
        Image image = new Image(height, width);
        setSize(height, width);

        int mode = AA.A_Menu.getDrawMode();


        addMouseListener(new MouseAdapter() { // parte dos eventos
            ArrayList<Point> points = new ArrayList<>();
            Point point = new Point(0, 0);

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                point.x = e.getX();
                point.y = e.getY();
                points.add(point);
                System.out.println("Point " + " (x,y) = (" + point.getX() + ", " + point.getY() + ")");
                System.out.println("button: " + e.getButton());

                switch (mode) {
                    case 0: // Line
                        int ps = points.size();
                        System.out.println("Line");
                        Line line = new Line("line",points.get(ps-2).x, points.get(ps-2).y, points.get(ps-1).x, points.get(ps -2).y, "black", "blck", "20");
                        image.addShape(line);
                        Graphics g = null;
                        paintComponent(g, mode);
                        break;
                    case 1: // Circle
                        System.out.println("Circle");
                        break;
                    default:
                        System.out.println("Error: Invalid mode");
                        break;
                }

            }
        });

    }

    //@Override
    protected void paintComponent(Graphics g, int mode) { // parte da pintura
        super.paintComponent(g);

        switch (mode) {
            case 0: // Point
                g.drawOval(0,0,1,1);
                break;
            case 1: // Line

                break;
            case 2: // Circle

                break;
            default:
                System.out.println("Error: Invalid mode can't paint");
                break;
        }



        // ter cuidado para quando uma janela passa à frente da nossa não apagar a nossa janela
/*
        for(int i=0; i<points.size()-1; i++){ // Bom para svg
            Point p1 = points.get(i);
            Point p2 = points.get(i+1);
            g.drawLine(p1.x,p1.y,p2.x,p2.y);
        }

 */

        /*
            // para que fiquem sobrepostos
            for(Point p: this.points){
                g.drawOval(p.x,p.y,1,1);
            }


        System.out.println("paint");

        Graphics2D g2 = (Graphics2D) g;
        g2.drawRect(x, y, 20, 20);

        g2.drawString("Hello",x,y); */
    }
}
