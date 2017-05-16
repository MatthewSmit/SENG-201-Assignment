package seng201.assignment.gui;

import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextPane;

public class PetInfoWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PetInfoWindow window = new PetInfoWindow();
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
	public PetInfoWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 446, 314);
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
		
		JButton okButton = new JButton("OK");
		
		JTextPane infoText = new JTextPane();
		infoText.setEditable(false);
		infoText.setEditable(false);
		infoText.getCaret().deinstall(infoText);
		infoText.setText("BLAH BLAH BLAH");
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
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
		frame.getContentPane().setLayout(groupLayout);
	}
}
