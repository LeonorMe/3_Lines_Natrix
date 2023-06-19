package shapes;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.awt.*;

public abstract class AbstShape {
    private String id="000", style="";
    private int x=0, y=0;

    public void AbstShape(String id, int x, int y, String style){
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
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public String getStyle(){
        return this.style;
    }
    public int getStyleTickness(){
        String[] parts = this.style.split(";");
        String type, value;
        for(String part : parts){
            type = part.split(":")[0];
            value = part.split(":")[1];

            if(type.equals("stroke-width"))
                return Integer.parseInt((value));
        }
        return 0;
    }

    // SET
    public void setId(String id){
        this.id = id;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public void setStyle(String style){
        this.style = style;
    }

    /*
    public void setAttributes(Element elem) {
        elem.setAttribute("id", this.id);
        //elem.setAttribute("x", Integer.toString(this.x));
        //elem.setAttribute("y", Integer.toString(this.y));
        elem.setAttribute("style", this.style);
    } */

    public void addElement(Element svg, Element elem) {
        elem.setAttribute("id", this.id);
        elem.setAttribute("style", this.style);

        svg.appendChild(elem);
    }

    /*
    public void delElement(Element svg, Document doc) {
        svg.removeChild(doc.getElementById(this.id));
        // TODO del child nodes
    }
     */

    public void show() {
        System.out.println("ID: " + this.id);
        System.out.println("Style: " + this.style);
    }

    public void drawShape(Graphics g) {
        g.drawOval(this.x, this.y, 1, 1);
    }

    public boolean isInside(int currentX, int currentY) {
        int size = getStyleTickness();
        if(currentX - this.x <= size && currentY - this.y <= size) return true;
        else return false;
    }
}
