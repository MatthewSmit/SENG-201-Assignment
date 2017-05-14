package seng201.assignment.gui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImageLabel extends JPanel {
	private Image image;
	
	public ImageLabel(ImageIcon image) {
		this.image = image.getImage();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int size = Math.min(getWidth(), getHeight());
		g.drawImage(image, 0, 0, size, size, this);
	}
}
