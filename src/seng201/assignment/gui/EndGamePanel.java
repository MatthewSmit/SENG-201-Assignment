package seng201.assignment.gui;

import javax.swing.*;

import seng201.assignment.Pet;
import seng201.assignment.Player;

import javax.swing.JPanel;

import seng201.assignment.Pet;
import seng201.assignment.Player;

import javax.swing.JLabel;

@SuppressWarnings("serial")
final class EndGamePanel extends JPanel {
    EndGamePanel(final Player player) {
        setLayout(null);

        JLabel nameLabel = new JLabel(player.getName());
        nameLabel.setBounds(12, 12, 111, 15);
        add(nameLabel);

        JLabel scoreLabel = new JLabel(String.format("Score: %d", player.getScore()));
        scoreLabel.setBounds(12, 39, 111, 15);
        add(scoreLabel);

        Pet currentPet = player.getPets()[0];
        
        JPanel pet1Image = new ImageLabel(Utils.loadImage(currentPet, 112, 112));
        pet1Image.setBounds(118, 12, 112, 112);
        add(pet1Image);

        JLabel pet1Label = new JLabel(currentPet.getName(), SwingConstants.CENTER);
        pet1Label.setBounds(118, 136, 111, 15);
        add(pet1Label);

        if (player.getPets().length > 1) {
            currentPet = player.getPets()[1];

            JPanel pet2Image = new ImageLabel(Utils.loadImage(currentPet, 112, 112));
            pet2Image.setBounds(241, 12, 112, 112);
            add(pet2Image);

            JLabel pet2Label = new JLabel(currentPet.getName(), SwingConstants.CENTER);
            pet2Label.setBounds(241, 136, 111, 15);
            add(pet2Label);
        }

        if (player.getPets().length > 2) {
            currentPet = player.getPets()[2];

            JPanel pet3Image = new ImageLabel(Utils.loadImage(currentPet, 112, 112));
            pet3Image.setBounds(364, 12, 112, 112);
            add(pet3Image);

            JLabel pet3Label = new JLabel(currentPet.getName(), SwingConstants.CENTER);
            pet3Label.setBounds(364, 136, 111, 15);
            add(pet3Label);
        }
    }
}
