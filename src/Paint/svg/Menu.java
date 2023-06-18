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

import static Paint.normal.DrawArea.imageSVG;
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
            // receber caminho para a pasta
            //String outPath = JOptionPane.showInputDialog(null, "Save as (C:images/paint/paint001.jpg): ");

            // Save image as .jpg
            // Assuming you have a BufferedImage named 'image' that you want to save

            // Create a file chooser to select the save location
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Save Image");

            int userSelection = fileChooser.showSaveDialog(null);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                // Get the selected file
                File fileToSave = fileChooser.getSelectedFile();

                // Ensure the file has the .jpg extension
                String filePath = fileToSave.getAbsolutePath();
                String svgPath = filePath;
                if (!filePath.toLowerCase().endsWith(".jpg")) {
                    fileToSave = new File(filePath + ".jpg");
                }else {
                    svgPath = filePath.substring(0, filePath.length() - 4);
                }
                svgPath = filePath + ".svg";

                // SVG format
                try {
                    imageSVG.saveSVG(svgPath);
                } catch (ParserConfigurationException ex) {
                    throw new RuntimeException(ex);
                } catch (TransformerException ex) {
                    throw new RuntimeException(ex);
                }

                // JPG format
                // Write the image to the file
                try {
                    ImageIO.write((RenderedImage) DrawArea.image, "jpg", fileToSave);
                    JOptionPane.showMessageDialog(null, "Image saved successfully! I like it Picasso" + "\n" +
                            "Your work as been sucefully saved to\n" +
                            filePath + "\n");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error saving image: " + ex.getMessage());
                }
            }


            // show image preview
            //ImageIcon imageIcon = new ImageIcon(image));
            //JLabel imageLabel = new JLabel(imageIcon);
            //JOptionPane.showMessageDialog(null, imageLabel);

        });
        add(saveButton);


        // OPEN BUTTON
        Icon openIcon = new ImageIcon("Images/openIcon.jpg");
        openButton = new JButton(openIcon);
        openButton.addActionListener(e -> {
            // receber caminho para a pasta
            JTextArea inPath = new JTextArea("C:files/svgWork/paint001.svg", 1, 30);
            String path2 = String.valueOf(inPath.getAccessibleContext());
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
