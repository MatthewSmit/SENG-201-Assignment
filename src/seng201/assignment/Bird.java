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
    public Toy[] getFavouriteToy(){
		return new Toy[] {Toy.JUNGLEGYM, Toy.GUINEAPIGWHEEL};
	}

	@Override
    public Food[] getFavouriteFood(){
		return new Food[] {Food.SEEDS, Food.BLOODWORM, Food.PEAS};
	}
	
	public float[] getSpeciesWeightRange(){
		return weightRange;
	}
	
	public int[] getSpeciesPlayfulnessRange(){
		return playfulnessRange;
	}
	public int[] getSpeciesRoughnessRange(){
		return roughnessRange;
	}
	public int[] getSpeciesHungerRateRange(){
		return hungerRateRange;
	}
	public int[] getSpeciesTiredRateRange(){
		return tiredRateRange;
	}
}
