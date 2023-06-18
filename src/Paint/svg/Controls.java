package Paint.svg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Paint.svg.SVGPaint.drawArea;
public class Controls extends JPanel {

    private JButton clearBtn, rubberBtn, thicknessBtn, colorBtn, bgColorBtn, styleBtn;
    private JTextField setThickness;

    JMenuBar shapesMenuBar;
    JMenu shapesMenu;
    JMenuItem line, circle, rectangle, path;

    ActionListener actionListener = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == clearBtn) {
                drawArea.clear();
            } else if (e.getSource() == rubberBtn) {
                drawArea.rubber();
            } else if (e.getSource() == colorBtn) {
                drawArea.otherColor();
            } else if (e.getSource() == thicknessBtn) {
                drawArea.setThickness(Integer.parseInt(setThickness.getText()));
            } else if (e.getSource() == bgColorBtn) {
                drawArea.setBgColor();
            } else if (e.getSource() == line) {
                drawArea.line();
            } else if (e.getSource() == circle) {
                drawArea.circle();
            } else if (e.getSource() == rectangle) {
                drawArea.rectangle();
            } else if (e.getSource() == styleBtn) {
                String styleInput = JOptionPane.showInputDialog("Enter style (stroke:#000;stroke-width:1) ");
                drawArea.setStyle(styleInput);
                //} else if (e.getSource() == path) {
               // drawArea.polyline();
            } else {
                    System.out.println("Error");
            }
        }
    };

    public Controls() {
        setBackground(Color.LIGHT_GRAY);
        setLayout(new GridLayout(11, 1));

        clearBtn = new JButton("Clear");
        clearBtn.setBackground(Color.WHITE);
        clearBtn.setSize(60, 40);
        clearBtn.addActionListener(actionListener);

        rubberBtn = new JButton("Rubber");
        rubberBtn.setBackground(Color.WHITE);
        rubberBtn.addActionListener(actionListener);

        colorBtn = new JButton("Other Color");
        colorBtn.addActionListener(actionListener);

        setThickness = new JTextField("1");
        setThickness.setPreferredSize(new Dimension(30, 20));
        thicknessBtn = new JButton("Size");
        thicknessBtn.addActionListener(actionListener);

        bgColorBtn = new JButton("Background Color");
        bgColorBtn.addActionListener(actionListener);

        shapesMenuBar = new JMenuBar();
        shapesMenu = new JMenu("Shapes");
        line = new JMenuItem("Line");
        circle = new JMenuItem("Circle");
        rectangle = new JMenuItem("Rectangle");
        path = new JMenuItem("Path");
        shapesMenu.add(line); shapesMenu.add(circle); shapesMenu.add(rectangle); shapesMenu.add(path);
        shapesMenuBar.add(shapesMenu);
        line.addActionListener(actionListener);
        circle.addActionListener(actionListener);
        rectangle.addActionListener(actionListener);
        path.addActionListener(actionListener);


        styleBtn = new JButton("Style");
        styleBtn.addActionListener(actionListener);

        //add to panel
        add(shapesMenuBar);
        add(clearBtn);
        add(rubberBtn);
        add(colorBtn);
        add(setThickness);
        add(thicknessBtn);
        add(bgColorBtn);
        add(styleBtn);
    }
}
