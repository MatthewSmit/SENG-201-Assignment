package seng201.assignment.gui;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import seng201.assignment.PetType;

import javax.swing.JTextPane;

public class PetInfoDialogue extends JDialog {
	private static final long serialVersionUID = -6846642495293896897L;
	
	public PetInfoDialogue(Frame frame, PetType type) {
		super(frame, true);
		
		setBounds(100, 100, 446, 314);
		
		BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(getClass().getResourceAsStream(type.getImageFile()));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}

		JPanel image = new ImageLabel(new ImageIcon(bufferedImage));
		
		final JDialog dialogue = this;
		
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialogue.dispose();
			}
		});
		
		JTextPane infoText = new JTextPane();
		infoText.setEditable(false);
		infoText.setEditable(false);
		infoText.getCaret().deinstall(infoText);
		infoText.setText(type.getName());
		
		GroupLayout groupLayout = new GroupLayout(this.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(groupLayout.createParallelGroup()
						.addComponent(image, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
						.addComponent(infoText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 0, Short.MAX_VALUE)
				.addComponent(okButton)
				.addContainerGap()
		);
		groupLayout.setVerticalGroup(
			groupLayout.createSequentialGroup()
			.addContainerGap()
			.addComponent(image, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
			.addComponent(infoText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(ComponentPlacement.RELATED, 0, Short.MAX_VALUE)
			.addComponent(okButton)
			.addContainerGap()
		);
		this.getContentPane().setLayout(groupLayout);
	}
}