package seng201.assignment;

/**
 * The misbehaving event, sets the pet to misbehave. A greater chance the more unhappy the pet is.
 */
public final class MisbehaveEvent extends Event {

    /**
     * Processes a pet (at the end of a turn), to check if it becomes sick.
     * @param pet - the pet to be processed.
     * @return true - if pet starts misbehaving in the turn, false - if pet is already misbehaving or pet does not misbehave.
     */
    @Override
    protected boolean processPet(final Pet pet) {
        if (pet.isMisbehaving() || pet.isDead()) {
            return false;
        }

        float chance = lerp(0, 0.25f, (5 - pet.getHappiness()) / 5.0f);
        if (getRandom() <= chance) {
            pet.startMisbehaving();

            return true;
        }

        return false;
    }
}
