package seng201.assignment.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Window.Type;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class NamePetWindow {

	private JFrame frame;
	private JTextField nameText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NamePetWindow window = new NamePetWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NamePetWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setType(Type.POPUP);
		frame.setBounds(100, 100, 360, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(new File("data/dog.png"));
		} catch (IOException e) {
			System.out.println(System.getProperty("user.dir"));
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(-1);
		}

		JPanel image = new ImageLabel(new ImageIcon(bufferedImage));
		
		JLabel nameLabel = new JLabel("Name");
		
		nameText = new JTextField();
		nameText.setColumns(10);
		
		JButton okButton = new JButton("OK");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
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
		frame.getContentPane().setLayout(groupLayout);
	}

}
