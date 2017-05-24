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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameStartWindow extends JFrame {
    private class IntegerFilter extends DocumentFilter {
        private static final String REMOVE_REGEX = "\\D"; 

        @Override
        public void insertString(final FilterBypass fb, final int offset, String text, final AttributeSet attr) throws BadLocationException {
            text = text.replaceAll(REMOVE_REGEX, "");
            super.insertString(fb, offset, text, attr);
        }

        @Override
        public void replace(final FilterBypass fb, final int offset, final int length, String text, final AttributeSet attrs) throws BadLocationException {
            text = text.replaceAll(REMOVE_REGEX, "");
            super.replace(fb, offset, length, text, attrs);
        }
    }

    private static final long serialVersionUID = -7841059888084740875L;

    private JTextField numberDaysText;

    /**
     * Launch the application.
     */
    public static void main(final String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                GameStartWindow window = new GameStartWindow();
                window.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the application.
     */
    public GameStartWindow() {
        super();

        setResizable(false);
        setTitle("Game Setup");
        setBounds(100, 100, 320, 240);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel numberPlayersLabel = new JLabel("Number of Players");

        final JRadioButton players1Radio = new JRadioButton("1 Player");
        players1Radio.setSelected(true);

        final JRadioButton players2Radio = new JRadioButton("2 Players");

        final JRadioButton players3Radio = new JRadioButton("3 Players");

        ButtonGroup playerGroup = new ButtonGroup();
        playerGroup.add(players1Radio);
        playerGroup.add(players2Radio);
        playerGroup.add(players3Radio);

        JLabel numberDaysLabel = new JLabel("Number of Days");

        numberDaysText = new JTextField();
        numberDaysText.setText("10");
        ((PlainDocument)numberDaysText.getDocument()).setDocumentFilter(new IntegerFilter());

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                int players = getNumberPlayers();
                int days = Integer.parseInt(numberDaysText.getText());

                dispose();
                PlayerChoosingWindow newWindow = new PlayerChoosingWindow(players, days);
                newWindow.setVisible(true);
            }

            private int getNumberPlayers() {
                if (players3Radio.isSelected()) {
                    return 3;
                }
                if (players2Radio.isSelected()) {
                    return 2;
                }
                return 1;
            }
        });

        GroupLayout groupLayout = new GroupLayout(getContentPane());
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
        getContentPane().setLayout(groupLayout);
    }
}
