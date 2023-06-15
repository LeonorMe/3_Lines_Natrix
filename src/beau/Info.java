package beau;

public class Info {
    final String VERSION = "1.0";
    final String AUTHOR = "Leonor Medeiros - A50758";
    final String NAME = "3 Lines Natrix";

    public String show(){
        String texto = "SVG Software: " + NAME  + " | " + AUTHOR + " | " + "Versão: " + VERSION;
        System.out.println("SVG Software: " + NAME  + "\n" + AUTHOR + "\n" + "Versão: " + VERSION + "\n");
        return texto;
    }
}
