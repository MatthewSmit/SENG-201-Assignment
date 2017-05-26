package seng201.assignment;

/**
 * Implements dog as a possible pet with distinct weight, playfulness,
 * roughness, hunger rate and tiredness rate attributes.
 */
final class Dog extends Pet {
    private static final float[] weightRange = {20, 40};
    private static final int[] playfulnessRange = {3, 10};
    private static final int[] roughnessRange = {5, 10};
    private static final int[] hungerRateRange = {3, 4};
    private static final int[] tiredRateRange = {2, 4};

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
