package seng201.assignment;

/**
 * Created by Matthew on 12/04/2017.
 */
public class Rabbit extends Pet {
    
	private float[] weightRange = new float[] {1.5f, 2.5f};
	private int[] playfulnessRange = new int[] {2, 5};
	private int[] roughnessRange = new int[] {3, 6};
	private int[] hungerRateRange = new int[] {1, 3};
	private int[] tiredRateRange = new int[] {1, 2};
	
	Rabbit(String name){
		super(name);
	}
	
	@Override
	protected String getSpecies() {
        return "Rabbit";
    }
    
	protected Toy[] getFavouriteToy(){
		return new Toy[] {Toy.CARDBOARDBOX, Toy.GUINEAPIGWHEEL,Toy.SMALLBALL};
	}
	
	protected Food[] getFavouriteFood(){
		return new Food[] {Food.CARROT, Food.LETTUCE, Food.PEAS};
	}

	protected float[] getSpeciesWeightRange(){
		return weightRange;
	}
	
	protected int[] getSpeciesPlayfulnessRange(){
		return playfulnessRange;
	}
	protected int[] getSpeciesRoughnessRange(){
		return roughnessRange;
	}
	protected int[] getSpeciesHungerRateRange(){
		return hungerRateRange;
	}
	protected int[] getSpeciesTiredRateRange(){
		return tiredRateRange;
	}
	
}
