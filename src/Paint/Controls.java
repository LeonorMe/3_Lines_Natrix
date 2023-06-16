package Paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controls extends JPanel {

    private JButton clearBtn, blackBtn, grayBtn, greenBtn, rubberBtn, thicknessBtn, colorBtn, bgColorBtn, styleBtn;
    private JTextField setThickness;

    JMenuBar shapesMenuBar;
    JMenu shapesMenu;
    JMenuItem line, circle, rectangle;

    ActionListener actionListener = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == clearBtn) {
                Paint.drawArea.clear();
            } else if (e.getSource() == blackBtn) {
                Paint.drawArea.black();
            } else if (e.getSource() == grayBtn) {
                Paint.drawArea.gray();
            } else if (e.getSource() == greenBtn) {
                Paint.drawArea.green();
            } else if (e.getSource() == rubberBtn) {
                Paint.drawArea.rubber();
            } else if (e.getSource() == colorBtn) {
                Paint.drawArea.otherColor();
            } else if (e.getSource() == thicknessBtn) {
                Paint.drawArea.setThickness(Integer.parseInt(setThickness.getText()));
            } else if (e.getSource() == bgColorBtn) {
                Paint.drawArea.setBgColor();
            } else if (e.getSource() == line) {
                Paint.drawArea.line();
            } else if (e.getSource() == circle) {
                Paint.drawArea.circle();
            } else if (e.getSource() == rectangle) {
                Paint.drawArea.rectangle();
            } else if (e.getSource() == styleBtn) {
                //String styleInput = JOptionPane.showInputDialog("Enter style (stroke:black;stroke-width:1): ");
                String styleInput = new styleControls().getStyle();
                Paint.drawArea.setStyle(styleInput);
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

        blackBtn = new JButton("Black");
        blackBtn.setBackground(Color.BLACK);
        blackBtn.setForeground(Color.WHITE);
        blackBtn.addActionListener(actionListener);

        grayBtn = new JButton("Gray");
        grayBtn.setBackground(Color.BLUE);
        grayBtn.addActionListener(actionListener);

        greenBtn = new JButton("Green");
        greenBtn.setBackground(Color.GREEN);
        greenBtn.addActionListener(actionListener);


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
        shapesMenu.add(line); shapesMenu.add(circle); shapesMenu.add(rectangle);
        shapesMenuBar.add(shapesMenu);
        line.addActionListener(actionListener);
        circle.addActionListener(actionListener);
        rectangle.addActionListener(actionListener);


        styleBtn = new JButton("Style");
        styleBtn.addActionListener(actionListener);

        //add to panel
        add(shapesMenuBar);
        add(clearBtn);
        add(rubberBtn);
        add(blackBtn);
        add(grayBtn);
        add(greenBtn);
        add(colorBtn);
        add(setThickness);
        add(thicknessBtn);
        add(bgColorBtn);
        add(styleBtn);
    }
}
