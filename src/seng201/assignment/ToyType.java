package seng201.assignment;

/**
 * Created by Matthew on 12/04/2017.
 */
public enum ToyType {
	
	//price, durability = 1->10 (1 lowest, 10 highest)
	SMALLBALL     (3, 8),
	LARGEBALL     (5, 9),
	SQUEAKYTOY    (8, 5),
	GUINEAPIGWHEEL(7, 7),
	JUNGLEGYM     (8, 5),
	CARDBOARDBOX  (1, 2);
	
    private final int price;
    private final int durability;

	ToyType(int price, int durability){
    	this.price = price;
    	this.durability = durability;
    }

    public int getPrice(){
        return price;
    }

    public int getDurability(){
        return durability;
    }
}
