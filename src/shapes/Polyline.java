package shapes;

import org.w3c.dom.Element;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.awt.*;
import java.util.ArrayList;

public class Polyline extends AbstShape {
    // Exemple SVG <polyline points="20,20 40,25 60,40 80,120 120,140 200,180" style="fill:none;stroke:black;stroke-width:3" />
    ArrayList<Ponto> pontos;
    public Polyline(String id, int x1, int y1, ArrayList<Ponto> pontos, String style) {
        super.AbstShape(id, x1, y1, style);
        this.pontos = pontos;
    }

    // GET
    @Override
    public String getType(){
        return "polyline";
    }
    public ArrayList<Ponto> getPontos(){
        return this.pontos;
    }
    public Ponto getPonto(int i){
        return this.pontos.get(i);
    }
    public Ponto getLastPonto(){
        return this.pontos.get(this.pontos.size()-1);
    }

    // SET
    public void addPonto(Ponto p){
        this.pontos.add(p);
    }
    public void setPontos(ArrayList<Ponto> pontos){
        this.pontos = pontos;
    }
    public void setPontoI(int i, Ponto p){
        this.pontos.set(i, p);
    }
    public void setLastPonto(Ponto p){
        this.pontos.set(this.pontos.size()-1, p);
    }
    public void deletePonto(int i){
        this.pontos.remove(i);
    }
    public void deleteLastPonto(){
        this.pontos.remove(this.pontos.size()-1);
    }

    @Override
    public void addElement(Element svg, Element polyline) {
        // <polyline points="20,20 40,25 60,40 80,120 120,140 200,180" style="fill:none;stroke:black;stroke-width:3" />
        super.addElement(svg, polyline);
        String points = "";
        for (Ponto ponto : this.getPontos()) {
            points += ponto.getX() + "," + ponto.getY() + " ";
        }
        polyline.setAttribute("points", points);
        svg.appendChild(polyline);
    }

    public void show(){
        System.out.println("polyline");
        System.out.println("x2: " + this.getLastPonto().getX());
        System.out.println("y2: " + this.getLastPonto().getY());
        super.show();
    }

    @Override
    public String toString(){
        String s = "";
        s += "polyline\n";
        s += "x2: " + this.getLastPonto().getX() + "\n";
        s += "y2: " + this.getLastPonto().getY() + "\n";
        s += super.toString();
        return s;
    }

    @Override
    public void drawShape(Graphics g) {
        for (int i = 0; i < this.getPontos().size()-1; i++) {
            g.drawLine(this.getPonto(i).getX(), this.getPonto(i).getY(), this.getPonto(i+1).getX(), this.getPonto(i+1).getY());
        }
    }

    public boolean isInside(int currentX, int currentY, int size) {
        if(!super.isInside(currentX, currentY)){
            Line line;
            for (int i= 0; i < this.getPontos().size() - 1; i++) {
                line = new Line(Integer.toString(i), this.getPonto(i).getX(), this.getPonto(i).getY(), this.getPonto(i+1).getX(), this.getPonto(i+1).getY(), this.getStyle());
                if(line.isInside(currentX, currentY)){
                    return true;
                }
            }
        }
        return false;
    }
    /*
    public void move(int currentX, int currentY, int size) {
        int x = currentX - this.getX1();
        int y = currentY - this.getY1();
        this.setX1(currentX);
        this.setY1(currentY);
        for (int i = 0; i < this.getPontos().size(); i++) {
            this.getPonto(i).setX(this.getPonto(i).getX() + x);
            this.getPonto(i).setY(this.getPonto(i).getY() + y);
        }
    }*/

    /*
    public static void main(String[] args) throws ParserConfigurationException, TransformerException {
        ArrayList<Ponto> pontos = new ArrayList<>();
        pontos.add(new Ponto(20, 20));
        pontos.add(new Ponto(40, 25));
        pontos.add(new Ponto(60, 40));
        pontos.add(new Ponto(80, 120));
        pontos.add(new Ponto(120, 140));
        pontos.add(new Ponto(200, 180));
        Polyline polyline = new Polyline("poly_1", 20, 20, pontos, "fill:none;stroke:black;stroke-width:3");
        polyline.show();

        ImageSVG svg = new ImageSVG(500, 500);
        svg.addShape(polyline);
        svg.saveSVG("polyline.svg");
    }
     */
}
