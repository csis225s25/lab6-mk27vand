import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * Lab 5 demo of mouse events.
 * 
 * @author Jim Teresco
 * @author Ira Goldstein
 * @version Spring 2025
 */
public class MousePressCounter extends MouseAdapter implements Runnable, ActionListener {
    int count = 0;
    JLabel counter;
    JButton reset;
    @Override
	public void run() {

		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("MouseDemo");
		frame.setPreferredSize(new Dimension(500, 500));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// construct an anonymous class that extends JPanel,
		// for which we override the paintComponent method
		JPanel panel = new JPanel(new GridBagLayout());
		frame.add(panel);
        counter = new JLabel("Mouse Press Count: " + count);
        panel.add(counter);
        reset = new JButton("Reset Counter");
        reset.addActionListener(this);
        panel.add(reset);

		panel.addMouseListener(this);

		// display the window we've created
		frame.pack();
		frame.setVisible(true);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
        count++;
		counter.setText("Mouse Press Count: " + count);
	}
    public void actionPerformed(ActionEvent e) {
        count = 0;
        counter.setText("Mouse Press Count: " + count);
    }

    public static void main(String args[]) {
		javax.swing.SwingUtilities.invokeLater(new MousePressCounter());
	}
}