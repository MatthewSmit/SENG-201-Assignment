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

	public Cat(String name, PetType type) {
        super(name, type);
    }

	@Override
    public ToyType[] getFavouriteToy(){
		return new ToyType[] {ToyType.CARDBOARDBOX, ToyType.SMALLBALL};
	}

	@Override
    public Food[] getFavouriteFood(){
		return new Food[] {Food.TUNA, Food.STEAK};
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
