package formas;

public class Reta extends Forma {
    private Ponto[] points = {new Ponto(0,0), new Ponto(0,0)};

    // CONSTRUCT
    public Reta(String name, Ponto p1, Ponto p2){
        super(name, (p1.x + p2.x)/2, (p1.y + p2.y)/2, false);
        this.points = new Ponto[]{p1, p2};
    }

    // GET
    public Ponto[] getPontos(){
        return points;
    }

    // SET
    public void setPonto(int indice,float x, float y){
        this.points[indice].x = x;
        this.points[indice].y = y;
    }

    // DO STUFF
    @Override
    public void setCenter(Ponto newCenter){
        getCenter().setX(newCenter.getX());
        getCenter().setY(newCenter.getY());

        for (Ponto point: this.points) {
            point.x -= newCenter.x;
            point.y -= newCenter.y;
        }
    }

    @Override
    public void setClosed(Boolean bol){
        System.out.println("Erro 001: Não é possível preencher esta forma.");
    }

    public float comprimento(){
        double x =  (double)(points[0].x - points[1].x),
                y = (double)(points[0].y - points[1].y);
        return (float) Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
    }

    // ABSTRACT IMPLEMENTATION

    @Override
    public void show() {
        // super ? TODO
        System.out.println("Reta: " + this.getName());
        System.out.println("Reta do ponto " + this.points[0].toString() + " ao ponto " + this.points[1].toString());
    }

    @Override
    public void saveSVG() {
        // TODO
        System.out.println("funcionalidade temporariamente indisponivel");
    }

    // MAIN
    public static void main(String[] args) {
        Reta linha = new Reta("linha_000", new Ponto(2,3), new Ponto(6,9));
        linha.show();
        linha.resize(2.5f);
        linha.show();
        linha.fill();
        linha.saveSVG();
    }
}
