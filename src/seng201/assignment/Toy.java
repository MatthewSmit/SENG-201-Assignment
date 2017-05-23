package seng201.assignment;

/**
 * Created by Matthew on 2017-04-27.
 */
public final class Toy extends Item {
    /**
     * A small ball.
     */
    public static final Toy SMALLBALL      = new Toy("small ball", 3, 8);
    /**
     * A large ball.
     */
    public static final Toy LARGEBALL      = new Toy("large ball", 5, 9);
    /**
     * A squeaky toy.
     */
    public static final Toy SQUEAKYTOY     = new Toy("squeaky toy", 8, 5);
    /**
     * A spinning guinea pig wheel.
     */
    public static final Toy GUINEAPIGWHEEL = new Toy("guinea pig wheel", 7, 7);
    /**
     * A jungle gym.
     */
    public static final Toy JUNGLEGYM      = new Toy("jungle gym", 8, 5);
    /**
     * A cardboard box.
     */
    public static final Toy CARDBOARDBOX   = new Toy("cardboard box", 1, 2);

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

    private Toy(final String name, final int price, final int maxDurability) {
        this.name = name;
        this.price = price;
        this.maxDurability = maxDurability;
        durability = maxDurability;
    }

    /**
     * Damages the toy, random damage value between [0, pet.roughness).
     * @param pet The pet the damages the toy
     */
    public void degrade(final Pet pet) {
        if (this.durability <= 0) {
            throw new UnsupportedOperationException("Can't play with a broken toy!");
        } else {
            int damageAmount = pet.getRandom().nextInt(pet.getRoughness() + 1);
            durability -= damageAmount;
            if (durability < 0) {
                durability = 0;
            }
        }
    }

    /**
     * If the toy has broken.
     */
    public boolean isBroken() {
        return durability <= 0;
    }

    /**
     * Create another instance of a toy.
     */
    @Override
    public Toy clone() {
        return new Toy(name, price, maxDurability);
    }

    /**
     * Get the price of the toy.
     */
    @Override
    public int getPrice() {
        return price;
    }

    /**
     * Remaining durability of the toy.
     */
    public int getDurability() {
        return durability;
    }

    /**
     * Maximum durability of the toy.
     */
    public int getMaxDurability() {
        return maxDurability;
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     * An array of all the possible toy types.
     */
    public static Toy[] values() {
        return VALUES;
    }
}
