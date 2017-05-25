package seng201.assignment.gui;

import javax.swing.JPanel;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import seng201.assignment.Food;
import seng201.assignment.Game;
import seng201.assignment.GameStrings;
import seng201.assignment.Item;
import seng201.assignment.Player;
import seng201.assignment.Toy;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.LineBorder;
import javax.swing.JTextPane;

@SuppressWarnings("serial")
final class StorePanel extends JPanel {
    private class InventoryListModel extends AbstractListModel<ShopListView<String>> {
        private Game game;
        private ArrayList<ArrayList<String>> currentList;

        InventoryListModel(final Game game) {
            this.game = game;

            Player player = game.getCurrentPlayer();
            currentList = GameStrings.generateInventoryListofLists(player.getItems());
        }

        public int getSize() {
            return currentList.size();
        }

        public ShopListView<String> getElementAt(final int index) {
            if (index < 0 || index >= getSize()) {
                return null;
            }

            return new ShopListView<String>(currentList.get(index).get(0), currentList.get(index).get(1));
        }

        public void redraw() {
            Player player = game.getCurrentPlayer();
            currentList = GameStrings.generateInventoryListofLists(player.getItems());
            this.fireContentsChanged(this, 0, Integer.MAX_VALUE);
        }
    }

    private static final double SELL_MODIFIER = 0.8;

    private final JFrame frame;
    private final Game game;

    private JLabel remainingLabel;
    private JLabel buyAmountLabel;
    private JLabel sellAmountLabel;
    private JLabel playerLabel;
    private JList<ShopListView<Item>> storeList;

    private JSpinner buySpinner;
    private JSpinner sellSpinner;
    
    private JTextPane statsText;

    private JList<ShopListView<String>> inventoryList;

