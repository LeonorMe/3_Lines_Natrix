package formas;

public abstract class Forma {
    private String name="shape";
    private Ponto center = new Ponto(0,0);
    private boolean closed = true;
    private Ponto[] points = {new Ponto(0,0)};

    // CONSTRUCT
    public Forma(String name, float v, float v1, boolean close){
        setName(this.name);
        this.center.p(v,v1);
        this.closed = close;
    }

    // GET
    public String getName(){
        return this.name;
    }
    public Ponto getCenter() {
        return center;
    }
    public boolean isClosed() {
        return closed;
    }

    // SET
    public void setName(String name) {
        if(nameValid(name)){ // if is valid
            char[] nome = name.toCharArray();
            for(int i=0; i<nome.length; i++){
                if(nome[i] == ' '){
                    nome[i] = '_';
                }
            }
           this.name = nome.toString(); //+ nameExists(allShapes, name); // TODO
        }else{
            this.name = "shape_000";
            System.out.println("Erro 002: Nome inválido, usa a notação shape_001");
        }
    }
    public boolean nameValid(String name){
        if(name != null && name != ""){ // if is valid  //&& name != this.getName() ?
            return true;
        }
        System.out.println("Erro 004: O nome não é válido");
        return false;
    }
    public String nameExists(Forma[] allShapes, String name){
        String nameEnd=null;
        int i=0;
        for(Forma shape : allShapes) { // check if is diferente from all of the names that existes
            if (name == shape.getName()) {
                nameEnd = "0" + Integer.toString(i);
            }
            i++;
        }
        return nameEnd;
    }

    public void setClosed(Boolean bol){
        this.closed = bol;
    }

    // DO STUFF
    public void setCenter(Ponto newCenter){
        getCenter().setX(newCenter.getX());
        getCenter().setY(newCenter.getY());
    }


    public boolean fill(){
        if(this.isClosed()){
            System.out.println("Pode ser pintada");
            return true;
        }
        else{
            System.out.println("É necessário fechar a forma primeiro");
            return false;
        }
    }

    public void show(){
        System.out.println("Forma: " + this.name);
        System.out.println("Com centro em " + this.center);
        System.out.println("A forma é fechada?" + this.closed);
    }

    // ABSTRACT
    public void resize(float times) {
        for (Ponto point: this.points) {
            point.x *= times;
            point.y *= times;
        }
    }

    public abstract void  saveSVG();

    // MAIN
    public static void main(String[] args) {
        System.out.println("Shapes.java");
    }
}
