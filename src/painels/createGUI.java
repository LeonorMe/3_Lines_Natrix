package painels;

import javax.swing.*;
import java.awt.*;

public class createGUI {//extends JPanel {
    public static boolean addIsVisible = false;
    public static boolean editIsVisible = false;
    public static boolean newIsVisible = false;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                try {
                    UIManager.setLookAndFeel(new CustomLookAndFeel());
                    SwingUtilities.invokeLater(() -> {

                        criarGUI();

                    });
                } catch (UnsupportedLookAndFeelException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private static void criarGUI() {

        JFrame frame = new JFrame("SVG Software: 3 Lines Natrix");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1080, 720);

        // Criação dos painéis chamando as classes personalizadas
        JPanel menu = new  Menu();
        JPanel canva = new Canva();
        JPanel rodape = new Rodape();
        JPanel add = new Add();
        JPanel edit = new Edit();

        // Define o layout para BorderLayout
        frame.setLayout(new BorderLayout());

        // Adiciona os painéis ao frame usando diferentes posições
        frame.add(menu, BorderLayout.NORTH);
        frame.add(canva, BorderLayout.CENTER);
        frame.add(rodape, BorderLayout.SOUTH);
        frame.add(add, BorderLayout.WEST);
        frame.add(edit, BorderLayout.EAST);
        addIsVisible = true;
        editIsVisible = true;

        // Set the icon image
        ImageIcon icon = new ImageIcon("Images/logoIcon.jpg");
        frame.setIconImage(icon.getImage());

        SwingUtilities.updateComponentTreeUI(frame);
        frame.setVisible(true);
    }
}
