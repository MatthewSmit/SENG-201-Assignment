package seng201.assignment.gui;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.LayoutStyle.ComponentPlacement;

import seng201.assignment.PetType;

@SuppressWarnings("serial")
final class NamePetDialogue extends JDialog {
    private JTextField nameText;

    NamePetDialogue(final PlayerChoosingWindow frame, final PetType type) {
        super(frame, true);

        setBounds(100, 100, 360, 200);

        Image bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(getClass().getResourceAsStream(type.getImageFile()));
            bufferedImage = bufferedImage.getScaledInstance(128, 128, java.awt.Image.SCALE_SMOOTH);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        JPanel image = new ImageLabel(new ImageIcon(bufferedImage));

        JLabel nameLabel = new JLabel("Name");

        nameText = new JTextField();
        nameText.setColumns(10);
        nameText.setDocument(new JTextFieldLimit(10));

        final JDialog dialogue = this;

        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                String name = nameText.getText();

                if (name.length() > 0 && frame.isUniqueName(name)) {
                    frame.addNewPet(type, name);
                    dialogue.dispose();
                } else {
                    JOptionPane.showMessageDialog(frame, "Pet name must be unique.");
                }
            }
        });

        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
                groupLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(image, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addComponent(nameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(nameLabel))
                .addPreferredGap(ComponentPlacement.RELATED, 0, Short.MAX_VALUE)
                .addComponent(okButton)
                .addContainerGap()
                );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(image, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                .addGroup(groupLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(nameLabel)
                        .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(nameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED, 0, Short.MAX_VALUE)
                        .addComponent(okButton)
                        .addContainerGap())
                );
        getContentPane().setLayout(groupLayout);
    }

}
