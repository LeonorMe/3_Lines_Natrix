package formas;

import org.w3c.dom.Element;
import javax.xml.parsers.ParserConfigurationException;

public class Rectangle extends AbstShape {
    private String id="000";
    private float x=0, y=0, width=0, height=0;

    public Rectangle(String id, float x, float y, float width, float height, String fill, String stroke, String stroke_width) throws ParserConfigurationException {
        super.Forma(id, x, y, fill, stroke, stroke_width);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    // GET
    @Override
    public String getType(){
        return "rect";
    }
    float getWidth(){
        return this.width;
    }
    float getHeight(){
        return this.height;
    }

    // SET
    void setWidth(int width){
        this.width = width;
    }
    void setHeight(int height){
        this.height = height;
    }

    public void addElement(Element svg, Element rect) {
        super.addElement(svg, rect);
        rect.setAttribute("x", Float.toString(this.x));
        rect.setAttribute("y", Float.toString(this.y));
        rect.setAttribute("width", Float.toString(width));
        rect.setAttribute("height", Float.toString(height));
        svg.appendChild(rect);
    }

    public static void main(String[] args) throws ParserConfigurationException {
        Rectangle rect = new Rectangle("000", 10, 20, 80, 80, "black", "black", "1");
        rect.setX(0);
    }

    public void show(){
        super.show();
        System.out.println("Rectangle");
        System.out.println("width: " + this.width);
        System.out.println("height: " + this.height);
    }
}
