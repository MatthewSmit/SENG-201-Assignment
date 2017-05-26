package seng201.assignment;

/**
 * Implements the toys useable by pets.
 */
public final class Toy extends Item {
    /**
     * A small ball.
     */
    public static final Toy SMALLBALL      = new Toy("Small Ball", 3, 8);
    /**
     * A large ball.
     */
    public static final Toy LARGEBALL      = new Toy("Large Ball", 5, 9);
    /**
     * A squeaky toy.
     */
    public static final Toy SQUEAKYTOY     = new Toy("Squeaky Toy", 8, 5);
    /**
     * A spinning guinea pig wheel.
     */
    public static final Toy GUINEAPIGWHEEL = new Toy("Guinea Pig Wheel", 7, 7);
    /**
     * A jungle gym.
     */
    public static final Toy JUNGLEGYM      = new Toy("Jungle Gym", 8, 5);
    /**
     * A cardboard box.
     */
    public static final Toy CARDBOARDBOX   = new Toy("Cardboard Box", 1, 2);

    private static final Toy[] VALUES = new Toy[] {
            SMALLBALL,
            LARGEBALL,
            SQUEAKYTOY,
            GUINEAPIGWHEEL,
            JUNGLEGYM,
            CARDBOARDBOX
    };

    private final String name;
    private final int price;
    private final int maxDurability;

    private int durability;

    /**
     * Creates a toy.
     * @param name - name of the toy.
     * @param price - the price of the toy.
     * @param maxDurability - the maximum durability of the toy.
     */
    private Toy(final String name, final int price, final int maxDurability) {
        this.name = name;
        this.price = price;
        this.maxDurability = maxDurability;
        durability = maxDurability;
    }

    /**
     * Damages the toy, random damage value between [0, pet.roughness).
     * @param pet - The pet that damages the toy.
     */
    public void degrade(final Pet pet) {
        if (this.durability <= 0) {
            throw new UnsupportedOperationException("Can't play with a broken toy!");
        } else {
            int damageAmount = pet.getRandom().nextInt(pet.getRoughness()) + 1;
            durability -= damageAmount;
            if (durability < 0) {
                durability = 0;
            }
        }
    }
    
    
    /**
     * Checks whether or not the toy is broken.
     * @return true - if the toy is broken, false - if the toy is not broken.
     */
    public boolean isBroken() {
        return durability <= 0;
    }

    /**
     * Returns a copy of the toy.
     * @return toy - copy of the toy being cloned.
     */
    @Override
    public Toy clone() {
        return new Toy(name, price, maxDurability);
    }

    /**
     * Get the price of the toy.
     * @return price - price of the toy.
     */
    @Override
    public int getPrice() {
        return price;
    }

    /**
     * Remaining durability of the toy.
     * @return durability - the remaining durability of the toy.
     */
    public int getDurability() {
        return durability;
    }

    /**
     * Maximum durability of the toy.
     * @return maxDurability - the maximum durability of the toy.
     */
    public int getMaxDurability() {
        return maxDurability;
    }

    /**
     * Gets the name of the toy.
     * @return name - the name of the toy.
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * Gets an array containing all the possible toys.
     * @return VALUES - an array containing all the possible toys.
     */
    public static Toy[] values() {
        return VALUES;
    }
}
