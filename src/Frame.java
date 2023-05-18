import painels.*;
import javax.swing.*;

public class Frame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("3 Lines Natrix");
        frame.setSize(1920, 1018);

        switch (painel){
            case 0:
                frame.add(new Start()); // Open page
            case 1:
                frame.add(new Create()); // Strat new project or open other
            case 2:
                frame.add(new Edit()); // actual SVG work
            case 3:
                frame.add(new Save()); // Save new work in SVG
            case 4:
                frame.add(new Load()); // Load SVG to check
            case 5:
                frame.add(new Exit()); // Exit
            case 6:
                frame.add(new Menu()); // Menu
            default:
                frame.add(new Start());
        }
*/
        frame.setVisible(true);
    }
}