package seng201.assignment.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JLabel;

public class StartFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartFrame frame = new StartFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StartFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//contentPane.setLayout(new MigLayout("", "[][]", "[][][][]"));
		
		JLabel lblNumberOfPlayers = new JLabel("Number of Players");
		contentPane.add(lblNumberOfPlayers, "cell 0 0");
		
		JLabel lblDaysOfPlay = new JLabel("Days of Play");
		contentPane.add(lblDaysOfPlay, "cell 1 0");
		
		JRadioButton rdbtnPlayer = new JRadioButton("1 Player");
		contentPane.add(rdbtnPlayer, "cell 0 1");
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setValue(1);
		scrollBar.setMinimum(1);
		scrollBar.setOrientation(JScrollBar.HORIZONTAL);
		contentPane.add(scrollBar, "cell 1 1");
		
		JRadioButton rdbtnPlayer_1 = new JRadioButton("2 Player");
		contentPane.add(rdbtnPlayer_1, "cell 0 2");
		
		JRadioButton rdbtnPlayer_2 = new JRadioButton("3 Player");
		contentPane.add(rdbtnPlayer_2, "cell 0 3");
	}

}
