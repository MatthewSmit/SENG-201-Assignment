package seng201.assignment.gui;

import javax.swing.JPanel;
import javax.swing.AbstractListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.border.CompoundBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JSpinner;

public class StorePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public StorePanel() {
		setLayout(null);
		
		JList storeList = new JList();
		storeList.setFont(new Font("Tahoma", Font.PLAIN, 13));
		storeList.setBorder(new CompoundBorder());
		storeList.setBounds(10, 49, 397, 377);
		storeList.setModel(new AbstractListModel() {
			String[] values = new String[] {"Guinea Pig Wheel", "Item2", "Item3", "Item4", "Item5", "Item6", "Item7", "Item8",
											"Item9", "Item10", "Item11", "Item12", "Item13", "Item14"};/*, "Item7", "Item8",
											"Item1", "Item2", "Item3", "Item4", "Item5","Item1", "Item2", "Item3", "Item4", "Item5",
											"Item1", "Item2", "Item3", "Item4", "Item5","Item1", "Item2", "Item3", "Item4", "Item5",
											"Item1", "Item2", "Item3", "Item4", "Item5","Item1", "Item2", "Item3", "Item4", "Item5"};*/
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		add(storeList);
		
		
		JLabel lblRemaining = new JLabel("$50 remaining");
		lblRemaining.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRemaining.setBounds(500, 15, 125, 23);
		add(lblRemaining);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(454, 167, 217, 259);
		add(scrollPane);
		
		JList inventoryList = new JList();
		scrollPane.setViewportView(inventoryList);
		inventoryList.setModel(new AbstractListModel() {
			String[] values = new String[] {"Guinea Pig Wheel", "Item2", "Item3", "Item4", "Item5", "Item6", "Item7", "Item8",
											"Item9", "Item2", "Item3", "Item4", "Item5", "Item6", "Item7", "Item8",
											"Item1", "Item2", "Item3", "Item4", "Item5","Item1", "Item2", "Item3", "Item4", "Item5",
											"Item1", "Item2", "Item3", "Item4", "Item5","Item1", "Item2", "Item3", "Item4", "Item5",
											"Item1", "Item2", "Item3", "Item4", "Item5","Item1", "Item2", "Item3", "Item4", "Item5"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		
		JButton btnBuy = new JButton("Buy");
		btnBuy.setBounds(454, 66, 74, 23);
		add(btnBuy);
		
		JButton btnSell = new JButton("Sell");
		btnSell.setBounds(454, 119, 74, 23);
		add(btnSell);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(548, 66, 74, 23);
		add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(548, 119, 74, 23);
		add(spinner_1);
		
		JLabel label_1 = new JLabel("$30");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(636, 70, 35, 19);
		add(label_1);
		
		JLabel label_2 = new JLabel("$50");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_2.setBounds(636, 123, 35, 19);
		add(label_2);
		
		JLabel label_3 = new JLabel("Player 0 - Day 0 of 0");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_3.setBounds(10, 15, 200, 23);
		add(label_3);

	}
}
