package seng201.assignment.gui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

final class ImageLabel extends JPanel {
    private static final long serialVersionUID = -2448285466458004426L;

    private Image image;

    ImageLabel() {
    }

    ImageLabel(final ImageIcon imageIcon) {
        image = imageIcon.getImage();
    }

    ImageLabel(final Image image) {
        this.image = image;
    }

    @Override
    public void paintComponent(final Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            int size = Math.min(getWidth(), getHeight());
            g.drawImage(image, 0, 0, size, size, this);
        }
    }

    public void setImage(final ImageIcon imageIcon) {
        this.image = imageIcon.getImage();
        this.repaint();
    }

    public void setImage(final Image image) {
        this.image = image;
        this.repaint();
    }
}
