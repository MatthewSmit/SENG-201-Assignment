package seng201.assignment.gui;

import javax.swing.JPanel;

import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

import seng201.assignment.Pet;

@SuppressWarnings("serial")
final class CurrentPetsPanel extends JPanel {
    private OwnedPetPanel pet1;
    private OwnedPetPanel pet2;
    private OwnedPetPanel pet3;

    /**
     * Create the panel.
     */
    CurrentPetsPanel(final PlayerChoosingWindow frame) {
        pet1 = new OwnedPetPanel(frame);
        pet2 = new OwnedPetPanel(frame);
        pet3 = new OwnedPetPanel(frame);

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

        pet1.setVisible(false);
        pet2.setVisible(false);
        pet3.setVisible(false);
    }

    public void setPets(final ArrayList<Pet> pets) {
        assert pets.size() <= 3;

        if (pets.size() > 0) {
            pet1.setPet(pets.get(0));
        } else {
            pet1.setVisible(false);
        }

        if (pets.size() > 1) {
            pet2.setPet(pets.get(1));
        } else {
            pet2.setVisible(false);
        }

        if (pets.size() > 2) {
            pet3.setPet(pets.get(2));
        } else {
            pet3.setVisible(false);
        }
    }
}
