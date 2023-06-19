package shapes;

public class Ponto {
    public int x = 0, y = 0;
    private int[] ponto = {x,y};

    public Ponto(int x, int y){
        this.x = x;
        this.y = y;
        this.ponto[0] = x;
        this.ponto[1] = y;
    }
// GET
    public int getX() {
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public int[] getP(){
        return this.ponto;
    }
// SET
    public void setX(int x){
        this.x = x;
        this.ponto[0] = x;
    }
    public void setY(int y){
        this.y = y;
        this.ponto[1] = y;
    }
    public void p(int x, int y){
        this.ponto = new int[]{x,y};
    }

    // DO STUFF

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}
