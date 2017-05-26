package seng201.assignment;

/**
 * Implements dog as a possible pet with distinct weight, playfulness,
 * roughness, hunger rate and tiredness rate attributes.
 */
final class Dog extends Pet {
    private static final float[] WEIGHT_RANGE = {20, 40};
    private static final int[] PLAYFULNESS_RANGE = {3, 10};
    private static final int[] ROUGHNESS_RANGE = {5, 10};
    private static final int[] HUNGER_RATE_RANGE = {3, 4};
    private static final int[] TIRED_RATE_RANGE = {2, 4};

    /**
     * Creates a pet dog.
     * @param name - name of the pet dog.
     * @param type - which type of pet it is.
     */
    Dog(final String name, final PetType type) {
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
