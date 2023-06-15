package Paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controls extends JPanel {

    private JButton clearBtn, blackBtn, blueBtn, greenBtn, redBtn, whiteBtn, thicknessBtn, colorBtn, bgColorBtn;
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
            } else if (e.getSource() == blueBtn) {
                Paint.drawArea.blue();
            } else if (e.getSource() == greenBtn) {
                Paint.drawArea.green();
            } else if (e.getSource() == redBtn) {
                Paint.drawArea.red();
            } else if (e.getSource() == whiteBtn) {
                Paint.drawArea.rubber();
            } else if (e.getSource() == colorBtn) {
                Paint.drawArea.otherColor();
            } else if (e.getSource() == thicknessBtn) {
                Paint.drawArea.setThickness(Integer.parseInt(setThickness.getText()));
            } else if (e.getSource() == bgColorBtn) {
                Paint.drawArea.setBgColor();
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

        whiteBtn = new JButton("Rubber");
        whiteBtn.setBackground(Color.WHITE);
        whiteBtn.addActionListener(actionListener);

        blackBtn = new JButton("Black");
        blackBtn.setBackground(Color.BLACK);
        blackBtn.setForeground(Color.WHITE);
        blackBtn.addActionListener(actionListener);

        blueBtn = new JButton("Blue");
        blueBtn.setBackground(Color.BLUE);
        blueBtn.addActionListener(actionListener);

        greenBtn = new JButton("Green");
        greenBtn.setBackground(Color.GREEN);
        greenBtn.addActionListener(actionListener);

        redBtn = new JButton("Red");
        redBtn.setBackground(Color.RED);
        redBtn.addActionListener(actionListener);

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

        line.addActionListener(e -> {
            Paint.drawArea.line();
        });
        circle.addActionListener(e -> {
            Paint.drawArea.circle();
        });
        rectangle.addActionListener(e -> {
            Paint.drawArea.rectangle();
        });

        //add to panel
        add(shapesMenuBar);
        add(clearBtn);
        add(whiteBtn);
        add(blackBtn);
        add(blueBtn);
        add(greenBtn);
        add(redBtn);
        add(colorBtn);
        add(setThickness);
        add(thicknessBtn);
        add(bgColorBtn);
    }
}
