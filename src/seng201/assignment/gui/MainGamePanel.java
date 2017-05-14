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
		
		JLabel petNameLabel = new JLabel("Harry");
		
		JPanel petImage = new ImageLabel(new ImageIcon(bufferedImage));
		
		JTextPane statsText = new JTextPane();
		statsText.setText("Species: Cat\r\nHunger: 50%\r\nTiredness: 20%\r\nHarry is Sick!");
		statsText.setEditable(false);
		
		JButton toiletButton = new JButton("Toilet");
		
		JButton sleepButton = new JButton("Sleep");
		
		JButton useButton = new JButton("Use");
		
		JLabel pet2NameLabel = new JLabel("Snuffles");
		
		JPanel pet2Image = new ImageLabel(new ImageIcon(bufferedImage));
		
		JLabel pet3NameLabel = new JLabel("Snuffles 2");
		
		JPanel pet3Image = new ImageLabel(new ImageIcon(bufferedImage));
		
		JButton nextButton = new JButton("------->");
		
		JTextPane messageLogText = new JTextPane();
		messageLogText.setText("Harry ate food");
		messageLogText.setEditable(false);
		
		JList inventoryList = new JList();
		inventoryList.setModel(new AbstractListModel() {
			String[] values = new String[] {"Item1", "Item2", "Item3", "Item4", "Item5", "Item6", "Item7", "Item8"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(playerLabel)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(petNameLabel)
										.addComponent(petImage, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
										.addComponent(statsText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(112)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(messageLogText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(pet2NameLabel)
												.addComponent(pet2Image, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addGap(18)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(pet3Image, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(pet3NameLabel))))))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
									.addComponent(nextButton))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(37)
									.addComponent(inventoryList, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(toiletButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(sleepButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(useButton)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(playerLabel)
						.addComponent(nextButton))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(petNameLabel)
								.addComponent(pet2NameLabel)
								.addComponent(pet3NameLabel))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(petImage, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(statsText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(toiletButton)
										.addComponent(sleepButton)
										.addComponent(useButton)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(pet2Image, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
										.addComponent(pet3Image, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(messageLogText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(inventoryList, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(178))
		);
		setLayout(groupLayout);

	}
}
