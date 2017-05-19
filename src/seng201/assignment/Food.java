package seng201.assignment;

/**
 * Created by Matthew on 12/04/2017.
 */
public class Food extends Item {
    public static final Food CARROT          = new Food("carrot", 2, 3, 3, 3);
    public static final Food TUNA            = new Food("tuna", 6, 5, 4, 5);
    public static final Food LETTUCE         = new Food("lettuce", 2, 2, 3, 2);
    public static final Food STEAK           = new Food("steak", 8, 7, 6, 6);
    public static final Food SEEDS           = new Food("seeds", 4, 3, 3, 4);
    public static final Food BLOODWORM       = new Food("bloodworm", 5, 2, 2, 3);
    public static final Food PEAS            = new Food("peas", 2, 3, 2, 2);
    public static final Food MEDICINE        = new Food("medicine", 10, 0, 0, 0);
    public static final Food REVIVALMEDICINE = new Food("revival medicine", 25, 0, 0, 0);
    
    private static final Food[] values = new Food[]{
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
    
    private Food(String name, int price, int nutrition, int mealSize, int tastiness) {
        this.foodName = name;
    	this.price = price;
        this.nutrition = nutrition;
        this.mealSize = mealSize;
        this.tastiness = tastiness;
    }

    @Override
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
    
    public static Food[] values() {
        return values;
    }
}
