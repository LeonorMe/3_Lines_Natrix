package beau;

public class Info {
    static final String NAME = "3 Lines Natrix";
    static final String VERSION = "2.0";
    static final String AUTHOR = "Leonor Medeiros - A50758";
    static String infoTexto = "SVG Software: " + NAME  + " | " + AUTHOR + " | " + "Version: " + VERSION;
    public void show(){
        System.out.println(infoTexto);
    }
    public static String getInfo(){
        return infoTexto;
    }
}
