import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;

class Canvas extends JPanel {
    int x = 0, y = 0;

    ArrayList<Point> points = new ArrayList<>();

    public Canvas() {
        addMouseListener(new MouseAdapter() { // parte dos eventos
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                x = e.getX();
                y = e.getY();
                Point point = new Point(x, y);
                points.add(point);
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                super.mouseWheelMoved(e);
                points.clear();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) { // parte da pintura
        super.paintComponent(g);
        // ter cuidado para quando uma janela passa à frente da nossa não apagar a nossa janela

        for(int i=0; i<points.size()-1; i++){ // Bom para svg
            Point p1 = points.get(i);
            Point p2 = points.get(i+1);
            g.drawLine(p1.x,p1.y,p2.x,p2.y);
        }

    }
    public class Paint {
        public static void main(String[] args) {
            JFrame frame = new JFrame("Matrix Paint");
            frame.setSize(800,600);

            JPanel painel = new JPanel();
            painel.setSize(400,500);

            frame.setContentPane(new Canvas());

            frame.setVisible(true);
        }
    }
}
