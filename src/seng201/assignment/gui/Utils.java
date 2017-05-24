package seng201.assignment.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import seng201.assignment.Pet;

final class Utils {
    private Utils() {
    }

    public static Image loadImage(final Pet pet, final int width, final int height) {
        String imageFile = pet.getType().getImageFile();

        Image image;
        try {
            image = ImageIO.read(Utils.class.getResourceAsStream(imageFile));
        } catch (IOException e) {
            e.printStackTrace();
            throw new Error();
        }

        image = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);

        if (pet.isDead()) {
            Image deadImage;
            try {
                deadImage = ImageIO.read(Utils.class.getResourceAsStream("dead.png"));
            } catch (IOException e) {
                e.printStackTrace();
                throw new Error();
            }

            deadImage = deadImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            Image combined = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics graphics = combined.getGraphics();
            graphics.drawImage(image, 0, 0, null);
            graphics.drawImage(deadImage, 0, 0, null);
            image = combined;
        }

        return image;
    }
}
