package seng201.assignment.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import seng201.assignment.*;

import java.awt.BorderLayout;

@SuppressWarnings("serial")
public class MainGameWindow extends JFrame {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	    Pet[] pets = new Pet[3];
        pets[0] = PetType.Dog.create("TestDog");
        pets[1] = PetType.Cat.create("TestCat");
        pets[2] = PetType.Rabbit.create("TestRabbit");
	    Player[] players = new Player[1];
	    players[0] = new Player("TestPlayer", pets);
        players[0].purchase(Food.CARROT);
        players[0].purchase(Food.BLOODWORM);
        players[0].purchase(Food.BLOODWORM);
        players[0].purchase(Toy.CARDBOARDBOX);
        players[0].purchase(Food.LETTUCE);
	    final Game game = new Game(10, players);
	    
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGameWindow window = new MainGameWindow(game);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainGameWindow(Game game) {
		setResizable(false);
		setBounds(100, 100, 760, 505);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		
		final HelpPanel help = new HelpPanel();

		tabbedPane.addTab("Pet", new MainGamePanel(game));
		tabbedPane.addTab("Store", new StorePanel(this, game));
		tabbedPane.addTab("Help", help);
		tabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                help.onTabChanged();
            }
        });
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
	}

}
