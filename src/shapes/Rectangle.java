package shapes;

import org.w3c.dom.Element;
import javax.xml.parsers.ParserConfigurationException;

public class Rectangle extends AbstShape {
    private float width=0, height=0;

    public Rectangle(String id, float x, float y, float width, float height, String fill, String stroke, String strokeWidth) throws ParserConfigurationException {
        super.AbstShape(id, x, y, fill, stroke, strokeWidth);
        this.width = width;
        this.height = height;
    }

    // GET
    @Override
    public String getType(){
        return "rect";
    }
    public float getWidth(){
        return this.width;
    }
    public float getHeight(){
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
        rect.setAttribute("x", Float.toString(getX()));
        rect.setAttribute("y", Float.toString(getY()));
        rect.setAttribute("width", Float.toString(width));
        rect.setAttribute("height", Float.toString(height));
        svg.appendChild(rect);
    }

    public void show(){
        System.out.println("Rectangle");
        System.out.println("width: " + this.width);
        System.out.println("height: " + this.height);
        super.show();
    }
}
