package seng201.assignment;

import java.util.Random;

/**
 * Implements a pet to be further extended by species subclasses,
 * contains the basic private attributes of a pet such as weight and gender,
 * methods for initializing these attributes, and abstract method declarations
 * used in the species subclasses.
 */
public abstract class Pet {
    /**
     * The death state.
     */
    public enum DeathState {
        /**
         * Pet is alive.
         */
        ALIVE,
        /**
         * Pet is alive and has died once.
         */
        ALIVE_WAS_DEAD,
        /**
         * Pet is dead and can be revived.
         */
        DEAD_ONCE,
        /**
         * Pet is permanently dead.
         */
        PERMANENTLY_DEAD
    }

    /**
     * The current event type that happened.
     */
    public enum EventState {
        /**
         * No Event.
         */
        NO_EVENT,
        /**
         * Pet is misbehaving.
         */
        MISBEHAVING,
        /**
         * Pet is sick.
         */
        SICK,
        /**
         * Pet is dead.
         */
        DEAD
    }

    /**
     * How much the toilet need contributes to weight.
     */
    private static final float FOOD_WEIGHT_MULTIPLIER = 0.01f;
    /**
     * How much a pet enjoys eating its favourite food.
     */
    private static final int BEST_FOOD_HAPPINESS = 5;
    /**
     * How much a pet enjoys eating good food.
     */
    private static final int GOOD_FOOD_HAPPINESS = 3;
    /**
     * How much the happiness decreases daily.
     */
    private static final int HAPPY_DECREASE_RATE = 3;
    /**
     * How much a pet enjoys playing with its favourite toy.
     */
    private static final int BEST_TOY_HAPPINESS = 5;
    /**
     * How much a pet enjoys playing with a good toy.
     */
    private static final int GOOD_TOY_HAPPINESS = 3;
    /**
     * How much a pet enjoys playing with a bad toy.
     */
    private static final int BAD_TOY_HAPPINESS = 1;
    /**
     * How much rest a pet gets from sleeping.
     */
    private static final int REST_AMOUNT = 8;
    /**
     * How much going toilet decreases toilet need.
     */
    private static final int TOILET_AMOUNT = 8;

    /**
     * How much hunger the pet starts with.
     */
    private static final int INITIAL_HUNGER = 0;

    /**
     * How much tiredness the pet starts with.
     */
    private static final int INITIAL_TIREDNESS = 0;

    /**
     * How much toilet-need the pet starts with.
     */
    private static final int INITIAL_TOILET_NEED = 0;

    /**
     * How much happiness the pet starts with.
     */
    private static final int INITIAL_HAPPINESS = 5;

    /**
     * How much health the pet starts with.
     */
    private static final int INITIAL_HEALTH = 10;

    /**
     * Field to randomise pet statistics.
     */
    private static Random rn = new Random();

    /**
     * How hungry the pet is.
     */
    private int hunger;
    /**
     * How tired the pet is.
     */
    private int tiredness;
    /**
     * How much the pet needs to go toilet.
     */
    private int toiletNeed;
    /**
     * How health the pet is, ranges from 0 (deathly ill) to 10 (perfectly health).
     */
    private int health;
    /**
     * How happy the pet is.
     */
    private int happiness;
    /**
     * If the pet has died before.
     */
    private DeathState deathState = DeathState.ALIVE;
    /**
     * The pets name.
     */
    private String name;

    /**
     * How quickly the pet gets hungry.
     */
    private int hungerRate;
    /**
     * How quickly the pet gets tired.
     */
    private int tiredRate;
    /**
     * TODO: ???
     */
    private final int playfulness;
    /**
     * How rough the pet is with toys.
     */
    private final int roughness;
    /**
     * Weight of the pet, represented in kg.
     */
    private float weight;


    private PetType type;
    /**
     * Gender of the pet. 
     */    
    private String gender;

    /**
     * The event that happened this turn, gets reset at the start of a new turn.
     */
    private EventState eventState = EventState.NO_EVENT;

    /**
     * If the pet is currently sick.
     */
    private boolean sick;
    /**
     * If the pet is misbehaving.
     */
    private boolean misbehaving;

    /**
     * Number of actions left in this round.
     */
    private int actionsLeft = 2;

