package seng201.assignment.gui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class OwnedPetPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public OwnedPetPanel() {
		BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(new File("data/dog.png"));
		} catch (IOException e) {
			System.out.println(System.getProperty("user.dir"));
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(-1);
		}

		JPanel image = new ImageLabel(new ImageIcon(bufferedImage));
		
		JButton removeButton = new JButton("-");
		
		JLabel nameLabel = new JLabel("SNUFFLES");
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createSequentialGroup()
			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
					.addComponent(image, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
					.addComponent(removeButton))
			.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
			.addComponent(nameLabel)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(nameLabel)
						.addComponent(image, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addComponent(removeButton)
		);
		setLayout(groupLayout);

	}

}
