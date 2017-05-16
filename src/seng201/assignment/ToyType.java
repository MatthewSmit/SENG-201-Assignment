package seng201.assignment;

/**
 * Created by Matthew on 12/04/2017.
 */
public enum ToyType {
	
	//price, durability = 1->10 (1 lowest, 10 highest)
	SMALLBALL     ("small ball", 3, 8),
	LARGEBALL     ("large ball", 5, 9),
	SQUEAKYTOY    ("squeaky toy", 8, 5),
	GUINEAPIGWHEEL("guinea pig wheel", 7, 7),
	JUNGLEGYM     ("jungle gym", 8, 5),
	CARDBOARDBOX  ("cardboard box", 1, 2);
	
	
	private final String toyName;
    private final int price;
    private final int durability;

	ToyType(String name, int price, int durability){
    	this.toyName = name;
		this.price = price;
    	this.durability = durability;
    }

    public int getPrice(){
        return price;
    }

    public int getDurability(){
        return durability;
    }
    
    public String toString(){
    	return toyName;
    }
}
