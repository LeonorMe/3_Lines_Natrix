package shapes;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public abstract class AbstShape {
    private String id="000", style="";
    private float x=0, y=0;

    public void AbstShape(String id, float x, float y, String style){
        this.id = id;
        this.x = x;
        this.y = y;
        this.style = style;
    }

    // GET
    public abstract String getType();
    String getId(){
        return this.id;
    }
    public float getX(){
        return this.x;
    }
    public float getY(){
        return this.y;
    }
    String getStyle(){
        return this.style;
    }
    // SET
    public void setId(String id){
        this.id = id;
    }
    public void setX(float x){
        this.x = x;
    }
    public void setY(float y){
        this.y = y;
    }
    public void setStyle(String style){
        this.style = style;
    }

    /*
    public void setAttributes(Element elem) {
        elem.setAttribute("id", this.id);
        //elem.setAttribute("x", Float.toString(this.x));
        //elem.setAttribute("y", Float.toString(this.y));
        elem.setAttribute("style", this.style);
    } */

    public void addElement(Element svg, Element elem) {
        elem.setAttribute("id", this.id);
        //elem.setAttribute("x", Float.toString(this.x));
        //elem.setAttribute("y", Float.toString(this.y));
        elem.setAttribute("style", this.style);

        svg.appendChild(elem);
    }

    public void delElement(Element svg, Document doc) {
        svg.removeChild(doc.getElementById(this.id));
        // TODO del child nodes
    }

    public void show() {
        System.out.println("ID: " + this.id);
        //System.out.println("X: " + this.x);
        //System.out.println("Y: " + this.y);
        System.out.println("Style: " + this.style);
    }

    public boolean isInside(int currentX, int currentY) {
        if(currentX - this.x < 5 && currentY - this.y < 5) return true;
        else return false;
    }
}
