package seng201.assignment;

/**
 * The death event, which kills pets. A greater chance the more hungry, tired, toiletneedy and unhealth a pet is.
 */
public final class DeadEvent extends Event {
    @Override
    protected boolean processPet(Pet pet) {
        if (pet.isDead())
            return false;
        
        // Pet has a higher chance the more it needs to eat, sleep, toilet and health
        // Ranges from 0% at 10 hunger, 10 tiredness, 10 toilet, 10 health to 100% at 20 hunger, 20 tiredness, 20 toilet, 0 health
        float chance = lerp(0, 0.2f, (pet.getHunger() - 10) / 10.0f) +
                lerp(0, 0.2f, (pet.getTiredness() - 10) / 10.0f) +
                lerp(0, 0.2f, (pet.getToiletNeed() - 10) / 10.0f) +
                lerp(0, 0.4f, (10 - pet.getHealth()) / 10.0f);

        if (random.nextFloat() <= chance) {
            pet.die();

            return true;
        }

        return false;
    }
}
