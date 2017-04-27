package seng201.assignment;

/**
 * Created by Matthew on 12/04/2017.
 */
public enum Food {
    CARROT   (2, 3, 3, 3),
    TUNA     (6, 5, 4, 5),
    LETTUCE  (2, 2, 3, 2),
    STEAK    (8, 7, 6, 6),
    SEEDS    (4, 3, 3, 4),
    BLOODWORM(5, 2, 2, 3),
    PEAS     (2, 3, 2, 2);

    private final int price;
    private final int nutrition;
    private final int mealSize;
    private final int tastiness;
    
    Food(int price, int nutrition, int mealSize, int tastiness) {
        this.price = price;
        this.nutrition = nutrition;
        this.mealSize = mealSize;
        this.tastiness = tastiness;
    }

    public int getPrice() {
        return price;
    }

    public int getNutrition() {
        return nutrition;
    }

    public int getMealSize() {
        return mealSize;
    }

    public int getTastiness() {
        return tastiness;
    }
}
