package seng201.assignment;

/**
 * Pet cat.
 */
final class Cat extends Pet {
    private static float[] weightRange = new float[] {2.5f, 11};
    private static int[]  playfulnessRange = new int[] {3, 9};
    private static int[] roughnessRange = new int[] {3, 7};
    private static int[] hungerRateRange = new int[] {2, 4};
    private static int[] tiredRateRange = new int[] {2, 4};

    Cat(final String name, final PetType type) {
        super(name, type);
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
