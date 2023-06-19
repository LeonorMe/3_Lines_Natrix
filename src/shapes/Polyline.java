package shapes;

import org.w3c.dom.Element;

import java.awt.*;
import java.util.ArrayList;

public class Polyline extends AbstShape {
    // <polyline points="20,20 40,25 60,40 80,120 120,140 200,180" style="fill:none;stroke:black;stroke-width:3" />
    ArrayList<Ponto> pontos;
    public Polyline(String id, int x1, int y1, ArrayList<Ponto> pontos, String style) {
        super.AbstShape(id, x1, y1, style);
        this.pontos = pontos;
    }

    // GET
    @Override
    public String getType(){
        return "path";
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
    /*
    @Override
    public boolean equals(Object o){
        if (o == this) return true;
        if (!(o instanceof Polyline)) return false;
        Polyline p = (Polyline) o;
        return super.equals(p) && this.pontos.equals(p.getPontos());
    }
     */

    @Override
    public void drawShape(Graphics g) {
        for (int i = 0; i < this.getPontos().size()-1; i++) {
            g.drawLine(this.getPonto(i).getX(), this.getPonto(i).getY(), this.getPonto(i+1).getX(), this.getPonto(i+1).getY());
        }
    }

    public boolean isInside(int currentX, int currentY, int size) {
        // TODO
        if(!super.isInside(currentX, currentY)){
            for (Ponto ponto: pontos) {
                if(currentX - ponto.getX() < size && currentY - ponto.getY() < size)
                    return true;
            }
        }
        return false;
    }
}
