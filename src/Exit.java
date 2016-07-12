import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

/**
 * Class used to exit program
 * 
 * @author Yoseppe
 *
 */
@SuppressWarnings("serial")
public class Exit extends JFrame implements ActionListener {

	private JButton yes, no;
	private JLabel areYouSureYouWantToExit;

	public Exit() {

		setContentPane(new ImagePanel("src/exit.gif"));

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 200);
		setVisible(true);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);

		// Asking if he really wants to exit
		areYouSureYouWantToExit = new JLabel("Are you sure you want to exit");
		areYouSureYouWantToExit.setVisible(true);
		areYouSureYouWantToExit.setText("Are you sure you want to exit?");
		areYouSureYouWantToExit.setBounds(0, 10, 400, 20);
		areYouSureYouWantToExit.setHorizontalAlignment(JLabel.CENTER);
		add(areYouSureYouWantToExit);

		// Press this to close the application
		yes = new JButton("I`m sure!");
		yes.setBounds(25, 60, 150, 40);
		yes.addActionListener(this);
		yes.setBackground(Color.WHITE);
		yes.setOpaque(true);
		yes.setBorder(new LineBorder(Color.RED));
		add(yes);

		// Press this if you don`t want to close the application
		no = new JButton("Just a mistake");
		no.setBounds(225, 60, 150, 40);
		no.addActionListener(this);
		no.setBackground(Color.WHITE);
		no.setOpaque(true);
		no.setBorder(new LineBorder(Color.BLUE));
		add(no);
		
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == yes) {
			yes.setBackground(Color.RED);
			yes.setForeground(Color.WHITE);
			// without timer System.exit(0) would be called instantly and Colors
			// would not change
			Timer t = new Timer(500, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
			t.setRepeats(false);
			t.start();

		} else if (e.getSource() == no) {
			no.setBackground(Color.BLUE);
			no.setForeground(Color.WHITE);
			Timer t = new Timer(500, new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {

					dispose();
				}
			});
			t.setRepeats(false);
			t.start();
		}
	}
}
