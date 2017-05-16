package seng201.assignment;

/**
 * Created by Matthew on 12/04/2017.
 */
public enum Food {
    CARROT   ("carrot", 2, 3, 3, 3),
    TUNA     ("tuna", 6, 5, 4, 5),
    LETTUCE  ("lettuce", 2, 2, 3, 2),
    STEAK    ("steak", 8, 7, 6, 6),
    SEEDS    ("seeds", 4, 3, 3, 4),
    BLOODWORM("bloodworm", 5, 2, 2, 3),
    PEAS     ("peas", 2, 3, 2, 2),
    MEDICINE ("medicine", 10, 0, 0, 0),
	REVIVALMEDICINE ("revival medicine", 25, 0, 0, 0);
	
	private final String foodName;
    private final int price;
    private final int nutrition;
    private final int mealSize;
    private final int tastiness;
    
    Food(String name, int price, int nutrition, int mealSize, int tastiness) {
        this.foodName = name;
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
    
    @Override
    public String toString(){
    	return foodName;
    }
}
