package seng201.assignment;

/**
 * Implements bird as a possible pet with distinct weight, playfulness,
 * roughness, hunger rate and tiredness rate attributes.
 */
final class Bird extends Pet {
    private static final float[] WEIGHT_RANGE = {0.15f, 0.6f};
    private static final int[] PLAYFULNESS_RANGE = {2, 6};
    private static final int[] ROUGHNESS_RANGE = {1, 4};
    private static final int[] HUNGER_RATE_RANGE = {1, 2};
    private static final int[] TIRED_RATE_RANGE = {2, 3};

    
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
        return WEIGHT_RANGE;
    }

    @Override
    public int[] getSpeciesPlayfulnessRange() {
        return PLAYFULNESS_RANGE;
    }

    @Override
    public int[] getSpeciesRoughnessRange() {
        return ROUGHNESS_RANGE;
    }

    @Override
    public int[] getSpeciesHungerRateRange() {
        return HUNGER_RATE_RANGE;
    }

    @Override
    public int[] getSpeciesTiredRateRange() {
        return TIRED_RATE_RANGE;
    }
}
