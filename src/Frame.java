import painels.*;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Frame {
    public static void main(String[] args) {
        /*
        String[] fontNames = {"Courier New", "Consolas", "Monospaced", "DejaVu Sans Mono", "Lucida Console", "Menlo", "Source Code Pro", "Ubuntu Mono"};
        int fontSize = 14;

        for (String fontName : fontNames) {
            Font font = new Font(fontName, Font.PLAIN, fontSize);
            JLabel label = new JLabel(fontName);
            label.setFont(font);

            JFrame frame = new JFrame("Font Example");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(200, 50);
            frame.getContentPane().setLayout(new FlowLayout());
            frame.getContentPane().add(label);
            frame.setVisible(true);
        } */


 /*        Scanner scanner = new Scanner(System.in);

        JFrame frame = new JFrame("3 Lines Natrix");
        frame.setSize(1920, 1018);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        int painel = 0;
        System.out.println("Chose Painel: 0 - Start, 1 - Create, 2 - Edit, 3 - Save, 4 - Load, 5 - Exit, 6 - Menu");
        painel = scanner.nextInt();

        switch (painel){
            case 0:
                frame.add(new Start()); // Open page

            case 1:
                frame.add(new Create()); // Strat new project or open other
            case 2:
                frame.add(new Edit()); // actual SVG work
            case 3:
                frame.add(new Save()); // Save new work in SVG
            case 4:
                frame.add(new Load()); // Load SVG to check
            case 5:
                frame.add(new Exit()); // Exit
            case 6:
                frame.add(new Menu()); // Menu
            default:
                frame.add(new Start());


        }

        frame.setVisible(true);*/
    }
}