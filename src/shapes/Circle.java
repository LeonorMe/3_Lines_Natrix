package shapes;

import org.w3c.dom.Element;
import javax.xml.parsers.ParserConfigurationException;

public class Circle extends AbstShape {
    private float r=0;

    public Circle(String id, float x, float y, float r, String fill, String stroke, String strokeWidth) throws ParserConfigurationException {
        super.AbstShape(id, x, y, fill, stroke, strokeWidth);
        this.r = r;
    }

    // GET
    @Override
    public String getType(){
        return "circle";
    }
    public float getR(){
        return this.r;
    }

    // SET
    public void setR(float r){
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

    public void show(){
        System.out.println("Circle");
        System.out.println("r: " + this.r);
        super.show();
    }
}
