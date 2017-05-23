package seng201.assignment;

/**
 * The sickness event, sets the pet to be sick. A greater chance the more hungry, tired and toilet-needy the pet is.
 */
public final class SicknessEvent extends Event {
    @Override
    protected boolean processPet(final Pet pet) {
        if (pet.isSick() || pet.isDead()) {
            return false;
        }

        // Pet has a higher chance the more it needs to eat, sleep and toilet
        // Ranges from 0% at 5 hunger, 5 tiredness, 5 toilet to 60% at 15 hunger, 15 tiredness, 15 toilet
        float chance = lerp(0, 0.2f, (pet.getHunger() - 5) / 10.0f)
                + lerp(0, 0.2f, (pet.getTiredness() - 5) / 10.0f)
                + lerp(0, 0.2f, (pet.getToiletNeed() - 5) / 10.0f);

        if (getRandom() <= chance) {
            pet.startBeingSick();

            return true;
        }

        return false;
    }
}
