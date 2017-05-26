package seng201.assignment;

/**
 * Implements cat as a possible pet with distinct weight, playfulness,
 * roughness, hunger rate and tiredness rate attributes.
 */
final class Cat extends Pet {
    private static final float[] weightRange = {2.5f, 11};
    private static final int[]  playfulnessRange = {3, 9};
    private static final int[] roughnessRange = {3, 7};
    private static final int[] hungerRateRange = {2, 4};
    private static final int[] tiredRateRange = {2, 4};

    
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
