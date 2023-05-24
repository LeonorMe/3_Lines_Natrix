package formas;

import org.w3c.dom.Element;

public class Line extends AbstShape {
    private String id="000";
    private float x2=0, y2=0;

    public Line(String id, float x1, float y1, float x2, float y2, String fill, String stroke, String stroke_width) {
        super.Forma(id, x1, y1, fill, stroke, stroke_width);
        this.x2 = x2;
        this.y2 = y2;
    }

    // GET
    @Override
    public String getType(){
        return "line";
    }
    float getX2(){
        return this.x2;
    }
    float getY2(){
        return this.y2;
    }

    // SET
    void setX2(int x2){
        this.x2 = x2;
    }
    void setY2(int y2){
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

    public static void main(String[] args) {
        Line line = new Line("000", 10, 20, 15, 30, "black", "black", "1");
        line.setX(0);
    }
}
