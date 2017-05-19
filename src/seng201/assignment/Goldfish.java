package seng201.assignment;

/**
 * Created by Matthew on 12/04/2017.
 */
public class Goldfish extends Pet {
	private static float[] weightRange = new float[] {0.1f, 1.1f};
	private static int[]  playfulnessRange = new int[] {2, 4};
	private static int[] roughnessRange = new int[] {1, 3};
	private static int[] hungerRateRange = new int[] {1, 2};
	private static int[] tiredRateRange = new int[] {1, 2};

	public Goldfish(String name, PetType type) {
        super(name, type);
    }

	protected ToyType[] getFavouriteToy(){
		return new ToyType[] {ToyType.SMALLBALL};
	}

	@Override
	protected Food[] getFavouriteFood(){
		return new Food[] {Food.BLOODWORM, Food.LETTUCE, Food.PEAS};
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
