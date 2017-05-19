package seng201.assignment;

/**
 * Pet Dog.
 */
public class Dog extends Pet {
	private static float[] weightRange = new float[] {20, 40};
	private static int[] playfulnessRange = new int[] {3, 10};
	private static int[] roughnessRange = new int[] {5, 10};
	private static int[] hungerRateRange = new int[] {3, 4};
	private static int[] tiredRateRange = new int[] {2, 4};

	public Dog(String name, PetType type) {
        super(name, type);
    }

    @Override
    public Toy[] getFavouriteToy(){
		return new Toy[] {Toy.LARGEBALL, Toy.SQUEAKYTOY, Toy.SMALLBALL};
	}

	@Override
    public Food[] getFavouriteFood(){
		return new Food[] {Food.STEAK, Food.TUNA};
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
