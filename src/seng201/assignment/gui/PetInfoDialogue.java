package seng201.assignment.gui;

import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import seng201.assignment.GameStrings;
import seng201.assignment.PetType;

import javax.swing.JTextPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;

final class PetInfoDialogue extends JDialog {
    private static final long serialVersionUID = -6846642495293896897L;

    PetInfoDialogue(final Frame frame, final PetType type) {
        super(frame, true);
        setResizable(false);

        setBounds(100, 100, 440, 250);

        Image bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(getClass().getResourceAsStream(type.getImageFile()));
            bufferedImage = bufferedImage.getScaledInstance(128, 128, java.awt.Image.SCALE_SMOOTH);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        JPanel image = new ImageLabel(new ImageIcon(bufferedImage));

        final JDialog dialogue = this;

        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                dialogue.dispose();
            }
        });

        JTextPane infoText = new JTextPane();
        infoText.setFont(new Font("Tahoma", Font.PLAIN, 14));
        infoText.setEditable(false);
        infoText.setText(GameStrings.getSpeciesStats(type));
        infoText.setHighlighter(null);

        JLabel lblSpecies = new JLabel();
        lblSpecies.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblSpecies.setText(GameStrings.getTypeSpecies(type));

        GroupLayout groupLayout = new GroupLayout(this.getContentPane());
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.TRAILING)
                .addGroup(groupLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                .addComponent(lblSpecies)
                                .addGroup(groupLayout.createSequentialGroup()
                                        .addComponent(image, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(ComponentPlacement.RELATED)
                                        .addComponent(infoText, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)))
                        .addContainerGap())
                .addGroup(groupLayout.createSequentialGroup()
                        .addContainerGap(357, Short.MAX_VALUE)
                        .addComponent(okButton)
                        .addContainerGap())
                );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblSpecies)
                        .addPreferredGap(ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                        .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                .addGroup(groupLayout.createSequentialGroup()
                                        .addComponent(infoText, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                        .addGap(12)
                                        .addComponent(okButton))
                                .addComponent(image, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                );
        this.getContentPane().setLayout(groupLayout);
    }
}
