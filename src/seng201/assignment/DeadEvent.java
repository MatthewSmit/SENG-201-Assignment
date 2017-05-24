package seng201.assignment;

/**
 * The death event, which kills pets. A greater chance the more hungry, tired, toilet-needy and unhealthy a pet is.
 */
public final class DeadEvent extends Event {
	
	/**
	 * Processes a pet (at the end of a turn), to check if it dies.
	 * @param pet - the pet to be processed.
	 * @return true - if pet dies in the turn, false - if pet is already dead or does not die.
	 **/
    @Override
    protected boolean processPet(final Pet pet) {
        if (pet.isDead()) {
            return false;
        }

        float chance = lerp(0, 0.4f, (10 - pet.getHealth()) / 10.0f);

        if (getRandom() <= chance) {
            pet.die();

            return true;
        }

        return false;
    }
}
