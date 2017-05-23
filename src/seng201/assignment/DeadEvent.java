package seng201.assignment;

/**
 * The death event, which kills pets. A greater chance the more hungry, tired, toilet-needy and unhealthy a pet is.
 */
public final class DeadEvent extends Event {
    @Override
    protected boolean processPet(final Pet pet) {
        if (pet.isDead()) {
            return false;
        }
        
        // Pet has a higher chance the sicker it is
        // Ranges from 0% at 10 health to 40% at 0 health
        float chance = lerp(0, 0.4f, (10 - pet.getHealth()) / 10.0f);

        if (getRandom() <= chance) {
            pet.die();

            return true;
        }

        return false;
    }
}