    /**
     * Create the panel.
     */
    StorePanel(final JFrame frame, final Game game) {
        this.frame = frame;
        this.game = game;

        setLayout(null);

        DefaultListModel<ShopListView<Item>> list = new DefaultListModel<>();
        for (Food food : Food.values()) {
            list.addElement(new ShopListView<Item>(food, String.format("$%d", food.getPrice())));
        }

        for (Toy toy : Toy.values()) {
            list.addElement(new ShopListView<Item>(toy, String.format("$%d", toy.getPrice())));
        }

        storeList = new JList<>();
        storeList.setFont(new Font("Tahoma", Font.PLAIN, 13));
        storeList.setBorder(new LineBorder(new Color(0, 0, 0)));
        storeList.setBounds(10, 49, 397, 263);
        storeList.setModel(list);
        storeList.setCellRenderer(new ShopListViewRenderer<Item>());
        storeList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(final ListSelectionEvent e) {
                redraw();
            }
        });
        add(storeList);

        remainingLabel = new JLabel();
        remainingLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        remainingLabel.setBounds(500, 15, 200, 23);
        add(remainingLabel);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(454, 167, 217, 256);
        add(scrollPane);

        inventoryList = new JList<>();
        scrollPane.setViewportView(inventoryList);
        inventoryList.setModel(new InventoryListModel(game));
        inventoryList.setCellRenderer(new ShopListViewRenderer<String>());
        inventoryList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(final ListSelectionEvent e) {
                redraw();
            }
        });

        JButton buyButton = new JButton("Buy");
        buyButton.setBounds(454, 66, 74, 23);
        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                handleBuy();
            }
        });
        add(buyButton);

        JButton sellButton = new JButton("Sell");
        sellButton.setBounds(454, 119, 74, 23);
        sellButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                handleSell();
            }
        });
        add(sellButton);

        buySpinner = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
        buySpinner.setBounds(548, 66, 74, 23);
        buySpinner.addChangeListener(new ChangeListener() { 
            @Override
            public void stateChanged(final ChangeEvent e) {
                redraw();
            }
        });
        add(buySpinner);

        sellSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
        sellSpinner.setBounds(548, 119, 74, 23);
        sellSpinner.addChangeListener(new ChangeListener() { 
            @Override
            public void stateChanged(final ChangeEvent e) {
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
        playerLabel.setBounds(10, 15, 397, 23);
        add(playerLabel);
        
        statsText = new JTextPane();
        statsText.setFont(new Font("Tahoma", Font.PLAIN, 13));
        statsText.setEditable(false);   
        statsText.setBounds(12, 323, 395, 100);
        statsText.setHighlighter(null);
        add(statsText);

        redraw();
    }

    private void handleBuy() {
        Player player = game.getCurrentPlayer();
        int buyPrice = calculateBuyPrice();
        ShopListView<Item> view = storeList.getSelectedValue();
        if (buyPrice > player.getMoney()) {
            JOptionPane.showMessageDialog(frame, "You don't have enough money.");
        } else if (view == null) {
            JOptionPane.showMessageDialog(frame, "You must select an item to buy.");
        } else {
            int amount = ((SpinnerNumberModel)buySpinner.getModel()).getNumber().intValue();
            for (int i = 0; i < amount; i++) {
                game.getCurrentPlayer().purchase(view.getLhs());
            }
            redraw();
        }
    }
    
    private void handleSell() {
        ShopListView<String> selectedItem = inventoryList.getSelectedValue();
        if (selectedItem == null) {
            JOptionPane.showMessageDialog(frame, "You must select an item to sell.");
        } else {
            String itemName = selectedItem.getLhs();

            Player player = game.getCurrentPlayer();
            int amount = ((SpinnerNumberModel)sellSpinner.getModel()).getNumber().intValue();

            for (int i = 0, j = 0; i < player.getItems().size(); i++) {
                Item item = player.getItems().get(i);
                if (item.toString().equals(itemName)) {
                    double tempAmount = item.getPrice() * SELL_MODIFIER;

                    if (item instanceof Toy) {
                        Toy toy = (Toy)item;
                        double damaged = (double)toy.getDurability() / (double)toy.getMaxDurability();
                        tempAmount *= damaged;
                    }

                    int sellAmount = (int)Math.floor(tempAmount);
                    player.addMoney(sellAmount);
                    player.getItems().remove(i);
                    i--;

                    j++;
                    if (j >= amount) {
                        break;
                    }
                }
            }

            redraw();
        }
    }

    public void redraw() {
        Player player = game.getCurrentPlayer();

        ((InventoryListModel)inventoryList.getModel()).redraw();
        if (inventoryList.getSelectedIndex() >= inventoryList.getModel().getSize()) {
            inventoryList.setSelectedIndex(inventoryList.getModel().getSize() - 1);
        } else {
            inventoryList.setSelectedIndex(inventoryList.getSelectedIndex());
        }

        playerLabel.setText(GameStrings.getCurrentPlayerAndDay(game));
        remainingLabel.setText(String.format("$%d remaining", player.getMoney()));

        int buyPrice = calculateBuyPrice();
        buyAmountLabel.setText(String.format("$%d", buyPrice));
        if (buyPrice > player.getMoney()) {
            buyAmountLabel.setForeground(Color.RED);
        } else {
            buyAmountLabel.setForeground(Color.BLACK);
        }

        int sellPrice = calculateSellPrice();
        sellAmountLabel.setText(String.format("$%d", sellPrice));
        
        ShopListView<Item> item = storeList.getSelectedValue();
        if (item == null) {
            statsText.setText("");
        } else {
            statsText.setText(GameStrings.getItemInfo(item.getLhs()));
        }
    }

    private int calculateBuyPrice() {
        ShopListView<Item> view = storeList.getSelectedValue();
        if (view == null) {
            return 0;
        }

        int amount = ((SpinnerNumberModel)buySpinner.getModel()).getNumber().intValue();

        Item item = view.getLhs();
        return item.getPrice() * amount;
    }

    private int calculateSellPrice() {
        ShopListView<String> selectedItem = inventoryList.getSelectedValue();
        if (selectedItem == null) {
            return 0;
        }

        String itemName = selectedItem.getLhs();

        Player player = game.getCurrentPlayer();
        int amount = ((SpinnerNumberModel)sellSpinner.getModel()).getNumber().intValue();

        int total = 0;
        int i = 0;
        for (Item item : player.getItems()) {
            if (item.toString().equals(itemName)) {
                double tempAmount = item.getPrice() * SELL_MODIFIER;

                if (item instanceof Toy) {
                    Toy toy = (Toy)item;
                    double damaged = (double)toy.getDurability() / (double)toy.getMaxDurability();
                    tempAmount *= damaged;
                }

                total += (int)Math.floor(tempAmount);

                i++;
                if (i >= amount) {
                    break;
                }
            }
        }

        return total;
    }
}
