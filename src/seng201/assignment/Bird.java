package seng201.assignment;

/**
 * Pet Bird.
 */
public class Bird extends Pet {
	private static float[] weightRange = new float[] {0.15f, 0.6f};
	private static int[] playfulnessRange = new int[] {2, 6};
	private static int[] roughnessRange = new int[] {1, 4};
	private static int[] hungerRateRange = new int[] {1, 2};
	private static int[] tiredRateRange = new int[] {2,3};

	public Bird(String name, PetType type) {
		super(name, type);
	}

	@Override
	protected ToyType[] getFavouriteToy(){
		return new ToyType[] {ToyType.JUNGLEGYM, ToyType.GUINEAPIGWHEEL};
	}

	@Override
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