    /**
     * Create a new pet.
     * @param petName - the name of the new pet
     * @param petType - the type of the new pet
     */
    protected Pet(final String petName, final PetType petType) {
        name = petName;
        type = petType;

        hunger = INITIAL_HUNGER;
        tiredness = INITIAL_TIREDNESS;
        toiletNeed = INITIAL_TOILET_NEED;
        health = INITIAL_HEALTH;
        happiness = INITIAL_HAPPINESS;
        playfulness = getSpeciesPlayfulness();
        roughness = getSpeciesRoughness();
        hungerRate = getSpeciesHungerRate();
        tiredRate = getSpeciesTiredRate();
        weight = getSpeciesInitialWeight();
        gender = getInitialGender();
    }

    /**
     * Processes changes of attributes when a day finishes.
     */
    final void dayPassed() {
        actionsLeft = 2;
        hunger += hungerRate;
        tiredness += tiredRate;

        happiness -= HAPPY_DECREASE_RATE;
        if (happiness < 0) {
            happiness = 0;
        }

        if (sick) {
            health--;
        }

        eventState = EventState.NO_EVENT;
    }

    /**
     * Feeds the pet some food. Decreases hunger, increases toilet need, and happiness if its a favoured food.
     * @param food - the food used to feed the pet
     */
    public void feed(final Food food) {
        assert !isDead();
        assert actionsLeft > 0;
        actionsLeft--;

        Food[] favourites = type.getFavouriteFoods();

        boolean mostFavourite = favourites[0] == food;
        boolean favourite = Lists.contains(favourites, food);

        hunger -= food.getNutrition();
        if (hunger < 0) {
            hunger = 0;
        }

        toiletNeed += food.getMealSize();

        if (favourite) {
            if (mostFavourite) {
                happiness += BEST_FOOD_HAPPINESS;
            } else {
                happiness += GOOD_FOOD_HAPPINESS;
            }
        }
    }

    /**
     * Plays with the pet, using a toy. Increases the pets happiness, 
     * more so if it is their favourite toy or one of their favourites.
     * @param toy the toy used to play with the pet
     */
    public void play(final Toy toy) {
        assert !isDead();
        assert actionsLeft > 0;
        actionsLeft--;

        Toy[] favourites = type.getFavouriteToys();

        boolean mostFavourite = favourites[0].equals(toy);
        boolean favourite = Lists.contains(favourites, toy);

        toy.degrade(this);

        if (favourite) {
            if (mostFavourite) {
                happiness += BEST_TOY_HAPPINESS;
            } else {
                happiness += GOOD_TOY_HAPPINESS;
            }
        } else {
            happiness += BAD_TOY_HAPPINESS;
        }

        if (happiness > 10) {
            happiness = 10;
        }

    }

    /**
     * Gets the pet to go to sleep for a turn, decreasing their tiredness.
     */
    public void sleep() {
        assert !isDead();
        assert actionsLeft > 0;
        actionsLeft--;

        tiredness -= REST_AMOUNT;
        if (tiredness < 0) {
            tiredness = 0;
        }
    }

    /**
     * Gets the pet to go to the toilet, decreasing their need to go to the toilet.
     */
    public void toilet() {
        assert !isDead();
        assert actionsLeft > 0;
        actionsLeft--;

        toiletNeed -= TOILET_AMOUNT;
        if (toiletNeed < 0) {
            toiletNeed = 0;
        }
    }

    /**
     * Cures the sickness the pet has, increasing their happiness.
     */
    public void cure() {
        assert sick;
        sick = false;
        happiness += 2;
    }


    /**
     * Pet is punished for misbehaving, decreasing their happiness.
     */
    public void fixMisbehaving() {
        if (!misbehaving) {
            throw new IllegalStateException();
        } else {
            eventState = EventState.NO_EVENT;
            misbehaving = false;
            happiness -= 2;
        }
    }

    /**
     * Pet starts to misbehave.
     */
    final void startMisbehaving() {
        if (eventState != EventState.NO_EVENT) {
            throw new IllegalStateException();
        }

        eventState = EventState.MISBEHAVING;
        misbehaving = true;
    }

