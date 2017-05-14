package seng201.assignment.gui;

import javax.swing.JPanel;

import org.omg.CORBA.Environment;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class AvaliablePetPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public AvaliablePetPanel() {
		
		BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(new File("data/dog.png"));
		} catch (IOException e) {
			System.out.println(System.getProperty("user.dir"));
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(-1);
		}
		
		JButton addPetButton = new JButton("+");
		
		JButton viewPetButton = new JButton("?");
		
		JPanel image = new ImageLabel(new ImageIcon(bufferedImage));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(image, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(addPetButton)
						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
						.addComponent(viewPetButton)
						.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createSequentialGroup()
				.addComponent(image, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
					.addComponent(addPetButton)
					.addComponent(viewPetButton))
		);
		setLayout(groupLayout);

	}

}
