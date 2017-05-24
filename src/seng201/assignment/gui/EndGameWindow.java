package seng201.assignment.gui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

import seng201.assignment.Pet;
import seng201.assignment.PetType;
import seng201.assignment.Player;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
final class EndGameWindow extends JFrame {
    /**
     * Launch the application.
     */
    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EndGameWindow window = new EndGameWindow(new Player[]{
                            new Player("player1", new Pet[]{
                                    PetType.Dog.create("dog1")
                            }),
                            new Player("player2", new Pet[]{
                                    PetType.Cat.create("cat1"),
                                    PetType.Bird.create("bird1")
                            }),
                            new Player("player3", new Pet[]{
                                    PetType.Goldfish.create("goldfish1"),
                                    PetType.GuineaPig.create("guinea pig1"),
                                    PetType.Rabbit.create("rabbit1")
                            })
                    });
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
    EndGameWindow(final Player[] players) {
        getContentPane().setLayout(null);

        setResizable(false);
        setBounds(100, 100, 412, 665);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel endLabel = new JLabel("GAME OVER", SwingConstants.CENTER);
        endLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        endLabel.setBounds(12, 12, 388, 24);
        getContentPane().add(endLabel);

        JPanel player1 = new EndGamePanel(players[0]);
        player1.setBounds(12, 100, 488, 10);
        getContentPane().add(player1);

        if (players.length > 1) {
            JPanel player2 = new EndGamePanel(players[1]);
            player2.setBounds(12, 100, 488, 10);
            getContentPane().add(player2);
        }

        if (players.length > 2) {
            JPanel player3 = new EndGamePanel(players[2]);
            player3.setBounds(12, 100, 488, 10);
            getContentPane().add(player3);
        }
    }
}
