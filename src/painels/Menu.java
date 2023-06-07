package painels;

import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.IOException;

import static painels.Create.addIsVisible;
import static painels.Create.editIsVisible;
import static shapes.Image.openSVG;

public class Menu extends JPanel {
    public static boolean addRemove = false;
    public static boolean editRemove = false;
        public Menu() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);

        setBackground(Color.LIGHT_GRAY);
        //JLabel label1 = new JLabel("Painel 1");
        //add(label1);


        // MENU BUTTON
        Icon menuIcon = new ImageIcon("Images/menuIcon.jpg");
        JButton menuButton = new JButton(menuIcon);
        menuButton.addActionListener(e -> {
            if(!addIsVisible)
                frame.add(new Add());
            else
                addRemove = true;
        });
        add(menuButton);

        // SAVE BUTTON
        Icon saveIcon = new ImageIcon("Images/saveIcon.jpg");
        JButton saveButton = new JButton(saveIcon);
        saveButton.addActionListener(e -> {
            // receber caminho para a pasta
            TextArea outPath = new TextArea("C:files/svgWork/paint001.svg", 1, 30);
            String path = String.valueOf(outPath.getAccessibleContext());
            // TODO
            //image.saveSVG(path);

            frame.add(new Load());

            JOptionPane.showMessageDialog(null,
                    "Save\n\n" + "Your work as been sucefully saved in\n" +
                    path + "\n");
        });
        add(saveButton);

        // OPEN BUTTON
        Icon openIcon = new ImageIcon("Images/openIcon.jpg");
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

        // EDIT BUTTON
        Icon editIcon = new ImageIcon("Images/editIcon.jpg");
        JButton editButton = new JButton(editIcon);
        editButton.addActionListener(e -> {
            if(!editIsVisible)
                frame.add(new Edit());
            else
                editRemove = true;

        });
        add(editButton);

    }
}
