package formas;

public class Retangulo extends Forma {
    private Ponto[] points = {new Ponto(0, 0), new Ponto(0, 0), new Ponto(0, 0), new Ponto(0, 0)};

    // CONSTRUCT
    public Retangulo(String name, Ponto[] p) {
        super(name, p[0].x, p[0].y, true);
        if (p.length == 2) {
            this.points[0] = p[0];
            this.points[2] = p[1];
        } else {
            System.out.println("Erro 006: Tem que ter 2 pontos.");
        }
        this.points[1] = new Ponto(p[1].x, p[0].y);
        this.points[3] = new Ponto(p[0].x, p[1].y);
    }

    // DO STUFF

    @Override
    public void setClosed(Boolean bol) {
        System.out.println("Esta forma pode ser preenchida.");
    }

    public Reta[] retas() {
        Reta a = new Reta("a", this.points[0], this.points[1]),
                b = new Reta("b", this.points[1], this.points[2]);
        return new Reta[] {a,b};
    }
    public float perimetro(){
        return retas()[0].comprimento() * 2f + retas()[0].comprimento() * 2f;
    }
    public float area(){
        return retas()[0].comprimento() * retas()[1].comprimento();
    }

    // ABSTRACT IMPLEMENTATION


    @Override
    public String toString(){
        return "Retangulo" + this.getName();
    }
    @Override
    public void show() {
        // super ? TODO
        System.out.println("Retangulo nos pontos " + this.points[0].toString() + ", " + this.points[1].toString() + ", " + this.points[2].toString() + ", " + this.points[3].toString());
    }

    @Override
    public void saveSVG() {
        // TODO
        System.out.println("funcionalidade temporariamente indisponivel");
    }

    // MAIN
    public static void main(String[] args) {
        Ponto[] p = {new Ponto(20,30), new Ponto(50,60)};
        Retangulo ret= new Retangulo("ret_004", p);
        ret.show();
        ret.resize(0.5f);
        ret.show();
        ret.fill();
        ret.saveSVG();
        ret.setClosed(true);
    }
}
