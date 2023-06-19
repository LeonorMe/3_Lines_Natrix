package shapes;

import org.w3c.dom.Element;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;

public class Rectangle extends AbstShape {
    private int width=0, height=0;

    public Rectangle(String id, int x, int y, int width, int height, String style) {
        super.AbstShape(id, x, y, style);
        this.width = width;
        this.height = height;
    }

    // GET
    @Override
    public String getType(){
        return "rect";
    }
    public int getWidth(){
        return this.width;
    }
    public int getHeight(){
        return this.height;
    }

    // SET
    public void setWidth(int width){
        this.width = width;
    }
    public void setHeight(int height){
        this.height = height;
    }

    public void addElement(Element svg, Element rect) {
        super.addElement(svg, rect);
        rect.setAttribute("x", Integer.toString(getX()));
        rect.setAttribute("y", Integer.toString(getY()));
        rect.setAttribute("width", Integer.toString(width));
        rect.setAttribute("height", Integer.toString(height));
        svg.appendChild(rect);
    }

    public void show(){
        System.out.println("Rectangle");
        System.out.println("width: " + this.width);
        System.out.println("height: " + this.height);
        super.show();
    }
    public void drawShape(Graphics g) {
        g.drawRect(getX(), getY(), this.width, this.height);
    }

    @Override
    public boolean isInside(int currentX, int currentY) {
        if(!super.isInside(currentX, currentY)){
            Line[] lines = createLines();
            for(Line line : lines){
                if(line.isInside(currentX, currentY))
                    return true;
            }
        }
        return false;
    }

    private Line[] createLines(){
        Line line0 = new Line("rectLine_0", getX(), getY(), getX()+getWidth(), getY(), getStyle());
        Line line1 = new Line("rectLine_1", getX()+getWidth(), getY(), getX()+getWidth(), getY()+getHeight(), getStyle());
        Line line2 = new Line("rectLine_2", getX()+getWidth(), getY()+getHeight(), getX(), getY()+getHeight(), getStyle());
        Line line3 = new Line("rectLine_3", getX(), getY()+getHeight(), getX(), getY(), getStyle());
        return new Line[]{line0, line1, line2, line3};
    }
}
