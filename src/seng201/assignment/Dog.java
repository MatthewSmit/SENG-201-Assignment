package seng201.assignment;

/**
 * Created by Matthew on 12/04/2017.
 */
public class Dog extends Pet {
	private static float[] weightRange = new float[] {20, 40};
	private static int[] playfulnessRange = new int[] {3, 10};
	private static int[] roughnessRange = new int[] {5, 10};
	private static int[] hungerRateRange = new int[] {3, 4};
	private static int[] tiredRateRange = new int[] {2, 4};

	public Dog(String name) {
		super(name);
	}

	@Override
	public String getSpecies() {
        return "Dog";
    }

    @Override
	protected Toy[] getFavouriteToy(){
		return new Toy[] {Toy.LARGEBALL, Toy.SQUEAKYTOY, Toy.SMALLBALL};
	}

	@Override
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
