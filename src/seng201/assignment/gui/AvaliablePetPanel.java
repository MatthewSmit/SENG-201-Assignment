package seng201.assignment.gui;

import javax.swing.JPanel;

import seng201.assignment.PetType;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class AvaliablePetPanel extends JPanel {
	/**
	 * Create the panel.
	 */
	public AvaliablePetPanel(final PlayerChoosingWindow frame, final PetType type) {
		BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(getClass().getResourceAsStream(type.getImageFile()));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
		JButton addPetButton = new JButton("+");
		addPetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			    if (frame.getCurrentPets().size() == 3) {
                    JOptionPane.showMessageDialog(frame, "Can only create up to 3 pets.");
			    }
			    else {
	                NamePetDialogue dialogue = new NamePetDialogue(frame, type);
	                dialogue.pack();
	                dialogue.setLocationRelativeTo(frame);
	                dialogue.setVisible(true);
			    }
			}
		});
		
		JButton viewPetButton = new JButton("?");
		viewPetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PetInfoDialogue dialogue = new PetInfoDialogue(frame, type);
				dialogue.pack();
				dialogue.setLocationRelativeTo(frame);
				dialogue.setVisible(true);
			}
		});
		
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
