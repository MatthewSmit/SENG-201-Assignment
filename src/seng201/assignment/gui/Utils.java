package seng201.assignment.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import seng201.assignment.Pet;
import seng201.assignment.PetType;

final class Utils {
    private Utils() {
    }

    public static Image loadImage(final String imageFile, final int width, final int height) {
        Image image;
        try {
            image = ImageIO.read(Utils.class.getResourceAsStream(imageFile));
        } catch (IOException e) {
            e.printStackTrace();
            throw new Error();
        }

        return image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }

    public static Image loadImage(final PetType petType, final int width, final int height) {
        return loadImage(petType.getImageFile(), width, height);
    }

    public static Image loadImage(final Pet pet, final int width, final int height) {
        Image image = loadImage(pet.getType(), width, height);

        if (pet.isDead()) {
            Image deadImage = loadImage("dead.png", width, height);

            Image combined = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics graphics = combined.getGraphics();
            graphics.drawImage(image, 0, 0, null);
            graphics.drawImage(deadImage, 0, 0, null);
            image = combined;
        }

        return image;
    }
}
