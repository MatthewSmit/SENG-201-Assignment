package seng201.assignment.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

    private JLabel playerNumberLabel; 
    private CurrentPetsPanel yourPets;
    private JTextField nameText;
    private int playerIndex;

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
        setResizable(false);
        setBounds(100, 100, 700, 665);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        currentPets = new ArrayList<>();

        playerNumberLabel = new JLabel();
        playerNumberLabel.setBounds(10, 11, 64, 14);

        JLabel playerNameLabel = new JLabel("Player Name:");
        playerNameLabel.setBounds(10, 34, 103, 14);

        nameText = new JTextField();
        nameText.setBounds(112, 31, 86, 20);
        nameText.setColumns(10);
        nameText.setDocument(new JTextFieldLimit(10));

        JLabel avaliablePetsLabel = new JLabel("Avaliable Pets");
        avaliablePetsLabel.setBounds(10, 57, 103, 14);

        JLabel yourPetsLabel = new JLabel("Your Pets");
        yourPetsLabel.setBounds(373, 57, 76, 14);

        JButton nextButton = new JButton("Next");
        nextButton.setBounds(605, 605, 76, 23);
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                handleNext();
            }
        });

        JPanel avaliablePets = new AvaliablePetsPanel(this);
        avaliablePets.setBounds(10, 77, 308, 517);
        avaliablePets.setBorder(new LineBorder(new Color(0, 0, 0)));

        yourPets = new CurrentPetsPanel(this);
        yourPets.setBounds(373, 77, 308, 517);
        yourPets.setBorder(new LineBorder(new Color(0, 0, 0)));
        getContentPane().setLayout(null);
        getContentPane().add(playerNumberLabel);
        getContentPane().add(playerNameLabel);
        getContentPane().add(nameText);
        getContentPane().add(avaliablePetsLabel);
        getContentPane().add(avaliablePets);
        getContentPane().add(yourPetsLabel);
        getContentPane().add(yourPets);
        getContentPane().add(nextButton);
        
        initialize(0);
    }

    private void initialize(final int newPlayerIndex) {
        playerIndex = newPlayerIndex;
        
        currentPets.clear();
        playerNumberLabel.setText(String.format("Player %d", playerIndex + 1));
        yourPets.setPets(currentPets);
        
        nameText.setText("");
    }

    private void handleNext() {
        String name = nameText.getText();

        if (currentPets.size() == 0) {
            JOptionPane.showMessageDialog(this, "Player must have at least one pet.");
        } else if (name.length() > 0 && isUniqueName(name)) {
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
            JOptionPane.showMessageDialog(this, "Player name must be unique.");
        }
    }

    public boolean isUniqueName(final String newName) {
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

    public void addNewPet(final PetType type, final String name) {
        assert currentPets.size() < 3;
        currentPets.add(type.create(name));
        yourPets.setPets(currentPets);
    }

    public ArrayList<Pet> getCurrentPets() {
        return currentPets;
    }

    public void removePet(final Pet pet) {
        currentPets.remove(pet);
        yourPets.setPets(currentPets);
    }
}
