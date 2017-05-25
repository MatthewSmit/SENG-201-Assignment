package seng201.assignment.gui;

import seng201.assignment.Pet;
import seng201.assignment.PetType;
import seng201.assignment.Player;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

@SuppressWarnings("serial")
final class EndGameWindow extends JFrame {
    /**
     * Launch the application.
     */
    public static void main(final String[] args) {
        EventQueue.invokeLater(() -> {
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
        });
    }

    /**
     * Create the application.
     */
    EndGameWindow(final Player[] players) {
        getContentPane().setLayout(null);

        setResizable(false);
        setVisible(true);
        int borderWidth = getInsets().left + getInsets().right;
        int borderHeight = getInsets().top + getInsets().bottom;
        setBounds(100, 100, 512 + borderWidth, 211 + borderHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel endLabel = new JLabel("GAME OVER", SwingConstants.CENTER);
        endLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        endLabel.setBounds(12, 12, 488, 24);
        getContentPane().add(endLabel);

        JPanel player1 = new EndGamePanel(players[0]);
        player1.setBounds(12, 36, 488, 163);
        player1.setBorder(new LineBorder(Color.BLACK));
        getContentPane().add(player1);

        if (players.length > 1) {
            JPanel player2 = new EndGamePanel(players[1]);
            player2.setBounds(12, 211, 488, 163);
            player2.setBorder(new LineBorder(Color.BLACK));
            getContentPane().add(player2);
            setBounds(100, 100, 512 + borderWidth, 386 + borderHeight);
        }

        if (players.length > 2) {
            JPanel player3 = new EndGamePanel(players[2]);
            player3.setBounds(12, 386, 488, 163);
            player3.setBorder(new LineBorder(Color.BLACK));
            getContentPane().add(player3);
            setBounds(100, 100, 512 + borderWidth, 561 + borderHeight);
        }
    }
}
