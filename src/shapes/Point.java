package shapes;

public class Point {
    int x;
    int y;

    int[] coordenadas = {0,0};

    public Point(int x, int y){
        this.x = x;
        this.y = y;
        coordenadas[0]=this.x;
        coordenadas[1] = this.y;
    }

    public int x() {
        return this.x;
    }
    public int y(){
        return this.y;
    }
    public int[] c(){
        return coordenadas;
    }
}
