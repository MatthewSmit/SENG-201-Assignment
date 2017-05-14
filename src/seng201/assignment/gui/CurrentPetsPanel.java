package seng201.assignment.gui;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

public class CurrentPetsPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public CurrentPetsPanel() {

		JPanel pet1 = new OwnedPetPanel();
		JPanel pet2 = new OwnedPetPanel();
		JPanel pet3 = new OwnedPetPanel();
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createSequentialGroup()
			.addContainerGap()
				.addGroup(groupLayout.createParallelGroup()
					.addComponent(pet1)
					.addComponent(pet2)
					.addComponent(pet3))
			.addContainerGap()
		);
		groupLayout.setVerticalGroup(
			groupLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(pet1)
				.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addComponent(pet2)
				.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addComponent(pet3)
				.addContainerGap()
		);
		setLayout(groupLayout);
		

	}
}
