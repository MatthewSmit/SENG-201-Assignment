package seng201.assignment;

import java.lang.reflect.Constructor;

/**
 * The type of pet, used to get the image file for the pet type.
 */
public enum PetType {
    /**
     * A dog.
     */
    Dog("Dog", "dog.png", Dog.class),
    /**
     * A cat.
     */
    Cat("Cat", "cat.png", Cat.class),
    /**
     * A Bird.
     */
    Bird("Bird", "bird.png", Bird.class),
    /**
     * A Goldfish.
     */
    Goldfish("Goldfish", "goldfish.png", Goldfish.class),
    /**
     * A Rabbit.
     */
    Rabbit("Rabbit", "rabbit.png", Rabbit.class),
    /**
     * A Guinea Pig.
     */
    GuineaPig("Guinea Pig", "guineapig.png", GuineaPig.class);

    private final String name;
    private final String imageFile;
    private final Class<? extends Pet> petClass;

    PetType(final String name, final String imageFile, final Class<? extends Pet> petClass) {
        this.name = name;
        this.imageFile = imageFile;
        this.petClass = petClass;
    }

    /**
     * Gets the path to the image file.
     */
    public String getImageFile() {
        return imageFile;
    }

    /**
     * Gets the name of the pet species.
     */
    public String getName() {
        return name;
    }

    /**
     * Create a pet of the desired type.
     * @param petName The name of the new pet
     */
    public Pet create(final String petName) {
        try {
            Constructor<? extends Pet> constructor = petClass.getDeclaredConstructor(String.class, PetType.class);
            constructor.setAccessible(true);
            return (Pet)constructor.newInstance(petName, this);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Error();
        }
    }
}
