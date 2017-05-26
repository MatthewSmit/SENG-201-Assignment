package seng201.assignment;

import java.lang.reflect.Constructor;

/**
 * The type of pet, used to get the image file for a pet type.
 */
public enum PetType {
    /**
     * A dog.
     */
    Dog("Dog", "dog.png", Dog.class, new Toy[] {Toy.LARGEBALL, Toy.SQUEAKYTOY, Toy.SMALLBALL}, 
    		new Food[] {Food.STEAK, Food.TUNA}),
    /**
     * A cat.
     */
    Cat("Cat", "cat.png", Cat.class, new Toy[] {Toy.CARDBOARDBOX, Toy.SMALLBALL}, 
    		new Food[] {Food.TUNA, Food.STEAK}),
    /**
     * A Bird.
     */
    Bird("Bird", "bird.png", Bird.class, new Toy[] {Toy.JUNGLEGYM, Toy.GUINEAPIGWHEEL}, 
    		new Food[] {Food.SEEDS, Food.BLOODWORM, Food.PEAS}),
    /**
     * A Goldfish.
     */
    Goldfish("Goldfish", "goldfish.png", Goldfish.class, new Toy[] {Toy.SMALLBALL}, 
    		new Food[] {Food.BLOODWORM, Food.LETTUCE, Food.PEAS}),
    /**
     * A Rabbit.
     */
    Rabbit("Rabbit", "rabbit.png", Rabbit.class, new Toy[] {Toy.CARDBOARDBOX, Toy.GUINEAPIGWHEEL, Toy.SMALLBALL}, 
    		new Food[] {Food.CARROT, Food.LETTUCE, Food.PEAS}),
    /**
     * A Guinea Pig.
     */
    GuineaPig("Guinea Pig", "guineapig.png", GuineaPig.class, new Toy[] {Toy.SMALLBALL, Toy.GUINEAPIGWHEEL}, 
    		new Food[] {Food.PEAS, Food.LETTUCE, Food.CARROT, Food.SEEDS});

    private final String name;
    private final String imageFile;
    private final Class<? extends Pet> petClass;
    private final Toy[] favouriteToys;
    private final Food[] favouriteFoods;

    /**
     * creates a type of a pet.
     * @param name - the species of the pet.
     * @param imageFile - the name of the corresponding image file for the pet.
     * @param petClass - the class (species) that the pet belongs to.
     * @param favouriteToys - the favourite toys of that pet as a Toy[] list.
     * @param favouriteFood - the favourite foods of that pet as a Food[] list.
     */
    PetType(final String name, final String imageFile, final Class<? extends Pet> petClass, final Toy[] favouriteToys, final Food[] favouriteFood) {
        this.name = name;
        this.imageFile = imageFile;
        this.petClass = petClass;
        this.favouriteToys = favouriteToys;
        this.favouriteFoods = favouriteFood;

        assert favouriteToys != null && favouriteToys.length > 0;
        assert favouriteFood != null && favouriteFood.length > 0;
    }

    /**
     * Gets the path of the image file.
     * @return imageFile - the path of the image file as a string.
     */
    public String getImageFile() {
        return imageFile;
    }

    /**
     * Gets the name of the pet species.
     * @return name - the species of the pet.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Gets the favourite toys.
     * @return favouriteToys - the favourite toys of a pet type.
     */
    public Toy[] getFavouriteToys() {
        return favouriteToys;
    }
    
    /**
     * Gets the favourite foods.
     * @return favouriteFoods - the favourite foods of a pet type.
     */
    public Food[] getFavouriteFoods() {
        return favouriteFoods;
    }

    /**
     * Create a pet of the desired type.
     * @param petName - The name of the new pet.
     * @return pet - the created pet.
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
