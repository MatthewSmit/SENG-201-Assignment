package seng201.assignment;

import java.util.Random;

/**
 * The pet base class, handles most statistics information and logic changes.
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
        NoEvent,
        /**
         * Pet is misbehaving.
         */
        Misbehaving,
        /**
         * Pet is sick.
         */
        Sick,
        /**
         * Pet is dead.
         */
        Dead
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
    private static final int GOOD_FOOD_HAPPINESS = 2;
    /**
     * How much the happiness decreases daily.
     */
    private static final int HAPPY_DECREASE_RATE = 5;
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
    private static final int REST_AMOUNT = 4;
    /**
     * How much the toilet rate increases daily.
     */
    private static final int TOILET_RATE = 4;
    
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
    private EventState eventState = EventState.NoEvent;

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
     * @param petName the name of the new pet
     * @param petType the type of the new pet
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
     * Processes stat changes when the day changes.
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

        eventState = EventState.NoEvent;

        // TODO: Misbehaving action? Such as toilet, eating or playing without being told
    }

    /**
     * Feeds the pet some food. Decreases hunger, increases toilet need, and happiness if its a favoured toy.
     * @param food the food used to feed the pet
     */
    public void feed(final Food food) {
        assert !isDead();
        assert actionsLeft > 0;
        actionsLeft--;

        Food[] favourites = getFavouriteFood();

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
     * Plays with the pet, using a toy. Increases the pets happiness.
     * @param toy the toy used to play with the pet
     */
    public void play(final Toy toy) {
        assert !isDead();
        assert actionsLeft > 0;
        actionsLeft--;

        Toy[] favourites = getFavouriteToy();

        boolean mostFavourite = favourites[0] == toy;
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

        //TODO: Make them get more tired/hungry depending on how vigorous the play is
    }

    /**
     * Gets the pet to go to sleep, restoring its tiredness.
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
     * Gets the pet to go to the toilet, restoring its toilet need.
     */
    public void toilet() {
        assert !isDead();
        assert actionsLeft > 0;
        actionsLeft--;

        toiletNeed -= TOILET_RATE;
        if (toiletNeed < 0) {
            toiletNeed = 0;
        }
    }
    
    /**
     * Cures the sickness the pet has.
     */
    public void cure() {
        assert sick;
        sick = false;
    }

    final void startMisbehaving() {
        if (eventState != EventState.NoEvent) {
            throw new IllegalStateException();
        }

        eventState = EventState.Misbehaving;
        misbehaving = true;
    }

    final void startBeingSick() {
        if (eventState != EventState.NoEvent) {
            throw new IllegalStateException();
        }

        eventState = EventState.Sick;
        sick = true;
        health--;
    }

    /**
     * Kills the pet, either setting it to once-dead, or permanently-dead.
     */
    public void die() {
        assert deathState == DeathState.ALIVE || deathState == DeathState.ALIVE_WAS_DEAD;

        eventState = EventState.Dead;
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
     * Gets the pets hunger. [0-5] is fed, [6-15] is dangerous.
     */
    public int getHunger() {
        return hunger;
    }

    /**
     * Gets the pets tiredness. [0-5] is awake, [6-15] is dangerous.
     */
    public int getTiredness() {
        return tiredness;
    }

    /**
     * Gets how playful the pet is.
     */
    public int getPlayfulness() {
        return playfulness;
    }

    /**
     * Gets how rough while playing the pet is.
     */
    public int getRoughness() {
        return roughness;
    }

    /**
     * Gets how much the pet needs to go toilet. [0-5] is well toileted, [6-15] is dangerous.
     */
    public int getToiletNeed() {
        return toiletNeed;
    }

    /**
     * Gets how healthy the pet is, with 0 being critical and 10 being healthy.
     */
    public int getHealth() {
        return health;
    }

    /**
     * Gets how happy the pet is. Has a chance of misbehaving above 5.
     */
    public int getHappiness() {
        return happiness;
    }

    /**
     * Gets how heavy the pet is in kg.
     */
    public float getWeight() {
        return weight + toiletNeed * FOOD_WEIGHT_MULTIPLIER;
    }

    /**
     * Gets whether the pet has died once, or is dead permanently.
     */
    public DeathState getDeathState() {
        return deathState;
    }

    /**
     * Gets if there is a new event this turn.
     */
    public EventState getEventState() {
        return eventState;
    }

    /**
     * Gets if the pet is currently sick.
     */
    public boolean isSick() {
        return sick;
    }

    /**
     * Gets if the pet is currently misbehaving.
     */
    public boolean isMisbehaving() {
        return misbehaving;
    }

    /**
     * Gets the name of the pet.
     */
    public String getName() {
        return name;
    }


    /**
     * Gets the gender of the pet.
     */
    public String getGender() {
        return gender;
    }


    /**
     * Gets the actions remaining.
     */
    public int getActionsLeft() {
        return actionsLeft;
    }

    /**
     * Gets the type of pet.
     */
    public PetType getType() {
        return type;
    }

    /**
     * Gets the species of the pet.
     */
    public String getSpecies() {
        return type.getName();
    }

    /**
     * Gets the favourite toys.
     */
    public abstract Toy[] getFavouriteToy();

    /**
     * Gets the favourite food.
     */
    public abstract Food[] getFavouriteFood();

    /**
     * Gets the weight range of the species.
     */
    public abstract float[] getSpeciesWeightRange();

    /***
     * Gets the playfulness range of the species.
     */
    public abstract int[] getSpeciesPlayfulnessRange();

    /**
     * Gets the roughness range of the species.
     */
    public abstract int[] getSpeciesRoughnessRange();

    /**
     * Gets the hunger rate range of the species.
     */
    public abstract int[] getSpeciesHungerRateRange();

    /**
     * Gets the tired rate range of the species.
     */
    public abstract int[] getSpeciesTiredRateRange();

    /**
     * Gets how playful a pet of a certain species is.
     */
    private int getSpeciesPlayfulness() {
        int[] playfulnessRange = getSpeciesPlayfulnessRange();
        return rn.nextInt(playfulnessRange[1] - playfulnessRange[0] + 1) + playfulnessRange[0];
    }
    
    /**
     * Gets how rough a pet of a certain species is.
     */
    private int getSpeciesRoughness() {
        int[] roughnessRange = getSpeciesRoughnessRange();
        return rn.nextInt(roughnessRange[1] - roughnessRange[0] + 1) + roughnessRange[0];
    }

    /**
     * Gets the rate that hunger increases for a pet of a certain species.
     */
    private int getSpeciesHungerRate() {
        int[] hungerRateRange = getSpeciesHungerRateRange();
        return rn.nextInt(hungerRateRange[1] - hungerRateRange[0] + 1) + hungerRateRange[0];
    }

    
    /**
     * Gets the rate tiredness increases for a pet of a certain species.
     */
    private int getSpeciesTiredRate() {
        int[] tiredRateRange = getSpeciesTiredRateRange();
        return rn.nextInt(tiredRateRange[1] - tiredRateRange[0] + 1) + tiredRateRange[0];
    }

    /**
     * Gets the initial weight of a pet of a certain species.
     */
    private float getSpeciesInitialWeight() {
        float[] weightRange = getSpeciesWeightRange();
        float initialWeight = rn.nextFloat() * (weightRange[1] - weightRange[0]) + weightRange[0];
        return initialWeight;
    }

    /**
     * Gets the gender of a pet.
     */
    private static String getInitialGender() {
        if (Math.random() >= 0.5) {
            return "male";
        }
        return "female";
    }

    /**
     * Returns true if the pet is currently dead, false if not.
     */
    public boolean isDead() {
        return deathState == DeathState.DEAD_ONCE || deathState == DeathState.PERMANENTLY_DEAD; 
    }

    final Random getRandom() {
        return rn;
    }
}
