package formas;

public class Triangulo extends Forma{
    private Ponto[] points = {new Ponto(0,0), new Ponto(0,0)};

    // CONSTRUCT
    public Triangulo(String name, Ponto[] p) {
        super(name, p[0].x, p[0].y, true);
        if(p.length == 3){
            this.points = p;
        }else{
            System.out.println("Erro 005: Tem que ter 3 pontos.");
        }
    }

    // DO STUFF

    @Override
    public void setClosed(Boolean bol){
        System.out.println("Esta forma pode ser preenchida.");
    }

    public Reta[] retas() {
        Reta a = new Reta("a", points[0], points[1]);
        Reta b = new Reta("b", points[1], points[2]);
        Reta c = new Reta("c", points[2], points[3]);
        return new Reta[] {a,b,c};
    }

    public float perimetro(){
        return retas()[0].comprimento() + retas()[1].comprimento() + retas()[2].comprimento();
    }
    public float area(){
        float altura = 1; // TODO
        return retas()[0].comprimento() * altura / 2.0f;
    }

    // ABSTRACT IMPLEMENTATION

    @Override
    public void show() {
        // super ? TODO
        System.out.println("Triangulo: " + this.getName());
        System.out.println("Triangulo nos pontos " + this.points[0].toString() + ", " + this.points[1].toString() + ", " + this.points[2].toString());
    }

    @Override
    public void saveSVG() {
        // TODO
        System.out.println("funcionalidade temporariamente indisponivel");
    }

    // MAIN
    public static void main(String[] args) {
        Ponto[] p = {new Ponto(2,3), new Ponto(20,20), new Ponto(50,60)};
        Triangulo tri= new Triangulo("tri_001", p);
        tri.show();
        tri.resize(0.5f);
        tri.show();
        tri.fill();
        tri.saveSVG();
    }
}
