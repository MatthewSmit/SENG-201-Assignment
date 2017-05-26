package seng201.assignment;

/**
 * Implements cat as a possible pet with distinct weight, playfulness,
 * roughness, hunger rate and tiredness rate attributes.
 */
final class Cat extends Pet {
    private static final float[] WEIGHT_RANGE = {2.5f, 11};
    private static final int[]  PLAYFULNESS_RANGE = {3, 9};
    private static final int[] ROUGHNESS_RANGE = {3, 7};
    private static final int[] HUNGER_RATE_RANGE = {2, 4};
    private static final int[] TIRED_RATE_RANGE = {2, 4};

    
    /**
     * Creates a pet cat.
     * @param name - name of the pet cat.
     * @param type - which type of pet it is.
     */
    Cat(final String name, final PetType type) {
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
