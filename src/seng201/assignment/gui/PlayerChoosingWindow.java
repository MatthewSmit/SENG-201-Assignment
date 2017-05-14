package seng201.assignment.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class PlayerChoosingWindow {

	private JFrame frame;
	private JTextField playerNameText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerChoosingWindow window = new PlayerChoosingWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PlayerChoosingWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 768, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel playerNumberLabel = new JLabel("Player 0");
		
		JLabel playerNameLabel = new JLabel("Player Name:");
		
		playerNameText = new JTextField();
		playerNameText.setColumns(10);
		
		JLabel avaliablePetsLabel = new JLabel("Avaliable Pets");
		
		JLabel yourPetsLabel = new JLabel("Your Pets");
		
		JButton nextButton = new JButton("Next");
		
		JPanel avaliablePets = new AvaliablePetsPanel();
		avaliablePets.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel yourPets = new CurrentPetsPanel();
		yourPets.setBorder(new LineBorder(new Color(0, 0, 0)));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(playerNumberLabel)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(playerNameLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(playerNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(avaliablePetsLabel)
							.addComponent(avaliablePets))
					.addPreferredGap(ComponentPlacement.RELATED, 0, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(yourPetsLabel)
							.addComponent(yourPets, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
						.addComponent(nextButton)
						.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(playerNumberLabel)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
					.addComponent(playerNameLabel)
					.addComponent(playerNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
					.addComponent(yourPetsLabel)
					.addComponent(avaliablePetsLabel))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(avaliablePets)
						.addComponent(yourPets))
				.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(nextButton)
				.addContainerGap()
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
