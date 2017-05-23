package seng201.assignment.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import seng201.assignment.Game;
import seng201.assignment.Pet;
import seng201.assignment.PetType;
import seng201.assignment.Player;

import java.awt.Color;

@SuppressWarnings("serial")
final class PlayerChoosingWindow extends JFrame {
    private ArrayList<Pet> currentPets;
    private Player[] players;
    private int numberDays;

    private CurrentPetsPanel yourPets;

    /**
     * Launch the application.
     */
    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PlayerChoosingWindow window = new PlayerChoosingWindow(3, 3);
                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    PlayerChoosingWindow(final int players, final int days) {
        this.players = new Player[players];
        this.numberDays = days;
        initialize();
    }

    /**
     * Initialise the contents of the frame.
     */
    private void initialize() {
        initialize(0);
    }

    private void initialize(final int playerIndex) {
        final JFrame frame = this;

        getContentPane().removeAll();

        setResizable(false);
        setBounds(100, 100, 768, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        currentPets = new ArrayList<>();

        JLabel playerNumberLabel = new JLabel(String.format("Player %d", playerIndex + 1));

        JLabel playerNameLabel = new JLabel("Player Name:");

        final JTextField nameText = new JTextField();
        nameText.setColumns(10);
        nameText.setDocument(new JTextFieldLimit(10));

        JLabel avaliablePetsLabel = new JLabel("Avaliable Pets");

        JLabel yourPetsLabel = new JLabel("Your Pets");

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                String name = nameText.getText();

                if (name.length() > 0 && isUniqueName(name)) {
                    players[playerIndex] = new Player(name, currentPets.toArray(new Pet[currentPets.size()]));
                    if (playerIndex + 1 == players.length) {
                        Game game = new Game(numberDays, players);

                        dispose();
                        MainGameWindow newWindow = new MainGameWindow(game);
                        newWindow.setVisible(true);
                    } else {
                        initialize(playerIndex + 1);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Player name must be unique.");
                }
            }
        });

        JPanel avaliablePets = new AvaliablePetsPanel(this);
        avaliablePets.setBorder(new LineBorder(new Color(0, 0, 0)));

        yourPets = new CurrentPetsPanel(this);
        yourPets.setBorder(new LineBorder(new Color(0, 0, 0)));

        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                .addComponent(playerNumberLabel)
                                .addGroup(groupLayout.createSequentialGroup()
                                        .addComponent(playerNameLabel)
                                        .addPreferredGap(ComponentPlacement.RELATED)
                                        .addComponent(nameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                .addGroup(groupLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                .addComponent(avaliablePetsLabel)
                                .addComponent(avaliablePets))
                        .addPreferredGap(ComponentPlacement.RELATED, 0, Short.MAX_VALUE)
                        .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                .addComponent(yourPetsLabel)
                                .addComponent(yourPets, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                .addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
                        .addComponent(nextButton)
                        .addContainerGap())
                );
        groupLayout.setVerticalGroup(
                groupLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(playerNumberLabel)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(playerNameLabel)
                        .addComponent(nameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(yourPetsLabel)
                        .addComponent(avaliablePetsLabel))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addComponent(avaliablePets)
                        .addComponent(yourPets, 1, 10, 600))
                .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nextButton)
                .addContainerGap()
                );
        getContentPane().setLayout(groupLayout);
    }

    public boolean isUniqueName(String newName) {
        for (Player player : players) {
            if (player != null) {
                if (newName.equals(player.getName())) {
                    return false;
                }

                for (Pet pet : player.getPets()) {
                    if (pet.getName().equals(newName)) {
                        return false;
                    }
                }
            }
        }

        for (Pet pet : currentPets) {
            if (pet.getName().equals(newName)) {
                return false;
            }
        }

        return true;
    }

    public void addNewPet(PetType type, String name) {
        assert currentPets.size() < 3;
        currentPets.add(type.create(name));
        yourPets.setPets(currentPets);
    }

    public ArrayList<Pet> getCurrentPets() {
        return currentPets;
    }

    public void removePet(Pet pet) {
        currentPets.remove(pet);
        yourPets.setPets(currentPets);
    }
}
