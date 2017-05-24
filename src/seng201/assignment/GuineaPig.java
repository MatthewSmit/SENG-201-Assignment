package seng201.assignment;

/**
 * Implements guinea pig as a possible pet with distinct weight, playfulness,
 * roughness, hunger rate and tiredness rate attributes.
 */
final class GuineaPig extends Pet {
    private static float[] weightRange = new float[] {0.5f, 1.5f};
    private static int[]  playfulnessRange = new int[] {2, 5};
    private static int[] roughnessRange = new int[] {2, 5};
    private static int[] hungerRateRange = new int[] {1, 3};
    private static int[] tiredRateRange = new int[] {1, 2};

    
    /**
     * Creates a pet guinea pig.
     * @param name - name of the pet guinea pig.
     * @param type - which type of pet it is.
     */
    GuineaPig(final String name, final PetType type) {
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
