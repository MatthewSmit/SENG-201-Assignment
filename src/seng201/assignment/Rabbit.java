package seng201.assignment;

/**
 * Created by Matthew on 12/04/2017.
 */
public class Rabbit extends Pet {
	private static float[] weightRange = new float[] {1.5f, 2.5f};
	private static int[] playfulnessRange = new int[] {2, 5};
	private static int[] roughnessRange = new int[] {3, 6};
	private static int[] hungerRateRange = new int[] {1, 3};
	private static int[] tiredRateRange = new int[] {1, 2};

	public Rabbit(String name){
		super(name);
	}
	
	@Override
	public String getSpecies() {
        return "Rabbit";
    }

	@Override
	protected ToyType[] getFavouriteToy(){
		return new ToyType[] {ToyType.CARDBOARDBOX, ToyType.GUINEAPIGWHEEL,ToyType.SMALLBALL};
	}

	@Override
	protected Food[] getFavouriteFood(){
		return new Food[] {Food.CARROT, Food.LETTUCE, Food.PEAS};
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