    /**
     * Pet becomes sick, decreasing their healthiness.
     */
    final void startBeingSick() {
        if (eventState != EventState.NO_EVENT) {
            throw new IllegalStateException();
        }

        eventState = EventState.SICK;
        sick = true;
        health--;
    }

    /**
     * Kills the pet, either setting it to once-dead if it is the first time the pet has died
     * or permanently-dead if it is the second.
     */
    public void die() {
        assert deathState == DeathState.ALIVE || deathState == DeathState.ALIVE_WAS_DEAD;

        eventState = EventState.DEAD;
        if (deathState == DeathState.ALIVE) {
            deathState = DeathState.DEAD_ONCE;
        } else {
            deathState = DeathState.PERMANENTLY_DEAD;
        }
    }

    /**
     * Revives a pet, can only be done once.
     */
    public void revive() {
        assert deathState == DeathState.DEAD_ONCE;
        deathState = DeathState.ALIVE_WAS_DEAD;

        hunger = INITIAL_HUNGER;
        tiredness = INITIAL_TIREDNESS;
        toiletNeed = INITIAL_TOILET_NEED;
        health = INITIAL_HEALTH;
        happiness = INITIAL_HAPPINESS;
        sick = false;
        misbehaving = false;
    }

    /**
     * Gets the pets hunger.
     * @return hunger - how hungry the pet is (0 to 10). Varies over time.
     */
    public int getHunger() {
        return hunger;
    }

    /**
     * Gets the pets tiredness.
     * @return tiredness - how tired the pet is (0 to 10). Varies over time.
     */
    public int getTiredness() {
        return tiredness;
    }

    /**
     * Gets how playful the pet is.
     * @return playfulness - how playful the pet is (0 to 10). Constant value.
     */
    public int getPlayfulness() {
        return playfulness;
    }

    /**
     * Gets how rough the pet is with toys.
     * @return roughness - how rough the pet is (0 to 10) with toys. Constant value.
     */
    public int getRoughness() {
        return roughness;
    }

    /**
     * Gets how much the pet needs to go to the toilet.
     * @return toiletNeed - how much the pet needs to go to the toilet (0 to 10). Varies over time.
     */
    public int getToiletNeed() {
        return toiletNeed;
    }

    /**
     * Gets how healthy the pet is.
     * @return health - how healthy the pet currently is (0 to 10). Varies over time.
     */
    public int getHealth() {
        return health;
    }

    /**
     * Gets how happy the pet is. Chance of misbehaving if over 5.
     * @return happiness - how happy the pet currently is (0 to 10). Varies over time.
     */
    public int getHappiness() {
        return happiness;
    }

    /**
     * Gets how much the pet weighs. Range of initial weights is constrained by species.
     * @return weight - how heavy the pet currently is. Varies over time.
     */
    public float getWeight() {
        return weight + toiletNeed * FOOD_WEIGHT_MULTIPLIER;
    }

    /**
     * Gets whether the pet has died once, or is dead permanently.
     * @return DeathState.ALIVE - if pet has never died, 
     * DeathState.DEAD_ONCE -  if pet has died for the first time, 
     * DeathState.ALIVE_WAS_DEAD - if pet has died once and been revived,
     * DeathState.PERMANENTLY_DEAD - if pet has died once and died again.
     */
    public DeathState getDeathState() {
        return deathState;
    }

    /**
     * Gets if there is a new event this turn.
     * @return EventState.NO_EVENT - if the pet has neither started to misbehave, become sick or die in a turn,
     * EventState.MISBEHAVING - if the pet begins to misbehave in a turn,
     * EventState.SICK - if the pet becomes sick in a turn,
     * EventState.DEAD - if the pet dies in a turn.
     */
    public EventState getEventState() {
        return eventState;
    }

    /**
     * Gets if the pet is currently sick.
     * @return true - if pet is currently sick, false - if pet is not currently sick.
     */
    public boolean isSick() {
        return sick;
    }

    /**
     * Gets if the pet is currently misbehaving.
     * @return true - if pet is currently misbehaving, false - if pet is not currently misbehaving.
     */
    public boolean isMisbehaving() {
        return misbehaving;
    }

