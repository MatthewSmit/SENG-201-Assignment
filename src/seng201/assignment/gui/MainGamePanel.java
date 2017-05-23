package seng201.assignment.gui;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.AbstractListModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import seng201.assignment.Food;
import seng201.assignment.Game;
import seng201.assignment.Item;
import seng201.assignment.Pet;
import seng201.assignment.Pet.DeathState;
import seng201.assignment.Player;
import seng201.assignment.Toy;

//How to - get correct string from enum (food/toy) - e.g. get "small ball" from Toy.SMALLBALL instead of SMALLBALL
//to be used in the console/gui. Have to check which enum is being referred to in toString() to get right name returned

//shifted from group to absolute layout as any time anything got moved other things would be moved as well.
@SuppressWarnings("serial")
final class MainGamePanel extends JPanel {
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

    private Game game;

    private int[] petIndex = new int[] {
            0, 1, 2
    };
    private JList<ShopListView<String>> inventoryList;
    private JLabel playerLabel;
    private JLabel petNameLabel;
    private ImageLabel petImage;
    private JLabel pet2NameLabel;
    private Image pet2Img;
    private JButton pet2Button;
    private JLabel pet3NameLabel;
    private Image pet3Img;
    private JButton pet3Button;
    
    private JTextPane statsText;
    private JScrollPane scrollStatsPane;
    
    private JScrollPane scrollMessagePane;
    private JTextPane messageLogText;
    private JButton toiletButton;
    private JButton sleepButton;
    private JButton useButton;

