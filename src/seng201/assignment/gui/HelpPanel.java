package seng201.assignment.gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JTextPane;

@SuppressWarnings("serial")
public class HelpPanel extends JPanel {
    private JScrollPane scrollPane;
    
    /**
     * Create the panel.
     */
    public HelpPanel() {
        setLayout(new BorderLayout(0, 0));
        
        JTextPane textPane = new JTextPane();
        textPane.setEditable(false);
        textPane.setHighlighter(null);
        textPane.setContentType("text/html");
        textPane.setText(
"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 3.2//EN\">\n" +
"<html>\n" +
"    <head>\n" +
"    </head>\n" +
"    <body>\n" +
"        <center><H1>PET GAME</H1></center>\n" +
"\n" +
"Your pet has 6 attributes; Tiredness, Toilet, Happiness, Hunger and Weight.\n" +
"<p>\n" +
"<table border=1>\n" +
"    <tr><th>Tiredness<td>How tired your pet is.\n" +
"    <tr><th>Toilet<td>How much your pet needs to go toilet.\n" +
"    <tr><th>Happiness<td>How happy your pet is.\n" +
"    <tr><th>Hunger<td>How hungry your pet is.\n" +
"    <tr><th>Weight<td>The weight of your pet, measured in kg.\n" +
"</table>\n" +
"<p>\n" +
"The game takes place over a configurable number of days, between 1-3 players. During each day, each player has a turn to control their pets. Each player has a certain amount of money that can be used to buy food and toys. Each pet has 2 actions that can be used each day.\n" +
"<p>\n" +
"The actions available are as follows:\n" +
"<ul>\n" +
"    <li>Sleep - Put your pet to bed.\n" +
"    <li>Toilet - Take your pet out to go toilet.\n" +
"    <li>Feed - Feed your pet the selected food. Pets may prefer certain types of food.\n" +
"    <li>Play - Play with your pet using the selected toy. Pets may prefer certain types of toys. Toys can break if pets are too rough with them.\n" +
"</ul>\n" +
"<p>\n" +
"You are able to go to the next day or next player using the next button, and buy toys and food from the store.\n" +
"<p>\n" +
"Each day certain events can happen. Pets can get sick, or start misbehaving. Becoming sick requires medicine to get better, otherwise it will continue to get sick and may die. Pets are able to be revived from death once, but only once. Pets are more likely to get sick if it is overweight or too hungry, and pets may misbehave if they are unhappy or hungry.\n" +
"    </body>\n" +
"</html>");
        
        scrollPane = new JScrollPane(textPane);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void onTabChanged() {
        scrollPane.getVerticalScrollBar().setValue(0);
    }
}
