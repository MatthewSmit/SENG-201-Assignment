package seng201.assignment;

/**
 * Created by Matthew on 12/04/2017.
 */
public enum Toy {
	
	//price, durability = 1->10 (1 lowest, 10 highest)
	SMALLBALL(3, 3),
	LARGEBALL(5, 5),
	SQUEAKYTOY(8, 5),
	GUINEAPIGWHEEL(7,4),
	JUNGLEGYM(8,4),
	CARDBOARDBOX(1,2);
	
    private int price;
    private int durability;
    
    Toy(int price, int durability){
    	this.price = price;
    	this.durability = durability;
    }
    
    public void degrade(Pet pet) {
    	durability -= pet.getRoughness();
    	System.out.println(name().toLowerCase() + " has degraded to " + getDurability() + " durability.");
    }

    public boolean isBroken() {
    	if (durability <= 0){
    		System.out.println(name()  + " is broken!");
    	}
        return durability <= 0;
    }

    public int getPrice(){
        return price;
    }

    public int getDurability(){
        return durability;
    }
}
