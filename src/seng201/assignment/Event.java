package seng201.assignment;

import java.util.Random;

/**
 * Base event class, used for events that affect pets. 
 * Each event can only affect one pet per day, 
 * and each pet can only be affected by one event per day.
 */
public abstract class Event {
    private static Random random = new Random();

    /**
     * Loops through each players pets, testing if the event gets applied to them.
     * @param player - This players pets get tested for the event.
     */
    public void processPlayer(final Player player) {
        for (Pet pet : player.getPets()) {
            if (pet.getEventState() == Pet.EventState.NO_EVENT) {
                if (processPet(pet)) {
                    break;
                }
            }
        }
    }

    /**
     * Tests if the pet can have the event applied to them.
     * @param pet - The pet to test
     * @return true - if the event was applied to them, false - otherwise
     */
    protected abstract boolean processPet(Pet pet);

    /**
     * Linearly Interpolates a number between low and high based upon the amount.
     * @param low - The lowest value
     * @param high - The highest value
     * @param amount - the amount between [0, 1], where 0 will return low and 1 will return high
     */
    protected static float lerp(final float low, final float high, final float amount) {
        if (amount < 0) {
            return low;
        }
        if (amount > 1) {
            return high;
        }
        return low + (high - low) * amount;
    }
    
    /**
     * Returns a random float between [0, 1).
     * @return random number between [0, 1)
     */
    protected static float getRandom() {
        return random.nextFloat();
    }

    /**
     * 
     * @param seed - sets random to a predetermined seed to ensure repeatable results
     */
    static void setRandomSeed(final long seed) {
        random.setSeed(seed);
    }
}
