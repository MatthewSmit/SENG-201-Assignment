package seng201.assignment.gui;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JList;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractListModel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;


//How to - get correct string from enum (food/toy) - e.g. get "small ball" from Toy.SMALLBALL instead of SMALLBALL
//to be used in the console/gui. Have to check which enum is being referred to in toString() to get right name returned

//shifted from group to absolute layout as any time anything got moved other things would be moved as well.
public class MainGamePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public MainGamePanel() {

		BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(new File("data/dog.png"));
		} catch (IOException e) {
			System.out.println(System.getProperty("user.dir"));
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(-1);
		}
		
		JLabel playerLabel = new JLabel("Player 0 - Day 0 of 0");
		playerLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		playerLabel.setBounds(10, 15, 200, 23);
		
		JLabel petNameLabel = new JLabel("Harry");
		petNameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		petNameLabel.setBounds(10, 43, 65, 19);
		
		JPanel petImage = new ImageLabel(new ImageIcon(bufferedImage));
		petImage.setBounds(10, 73, 213, 204);
		
		JTextPane messageLogText = new JTextPane();
		messageLogText.setBounds(268, 164, 217, 259);
		messageLogText.setText("Harry ate food\r\nSnuffles did this\r\nSnuffles 2 did that\r\nHarry is misbehaving\r\n"
				+ "Harry ate food\r\nSnuffles did this\r\nSnuffles 2 did that\r\nHarry is misbehaving\r\n"
				+ "Harry ate food\r\nSnuffles did this\r\nSnuffles 2 did that\r\nHarry is misbehaving\r\n"
				+ "Harry ate food\r\nSnuffles did this\r\nSnuffles 2 did that\r\nHarry is misbehaving\r\n"
				+ "Harry ate food\r\nSnuffles did this");
		messageLogText.setEditable(false);
		
		JScrollPane scrollMessagePane = new JScrollPane(messageLogText);
		scrollMessagePane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollMessagePane.setBounds(256, 180, 229, 267);
		//add(scrollPane);
		
		
		JTextPane statsText = new JTextPane();
		statsText.setBounds(10, 286, 213, 148);
		statsText.setFont(new Font("Tahoma", Font.PLAIN, 11));
		statsText.setText("Species: Dog\r\nWeight: 5.4kg\r\nGender: Male\r\nHunger: 50%\r\n"
				+ "Tiredness: 20%\r\nToilet need: 30%\r\nHealth: 50%\r\nHappiness: 6000000%\r\n"
				+ "Harry is Sick! (dif colour/font)\r\n");
		statsText.setEditable(false);
		
		JButton toiletButton = new JButton("Toilet");
		toiletButton.setBounds(10, 428, 65, 19);
		toiletButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		JButton sleepButton = new JButton("Sleep");
		sleepButton.setBounds(83, 428, 65, 19);
		sleepButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		JButton useButton = new JButton("Use");
		useButton.setBounds(158, 428, 65, 19);
		useButton.setEnabled(false);
		useButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		JLabel pet2NameLabel = new JLabel("Snuffles");
		pet2NameLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		pet2NameLabel.setBounds(256, 48, 48, 14);
		
		JPanel pet2Image = new ImageLabel(new ImageIcon(bufferedImage));
		pet2Image.setBounds(256, 77, 93, 92);
		
		JLabel pet3NameLabel = new JLabel("Snuffles 2");
		pet3NameLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		pet3NameLabel.setBounds(390, 48, 65, 14);
		
		JPanel pet3Image = new ImageLabel(new ImageIcon(bufferedImage));
		pet3Image.setBounds(392, 77, 93, 92);
		
		JButton nextButton = new JButton("------->");
		nextButton.setBounds(583, 26, 93, 23);
		
		JList inventoryList = new JList();
		inventoryList.setBounds(495, 61, 128, 362);
		inventoryList.setModel(new AbstractListModel() {
			String[] values = new String[] {"Guinea Pig Wheel", "Item2", "Item3", "Item4", "Item5", "Item6", "Item7", "Item8",
											"Item", "Item2", "Item3", "Item4", "Item5", "Item6", "Item7", "Item8",
											"Item1", "Item2", "Item3", "Item4", "Item5","Item1", "Item2", "Item3", "Item4", "Item5",
											"Item1", "Item2", "Item3", "Item4", "Item5","Item1", "Item2", "Item3", "Item4", "Item5",
											"Item1", "Item2", "Item3", "Item4", "Item5","Item1", "Item2", "Item3", "Item4", "Item5"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		JScrollPane scrollInventoryPane = new JScrollPane(inventoryList);
		scrollInventoryPane.setBounds(516, 61, 160, 386);
		
		
		setLayout(null);
		add(petNameLabel);
		add(petImage);
		add(toiletButton);
		add(sleepButton);
		add(useButton);
		add(statsText);
		add(pet2Image);
		add(pet2NameLabel);
		add(pet3NameLabel);
		add(pet3Image);
		add(playerLabel);
		//add(inventoryList);
		add(nextButton);
		add(scrollMessagePane);
		add(scrollInventoryPane);
		

	}
}
