package Paint.svg;

import Paint.normal.Paint;
import beau.CustomLookAndFeel;
import org.xml.sax.SAXException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import static Paint.svg.DrawArea.imageSVG;
import static shapes.ImageSVG.openSVG;

public class Menu extends JPanel {

    JButton newButton, saveButton, openButton, infoButton, undoButton, redoButton, svgButton;

        public Menu() {
        setBackground(CustomLookAndFeel.lightGreen);

        // NEW BUTTON
        Icon newIcon = new ImageIcon("Images/newIcon.jpg");
        newButton = new JButton(newIcon);
        newButton.addActionListener(e -> {
            //String askNewWindow = JOptionPane.showInputDialog(null, "Do you want to open a new window? (Y/N)");
            //if (askNewWindow.equals("N") || askNewWindow.equals("n")){
             //   Paint.paintFrame.setVisible(false);
            //}
            //new Paint().show();
            //Paint.main(null);
            //Paint.paintFrame.setVisible(false);
            resetProgram();

            // new Main2D().mainFrame.setVisible(true);
        });
        add(newButton);


        // SAVE BUTTON
        Icon saveIcon = new ImageIcon("Images/saveIcon.jpg");
        saveButton = new JButton(saveIcon);
        saveButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Save Image");

            int userSelection = fileChooser.showSaveDialog(null);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                // Get the selected file
                File fileToSave = fileChooser.getSelectedFile();

                // Ensure the file has the .svg extension
                String svgPath = fileToSave.getAbsolutePath();
                if (!svgPath.toLowerCase().endsWith(".svg")) {
                    fileToSave = new File(svgPath + ".svg");
                }
                try {
                    imageSVG.saveSVG(svgPath);
                    JOptionPane.showMessageDialog(null, "I like it Picasso!" + "\n" +
                            "Your work as been sucefully saved to\n" + svgPath + "\n");
                } catch (ParserConfigurationException ex) {
                    throw new RuntimeException(ex);
                } catch (TransformerException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        add(saveButton);


        // OPEN BUTTON
        Icon openIcon = new ImageIcon("Images/openIcon.jpg");
        openButton = new JButton(openIcon);
        openButton.addActionListener(e -> {
            // receber caminho para a pasta
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Open Image");
            int userSelection = JOptionPane.showConfirmDialog(null, "Do you want to open a new window? (Y/N)");
            if (userSelection == JOptionPane.YES_OPTION) {
                Paint.paintFrame.setVisible(false);
                Paint.paintFrame.dispose();
                Paint.main(null);
                JOptionPane.showMessageDialog(null,
                        "Open\n\n" + "Your work as been sucefully opened\n");
            }
        });
        add(openButton);


        // Info BUTTON
        Icon infoIcon = new ImageIcon("Images/infoIcon.jpg");
        infoButton = new JButton(infoIcon);
        infoButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null,
                    "Info\n\n" + "This is a simple paint program\n")
            ;
        });
        add(infoButton);

    }

    public static void resetProgram() {
        Paint.paintFrame.setVisible(false);
        Paint.paintFrame.dispose();
        // Reset variables
        DrawArea.image = new BufferedImage(900, 600, BufferedImage.TYPE_INT_ARGB);
        Paint.main(null);
        // close program
        System.exit(0);
        // TODO
    }
}
