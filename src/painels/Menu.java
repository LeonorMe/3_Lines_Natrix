package painels;

import shapes.*;
import shapes.Rectangle;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends JPanel{

    protected void paintComponent(Graphics g, Line line) {
        super.paintComponent(g);

        g.drawLine((int) line.getX(), (int) line.getY(), (int) line.getX2(), (int) line.getY2());
    }

    public Menu() {
        Color darkGreen = Color.decode("#006400");
        setBackground(darkGreen);

        setPreferredSize(new Dimension(200, 100));

        JPanel boxPanel = new JPanel();
        boxPanel.setBackground(darkGreen);
        boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.Y_AXIS));
        int verticalGap = 30;
        boxPanel.add(Box.createVerticalStrut(verticalGap));

        JLabel label_menu = new JLabel("Menu");
        boxPanel.add(label_menu);

        // buttons
        JButton addLine = new JButton("Add Line");
        JButton addCircle = new JButton("Add Circle");
        JButton addRect = new JButton("Add Rectangle");

        boxPanel.add(addLine);
        boxPanel.add(addCircle);
        boxPanel.add(addRect);

        add(boxPanel);

        addLine.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Add Line");
            int[] xy1 = {0,0};
            int[] xy2 = {0,0};

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    xy1[0] = e.getX();
                    xy1[1] = e.getY();
                }
            });

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    xy2[0] = e.getX();
                    xy2[1] = e.getY();
                }
            });

            Line line = new Line("Line", (float) xy1[0], (float) xy1[1], (float) xy2[0], (float)xy2[1], "black", "red", "12");
            line.show();
            paintComponent(getGraphics(), line);

        });

        addCircle.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Add Circle");
            try {
                Circle circle = new Circle("Circle", 0, 0, 0, "black", "red", "12");
                circle.show();
            } catch (ParserConfigurationException ex) {
                throw new RuntimeException(ex);
            }
        });

        addRect.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Add Rectangle");
            Rectangle rectangle = null;
            try {
                final int[] x = {0};
                final int[] y = {0};
                final int[] width = {0};
                final int[] height = {0};

                //x = Integer.parseInt(JOptionPane.showInputDialog("Enter x: "));
                //y = Integer.parseInt(JOptionPane.showInputDialog("Enter y: "));

                addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        x[0] = e.getX();
                        y[0] = e.getY();
                    }
                });

                addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        width[0] = e.getX();
                        height[0] = e.getY();
                    }
                });

                rectangle = new Rectangle("Rectangle", x[0], y[0], width[0], height[0], "black", "red", "12");
                rectangle.show();

                java.awt.Rectangle rect = new java.awt.Rectangle(x[0], y[0], width[0], height[0]);
                Graphics2D g2d = (Graphics2D) getGraphics();
                g2d.draw(rect);
            } catch (ParserConfigurationException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}
