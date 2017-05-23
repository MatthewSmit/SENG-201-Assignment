package seng201.assignment;

/**
 * The misbehaving event, sets the pet to misbehave. A greater chance the more unhappy the pet is.
 */
public final class MisbehaveEvent extends Event {
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
