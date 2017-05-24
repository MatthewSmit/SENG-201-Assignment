package seng201.assignment;

import java.lang.reflect.Constructor;

/**
 * The type of pet, used to get the image file for the pet type.
 */
public enum PetType {
    /**
     * A dog.
     */
    Dog("Dog", "dog.png", Dog.class, new Toy[] {Toy.LARGEBALL, Toy.SQUEAKYTOY, Toy.SMALLBALL}, new Food[] {Food.STEAK, Food.TUNA}),
    /**
     * A cat.
     */
    Cat("Cat", "cat.png", Cat.class, new Toy[] {Toy.CARDBOARDBOX, Toy.SMALLBALL}, new Food[] {Food.TUNA, Food.STEAK}),
    /**
     * A Bird.
     */
    Bird("Bird", "bird.png", Bird.class, new Toy[] {Toy.JUNGLEGYM, Toy.GUINEAPIGWHEEL}, new Food[] {Food.SEEDS, Food.BLOODWORM, Food.PEAS}),
    /**
     * A Goldfish.
     */
    Goldfish("Goldfish", "goldfish.png", Goldfish.class, new Toy[] {Toy.SMALLBALL}, new Food[] {Food.BLOODWORM, Food.LETTUCE, Food.PEAS}),
    /**
     * A Rabbit.
     */
    Rabbit("Rabbit", "rabbit.png", Rabbit.class, new Toy[] {Toy.CARDBOARDBOX, Toy.GUINEAPIGWHEEL, Toy.SMALLBALL}, new Food[] {Food.CARROT, Food.LETTUCE, Food.PEAS}),
    /**
     * A Guinea Pig.
     */
    GuineaPig("Guinea Pig", "guineapig.png", GuineaPig.class, new Toy[] {Toy.SMALLBALL, Toy.GUINEAPIGWHEEL}, new Food[] {Food.PEAS, Food.LETTUCE, Food.CARROT, Food.SEEDS});

    private final String name;
    private final String imageFile;
    private final Class<? extends Pet> petClass;
    private final Toy[] favouriteToys;
    private final Food[] favouriteFood;

    PetType(final String name, final String imageFile, final Class<? extends Pet> petClass, final Toy[] favouriteToys, final Food[] favouriteFood) {
        this.name = name;
        this.imageFile = imageFile;
        this.petClass = petClass;
        this.favouriteToys = favouriteToys;
        this.favouriteFood = favouriteFood;

        assert favouriteToys != null && favouriteToys.length > 0;
        assert favouriteFood != null && favouriteFood.length > 0;
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
     * Gets the favourite toys.
     */
    public Toy[] getFavouriteToys() {
        return favouriteToys;
    }
    
    /**
     * Gets the favourite food.
     */
    public Food[] getFavouriteFoods() {
        return favouriteFood;
    }

    /**
     * Create a pet of the desired type.
     * @param petName The name of the new pet
     */
    public Pet create(final String petName) {
        try {
            Constructor<? extends Pet> constructor = petClass.getDeclaredConstructor(String.class, PetType.class);
            constructor.setAccessible(true);
            return constructor.newInstance(petName, this);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Error();
        }
    }
}
