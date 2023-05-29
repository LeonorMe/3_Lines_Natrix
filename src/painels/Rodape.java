package painels;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Rodape extends JPanel {
    public Rodape() {
        setBackground(Color.GRAY);

        ImageIcon icon = new ImageIcon("Images/logo.png");
        Image originalImage = icon.getImage();
        Image resizedImage = originalImage.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        JLabel label_logo = new JLabel(resizedIcon);

        setLayout(new FlowLayout());
        add(label_logo);

        Info info = new Info();
        JLabel label_info = new JLabel(info.show());
        add(label_info);
        String buttonText = "HELP";
        JButton button_help = new JButton(buttonText);

        button_help.setPreferredSize(new Dimension(65,30));

        button_help.addActionListener(e -> {
            JOptionPane.showMessageDialog(null,
                    "Help\n\n" + "This is a software to edit SVG files\n" +
                    "You can create, edit, save and load SVG files\n" +
                            "For more information please go to the github page\n" +
                            "https://github.com/LeonorMe/3_Lines_Natrix\n" +
                            "or contact us by email: " + "leo305medeiros@gmail.com\n\n" +
                            "Thank you for using our software!\n"
            );
        });

        add(button_help);
    }
}
