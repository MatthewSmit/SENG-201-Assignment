package seng201.assignment;

/**
 * Created by Matthew on 12/04/2017.
 */
final class GuineaPig extends Pet {
    private static float[] weightRange = new float[] {0.5f, 1.5f};
    private static int[]  playfulnessRange = new int[] {2, 5};
    private static int[] roughnessRange = new int[] {2, 5};
    private static int[] hungerRateRange = new int[] {1, 3};
    private static int[] tiredRateRange = new int[] {1, 2};

    GuineaPig(final String name, final PetType type) {
        super(name, type);
    }

    @Override
    public Toy[] getFavouriteToy() {
        return new Toy[] {Toy.SMALLBALL, Toy.GUINEAPIGWHEEL};
    }

    @Override
    public Food[] getFavouriteFood() {
        return new Food[] {Food.PEAS, Food.LETTUCE, Food.CARROT, Food.SEEDS};
    }

    @Override
    public float[] getSpeciesWeightRange() {
        return weightRange;
    }

    @Override
    public int[] getSpeciesPlayfulnessRange() {
        return playfulnessRange;
    }

    @Override
    public int[] getSpeciesRoughnessRange() {
        return roughnessRange;
    }

    @Override
    public int[] getSpeciesHungerRateRange() {
        return hungerRateRange;
    }

    @Override
    public int[] getSpeciesTiredRateRange() {
        return tiredRateRange;
    }

}
