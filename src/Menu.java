import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

/**
 * The main menu of the application
 * @author Yoseppe
 *
 */
@SuppressWarnings("serial")
public class Menu extends JFrame implements ActionListener {

	// Buttons will be used in the constructor
	private JButton searchRecipe, dailyRecipe, favourites, usedRecipes, addOwnRecipe, exit;

	public static void main(String[] args) {
		// Main Menu created here
		Menu mainMenu = new Menu("Main menu");
		mainMenu.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mainMenu.setSize(400, 560);
		mainMenu.setLayout(null);
		mainMenu.setVisible(true);
	}

	public Menu(String title) {

		super(title);

		setContentPane(new ImagePanel("src/background.jpg"));

		// Press this button to search for a recipe
		// not implemented
		searchRecipe = new JButton("Search for a fitting recipe!");
		searchRecipe.setBounds(60, 40, 280, 40);
		searchRecipe.addActionListener(this);
		searchRecipe.setBackground(Color.WHITE);
		searchRecipe.setContentAreaFilled(false);
		searchRecipe.setOpaque(true);
		searchRecipe.setBorder(new LineBorder(Color.BLUE));
		add(searchRecipe);

		// Press this button to see which recipe we recommend today
		// not implemented
		dailyRecipe = new JButton("You should try this today!");
		dailyRecipe.setBounds(60, 120, 280, 40);
		dailyRecipe.addActionListener(this);
		dailyRecipe.setBackground(Color.WHITE);
		dailyRecipe.setContentAreaFilled(false);
		dailyRecipe.setOpaque(true);
		dailyRecipe.setBorder(new LineBorder(Color.GREEN));
		add(dailyRecipe);

		// Press this button to see which recipes you marked as your favorites
		// not implemented
		favourites = new JButton("Your favourite recipes!");
		favourites.setBounds(60, 200, 280, 40);
		favourites.addActionListener(this);
		favourites.setBackground(Color.WHITE);
		favourites.setContentAreaFilled(false);
		favourites.setOpaque(true);
		favourites.setBorder(new LineBorder(Color.GREEN));
		add(favourites);

		// Press this button to see the five recipes u used
		// not implemented
		usedRecipes = new JButton("The recipes you already know!");
		usedRecipes.setBounds(60, 280, 280, 40);
		usedRecipes.addActionListener(this);
		usedRecipes.setBackground(Color.WHITE);
		usedRecipes.setContentAreaFilled(false);
		usedRecipes.setOpaque(true);
		usedRecipes.setBorder(new LineBorder(Color.GREEN));
		add(usedRecipes);

		// Press this button to add a new recipe to the database
		// not implemented
		addOwnRecipe = new JButton("Tell us what you cooked yesterday");
		addOwnRecipe.setBounds(60, 360, 280, 40);
		addOwnRecipe.addActionListener(this);
		addOwnRecipe.setBackground(Color.WHITE);
		addOwnRecipe.setContentAreaFilled(false);
		addOwnRecipe.setOpaque(true);
		addOwnRecipe.setBorder(new LineBorder(Color.GREEN));
		add(addOwnRecipe);

		// Press this button to close this application
		// not implemented
		exit = new JButton("Exit :-(");
		exit.setBounds(60, 440, 280, 40);
		exit.addActionListener(this);
		exit.setBackground(Color.WHITE);
		exit.setContentAreaFilled(false);
		exit.setOpaque(true);
		exit.setBorder(new LineBorder(Color.RED));
		add(exit);

	}

	public void actionPerformed(ActionEvent e) {

		// change looks of the buttons
		Color backgroundColor = Color.GREEN;
		Color foregroundColor = Color.WHITE;
		// exit and search recipe have different colors
		if (e.getSource() == exit) {
			backgroundColor = Color.RED;
		} else if (e.getSource() == searchRecipe) {
			backgroundColor = Color.BLUE;
		} else if (e.getSource() != searchRecipe && e.getSource() != exit) {
			foregroundColor = Color.BLACK;
		}
		// all Buttons except exit and searchRecipe become green, and every
		// button loses its text
		JButton button = (JButton) e.getSource();
		if (button != null) {
			button.setBackground(backgroundColor);
			button.setForeground(foregroundColor);
			getContentPane().repaint();
		}

		if (e.getSource() == exit) {
			// without timer System.exit(0) would be called instantly and Color
			// and text would not change
			Timer t = new Timer(1000, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
			t.setRepeats(false);
			t.start();
		}
	}

}
