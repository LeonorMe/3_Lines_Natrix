package formas;

import java.util.ArrayList;

public class Poligono extends Forma{
    private ArrayList<Ponto> points = new ArrayList<Ponto>();; //{new Ponto(0, 0)};

    // CONSTRUCT

    public Poligono(String name, ArrayList<Ponto> p) {
        super(name, p.get(0).x, p.get(0).y, false);
        for (Ponto ponto: p){
            this.points.add(ponto);
        }
    }

    // GET
    @Override
    public Ponto[] getPontos(){
        return points.toArray(new Ponto[0]);
    }

    // TODO add ponto fazer verificaçao

    // DO STUFF
    public boolean isClosed(){
        if(points.get(0) == points.get(points.size()-1)) {
            this.setClosed(true);
            return true;
        }else{
            this.setClosed(false);
            return false;
        }
    }

    public boolean removePonto(int index){
        if(0 < index && index < points.size()){
            points.remove(index);
            retas();
            return true;
        }
        System.out.println("Erro 007: Não é possvivel remover um ponto na posição pedida.");
        return false;
    }

    public void turnClosed(){
        if(isClosed()) {
            System.out.println("A forma já está fechada");
        }else{
            points.add(points.get(0));
        }
    }

    public ArrayList<Reta> retas() {
        ArrayList<Reta> r = null;
        for (int i=0; i<this.points.size()-1; i++){
            r.add(new Reta("r", this.points.get(i), this.points.get(i+1)));
        }
        return r;
    }
    public float perimetro(){
        float comp = 0;
        for (Reta r: retas()){
            comp += r.comprimento();
        }
        return comp;
    }
    public float area(){
        System.out.println("Funcionalidade Indisponivel"); // TODO ? is it possible? usar "pixeis"?
        return 1;
    }

    // ABSTRACT IMPLEMENTATION

    @Override
    public String toString(){
        return "Poligono" + this.getName();
    }
    @Override
    public void show() {
        // super ? TODO
        System.out.println("Poligono nos pontos:");
        for (Ponto ponto:this.points) {
            System.out.println(ponto.toString() + ", ");
        }
    }

    @Override
    public void saveSVG() {
        // TODO
        System.out.println("funcionalidade temporariamente indisponivel");
    }

    // MAIN
    public static void main(String[] args) {
        ArrayList<Ponto> p = new ArrayList<Ponto>();
        p.add(new Ponto(2,3));
        p.add(new Ponto(20,20));
        p.add(new Ponto(50,60));
        p.add(new Ponto(400,600));
        p.add(new Ponto(700,750));

        Poligono poli= new Poligono("poli_005", p);
        poli.show();
        poli.resize(0.5f);
        poli.show();
        poli.fill();
        poli.turnClosed();
        poli.isClosed();
        p.remove(3);
        poli.saveSVG();
    }
}