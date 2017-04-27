package seng201.assignment;

/**
 * Created by Matthew on 12/04/2017.
 */
public enum Toy {
	
	//price, durability = 1->10 (1 lowest, 10 highest)
	SMALLBALL     (3, 8),
	LARGEBALL     (5, 9),
	SQUEAKYTOY    (8, 5),
	GUINEAPIGWHEEL(7, 7),
	JUNGLEGYM     (8, 5),
	CARDBOARDBOX  (1, 2);
	
    private final int price;
    private int durability;

    
    Toy(int price, int durability){
    	this.price = price;
    	this.durability = durability;
    }
    
    public void degrade(Pet pet) {
    	
    	if (this.durability <= 0){
    		throw new UnsupportedOperationException("Can't play with a broken toy!");
    	}
    	
    	else if (this.durability - pet.getRoughness() < 0){
    		this.durability = 0; 		
    	}
    	
    	else {
    		this.durability = durability-pet.getRoughness();
    	}
    	
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
