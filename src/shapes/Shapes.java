package shapes;

public abstract class Shapes {
    String name="shape";
    Point center = new Point(0,0);
    boolean closed = true;

    // CONSTRUCT
    public Shapes(String name, float x, float y, boolean close){
        setName(name);
        this.center.x = x;
        this.center.y = y;
        this.closed = close;
    }

    // GET
    public String getName(){
        return this.name;
    }
    public Point getCenter() {
        return center;
    }
    public boolean isClosed() {
        return closed;
    }

    // SET
    public void setName(String name) {
        if( nameValid(name)){ // if is valid
           this.name = name; //+ nameExists(allShapes, name); // TODO
        }
    }
    public boolean nameValid(String name){
        if(name != null && name != "" && name != this.getName()){ // if is valid
            return true;
        }
        return false;
    }
    public String nameExists(Shapes[] allShapes, String name){
        String nameEnd=null;
        int i=0;
        for(Shapes shape : allShapes) { // check if is diferente from all of the names that existes
            if (name == shape.getName()) {
                nameEnd = "0" + Integer.toString(i);
            }
            i++;
        }
        return nameEnd;
    }

    public void setCenter(Point newCenter){
        getCenter().setX(newCenter.getX());
        getCenter().setY(newCenter.getY());
    }

    public void setClosed(Boolean bol){
        // TODO
        // Adcicionar algoritmo que verifique se a shape é efetivamente fechada ou aberta
        this.closed = bol;
    }


    // Do stuff

    public abstract void  resize();
    public abstract void  show();
    public void fill(){
        if(this.isClosed()){
            System.out.println("Pode ser pintada");
        }
        else{
            System.out.println("É necessário fechar a forma primeiro");
        }
    }
    public abstract void  saveSVG();


    public static void main(String[] args) {
        System.out.println("Shapes.java");
    }
}
/*
pacage:
    grafic interface
    elementos_graficos
    package root


        // ver enumerados: array ? ter anumerado de formas >class forma >> classes filhas formas
*/

