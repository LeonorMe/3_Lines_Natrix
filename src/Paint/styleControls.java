package Paint;

import javax.swing.*;

public class styleControls extends JDialog {

    private String styleInput;

    public styleControls() {
        styleInput = JOptionPane.showInputDialog("Enter style (stroke:black;stroke-width:1): ");
        Paint.drawArea.setStyle(styleInput);

        Object complexMsg[] = { "Above Message", new ImageIcon("yourFile.gif"), new JButton("Hello"),
                new JSlider(), new ImageIcon("yourFile.gif"), "Below Message" };

        JOptionPane optionPane = new JOptionPane();
        optionPane.setMessage(complexMsg);
        optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        JDialog dialog = optionPane.createDialog(null, "Width 100");
        dialog.setVisible(true);
    }

    public String getStyle() {
        return styleInput;
    }

}
