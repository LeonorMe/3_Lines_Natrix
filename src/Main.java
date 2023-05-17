import formas.*;

import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception{
        System.out.println("Bem vindo ao SVG Editor - 3 Lines Natrix!" + "\nV0.0");
        System.out.println("Clic 1 to start, 0 to exit...");
        // read value

        ArrayList<Forma> allFormas = null;

        System.out.println("Começa a criar as tuas formas:\n0 Reta;\n1 Triangulo;\n2 Retangulo;\n3 Poligono");
        // read value
        int forma = 0;
        switch (forma){
            case 0:
                Reta linha = new Reta("forma_000", new Ponto(20, 6), new Ponto(50,90));
                //allFormas.add(linha);
                linha.show();
            default:
                Ponto ponto = new Ponto(400,400);
        }
    }
}