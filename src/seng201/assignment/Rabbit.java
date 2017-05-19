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

	public Rabbit(String name, PetType type) {
        super(name, type);
    }

	@Override
    public Toy[] getFavouriteToy(){
		return new Toy[] {Toy.CARDBOARDBOX, Toy.GUINEAPIGWHEEL,Toy.SMALLBALL};
	}

	@Override
    public Food[] getFavouriteFood(){
		return new Food[] {Food.CARROT, Food.LETTUCE, Food.PEAS};
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
