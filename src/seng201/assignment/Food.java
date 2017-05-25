package seng201.assignment;

/**
 * Implements the foods consumable by pets, along with the consumable
 * medicines for healing sickness and one off revival.
 */
public final class Food extends Item {
    /**
     * A carrot.
     */
    public static final Food CARROT          = new Food("Carrot", 2, 3, 3, 3);
    /**
     * Tuna.
     */
    public static final Food TUNA            = new Food("Tuna", 6, 5, 4, 5);
    /**
     * A lettuce.
     */
    public static final Food LETTUCE         = new Food("Lettuce", 2, 2, 3, 2);
    /**
     * A steak.
     */
    public static final Food STEAK           = new Food("Steak", 8, 7, 6, 6);
    /**
     * Seeds.
     */
    public static final Food SEEDS           = new Food("Seeds", 4, 3, 3, 4);
    /**
     * A bloodworm.
     */
    public static final Food BLOODWORM       = new Food("Bloodworm", 5, 2, 2, 3);
    /**
     * Peas.
     */
    public static final Food PEAS            = new Food("Peas", 2, 3, 2, 2);
    /**
     * Medicine for healing sick pets.
     */
    public static final Food MEDICINE        = new Food("Medicine", 10, 0, 0, 0);
    /**
     * Revival medicine, for reviving dead pets.
     */
    public static final Food REVIVALMEDICINE = new Food("Revival Medicine", 25, 0, 0, 0);

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

    /**
     * Creates a food.
     * @param name name of the food.
     * @param price the price of the food.
     * @param nutrition the nutrition value (1 to 10) of the food.
     * @param mealSize the size (1 to 10) of the food.
     * @param tastiness the tastiness (1 to 10) of the food.
     */
    private Food(final String name, final int price, final int nutrition, final int mealSize, final int tastiness) {
        this.foodName = name;
        this.price = price;
        this.nutrition = nutrition;
        this.mealSize = mealSize;
        this.tastiness = tastiness;
    }

    /**
     * Create another copy of a food item.
     * @return this - a clone of the current item.
     */
    @Override
    public Item clone() {
        return this;
    }
    
    /**
     * Gets the price of the food.
     * @return price - the price of the current food.
     */
    @Override
    public int getPrice() {
        return price;
    }

    /**
     * Gets how nutritious the food is.
     * @return nutrition - value indicating how nutritious the food is. From 0 - low, to 10 - high.
     */
    public int getNutrition() {
        return nutrition;
    }

    /**
     * Gets how large the food is.
     * @return mealSize - value indicating how large the food is. From 0 - small, to 10 - large.
     */
    public int getMealSize() {
        return mealSize;
    }

    /**
     * Gets how tasty the food is.
     * @return tastiness - value indicating how tasty the food is. From 0 - low, to 10 - high.
     */
    public int getTastiness() {
        return tastiness;
    }
    
    /**
     * Gets the name of the food.
     * @return foodName - the name of the food.
     */
    @Override
    public String toString() {
        return foodName;
    }

    /**
     * Gets an array containing all the possible Food values.
     * @return VALUES - an array containing all the possible Food values.
     */
    public static Food[] values() {
        return VALUES;
    }
}
