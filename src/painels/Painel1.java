package painels;

import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.IOException;

import static shapes.*;
import static shapes.Image.openSVG;

public class Painel1 extends JPanel {
    public Painel1() {
        setBackground(Color.WHITE);
        //JLabel label1 = new JLabel("Painel 1");
        //add(label1);

        // SAVE BUTTON
        Icon saveIcon = new ImageIcon("Images/logo.png");
        JButton saveButton = new JButton(saveIcon);
        saveButton.addActionListener(e -> {
            // receber caminho para a pasta
            TextArea outPath = new TextArea("C:files/svgWork/paint001.svg", 1, 30);
            String path = String.valueOf(outPath.getAccessibleContext());
            // TODO
            //image.saveSVG(path);
            JOptionPane.showMessageDialog(null,
                    "Save\n\n" + "Your work as been sucefully saved in\n" +
                    path + "\n");
        });
        add(saveButton);

        // OPEN BUTTON
        Icon openIcon = new ImageIcon("Images/logo.png");
        JButton openButton = new JButton(openIcon);
        openButton.addActionListener(e -> {
            // receber caminho para a pasta
            TextArea inPath = new TextArea("C:files/svgWork/paint001.svg", 1, 30);
            String path2 = String.valueOf(inPath.getAccessibleContext());
            // TODO
            try {
                openSVG(path2);
            } catch (ParserConfigurationException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (SAXException ex) {
                throw new RuntimeException(ex);
            }
            JOptionPane.showMessageDialog(null,
                    "Open\n\n" + "Your work as been sucefully opened from\n" +
                            path2 + "\n");
        });
        add(openButton);

        // MENU BUTTON
        Icon menuIcon = new ImageIcon("Images/logo.png");
        JButton menuButton = new JButton(menuIcon);
        menuButton.addActionListener(e -> {
            // TODO
            // show side menu
        });
        add(menuButton);
    }
}
