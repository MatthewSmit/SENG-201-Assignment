package seng201.assignment;

/**
 * Implements a playable game, containing players, pets, methods for the
 * interaction between players and pets, and methods for dealing with the passage of time
 * in the form of turns and days.
 */
public class Game {
    private static final Event[] EVENTS = new Event[] {
            new MisbehaveEvent(),
            new SicknessEvent(),
            new DeadEvent()
    };

    private final int maxDays;

    private Player[] players;
    private int playerTurn;
    private int day;
    private int currentPet;

    /**
     * Creates a game.
     * @param numberDays The number of days a game will play for.
     * @param players An array containing the players that are playing.
     */
    public Game(final int numberDays, final Player[] players) {
        maxDays = numberDays;
        this.players = players;
    }

    /**
     * Ends a turn. It will switch to the next player, and when that finishes, switch to a new day.
     */
    public void endTurn() {
        assert isRunning();
        
        currentPet = 0;
        playerTurn++;
        if (playerTurn == players.length) {
            playerTurn = 0;
            day++;

            for (Player player : players) {
                player.dayPassed();
            }

            for (Event event : EVENTS) {
                for (Player player : players) {
                    event.processPlayer(player);
                }
            }
        }
    }

    /**
     * Feeds the current pet the desired food.
     * @param food The desired food
     */
    public void feed(final Food food) {
        getCurrentPet().feed(food);
    }

    /**
     * Plays with the current pet and the desired toy.
     * @param toy The desired toy
     */
    public void play(final Toy toy) {
        getCurrentPet().play(toy);
    }

    /**
     * Puts the current pet to sleep.
     */
    public void sleep() {
        getCurrentPet().sleep();
    }

    /**
     * Lets the current pet go to the toilet.
     */
    public void toilet() {
        getCurrentPet().toilet();
    }

    /**
     * Returns if the game is still running.
     * @return true - if game is still running, false - if game has finished.
     */
    public boolean isRunning() {
        return day < maxDays;
    }

    /**
     * Gets the player whose turn it currently is.
     * @return player - player whose turn it currently is
     */
    public Player getCurrentPlayer() {
        return players[playerTurn];
    }

    /**
     * Gets the current day in the range [0, maxDays)
     * @return day - current day in the range [0, maxDays)
     */
    public int getCurrentDay() {
        return day;
    }

    /**
     * Gets the number of days the game will run for.
     * @return maxDays - days which the game will run for.
     */
    public int getMaxDays() {
        return maxDays;
    }

    /**
     * Gets the current pet being interacted with.
     * @return pet - the current pet being interacted with.
     */
    public Pet getCurrentPet() {
        return players[playerTurn].getPets()[currentPet];
    }

    /**
     * Gets the index in the players pet array for the current pet. 
     * @return currentPet - the index in the players pet array for the current pet.
     */
    public int getCurrentPetIndex() {
        return currentPet;
    }

    /**
     * Sets the index in the players pet array for the current pet.
     * @param newCurrentPet The index in the current players pet array
     */
    public void setCurrentPetIndex(final int newCurrentPet) {
        currentPet = newCurrentPet;
    }

    /**
     * Cures the current pet.
     */
    public void cure() {
        getCurrentPet().cure();
    }
    
    /**
     * Revives the current pet.
     */
    public void revive() {
        getCurrentPet().revive();
    }

    /**
     * Returns an array of the players.
     */
    public Player[] getPlayers() {
        return players;
    }
}
