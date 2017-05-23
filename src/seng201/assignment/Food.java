package seng201.assignment;

/**
 * Created by Matthew on 12/04/2017.
 */
public final class Food extends Item {
    /**
     * A carrot.
     */
    public static final Food CARROT          = new Food("carrot", 2, 3, 3, 3);
    /**
     * Tuna.
     */
    public static final Food TUNA            = new Food("tuna", 6, 5, 4, 5);
    /**
     * A lettuce.
     */
    public static final Food LETTUCE         = new Food("lettuce", 2, 2, 3, 2);
    /**
     * A steak.
     */
    public static final Food STEAK           = new Food("steak", 8, 7, 6, 6);
    /**
     * Seeds.
     */
    public static final Food SEEDS           = new Food("seeds", 4, 3, 3, 4);
    /**
     * A bloodworm.
     */
    public static final Food BLOODWORM       = new Food("bloodworm", 5, 2, 2, 3);
    /**
     * Peas.
     */
    public static final Food PEAS            = new Food("peas", 2, 3, 2, 2);
    /**
     * Medicine for healing sick pets.
     */
    public static final Food MEDICINE        = new Food("medicine", 10, 0, 0, 0);
    /**
     * Revival medicine, for reviving dead pets.
     */
    public static final Food REVIVALMEDICINE = new Food("revival medicine", 25, 0, 0, 0);

    private static final Food[] VALUES = new Food[]{
            CARROT,
            TUNA,
            LETTUCE,
            STEAK,
            SEEDS,
            BLOODWORM,
            PEAS,
            MEDICINE,
            REVIVALMEDICINE
    };

    private final String foodName;
    private final int price;
    private final int nutrition;
    private final int mealSize;
    private final int tastiness;

    private Food(final String name, final int price, final int nutrition, final int mealSize, final int tastiness) {
        this.foodName = name;
        this.price = price;
        this.nutrition = nutrition;
        this.mealSize = mealSize;
        this.tastiness = tastiness;
    }

    @Override
    public Item clone() {
        return this;
    }
    
    @Override
    public int getPrice() {
        return price;
    }

    /**
     * Gets how nutritious the food is.
     */
    public int getNutrition() {
        return nutrition;
    }

    /**
     * Gets how large the food is.
     */
    public int getMealSize() {
        return mealSize;
    }

    /**
     * Gets how tasty the food is.
     */
    public int getTastiness() {
        return tastiness;
    }

    @Override
    public String toString() {
        return foodName;
    }

    /**
     * Gets an array containing all the possible Food values.
     */
    public static Food[] values() {
        return VALUES;
    }
}
