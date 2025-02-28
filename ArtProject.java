import java.awt.*;
import java.awt.Font;
import java.awt.Color;
import javax.swing.*;

/**
 * Lab 6 starter example
 * 
 * @author Max Vanderbeek
 * @version Spring 2025
 */

// a class that extends JPanel to override the paintComponent method,
// allowing us to interact with Java's graphics system
class GraphicsPanel extends JPanel {

    @Override
    public void paintComponent(Graphics g) {

        // first, we should call the paintComponent method we are
        // overriding in JPanel
        super.paintComponent(g);

        // head
        g.setColor(Color.YELLOW);
        g.fillOval(super.getWidth() / 2 - 100, super.getHeight() / 2 - 100, 200, 200);
        // left eye
        g.setColor(Color.BLACK);
        g.drawOval(super.getWidth() / 2 - 70, super.getHeight() / 2 - 50, 50, 50);
        g.setColor(Color.BLUE);
        g.fillOval(super.getWidth() / 2 - 55, super.getHeight() / 2 - 35, 20, 20);
        // right eye
        g.setColor(Color.BLACK);
        g.drawOval(super.getWidth() / 2 + 20, super.getHeight() / 2 - 50, 50, 50);
        g.setColor(Color.BLUE);
        g.fillOval(super.getWidth() / 2 + 35, super.getHeight() / 2 - 35, 20, 20);

        // smile
        g.setColor(Color.RED);
        g.drawArc(super.getWidth() / 2 - 60, super.getHeight() / 2 + 10, 100, 50, -150, 70);
        // hair
        g.setColor(Color.BLACK);
        g.drawLine(super.getWidth() / 2, super.getHeight() / 2 - 100, super.getWidth() / 2 + 40, super.getHeight() / 2 - 150);
    }
}

public class ArtProject implements Runnable  {

    /**
     * The run method to set up the graphical user interface
     */
    @Override
    public void run() {

        // the usual JFrame setup steps
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("ArtProject");
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // construct JPanel with a custom paintComponent method
        JPanel panel = new GraphicsPanel();
        frame.add(panel);
        // display the window we've created
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        javax.swing.SwingUtilities.invokeLater(new ArtProject());
    }
}

