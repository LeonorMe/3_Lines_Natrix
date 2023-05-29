package painels;

import javax.swing.*;
import java.awt.*;

public class Create {//extends JPanel {
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
        JPanel painel1 = new Painel1();
        JPanel painel2 = new Canva();
        JPanel painel3 = new Rodape();
        JPanel menu = new Menu();

        // Define o layout para BorderLayout
        frame.setLayout(new BorderLayout());

        // Adiciona os painéis ao frame usando diferentes posições
        frame.add(painel1, BorderLayout.NORTH);
        frame.add(painel2, BorderLayout.CENTER);
        frame.add(painel3, BorderLayout.SOUTH);
        frame.add(menu, BorderLayout.WEST);

        // Set the icon image
        ImageIcon icon = new ImageIcon("Images/logo.png");
        frame.setIconImage(icon.getImage());

        SwingUtilities.updateComponentTreeUI(frame);
        frame.setVisible(true);
    }
}
