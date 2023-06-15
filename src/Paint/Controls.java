package Paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controls extends JPanel {

    private JButton clearBtn, blackBtn, blueBtn, greenBtn, redBtn, whiteBtn, thicknessBtn, colorBtn;
    private JTextField setThickness;

    ActionListener actionListener = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == clearBtn) {
                SwingPaint.drawArea.clear();
            } else if (e.getSource() == blackBtn) {
                SwingPaint.drawArea.black();
            } else if (e.getSource() == blueBtn) {
                SwingPaint.drawArea.blue();
            } else if (e.getSource() == greenBtn) {
                SwingPaint.drawArea.green();
            } else if (e.getSource() == redBtn) {
                SwingPaint.drawArea.red();
            } else if (e.getSource() == whiteBtn) {
                SwingPaint.drawArea.white();
            } else if (e.getSource() == colorBtn) {
                SwingPaint.drawArea.otherColor();
            } else if (e.getSource() == thicknessBtn) {
                SwingPaint.drawArea.setThickness(Integer.parseInt(setThickness.getText()));
            }
        }
    };

    public Controls() {

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

        //add to panel
        add(clearBtn);
        add(whiteBtn);
        add(blackBtn);
        add(blueBtn);
        add(greenBtn);
        add(redBtn);
        add(colorBtn);
        add(setThickness);
        add(thicknessBtn);
    }
}
