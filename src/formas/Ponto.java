package formas;

public class Ponto {
    public float x = 0, y = 0;
    private float[] ponto = {x,y};

    public Ponto(float x, float y){
        this.x = x;
        this.y = y;
        this.ponto[0] = x;
        this.ponto[1] = y;
    }
// GET
    public float getX() {
        return this.x;
    }
    public float getY(){
        return this.y;
    }
    public float[] getP(){
        return this.ponto;
    }
// SET
    public void setX(float x){
        this.x = x;
        this.ponto[0] = x;
    }
    public void setY(float y){
        this.y = y;
        this.ponto[1] = y;
    }
    public void p(float x, float y){
        this.ponto = new float[]{x,y};
    }

    // DO STUFF

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}
