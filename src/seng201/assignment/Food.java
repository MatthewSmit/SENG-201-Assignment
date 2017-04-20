package seng201.assignment;

/**
 * Created by Matthew on 12/04/2017.
 */
public enum Food {
    Carrot(2, 1, 1, 1),
    Tuna(6, 1, 1, 1),
    Lettuce(2, 1, 1, 1),
    Steak(10, 1, 1, 1),
    Seeds(4, 1, 1, 1),
    Bloodworm(8, 1, 1, 1),
    Peas(2, 1, 1, 1);

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
