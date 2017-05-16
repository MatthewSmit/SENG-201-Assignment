package seng201.assignment;

/**
 * Created by Matthew on 12/04/2017.
 */
public class Game {
    private static final Class[] petTypes = new Class[] {
            Bird.class,
            Cat.class,
            Dog.class,
            Goldfish.class,
            GuineaPig.class,
            Rabbit.class
    };

    private static final Event[] events = new Event[] {
            new MisbehaveEvent(),
            new SicknessEvent(),
            new DeadEvent()
    };

    private final int maxRounds;

    private Player[] players;
    private int playerTurn;
    private int round;
    private int currentPet;

    public Game(int rounds, Player[] players) {
        maxRounds = rounds;
        this.players = players;
    }

    public void endTurn() {
        for (Player player : players) {
            for (Pet pet : player.getPets()) {
                pet.dayPassed();
            }
        }

        for (Event event : events) {
            for (Player player : players) {
                event.processPlayer(player);
            }
        }

        playerTurn++;
        if (playerTurn == players.length) {
            playerTurn = 0;
            round++;
        }
    }

    public void feed(Food food) {
        getCurrentPet().feed(food);
    }

    public void play(Toy toy) {
        getCurrentPet().play(toy);
    }

    public void sleep() {
        getCurrentPet().sleep();
    }

    public void toilet() {
        getCurrentPet().toilet();
    }

    public boolean isRunning() {
        return round < maxRounds;
    }

    public Player getCurrentPlayer() {
        return players[playerTurn];
    }

    public static Class[] getPetTypes() {
        return petTypes;
    }

    public int getCurrentRound() {
        return round;
    }

    public int getMaxRound() {
        return maxRounds;
    }

    public Pet getCurrentPet() {
        return players[playerTurn].getPets()[currentPet];
    }

    public int getCurrentPetIndex() {
        return currentPet;
    }

    public void setCurrentPetIndex(int currentPet) {
        this.currentPet = currentPet;
    }
}
