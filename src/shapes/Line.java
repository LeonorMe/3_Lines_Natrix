package shapes;

import org.w3c.dom.Element;

import java.awt.*;

public class Line extends AbstShape {
    private int x2=0, y2=0;

    public Line(String id, int x1, int y1, int x2, int y2, String style) {
        super.AbstShape(id, x1, y1, style);
        this.x2 = x2;
        this.y2 = y2;
    }

    // GET
    @Override
    public String getType(){
        return "line";
    }
    public int getX2(){
        return this.x2;
    }
    public int getY2(){
        return this.y2;
    }

    // SET
    public void setX2(int x2){
        this.x2 = x2;
    }
    public void setY2(int y2){
        this.y2 = y2;
    }

    @Override
    public void addElement(Element svg, Element line) {
        super.addElement(svg, line);
        line.setAttribute("x1", Integer.toString(getX()));
        line.setAttribute("y1", Integer.toString(getY()));
        line.setAttribute("x2", Integer.toString(this.x2));
        line.setAttribute("y2", Integer.toString(this.y2));
        svg.appendChild(line);
    }

    public void show(){
        System.out.println("Line");
        System.out.println("x2: " + this.x2);
        System.out.println("y2: " + this.y2);
        super.show();
    }

    public void drawShape(Graphics g) {
        g.drawLine(getX(), getY(), this.x2, this.y2);
    }

    @Override
    public boolean isInside(int currentX, int currentY) {
        //return super.isInside(currentX, currentY);
        if (getX2() - getX() == 0) {
            return false;
        }
        else {
            int a = (int) ((int) (getY2() - getY()) / (getX2() - getX()));
            int b = (int) (getY() - a * getX());
            if(getStyleTickness() >= a*currentX + b - currentY ) return true;
            else return false;
        }
    }
}
