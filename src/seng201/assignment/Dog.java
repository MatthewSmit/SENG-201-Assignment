package seng201.assignment;

/**
 * Created by Matthew on 12/04/2017.
 */
public class Dog extends Pet {
    
	private float[] weightRange = new float[] {20, 40};
	private int[]  playfulnessRange = new int[] {3, 10};
	private int[] roughnessRange = new int[] {5, 10};
	private int[] hungerRateRange = new int[] {3, 4};
	private int[] tiredRateRange = new int[] {2, 4};
	
	Dog(String name){
		super(name);
	}
	
	
	@Override
	protected String getSpecies() {
        return "Dog";
    }
	
	protected Toy[] getFavouriteToy(){
		return new Toy[] {Toy.LARGEBALL, Toy.SQUEAKYTOY, Toy.SMALLBALL};
	}
	
	protected Food[] getFavouriteFood(){
		return new Food[] {Food.TUNA, Food.STEAK};
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
