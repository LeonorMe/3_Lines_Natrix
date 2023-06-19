package shapes;

import org.w3c.dom.Element;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;

public class Circle extends AbstShape {
    private int r = 0;

    public Circle(String id, int x, int y, int r, String style) {
        super.AbstShape(id, x, y, style);
        this.r = r;
    }

    // GET
    @Override
    public String getType(){
        return "circle";
    }
    public int getR(){
        return this.r;
    }

    // SET
    public void setR(int r){
        this.r = r;
    }

    @Override
    public void addElement(Element svg, Element circle) {
        super.addElement(svg, circle);
        circle.setAttribute("cx", Integer.toString(getX()));
        circle.setAttribute("cy", Integer.toString(getY()));
        circle.setAttribute("r", Integer.toString(this.r));
        svg.appendChild(circle);
    }

    public void show(){
        System.out.println("Circle");
        System.out.println("r: " + this.r);
        super.show();
    }

    @Override
    public void drawShape(Graphics g) {
        g.fillOval(getX(), getY(), this.r, this.r);
    }

    public boolean isInside(int mouseX, int mouseY) {
        if(!super.isInside(mouseX, mouseY)){
            if(Math.pow(mouseX - getX(), 2) + Math.pow(mouseY - getY(), 2) - Math.pow(this.r, 2) <= getStyleTickness())
                return true;
        }
        return false;
    }
}
