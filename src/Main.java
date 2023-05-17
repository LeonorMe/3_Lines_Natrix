import formas.*;

import java.util.ArrayList;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(System.in);
        System.out.println("Bem vindo ao SVG Editor - 3 Lines Natrix!" + "\nV0.0");
        System.out.println("Clic 1 to start, 0 to exit...");
        int resp0 = scan.nextInt();
        if(resp0 == 0){
            System.out.println("Obrigada por utilizar este Software! Até à próxima.");
        }else{
            System.out.println("Bem vindo à 3 Lines Natrix, o seu software de edição de Imagens em formato SVG.");

            ArrayList<Forma> allFormas = new ArrayList<Forma>();

            System.out.println("Começa a criar as tuas formas:\n0 Reta;\n1 Triangulo;\n2 Retangulo;\n3 Poligono");
            int forma = scan.nextInt();

            switch (forma){
                case 0:
                    Reta linha = new Reta("forma_000", new Ponto(20, 6), new Ponto(50,90));
                    //allFormas.add(linha);
                    linha.show();
                case 1:
                    Ponto[] p1 = {new Ponto(2,3), new Ponto(20,20), new Ponto(50,60)};
                    Triangulo tri= new Triangulo("tri_001", p1);
                    tri.show();
                case 2:
                    Ponto[] p2 = {new Ponto(20,30), new Ponto(50,60)};
                    Retangulo ret= new Retangulo("ret_004", p2);
                    ret.show();
                case 3:
                    ArrayList<Ponto> p3 = new ArrayList<Ponto>();
                    p3.add(new Ponto(2,3));
                    p3.add(new Ponto(20,20));
                    p3.add(new Ponto(50,60));
                    p3.add(new Ponto(400,600));
                    p3.add(new Ponto(700,750));

                    Poligono poli = new Poligono("poli_005", p3);
                    poli.show();
                default:
                    Ponto ponto = new Ponto(400,400);
            }
        }
    }
}