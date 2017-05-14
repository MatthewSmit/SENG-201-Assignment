package seng201.assignment.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

import java.awt.Window.Type;

public class GameStartWindow {
	private class IntegerFilter extends DocumentFilter {
		private static final String REMOVE_REGEX = "\\D"; 
		
		@Override
		public void insertString(FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
			text = text.replaceAll(REMOVE_REGEX, "");
			super.insertString(fb, offset, text, attr);
		}

		@Override
		public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
			text = text.replaceAll(REMOVE_REGEX, "");
			super.replace(fb, offset, length, text, attrs);
		}
	}

	private JFrame frmStartGame;
	private JTextField numberDaysText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameStartWindow window = new GameStartWindow();
					window.frmStartGame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GameStartWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStartGame = new JFrame();
		frmStartGame.setType(Type.POPUP);
		frmStartGame.setResizable(false);
		frmStartGame.setTitle("Game Setup");
		frmStartGame.setBounds(100, 100, 320, 240);
		frmStartGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel numberPlayersLabel = new JLabel("Number of Players");
		
		JRadioButton players1Radio = new JRadioButton("1 Player");
		players1Radio.setSelected(true);
		
		JRadioButton players2Radio = new JRadioButton("2 Players");
		
		JRadioButton players3Radio = new JRadioButton("3 Players");
		
		ButtonGroup playerGroup = new ButtonGroup();
		playerGroup.add(players1Radio);
		playerGroup.add(players2Radio);
		playerGroup.add(players3Radio);
		
		JLabel numberDaysLabel = new JLabel("Number of Days");
		
		numberDaysText = new JTextField();
		numberDaysText.setColumns(1);
		((PlainDocument)numberDaysText.getDocument()).setDocumentFilter(new IntegerFilter());
		
		JButton nextButton = new JButton("Next");
		GroupLayout groupLayout = new GroupLayout(frmStartGame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.CENTER)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(players1Radio)
						.addGroup(groupLayout.createParallelGroup(Alignment.CENTER)
							.addComponent(numberPlayersLabel)
							.addComponent(players2Radio)
							.addComponent(numberDaysLabel)
							.addComponent(numberDaysText, 80, 80, 80))
						.addComponent(players3Radio))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(0, Short.MAX_VALUE)
					.addComponent(nextButton)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(numberPlayersLabel)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 0, 16)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(players1Radio)
						.addComponent(players2Radio)
						.addComponent(players3Radio))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 0, 16)
					.addComponent(numberDaysLabel)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 0, 16)
					.addComponent(numberDaysText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 0, Short.MAX_VALUE)
					.addComponent(nextButton)
					.addContainerGap()
		);
		frmStartGame.getContentPane().setLayout(groupLayout);
	}
}
