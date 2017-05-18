package seng201.assignment.gui;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import seng201.assignment.PetType;

import java.awt.Color;
import java.awt.Frame;

public class AvaliablePetsPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public AvaliablePetsPanel(PlayerChoosingWindow frame) {
		
		JPanel pet1 = new AvaliablePetPanel(frame, PetType.Dog);
		JPanel pet2 = new AvaliablePetPanel(frame, PetType.Cat);
		JPanel pet3 = new AvaliablePetPanel(frame, PetType.Bird);
		JPanel pet4 = new AvaliablePetPanel(frame, PetType.Goldfish);
		JPanel pet5 = new AvaliablePetPanel(frame, PetType.Rabbit);
		JPanel pet6 = new AvaliablePetPanel(frame, PetType.GuineaPig);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
				groupLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(pet1, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
						.addComponent(pet3, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
						.addComponent(pet5, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(pet2, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
						.addComponent(pet4, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
						.addComponent(pet6, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
				.addContainerGap()
			);
		groupLayout.setVerticalGroup(
			groupLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(pet1)
						.addComponent(pet2))
				.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(pet3)
						.addComponent(pet4))
				.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(pet5)
						.addComponent(pet6))
				.addContainerGap()
		);
		setLayout(groupLayout);

	}

}
