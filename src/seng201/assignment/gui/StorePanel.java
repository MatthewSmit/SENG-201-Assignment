package seng201.assignment.gui;

import javax.swing.JPanel;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Color;
import java.awt.Font;
import javax.swing.border.CompoundBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import seng201.assignment.Food;
import seng201.assignment.Game;
import seng201.assignment.Item;
import seng201.assignment.Player;
import seng201.assignment.Toy;
import seng201.assignment.ToyType;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

@SuppressWarnings("serial")
public class StorePanel extends JPanel {
    private Game game;
    
    private JLabel remainingLabel;
    private JLabel buyAmountLabel;
    private JLabel sellAmountLabel;
    private JLabel playerLabel;
    private JList<ShopListView<Item>> storeList;

    private JSpinner buySpinner;

    private JSpinner sellSpinner;
    
	/**
	 * Create the panel.
	 */
	public StorePanel(Game game) {
	    this.game = game;
	    
		setLayout(null);
		
		DefaultListModel<ShopListView<Item>> list = new DefaultListModel<>();
		for (Food food : Food.values()) {
		    list.addElement(new ShopListView<Item>(food, String.format("$%d", food.getPrice())));
		}
		
		for (ToyType toy : ToyType.values()) {
            list.addElement(new ShopListView<Item>(new Toy(toy), String.format("$%d", toy.getPrice())));
		}
		
		storeList = new JList<>();
		storeList.setFont(new Font("Tahoma", Font.PLAIN, 13));
		storeList.setBorder(new CompoundBorder());
		storeList.setBounds(10, 49, 397, 377);
		storeList.setModel(list);
		storeList.setCellRenderer(new ShopListViewRenderer<Item>());
		storeList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                redraw();
            }
        });
		add(storeList);
		
		remainingLabel = new JLabel();
		remainingLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		remainingLabel.setBounds(500, 15, 200, 23);
		add(remainingLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(454, 167, 217, 259);
		add(scrollPane);
		
		JList<String> inventoryList = new JList<>();
		scrollPane.setViewportView(inventoryList);
		inventoryList.setModel(new AbstractListModel<String>() {
			String[] values = new String[] {"Guinea Pig Wheel", "Item2", "Item3", "Item4", "Item5", "Item6", "Item7", "Item8",
											"Item9", "Item2", "Item3", "Item4", "Item5", "Item6", "Item7", "Item8",
											"Item1", "Item2", "Item3", "Item4", "Item5","Item1", "Item2", "Item3", "Item4", "Item5",
											"Item1", "Item2", "Item3", "Item4", "Item5","Item1", "Item2", "Item3", "Item4", "Item5",
											"Item1", "Item2", "Item3", "Item4", "Item5","Item1", "Item2", "Item3", "Item4", "Item5"};
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});
		
		
		JButton buyButton = new JButton("Buy");
		buyButton.setBounds(454, 66, 74, 23);
		add(buyButton);
		
		JButton sellButton = new JButton("Sell");
		sellButton.setBounds(454, 119, 74, 23);
		add(sellButton);
		
		buySpinner = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
		buySpinner.setBounds(548, 66, 74, 23);
		buySpinner.addChangeListener(new ChangeListener() { 
            @Override
            public void stateChanged(ChangeEvent e) {
                redraw();
            }
        });
		add(buySpinner);
		
		sellSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
		sellSpinner.setBounds(548, 119, 74, 23);
		sellSpinner.addChangeListener(new ChangeListener() { 
            @Override
            public void stateChanged(ChangeEvent e) {
                redraw();
            }
        });
		add(sellSpinner);
		
		buyAmountLabel = new JLabel("$30");
		buyAmountLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buyAmountLabel.setBounds(636, 70, 50, 19);
		add(buyAmountLabel);
		
		sellAmountLabel = new JLabel("$50");
		sellAmountLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		sellAmountLabel.setBounds(636, 123, 50, 19);
		add(sellAmountLabel);
		
		playerLabel = new JLabel();
		playerLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		playerLabel.setBounds(10, 15, 200, 23);
		add(playerLabel);

		redraw();
	}
	
	private void redraw() {
	    Player player = game.getCurrentPlayer();
	    
	    playerLabel.setText(String.format("%s - Day %d of %d", player.getName(), game.getCurrentDay() + 1, game.getMaxDays()));
	    remainingLabel.setText(String.format("$%d remaining", player.getMoney()));
	    
	    int buyPrice = calculateBuyPrice();
	    buyAmountLabel.setText(String.format("$%d", buyPrice));
	    if (buyPrice > player.getMoney()) {
	        buyAmountLabel.setForeground(Color.RED);
	    }
	    else {
            buyAmountLabel.setForeground(Color.BLACK);
	    }
	}
	
	private int calculateBuyPrice() {
	    ShopListView<Item> view = storeList.getSelectedValue();
	    if (view == null)
	        return 0;
	    
	    Item item = view.getLhs();
	    return item.getPrice() * ((SpinnerNumberModel)buySpinner.getModel()).getNumber().intValue();
	}
}
