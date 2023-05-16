package shapes;

public class Point {
    public float x = 0, y = 0;

    public Point(float x, float y){
        this.x = x;
        this.y = y;
    }
// GET
    public float getX() {
        return this.x;
    }
    public float getY(){
        return this.y;
    }
// SET
    public void setX(float x){
        this.x = x;
    }
    public void setY(float y){
        this.y = y;
    }
}
