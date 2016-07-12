import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

public class Exit extends JFrame implements ActionListener {

	private JButton yes, no;
	private Exit areYouSure;

	public void exit() {
		areYouSure = new Exit();
		areYouSure.setDefaultCloseOperation(EXIT_ON_CLOSE);
		areYouSure.setSize(250, 200);
		areYouSure.setLayout(null);
		areYouSure.setVisible(true);

	}

	public Exit() {
		// Press this to close the application
		yes = new JButton("I`m sure!");
		yes.setBounds(10, 80, 100, 40);
		yes.addActionListener(this);
		yes.setBackground(Color.WHITE);
		yes.setContentAreaFilled(false);
		yes.setOpaque(true);
		yes.setBorder(new LineBorder(Color.RED));
		add(yes);

		// Press this if you don`t want to close the application
		no = new JButton("Just a mistake");
		no.setBounds(120, 80, 100, 40);
		no.addActionListener(this);
		no.setBackground(Color.WHITE);
		no.setContentAreaFilled(false);
		no.setOpaque(true);
		no.setBorder(new LineBorder(Color.GREEN));
		add(no);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == yes) {
			yes.setBackground(Color.RED);
			yes.setForeground(Color.WHITE);
			// without timer System.exit(0) would be called instantly and Colors
			// would not change
			Timer t = new Timer(1000, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
			t.setRepeats(false);
			t.start();
		} else if (e.getSource() == no) {

			this.dispose();

		}
	}
}
