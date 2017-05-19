package seng201.assignment;

/**
 * Created by Matthew on 12/04/2017.
 */
public class GuineaPig extends Pet {
	private static float[] weightRange = new float[] {0.5f, 1.5f};
	private static int[]  playfulnessRange = new int[] {2, 5};
	private static int[] roughnessRange = new int[] {2, 5};
	private static int[] hungerRateRange = new int[] {1, 3};
	private static int[] tiredRateRange = new int[] {1, 2};

	public GuineaPig(String name, PetType type) {
        super(name, type);
    }

	@Override
	protected ToyType[] getFavouriteToy(){
		return new ToyType[] {ToyType.SMALLBALL, ToyType.GUINEAPIGWHEEL};
	}

	@Override
	protected Food[] getFavouriteFood(){
		return new Food[] {Food.PEAS, Food.LETTUCE, Food.CARROT, Food.SEEDS};
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
