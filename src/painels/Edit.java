package painels;

import shapes.Line;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static painels.CustomLookAndFeel.lightGreen;
import static painels.Menu.editRemove;
//import static sun.security.util.ObjectIdentifier.pack;

public class Edit extends JPanel {
    private JTextField answerField_Id, answerField_X1, answerField_y1, answerField_x2, answerField_y2, answerField_stroke, answerField_fill;
    private JButton saveButton;
    private JLabel questionLabel_Id, questionLabel_X1, questionLabel_y1, questionLabel_x2, questionLabel_y2, questionLabel_stroke, questionLabel_fill;
    public Edit() {
        setBackground(lightGreen);
        //JLabel label1 = new JLabel("Edit");
        //add(label1);

        // TODO get object cliced
        Line line = new Line("001", 0, 0, 50, 50, "black", "5", "none");

        setLayout(new GridLayout(9, 2));

        // Create the components
        questionLabel_Id = new JLabel("Id:");
        answerField_Id = new JTextField(6);
        questionLabel_X1 = new JLabel("X1:");
        answerField_X1 = new JTextField(4);
        questionLabel_y1 = new JLabel("y1:");
        answerField_y1 = new JTextField(4);
        questionLabel_x2 = new JLabel("x2:");
        answerField_x2 = new JTextField(4);
        questionLabel_y2 = new JLabel("y2:");
        answerField_y2 = new JTextField(4);
        questionLabel_stroke = new JLabel("stroke:");
        answerField_stroke = new JTextField(4);
        questionLabel_fill = new JLabel("fill:");
        answerField_fill = new JTextField(6);

        saveButton = new JButton("Save");

        // Add the components to the panel
        add(questionLabel_Id);
        add(answerField_Id);
        add(questionLabel_X1);
        add(answerField_X1);
        add(questionLabel_y1);
        add(answerField_y1);
        add(questionLabel_x2);
        add(answerField_x2);
        add(questionLabel_y2);
        add(answerField_y2);
        add(questionLabel_stroke);
        add(answerField_stroke);
        add(questionLabel_fill);
        add(answerField_fill);

        add(new JLabel());
        add(saveButton);

        // Add action listener to the submit button
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String answer_Id = answerField_Id.getText();
                int answer_X1 = Integer.parseInt(answerField_X1.getText());
                int answer_y1 = Integer.parseInt(answerField_y1.getText());
                int answer_x2 = Integer.parseInt(answerField_x2.getText());
                int answer_y2 = Integer.parseInt(answerField_y2.getText());
                String answer_stroke = answerField_stroke.getText();
                String answer_fill = answerField_fill.getText();

                // Do something with the answers
                line.setId(answer_Id);
                line.setX(answer_X1);
                line.setY(answer_y1);
                line.setX2(answer_x2);
                line.setY2(answer_y2);
                line.setStroke(answer_stroke);
                line.setFill(answer_fill);
            }
        });

        //pack();
        setVisible(true);
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        if(editRemove)
            frame.remove(this);
    }
}
