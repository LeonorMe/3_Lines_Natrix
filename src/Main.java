import painels.Info;
import shapes.*;
import static shapes.ImageSVG.*;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception{
        Info info = new Info();
        info.show();

        Scanner scan = new Scanner(System.in);


        System.out.println("Clic 1 to start, 0 to exit...");
        int resp0 = scan.nextInt();

        if(resp0 == 0){
            System.out.println("Obrigada por utilizar este Software! Até à próxima.");
        }else{
            System.out.println("Bem vindo à 3 Lines Natrix, o seu software de edição de Imagens em formato SVG.");

            System.out.println("0 Criar nova imagem;\n1 Abrir imagem existente;");
            int resp1 = scan.nextInt();

            if (resp1 == 0){
                System.out.println("Qual o tamanho da imagem que deseja criar? (largura x altura)");
                int largura = scan.nextInt();
                int altura = scan.nextInt();
                ImageSVG imagem = new ImageSVG(largura, altura);
                System.out.println("Imagem criada com sucesso!");

                int resp2=0;
                do {
                    System.out.println("Começa a criar as tuas formas:\n0 Line;\n1 Rectangle;\n2 Circle;\n3 Point;");
                    int forma = scan.nextInt();

                    if (forma < 4 && forma >= 0) {
                        if(forma == 0) {
                            Line linha = new Line("line_001", 0, 0, 100, 100, "stroke:blue;stroke-width:10");
                            linha.show();
                            imagem.addShape(linha);
                        }
                        else if(forma == 1) {
                            Rectangle retangulo = new Rectangle("ret_001", 15, 25, 30, 30, "stroke:black;stroke-width:5;fill:green");
                            retangulo.show();
                            imagem.addShape(retangulo);
                        }
                        else if(forma == 2) {
                            Circle circulo = new Circle("circ_001", 50, 50, 10, "stroke:white;stroke-width:3;opacity:0.5;fill:red");
                            circulo.show();
                            imagem.addShape(circulo);
                        }
                        else if(forma == 3) {
                            int w = imagem.getDimensions()[0] / 2;
                            int h = imagem.getDimensions()[1] / 2;
                            Ponto ponto = new Ponto(w, h);
                            System.out.println("Ponto criado com sucesso! Na posição (" + ponto.getX() + ", " + ponto.getY() + ")");
                        }
                    }
                    else{
                        System.out.println("Forma inválida!");
                    }

                    System.out.println("Deseja continuar a criar formas? (0 - sim; 1 - não)");
                    resp2 = scan.nextInt();
                }while(resp2 == 0);

                System.out.println("Qual o caminho do ficheiro que deseja guardar?");
                String caminho = scan.next();
                imagem.saveSVG(caminho);

                System.out.println("\nObrigada por utilizar este Software! Até à próxima.");
            }
            else{
                System.out.println("Qual o caminho do ficheiro que deseja abrir?");
                String caminho = scan.next();
                openSVG(caminho);
                //Image oepnImg = new Image(openSVG);
                //image.show();
            }
        }

        //============================================================================================


        // READ FROM EXISTING SVG FILE

        String inPath = "SVG_files/open_svg.svg";
        openSVG(inPath);

        //__________________________________________

        // CREATE NEW SVG FILE

        // 1. Create new image
        ImageSVG newImage = new ImageSVG(100, 100);

        // 2. Add shapes
        Circle newCircle = new Circle("000", 10, 20, 80, "stroke:black;stroke-width:5;fill:green");
        newImage.addShape(newCircle);

        Rectangle rect = new Rectangle("001", 20, 30, 40, 50, "stroke:black;stroke-width:5;fill:green");
        newImage.addShape(rect);

        Line line = new Line("002", 60, 70, 80, 90, "stroke:black;stroke-width:5;fill:green");
        newImage.addShape(line);

        // 3. Set path
        String outPath = "SVG_files/new_03.svg";

        // 4. Save image in new empty SVG file
        newImage.saveSVG(outPath);
    }
}