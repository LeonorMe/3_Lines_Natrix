package painels;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.metal.MetalLookAndFeel;
import java.awt.*;

public class CustomLookAndFeel extends MetalLookAndFeel {
    public final static Color darkGreen = Color.decode("#3B5323");
    public final static Color green = Color.decode("#4B692F");
    final static Color lightGreen = Color.decode("#7B9F47");
    final static Color orange = Color.decode("#FFA500");

    @Override
    protected void initComponentDefaults(UIDefaults table) {
        super.initComponentDefaults(table);

        Font newFont = new Font("Source Code Pro", Font.PLAIN, 12);


        //UIManager.put("Button.foreground", Color.WHITE);
        UIManager.put("Label.font", newFont);
        UIManager.put("TextField.font", newFont);

        Border roundedBorder = new Border() {
            int radius = 15;

            @Override
            public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
                g.setColor(Color.BLACK);
                g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
            }

            @Override
            public Insets getBorderInsets(Component c) {
                return new Insets(radius, radius, radius, radius);
            }

            @Override
            public boolean isBorderOpaque() {
                return true;
            }
        };
        UIManager.put("Button.border", roundedBorder);
        UIManager.put("Button.font", newFont);
        UIManager.put("Button.background", Color.WHITE);

    }
}
