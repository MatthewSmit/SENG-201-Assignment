package seng201.assignment;

/**
 * Created by Matthew on 12/04/2017.
 */
public enum Food {
    CARROT(2, 1, 1, 1),
    TUNA(6, 1, 1, 1),
    LETTUCE(2, 1, 1, 1),
    STEAK(10, 1, 1, 1),
    SEEDS(4, 1, 1, 1),
    BLOODWORM(8, 1, 1, 1),
    PEAS(2, 1, 1, 1);

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
