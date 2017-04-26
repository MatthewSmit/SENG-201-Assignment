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

    private final int maxRounds;

    private Player[] players;
    private int playerTurn;
    private int petTurn;
    private int round;
    private int actionsLeft = 2;

    public Game(int rounds, Player[] players) {
        maxRounds = rounds;
        this.players = players;
    }

    public void endTurn() {
        actionsLeft = 2;
        petTurn++;
        if (petTurn == getCurrentPlayer().getPets().length) {
            petTurn = 0;
            playerTurn++;
            if (playerTurn == players.length) {
                playerTurn = 0;
                round++;
            }
        }
    }

    public void feed(Food food) {
        getCurrentPet().feed(food);
        actionsLeft--;
    }

    public void play(Toy toy) {
        getCurrentPet().play(toy);
        actionsLeft--;
    }

    public void sleep() {
        getCurrentPet().sleep();
        actionsLeft--;
    }

    public void toilet() {
        getCurrentPet().toilet();
        actionsLeft--;
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
        return players[playerTurn].getPets()[petTurn];
    }

    public int getActionsLeft() {
        return actionsLeft;
    }
}