    /**
     * Gets the name of the pet.
     * @return name - name of the pet as a string.
     */
    public String getName() {
        return name;
    }


    /**
     * Gets the gender of the pet.
     * @return gender - "male" if pet is male, "female" if pet is female.
     */
    public String getGender() {
        return gender;
    }


    /**
     * Gets the actions remaining in a turn.
     * @return actionsLeft - number of actions left in a turn.
     */
    public int getActionsLeft() {
        return actionsLeft;
    }

    /**
     * Gets the type of the pet.
     * @return type - type of the pet.
     */
    public PetType getType() {
        return type;
    }

    /**
     * Gets the species of the pet.
     * @return species - species of the pet as a string.
     */
    public String getSpecies() {
        return type.getName();
    }

    /**
     * Gets the weight range of the species.
     * @return weightRange - range of weight of the species.
     */
    public abstract float[] getSpeciesWeightRange();

    /**
   	 * Gets the range of playfulness for a species.
     * @return playfulnessRange - the playfulness range of the species.
     */
    public abstract int[] getSpeciesPlayfulnessRange();

    /**
   	 * Gets the range of roughness for a species.
     * @return roughnessRange - the roughness range of the species.
     */
    public abstract int[] getSpeciesRoughnessRange();

    /**
   	 * Gets the range of rates at which hunger increases per day for a species.
     * @return hungerRateRange - the range of rates at which hunger increases per day for a species.
     */
    public abstract int[] getSpeciesHungerRateRange();

    /**
   	 * Gets the range of rates at which tiredness increases per day for a species.
     * @return tiredRateRange - the range of rates at which tiredness increases per day for a species.
     */
    public abstract int[] getSpeciesTiredRateRange();

    /**
     * Gets how playful a pet of a certain species is.
     * @return playfulness - how playful a pet of a certain species is.
     */
    private int getSpeciesPlayfulness() {
        int[] playfulnessRange = getSpeciesPlayfulnessRange();
        return rn.nextInt(playfulnessRange[1] - playfulnessRange[0] + 1) + playfulnessRange[0];
    }

    /**
     * Gets how rough a pet of a certain species is.
     * @return roughness - how playful a pet of a certain species is.
     */
    private int getSpeciesRoughness() {
        int[] roughnessRange = getSpeciesRoughnessRange();
        return rn.nextInt(roughnessRange[1] - roughnessRange[0] + 1) + roughnessRange[0];
    }

    /**
     * Gets the rate at which hunger increases for a pet of a certain species.
     * @return hungerRate - the rate at which hungriness increases for a pet of a certain species.
     */
    private int getSpeciesHungerRate() {
        int[] hungerRateRange = getSpeciesHungerRateRange();
        return rn.nextInt(hungerRateRange[1] - hungerRateRange[0] + 1) + hungerRateRange[0];
    }


    /**
     * Gets the rate at which tiredness increases for a pet of a certain species.
     * @return tiredRate - the rate at which tiredness increases for a pet of a certain species.
     */
    private int getSpeciesTiredRate() {
        int[] tiredRateRange = getSpeciesTiredRateRange();
        return rn.nextInt(tiredRateRange[1] - tiredRateRange[0] + 1) + tiredRateRange[0];
    }

    /**
     * Gets the initial weight of a pet of a certain species.
     * @return initialWeight - the initial weight for a pet of a certain species.
     */
    private float getSpeciesInitialWeight() {
        float[] weightRange = getSpeciesWeightRange();
        return rn.nextFloat() * (weightRange[1] - weightRange[0]) + weightRange[0];
    }

    /**
     * Gets the gender of a pet.
     * @return "male" - if the pet is male, "female" - if the pet is female.
     */
    private static String getInitialGender() {
        if (Math.random() >= 0.5) {
            return "male";
        }
        return "Female";
    }

    /**
     * Returns true if the pet is currently dead, false if not.
     * @return true - if the pet is currently dead, false - if the pet is currently alive.
     */
    public boolean isDead() {
        return deathState == DeathState.DEAD_ONCE || deathState == DeathState.PERMANENTLY_DEAD; 
    }

    /**
     * gets the Random object rn.
     * @return rn - a Random object.
     */
    final Random getRandom() {
        return rn;
    }
}
