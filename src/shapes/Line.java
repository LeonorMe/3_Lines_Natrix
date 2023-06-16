package shapes;

import org.w3c.dom.Element;

public class Line extends AbstShape {
    private float x2=0, y2=0;

    public Line(String id, float x1, float y1, float x2, float y2, String style) {
        super.AbstShape(id, x1, y1, style);
        this.x2 = x2;
        this.y2 = y2;
    }

    // GET
    @Override
    public String getType(){
        return "line";
    }
    public float getX2(){
        return this.x2;
    }
    public float getY2(){
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
        line.setAttribute("x1", Float.toString(getX()));
        line.setAttribute("y1", Float.toString(getY()));
        line.setAttribute("x2", Float.toString(this.x2));
        line.setAttribute("y2", Float.toString(this.y2));
        svg.appendChild(line);
    }

    public void show(){
        System.out.println("Line");
        System.out.println("x2: " + this.x2);
        System.out.println("y2: " + this.y2);
        super.show();
    }
}
