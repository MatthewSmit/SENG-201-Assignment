package seng201.assignment;

/**
 * Created by Matthew on 12/04/2017.
 */
public class Bird extends Pet {
    
	
	private float[] weightRange = new float[] {0.15f, 0.6f};
	private int[] playfulnessRange = new int[] {2, 6};
	private int[] roughnessRange = new int[] {1, 4};
	private int[] hungerRateRange = new int[] {1, 2};
	private int[] tiredRateRange = new int[] {2,3};
	
	
	Bird(String name){
		super(name);
	}
	
	@Override
	protected String getSpecies() {
        return "Bird";
    }
	
	protected Toy[] getFavouriteToy(){
		return new Toy[] {Toy.JUNGLEGYM, Toy.GUINEAPIGWHEEL};
	}
	
	protected Food[] getFavouriteFood(){
		return new Food[] {Food.SEEDS, Food.BLOODWORM, Food.PEAS};
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
