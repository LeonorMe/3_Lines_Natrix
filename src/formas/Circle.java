package formas;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.ParserConfigurationException;

public class Circle extends Forma{
    private String id="000";
    private float x=0, y=0, r=0;

    public Circle(String id, float x, float y, float r, String fill, String stroke, String stroke_width) throws ParserConfigurationException {
        super.Forma(id, x, y, fill, stroke, stroke_width);
        this.r = r;
    }

    // GET
    float getR(){
        return this.r;
    }

    // SET
    void setR(int r){
        this.r = r;
    }

    @Override
    public void addElement(Element svg, Element circle) {
        super.addElement(svg, circle);
        circle.setAttribute("cx", Float.toString(getX()));
        circle.setAttribute("cy", Float.toString(getY()));
        circle.setAttribute("r", Float.toString(this.r));
        svg.appendChild(circle);
    }

    public static void main(String[] args) throws ParserConfigurationException {
        Circle circle = new Circle("000", 10, 20, 15, "white", "black", "1");
        circle.setR(30);
    }
}
