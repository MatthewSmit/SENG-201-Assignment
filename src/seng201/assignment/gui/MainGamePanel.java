package seng201.assignment.gui;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JList;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractListModel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import seng201.assignment.Game;
import seng201.assignment.Pet;
import seng201.assignment.PetType;

//How to - get correct string from enum (food/toy) - e.g. get "small ball" from Toy.SMALLBALL instead of SMALLBALL
//to be used in the console/gui. Have to check which enum is being referred to in toString() to get right name returned

//shifted from group to absolute layout as any time anything got moved other things would be moved as well.
@SuppressWarnings("serial")
public class MainGamePanel extends JPanel {
    private Game game;
    
    private JLabel playerLabel;
    private JLabel petNameLabel;
    private ImageLabel petImage;
    private JLabel pet2NameLabel;
    private ImageLabel pet2Image;
    private JLabel pet3NameLabel;
    private ImageLabel pet3Image;

	/**
	 * Create the panel.
	 */
	public MainGamePanel(Game game) {
	    this.game = game;

		BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(getClass().getResourceAsStream(PetType.Dog.getImageFile()));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
		playerLabel = new JLabel();
		playerLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		playerLabel.setBounds(10, 15, 200, 23);
		
		petNameLabel = new JLabel();
		petNameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		petNameLabel.setBounds(10, 43, 100, 19);
        add(petNameLabel);
		
		petImage = new ImageLabel();
		petImage.setBounds(10, 73, 213, 204);
        add(petImage);
        
        pet2NameLabel = new JLabel();
        pet2NameLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
        pet2NameLabel.setBounds(256, 48, 100, 14);
        add(pet2NameLabel);
        
        pet2Image = new ImageLabel();
        pet2Image.setBounds(256, 77, 93, 92);
        add(pet2Image);
        
        pet3NameLabel = new JLabel();
        pet3NameLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
        pet3NameLabel.setBounds(390, 48, 100, 14);
        add(pet3NameLabel);
        
        pet3Image = new ImageLabel();
        pet3Image.setBounds(392, 77, 93, 92);
        add(pet3Image);
		
		JTextPane statsText = new JTextPane();
		statsText.setBounds(10, 286, 213, 148);
		statsText.setFont(new Font("Tahoma", Font.PLAIN, 11));
		statsText.setText("Species: Dog\r\nWeight: 5.4kg\r\nGender: Male\r\nHunger: 50%\r\n"
				+ "Tiredness: 20%\r\nToilet need: 30%\r\nHealth: 50%\r\nHappiness: 6000000%\r\n"
				+ "Harry is Sick! (dif colour/font)\r\n");
		statsText.setEditable(false);
        add(statsText);
        
        JTextPane messageLogText = new JTextPane();
        messageLogText.setBounds(268, 164, 217, 259);
        messageLogText.setText("Harry ate food\r\nSnuffles did this\r\nSnuffles 2 did that\r\nHarry is misbehaving\r\n"
                + "Harry ate food\r\nSnuffles did this\r\nSnuffles 2 did that\r\nHarry is misbehaving\r\n"
                + "Harry ate food\r\nSnuffles did this\r\nSnuffles 2 did that\r\nHarry is misbehaving\r\n"
                + "Harry ate food\r\nSnuffles did this\r\nSnuffles 2 did that\r\nHarry is misbehaving\r\n"
                + "Harry ate food\r\nSnuffles did this");
        messageLogText.setEditable(false);
        
        JScrollPane scrollMessagePane = new JScrollPane(messageLogText);
        scrollMessagePane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollMessagePane.setBounds(256, 180, 229, 267);
        add(scrollMessagePane);
		
		JButton toiletButton = new JButton("Toilet");
		toiletButton.setBounds(10, 428, 65, 19);
		toiletButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		JButton sleepButton = new JButton("Sleep");
		sleepButton.setBounds(83, 428, 65, 19);
		sleepButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		JButton useButton = new JButton("Use");
		useButton.setBounds(158, 428, 65, 19);
		useButton.setEnabled(false);
		useButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		JButton nextButton = new JButton("------->");
		nextButton.setBounds(583, 26, 93, 23);
		
		JList<String> inventoryList = new JList<>();
		inventoryList.setBounds(495, 61, 128, 362);
		inventoryList.setModel(new AbstractListModel<String>() {
			String[] values = new String[] {"Guinea Pig Wheel", "Item2", "Item3", "Item4", "Item5", "Item6", "Item7", "Item8",
											"Item", "Item2", "Item3", "Item4", "Item5", "Item6", "Item7", "Item8",
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
		
		JScrollPane scrollInventoryPane = new JScrollPane(inventoryList);
		scrollInventoryPane.setBounds(516, 61, 160, 386);
		
		
		setLayout(null);
		add(toiletButton);
		add(sleepButton);
		add(useButton);
		add(playerLabel);
		//add(inventoryList);
		add(nextButton);
		add(scrollInventoryPane);
		
		redraw();
	}
	
	private void redraw() {
	    playerLabel.setText(String.format("%s - Day %d of %d", game.getCurrentPlayer().getName(), game.getCurrentDay() + 1, game.getMaxDays()));
	    petNameLabel.setText(game.getCurrentPet().getName());
	    petImage.setImage(loadImage(game.getCurrentPet().getType()));
	    
	    Pet[] pets = game.getCurrentPlayer().getPets();
	    if (pets.length > 1) {
	        Pet currentPet = pets[game.getCurrentPetIndex() == 0 ? 1 : 0];
            pet2NameLabel.setVisible(true);
            pet2NameLabel.setText(currentPet.getName());
            pet2Image.setVisible(true);
            pet2Image.setImage(loadImage(currentPet.getType()));
	    }
	    else {
            pet2NameLabel.setVisible(false);
            pet2Image.setVisible(false);
	    }

        if (pets.length > 2) {
            Pet currentPet = pets[game.getCurrentPetIndex() == 2 ? 1 : 2];
            pet3NameLabel.setVisible(true);
            pet3NameLabel.setText(currentPet.getName());
            pet3Image.setVisible(true);
            pet3Image.setImage(loadImage(currentPet.getType()));
        }
        else {
            pet3NameLabel.setVisible(false);
            pet3Image.setVisible(false);
        }
	}
	
	private ImageIcon loadImage(PetType type) {
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(getClass().getResourceAsStream(type.getImageFile()));
            return new ImageIcon(bufferedImage);
        } catch (IOException e) {
            e.printStackTrace();
            throw new Error();
        }
	}
}