    /**
     * Create the panel.
     */
    MainGamePanel(final MainGameWindow window, final Game game) {
        this.game = game;

        playerLabel = new JLabel();
        playerLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        playerLabel.setBounds(10, 15, 250, 23);
        add(playerLabel);

        petNameLabel = new JLabel();
        petNameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        petNameLabel.setBounds(10, 43, 200, 19);
        add(petNameLabel);

        petImage = new ImageLabel();
        petImage.setBounds(10, 73, 213, 204);
        add(petImage);

        pet2NameLabel = new JLabel();
        pet2NameLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
        pet2NameLabel.setBounds(256, 48, 100, 14);
        add(pet2NameLabel);

        pet2Button = new JButton();
        pet2Button.setBounds(256, 77, 93, 92);
        pet2Button.setEnabled(true);
        add(pet2Button);
        pet2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                petIndex[0] = petIndex[1];
                petIndex[1] = game.getCurrentPetIndex();
                game.setCurrentPetIndex(petIndex[0]);
                redraw();
            }
        });

        pet3NameLabel = new JLabel();
        pet3NameLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
        pet3NameLabel.setBounds(390, 48, 100, 14);
        add(pet3NameLabel);

        pet3Button = new JButton();
        pet3Button.setBounds(392, 77, 93, 92);
        pet3Button.setEnabled(true);
        add(pet3Button);
        pet3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                petIndex[0] = petIndex[2];
                petIndex[2] = game.getCurrentPetIndex();
                game.setCurrentPetIndex(petIndex[0]);
                redraw();
            }
        });

        statsText = new JTextPane();
        statsText.setBounds(10, 286, 213, 200);
        statsText.setFont(new Font("Tahoma", Font.PLAIN, 11));
        statsText.setEditable(false);
        statsText.setHighlighter(null);
        
        scrollStatsPane = new JScrollPane(statsText);
        scrollStatsPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollStatsPane.setBounds(10, 286, 213, 140);
        add(scrollStatsPane);

        messageLogText = new JTextPane();
        messageLogText.setBounds(268, 164, 217, 259);
        messageLogText.setEditable(false);
        messageLogText.setHighlighter(null);

        scrollMessagePane = new JScrollPane(messageLogText);
        scrollMessagePane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollMessagePane.setBounds(256, 180, 229, 215);
        add(scrollMessagePane);

        toiletButton = new JButton("Toilet");
        toiletButton.setBounds(256, 406, 65, 19);
        toiletButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
        toiletButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                game.toilet();
                addMessage(String.format("%s goes to the toilet.", game.getCurrentPet().getName()));
                redraw();
            }
        });
        add(toiletButton);

        sleepButton = new JButton("Sleep");
        sleepButton.setBounds(331, 406, 77, 19);
        sleepButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
        sleepButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                game.sleep();
                addMessage(String.format("%s goes to sleep.", game.getCurrentPet().getName()));
                redraw();
            }
        });
        add(sleepButton);

        useButton = new JButton();
        useButton.setBounds(418, 406, 65, 19);
        useButton.setEnabled(false);
        useButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
        useButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                Item item = getSelectedItem();
                if (item instanceof Toy) {
                    Toy toy = (Toy)item;
                    game.play(toy);
                    addMessage(String.format("%s plays with %s.", game.getCurrentPet().getName(), toy.toString()));

                    if (toy.isBroken()) {
                        addMessage(String.format("%s was too rough! %s breaks.", game.getCurrentPet().getName(), toy.toString()));
                        game.getCurrentPlayer().getItems().remove(item);
                    }
                } else if (item instanceof Food) {
                    if (item == Food.MEDICINE) {
                        if (!game.getCurrentPet().isSick()) {
                            JOptionPane.showMessageDialog(window, "Cannot cure a healthy pet!");
                        } else {
                            game.cure();
                            addMessage(String.format("%s is cured.", game.getCurrentPet().getName()));
                        }
                    } else if (item == Food.REVIVALMEDICINE) {
                        if (!game.getCurrentPet().isDead()) {
                            JOptionPane.showMessageDialog(window, "Cannot revive a living pet!");
                        } else if (game.getCurrentPet().getDeathState() == DeathState.PERMANENTLY_DEAD) {
                            JOptionPane.showMessageDialog(window, "Can only revive a pet once!");
                        } else {
                            game.revive();
                            addMessage(String.format("%s is revived.", game.getCurrentPet().getName()));
                        }
                    } else {
                        game.feed((Food)item);
                        addMessage(String.format("%s eats %s.", game.getCurrentPet().getName(), item.toString()));
                    }
                    
                    game.getCurrentPlayer().getItems().remove(item);
                } else {
                    assert false;
                }
                redraw();
            }
        });
        add(useButton);

        JButton nextButton = new JButton("------->");
        nextButton.setBounds(583, 26, 93, 23);
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                game.endTurn();

                for (Pet pet : game.getCurrentPlayer().getPets()) {
                    switch (pet.getEventState()) {
                        case NoEvent:
                            break;
                        case Misbehaving:
                            addMessage(String.format("%s has started misbehaving!", pet.getName()));
                            break;
                        case Sick:
                            addMessage(String.format("%s has gotten sick!", pet.getName()));
                            break;
                        case Dead:
                            addMessage(String.format("%s has died!", pet.getName()));
                            if (pet.getDeathState() == Pet.DeathState.PERMANENTLY_DEAD) {
                                addMessage(String.format("%s is now permenantly dead!", pet.getName()));
                            }
                            break;
                        default:
                            assert false;
                            break;
                    }
                }
                
                if (!game.isRunning()) {
                    JOptionPane.showMessageDialog(window, "Game has finished!");
                    window.dispose();
                }

                petIndex[0] = 0;
                petIndex[1] = 1;
                petIndex[2] = 2;

                redraw();
            }
        });
        add(nextButton);

        inventoryList = new JList<>();
        inventoryList.setBounds(495, 73, 128, 351);
        inventoryList.setModel(new InventoryListModel(game));
        inventoryList.setCellRenderer(new ShopListViewRenderer<String>());
        inventoryList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(final ListSelectionEvent e) {
                redraw();
            }
        });

        JScrollPane scrollInventoryPane = new JScrollPane(inventoryList);
        scrollInventoryPane.setBounds(516, 73, 160, 351);
        add(scrollInventoryPane);

        setLayout(null);

        redraw();
    }

    public void redraw() {
        Player player = game.getCurrentPlayer();
        Pet pet = game.getCurrentPet();

        ((InventoryListModel)inventoryList.getModel()).redraw();
        if (inventoryList.getSelectedIndex() >= inventoryList.getModel().getSize()) {
            inventoryList.setSelectedIndex(inventoryList.getModel().getSize() - 1);
        } else {
            inventoryList.setSelectedIndex(inventoryList.getSelectedIndex());
        }

        playerLabel.setText(GameStrings.getCurrentPlayerAndDay(game));

        String actionsLeftString;
        if (pet.getActionsLeft() == 0) {
            actionsLeftString = "No actions left";
        } else if (pet.getActionsLeft() == 1) {
            actionsLeftString = "1 action left";
        } else {
            actionsLeftString = String.format("%d actions left", pet.getActionsLeft());
        }

        petNameLabel.setText(String.format("%s - %s", pet.getName(), actionsLeftString));
        petImage.setImage(loadImage(pet, 213, 204));

        ((InventoryListModel)inventoryList.getModel()).redraw();

        Pet[] pets = player.getPets();
        if (pets.length > 1) {

            Pet currentPet = pets[petIndex[1]];
            pet2NameLabel.setVisible(true);
            pet2NameLabel.setText(String.format("%s - %d", currentPet.getName(), currentPet.getActionsLeft()));
            pet2Img = loadImage(currentPet, 93, 92);
            pet2Button.setIcon(new ImageIcon(pet2Img));


        } else {
            pet2NameLabel.setVisible(false);
            pet2Button.setVisible(false);
        }

        if (pets.length > 2) {
            Pet currentPet = pets[petIndex[2]];
            pet3NameLabel.setVisible(true);
            pet3NameLabel.setText(String.format("%s - %d", currentPet.getName(), currentPet.getActionsLeft()));
            pet3Img = loadImage(currentPet, 93, 92);
            pet3Button.setIcon(new ImageIcon(pet3Img));

        } else {
            pet3NameLabel.setVisible(false);
            pet3Button.setVisible(false);
        }

        Item item = getSelectedItem();
        if (item == null) {
            useButton.setText("Use");
            useButton.setEnabled(false);
        } else if (item instanceof Toy) {
            useButton.setText("Play");
            useButton.setEnabled(pet.getActionsLeft() > 0 && !pet.isDead());
        } else {
            useButton.setText("Feed");
            useButton.setEnabled(pet.getActionsLeft() > 0 && !pet.isDead());
        }

        toiletButton.setEnabled(pet.getActionsLeft() > 0 && !pet.isDead());
        sleepButton.setEnabled(pet.getActionsLeft() > 0 && !pet.isDead());

        statsText.setText(GameStrings.getPetInfo(game.getCurrentPet()));
        scrollStatsPane.getVerticalScrollBar().setValue(0);
    }

    private Item getSelectedItem() {
        ShopListView<String> value = inventoryList.getSelectedValue();
        if (value == null) {
            return null;
        }

        String itemName = value.getLhs();
        for (Item item : game.getCurrentPlayer().getItems()) {
            if (item.toString().equals(itemName)) {
                return item;
            }
        }

        return null;
    }

    private void addMessage(final String message) {
        if (messageLogText.getText().length() == 0) {
            messageLogText.setText(message);
        } else {
            messageLogText.setText(messageLogText.getText() + "\n" + message);
        }
    }

    private Image loadImage(final Pet pet, final int width, final int height) {
        String imageFile = pet.getType().getImageFile();
        
        Image image;
        try {
            image = ImageIO.read(getClass().getResourceAsStream(imageFile));
        } catch (IOException e) {
            e.printStackTrace();
            throw new Error();
        }

        image = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        
        if (pet.isDead()) {
            Image deadImage;
            try {
                deadImage = ImageIO.read(getClass().getResourceAsStream("dead.png"));
            } catch (IOException e) {
                e.printStackTrace();
                throw new Error();
            }

            deadImage = deadImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            Image combined = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics graphics = combined.getGraphics();
            graphics.drawImage(image, 0, 0, null);
            graphics.drawImage(deadImage, 0, 0, null);
            image = combined;
        }
        
        return image;
    }
}
