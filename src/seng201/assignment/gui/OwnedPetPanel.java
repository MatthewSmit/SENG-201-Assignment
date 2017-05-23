package seng201.assignment.gui;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import seng201.assignment.Pet;

@SuppressWarnings("serial")
final class OwnedPetPanel extends JPanel {
    private ImageLabel image;
    private JLabel nameLabel;
    private Pet pet;

    /**
     * Create the panel.
     */
    OwnedPetPanel(final PlayerChoosingWindow frame) {
        image = new ImageLabel();

        JButton removeButton = new JButton("-");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                frame.removePet(pet);
            }
        });

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

        Image bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(getClass().getResourceAsStream(pet.getType().getImageFile()));
            bufferedImage = bufferedImage.getScaledInstance(128, 128, java.awt.Image.SCALE_SMOOTH);
        } catch (IOException e) {
            System.out.println(System.getProperty("user.dir"));
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.exit(-1);
        }

        image.setImage(new ImageIcon(bufferedImage));

        nameLabel.setText(pet.getName());

        setVisible(true);
    }
}
