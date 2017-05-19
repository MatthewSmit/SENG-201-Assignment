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
	protected ToyType[] getFavouriteToy(){
		return new ToyType[] {ToyType.LARGEBALL, ToyType.SQUEAKYTOY, ToyType.SMALLBALL};
	}

	@Override
	protected Food[] getFavouriteFood(){
		return new Food[] {Food.STEAK, Food.TUNA};
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
