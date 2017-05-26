package seng201.assignment.gui;

import seng201.assignment.*;
import seng201.assignment.Pet.DeathState;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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

            return new ShopListView<>(currentList.get(index).get(0), currentList.get(index).get(1));
        }

        public void redraw() {
            Player player = game.getCurrentPlayer();
            currentList = GameStrings.generateInventoryListofLists(player.getItems());
            this.fireContentsChanged(this, 0, Integer.MAX_VALUE);
        }
    }

    private final MainGameWindow window;
    private final Game game;

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
    private JButton punishButton;

    /**
     * Create the panel.
     */
    MainGamePanel(final MainGameWindow window, final Game game) {
        this.window = window;
        this.game = game;

        playerLabel = new JLabel();
        playerLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        playerLabel.setBounds(10, 15, 480, 23);
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
        pet2Button.addActionListener(e -> {
            petIndex[0] = petIndex[1];
            petIndex[1] = game.getCurrentPetIndex();
            game.setCurrentPetIndex(petIndex[0]);
            redraw();
        });

        pet3NameLabel = new JLabel();
        pet3NameLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
        pet3NameLabel.setBounds(390, 48, 100, 14);
        add(pet3NameLabel);

        pet3Button = new JButton();
        pet3Button.setBounds(392, 77, 93, 92);
        pet3Button.setEnabled(true);
        add(pet3Button);
        pet3Button.addActionListener(e -> {
            petIndex[0] = petIndex[2];
            petIndex[2] = game.getCurrentPetIndex();
            game.setCurrentPetIndex(petIndex[0]);
            redraw();
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
        toiletButton.setBounds(256, 406, 93, 19);
        toiletButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
        toiletButton.addActionListener(e -> {
            game.toilet();
            addMessage(String.format("%s goes to the toilet.", game.getCurrentPet().getName()));
            redraw();
        });
        add(toiletButton);

        sleepButton = new JButton("Sleep");
        sleepButton.setBounds(392, 406, 93, 19);
        sleepButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
        sleepButton.addActionListener(e -> {
            game.sleep();
            addMessage(String.format("%s goes to sleep.", game.getCurrentPet().getName()));
            redraw();
        });
        add(sleepButton);

        useButton = new JButton();
        useButton.setBounds(516, 406, 72, 19);
        useButton.setEnabled(false);
        useButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
        useButton.addActionListener(e -> handleUse());
        add(useButton);

        JButton nextButton = new JButton("------->");
        nextButton.setBounds(583, 26, 93, 23);
        nextButton.addActionListener(e -> handleNext());
        add(nextButton);

        inventoryList = new JList<>();
        inventoryList.setBounds(495, 73, 128, 322);
        inventoryList.setModel(new InventoryListModel(game));
        inventoryList.setCellRenderer(new ShopListViewRenderer<>());
        inventoryList.addListSelectionListener(e -> redraw());

        final JScrollPane scrollInventoryPane = new JScrollPane(inventoryList);
        scrollInventoryPane.setBounds(516, 73, 160, 322);
        add(scrollInventoryPane);

        setLayout(null);

        punishButton = new JButton("Punish");
        punishButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
        punishButton.setBounds(604, 406, 72, 19);
        punishButton.setEnabled(false);
        punishButton.addActionListener(e -> {
            game.getCurrentPet().fixMisbehaving();
            addMessage(String.format("%s has been punished!", game.getCurrentPet().getName()));
            addMessage(String.format("%s becomes unhappy.", game.getCurrentPet().getName()));
            redraw();
        });
        add(punishButton);

        redraw();
    }

    private void handleUse() {
        final Item item = getSelectedItem();
        if (item instanceof Toy) {
            final Toy toy = (Toy)item;
            game.play(toy);
            addMessage(String.format("%s plays with %s.", game.getCurrentPet().getName(), toy.toString()));

            if (toy.isBroken()) {
                addMessage(String.format("%s was too rough! %s breaks.", game.getCurrentPet().getName(), toy.toString()));
                game.getCurrentPlayer().getItems().remove(item);
            }
        } else if (item instanceof Food) {
            if (item.equals(Food.MEDICINE)) {
                game.cure();
                addMessage(String.format("%s is cured.", game.getCurrentPet().getName()));
                game.getCurrentPlayer().getItems().remove(item);
            } else if (item.equals(Food.REVIVALMEDICINE)) {
                if (game.getCurrentPet().getDeathState() == DeathState.PERMANENTLY_DEAD) {
                    JOptionPane.showMessageDialog(window, "Can only revive a pet once!");
                } else if (game.getCurrentPet().isDead() && (game.getCurrentPet().getDeathState() == DeathState.DEAD_ONCE)) {
                    game.revive();
                    addMessage(String.format("%s is revived.", game.getCurrentPet().getName()));
                    game.getCurrentPlayer().getItems().remove(item);
                }
            } else {
                game.feed((Food)item);
                addMessage(String.format("%s eats %s.", game.getCurrentPet().getName(), item.toString()));
                game.getCurrentPlayer().getItems().remove(item);
            }

        } else {
            assert false;
        }
        redraw();
    }

    private void handleNext() {
        game.endTurn();

        for (final Pet pet : game.getCurrentPlayer().getPets()) {
            switch (pet.getEventState()) {
                case NO_EVENT:
                    break;
                case MISBEHAVING:
                    addMessage(String.format("%s has started misbehaving!", pet.getName()));
                    break;
                case SICK:
                    addMessage(String.format("%s has gotten sick!", pet.getName()));
                    break;
                case DEAD:
                    addMessage(String.format("%s has died!", pet.getName()));
                    if (pet.getDeathState() == DeathState.PERMANENTLY_DEAD) {
                        addMessage(String.format("%s is now permenantly dead!", pet.getName()));
                    }
                    break;
                default:
                    assert false;
                    break;
            }
        }

        if (!game.isRunning()) {
            new EndGameWindow(game.getPlayers());
            window.dispose();
        }

        petIndex[0] = 0;
        petIndex[1] = 1;
        petIndex[2] = 2;

        redraw();
    }

    void redraw() {
        final Player player = game.getCurrentPlayer();
        final Pet pet = game.getCurrentPet();

        ((InventoryListModel)inventoryList.getModel()).redraw();
        if (inventoryList.getSelectedIndex() >= inventoryList.getModel().getSize()) {
            inventoryList.setSelectedIndex(inventoryList.getModel().getSize() - 1);
        } else {
            inventoryList.setSelectedIndex(inventoryList.getSelectedIndex());
        }

        playerLabel.setText(GameStrings.getCurrentPlayerAndDay(game));

        final String actionsLeftString;
        if (pet.getActionsLeft() == 0) {
            actionsLeftString = "No actions left";
        } else if (pet.getActionsLeft() == 1) {
            actionsLeftString = "1 action left";
        } else {
            actionsLeftString = String.format("%d actions left", pet.getActionsLeft());
        }

        petNameLabel.setText(String.format("%s - %s", pet.getName(), actionsLeftString));
        petImage.setImage(Utils.loadImage(pet, 213, 204));

        ((InventoryListModel)inventoryList.getModel()).redraw();

        final Pet[] pets = player.getPets();
        if (pets.length > 1) {

            final Pet currentPet = pets[petIndex[1]];
            pet2NameLabel.setVisible(true);
            pet2NameLabel.setText(String.format("%s - %d", currentPet.getName(), currentPet.getActionsLeft()));
            pet2Img = Utils.loadImage(currentPet, 93, 92);
            pet2Button.setIcon(new ImageIcon(pet2Img));


        } else {
            pet2NameLabel.setVisible(false);
            pet2Button.setVisible(false);
        }

        if (pets.length > 2) {
            final Pet currentPet = pets[petIndex[2]];
            pet3NameLabel.setVisible(true);
            pet3NameLabel.setText(String.format("%s - %d", currentPet.getName(), currentPet.getActionsLeft()));
            pet3Img = Utils.loadImage(currentPet, 93, 92);
            pet3Button.setIcon(new ImageIcon(pet3Img));

        } else {
            pet3NameLabel.setVisible(false);
            pet3Button.setVisible(false);
        }


        if (pet.isMisbehaving()) {
            punishButton.setEnabled(true);
        } else if (!pet.isMisbehaving()) {
            punishButton.setEnabled(false);
        }

        final Item item = getSelectedItem();
        if (item == null) {
            useButton.setText("Use");
            useButton.setEnabled(false);
        } else if (item instanceof Toy) {
            useButton.setText("Play");
            useButton.setEnabled(pet.getActionsLeft() > 0 && !pet.isDead());
        } else if (item.equals(Food.REVIVALMEDICINE)) {
            useButton.setText("Feed");
            useButton.setEnabled(pet.isDead());
        } else if (item.equals(Food.MEDICINE)) {
            useButton.setText("Feed");
            useButton.setEnabled(pet.isSick());
        } else if (item instanceof Food) {
            useButton.setText("Feed");
            useButton.setEnabled(pet.getActionsLeft() > 0 && !pet.isDead());
        }

        toiletButton.setEnabled(pet.getActionsLeft() > 0 && !pet.isDead());
        sleepButton.setEnabled(pet.getActionsLeft() > 0 && !pet.isDead());

        statsText.setText(GameStrings.getPetInfo(game.getCurrentPet()));
        statsText.setCaretPosition(0);
    }

    private Item getSelectedItem() {
        final ShopListView<String> value = inventoryList.getSelectedValue();
        if (value == null) {
            return null;
        }

        final String itemName = value.getLhs();
        for (final Item item : game.getCurrentPlayer().getItems()) {
            if (item.toString().equals(itemName)) {
                return item;
            }
        }

        return null;
    }

    private void addMessage(final String message) {
        if (messageLogText.getText().isEmpty()) {
            messageLogText.setText(message);
        } else {
            messageLogText.setText(messageLogText.getText() + "\n" + message);
        }
    }
}
