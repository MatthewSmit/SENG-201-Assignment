package seng201.assignment.gui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImageLabel extends JPanel {
    private static final long serialVersionUID = -2448285466458004426L;
    
    private Image image;

    public ImageLabel() {
    }
    
    public ImageLabel(ImageIcon imageIcon) {
        image = imageIcon.getImage();
    }
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (image != null) {
		    int size = Math.min(getWidth(), getHeight());
		    g.drawImage(image, 0, 0, size, size, this);
		}
	}

    public void setImage(ImageIcon imageIcon) {
        this.image = imageIcon.getImage();
    }
}