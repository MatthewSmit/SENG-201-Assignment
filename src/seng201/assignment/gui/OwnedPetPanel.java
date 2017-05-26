package seng201.assignment.gui;

import java.awt.Image;
import java.io.IOException;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.*;

@SuppressWarnings("serial")
final class OwnedPetPanel extends JPanel {
    private ImageLabel image;
    private JLabel nameLabel;
    private Pet pet;

    /**
     * Create the panel.
     */
    OwnedPetPanel(final PlayerChoosingWindow frame) {
        super();
        image = new ImageLabel();

        JButton removeButton = new JButton("-");
        removeButton.addActionListener(e -> frame.removePet(pet));

        nameLabel = new JLabel();

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

    public void setPet(final Pet pet) {
        this.pet = pet;

        final Image petImage = Utils.loadImage(pet, 128, 128);
        image.setImage(petImage);

        nameLabel.setText(pet.getName());

        setVisible(true);
    }
}
