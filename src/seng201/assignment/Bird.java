package seng201.assignment;

/**
 * Implements bird as a possible pet with distinct weight, playfulness,
 * roughness, hunger rate and tiredness rate attributes.
 */
final class Bird extends Pet {
    private static final float[] weightRange = {0.15f, 0.6f};
    private static final int[] playfulnessRange = {2, 6};
    private static final int[] roughnessRange = {1, 4};
    private static final int[] hungerRateRange = {1, 2};
    private static final int[] tiredRateRange = {2, 3};

    
    /**
     * Creates a pet bird.
     * @param name - name of the pet bird.
     * @param type - which type of pet it is.
     */
    Bird(final String name, final PetType type) {
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