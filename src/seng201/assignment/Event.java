package seng201.assignment;

import java.util.Random;

/**
 * Base event class, used for events that affect pets. Each event can only affect one pet per day, and each pet can only be effected by one event per day.
 */
public abstract class Event {
    protected static Random random = new Random();

    /**
     * Loops through each players pets, testing if the event gets applied to them.
     * @param player The player whos pets get tested for the event.
     */
    public void processPlayer(Player player) {
        for (Pet pet : player.getPets()) {
            if (pet.getEventState() == Pet.EventState.NoEvent) {
                if (processPet(pet)) {
                    break;
                }
            }
        }
    }

    /**
     * Tests if the pet can have the event applied to them.
     * @param pet The pet to test
     * @return True if the event was applied to them, false otherwise
     */
    protected abstract boolean processPet(Pet pet);

    protected static float lerp(float low, float high, float amount) {
        if (amount < 0)
            return low;
        if (amount > 1)
            return high;
        return low + (high - low) * amount;
    }
}
