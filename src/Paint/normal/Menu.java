package Paint.normal;

import beau.CustomLookAndFeel;
import beau.Info;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Menu extends JPanel {
        public Menu() {
        setBackground(CustomLookAndFeel.lightGreen);

        // Logo & Info
        Icon logoIcon = new ImageIcon("Images/logoIcon.jpg");
        JButton logoButton = new JButton(logoIcon);
        logoButton.setBackground(Color.WHITE);
        logoButton.setSize(40,40);
        logoButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, Info.getInfo());
        });
        add(logoButton);

        // NEW BUTTON
        Icon newIcon = new ImageIcon("Images/newIcon.jpg");
        JButton newButton = new JButton(newIcon);
        newButton.setBackground(Color.WHITE);
        newButton.setSize(40,40);
        newButton.addActionListener(e -> {
            resetProgram();
        });
        add(newButton);

        // SAVE BUTTON
        Icon saveIcon = new ImageIcon("Images/saveIcon.jpg");
        JButton saveButton = new JButton(saveIcon);
        saveButton.setBackground(Color.WHITE);
        saveButton.setSize(40,40);
        saveButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Save Image");

            int userSelection = fileChooser.showSaveDialog(null);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();

                // Ensure the file has the .jpg extension
                String filePath = fileToSave.getAbsolutePath();
                if (!filePath.toLowerCase().endsWith(".jpg")) {
                    fileToSave = new File(filePath + ".jpg");
                }

                // JPG format
                try {
                    ImageIO.write((RenderedImage) DrawArea.image, "jpg", fileToSave);
                    JOptionPane.showMessageDialog(null, "I like it Picasso!" + "\n" +
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
        JButton openButton = new JButton(openIcon);
        openButton.setBackground(Color.WHITE);
        openButton.setSize(40,40);
        openButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser("Open Image");
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

            // Set the file filter to only allow JPG images
            FileNameExtensionFilter filter = new FileNameExtensionFilter("JPEG Images", "jpg", "jpeg");
            fileChooser.setFileFilter(filter);

            int result = fileChooser.showOpenDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();

                // Check if the selected file has a JPG extension
                if (selectedFile.getName().toLowerCase().endsWith(".jpg") || selectedFile.getName().toLowerCase().endsWith(".jpeg")) {
                    ImageIcon imageIcon = (ImageIcon) fileChooser.getIcon(selectedFile);
                    DrawArea.openImage(imageIcon); // TODO

                    JOptionPane.showMessageDialog(null, "Open\n\n" + "Your work as been sucefully opened from\n" + selectedFile.getAbsolutePath() + "\n");
                } else {
                    System.out.println("Please select a JPG image file.");
                }
            }
        });
        add(openButton);
    }

    private static void resetProgram() {
            // TODO
        Paint.paintFrame.setVisible(false);
        Paint.paintFrame.dispose();
        // Reset variables
        DrawArea.image = new BufferedImage(900, 600, BufferedImage.TYPE_INT_ARGB);
        Paint.main(null);

        //String askNewWindow = JOptionPane.showInputDialog(null, "Do you want to open a new window? (Y/N)");
        //if (askNewWindow.equals("N") || askNewWindow.equals("n")){
        //   Paint.paintFrame.setVisible(false);
        //}
        //new Paint().show();
        //Paint.main(null);
        //Paint.paintFrame.setVisible(false);
        // new Main2D().mainFrame.setVisible(true);
    }

    /*
    void a(){
        File file = fileChooser.getSelectedFile();
        String imagePath = file.getAbsolutePath();
        ImageIcon imageIcon = (ImageIcon) fileChooser.getIcon(file);
        Image newImage = imageIcon.getImage();

        DrawArea.image = new BufferedImage(newImage.getHeight(null), newImage.getWidth(null), BufferedImage.TYPE_INT_ARGB);
        DrawArea.image.getGraphics().drawImage(newImage, 0, 0, null);

        JOptionPane.showMessageDialog(null, "Open\n\n" + "Your work as been sucefully opened from\n" + imagePath + "\n");

    }
     */
}
