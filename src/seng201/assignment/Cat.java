package seng201.assignment;

/**
 * Created by Matthew on 12/04/2017.
 */
public class Cat extends Pet {
	
	private static float[] weightRange = new float[] {2.5f, 11};
	private static int[]  playfulnessRange = new int[] {3, 9};
	private static int[] roughnessRange = new int[] {3, 7};
	private static int[] hungerRateRange = new int[] {2, 4};
	private static int[] tiredRateRange = new int[] {2, 4};

	public Cat(String name){
		super(name);
	}
	
	@Override
	public String getSpecies() {
        return "Cat";
    }
	
	protected Toy[] getFavouriteToy(){
		return new Toy[] {Toy.CARDBOARDBOX, Toy.SMALLBALL};
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
