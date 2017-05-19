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
    public ToyType[] getFavouriteToy(){
		return new ToyType[] {ToyType.SMALLBALL, ToyType.GUINEAPIGWHEEL};
	}

	@Override
    public Food[] getFavouriteFood(){
		return new Food[] {Food.PEAS, Food.LETTUCE, Food.CARROT, Food.SEEDS};
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
