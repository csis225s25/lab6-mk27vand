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

        // the Graphics object passed to this method has many methods
        // we can use to draw in the area of the panel, one of which
        // allows us to draw a String at a given x,y position
        g.setFont(new Font("Algerian", Font.BOLD, 50));
        setForeground(Color.RED);
        setBackground(Color.GREEN);
        FontMetrics fm = g.getFontMetrics();
        int width = fm.stringWidth("Hello, Java Graphics World!");
        int height = fm.getAscent();
        g.drawString("Hello, Java Graphics World!", super.getWidth()/2-width/2, super.getHeight()/2-height/2);
    }
}

public class HelloGraphics implements Runnable  {

    /**
     * The run method to set up the graphical user interface
     */
    @Override
    public void run() {

        // the usual JFrame setup steps
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("HelloGraphics");
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
        javax.swing.SwingUtilities.invokeLater(new HelloGraphics());
    }
}
