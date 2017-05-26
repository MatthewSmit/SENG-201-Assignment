package seng201.assignment;

/**
 * The sickness event, which makes the pet sick. 
 * A greater chance of death the more hungry, tired and toilet-needy a pet is.
 */
public final class SicknessEvent extends Event {

    /**
     * Processes a pet at the end of the turn to check if it becomes sick.
     * @param pet - the pet to be processed.
     * @return true - if pet becomes sick in the turn, false - if pet is already sick or does not become sick.
     **/
    @Override
    protected boolean processPet(final Pet pet) {
        if (pet.isSick() || pet.isDead()) {
            return false;
        }

        float chance = lerp(0, 0.2f, (pet.getHunger() - 10) / 10.0f)
                + lerp(0, 0.2f, (pet.getTiredness() - 10) / 10.0f)
                + lerp(0, 0.2f, (pet.getToiletNeed() - 10) / 10.0f);

        if (getRandom() <= chance) {
            pet.startBeingSick();

            return true;
        }

        return false;
    }
}
