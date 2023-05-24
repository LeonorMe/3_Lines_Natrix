package shapes;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public abstract class AbstShape {
    private String id="000", fill="#000", stroke="#fff", stroke_width="1";
    private float x=0, y=0;

    public void Forma(String id, float x, float y, String fill, String stroke, String stroke_width){
        this.id = id;
        this.x = x;
        this.y = y;
        this.fill = fill;
        this.stroke = stroke;
        this.stroke_width = stroke_width;
    }

    // GET
    public abstract String getType();
    String getId(){
        return this.id;
    }
    float getX(){
        return this.x;
    }
    float getY(){
        return this.y;
    }
    String getFill(){
        return this.fill;
    }
    String getStroke(){
        return this.stroke;
    }
    String getStroke_width(){
        return this.stroke_width;
    }
    // SET
    private void setId(String id){
        this.id = id;
    }
    public void setX(float x){
        this.x = x;
    }
    public void setY(float y){
        this.y = y;
    }
    public void setFill(String fill){
        this.fill = fill;
    }
    public void setStroke(String stroke){
        this.stroke = stroke;
    }
    public void setStroke_width(String stroke_width){
        this.stroke_width = stroke_width;
    }

    public void addElement(Element svg, Element elem) {
        elem.setAttribute("id", this.id);
        //elem.setAttribute("x", Float.toString(this.x));
        //elem.setAttribute("y", Float.toString(this.y));
        elem.setAttribute("stroke", this.stroke);
        elem.setAttribute("fill", this.fill);
        svg.appendChild(elem);
    }

    public void delElement(Element svg, Document doc) {
        svg.removeChild(doc.getElementById(this.id));
    }

    public void show() {
        System.out.println("ID: " + this.id);
        System.out.println("X: " + this.x);
        System.out.println("Y: " + this.y);
        System.out.println("Fill: " + this.fill);
        System.out.println("Stroke: " + this.stroke);
        System.out.println("Stroke-width: " + this.stroke_width);
    }
}
