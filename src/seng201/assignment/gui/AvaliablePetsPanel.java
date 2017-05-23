package seng201.assignment.gui;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import seng201.assignment.PetType;

@SuppressWarnings("serial")
public class AvaliablePetsPanel extends JPanel {

    /**
     * Create the panel.
     */
    public AvaliablePetsPanel(PlayerChoosingWindow frame) {

        JPanel pet1 = new AvaliablePetPanel(frame, PetType.Dog);
        pet1.setBounds(10, 11, 128, 170);
        JPanel pet2 = new AvaliablePetPanel(frame, PetType.Cat);
        pet2.setBounds(170, 11, 128, 170);
        JPanel pet3 = new AvaliablePetPanel(frame, PetType.Bird);
        pet3.setBounds(10, 179, 128, 170);
        JPanel pet4 = new AvaliablePetPanel(frame, PetType.Goldfish);
        pet4.setBounds(170, 179, 128, 170);
        JPanel pet5 = new AvaliablePetPanel(frame, PetType.Rabbit);
        pet5.setBounds(10, 349, 128, 165);
        JPanel pet6 = new AvaliablePetPanel(frame, PetType.GuineaPig);
        pet6.setBounds(170, 349, 128, 165);
        setLayout(null);
        add(pet1);
        add(pet3);
        add(pet5);
        add(pet2);
        add(pet4);
        add(pet6);

    }

}
