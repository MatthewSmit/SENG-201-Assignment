package seng201.assignment;

/**
 * Created by Matthew on 12/04/2017.
 */
public class Game {
    private static final int ALLOWANCE = 20;
    
    private static final Event[] events = new Event[] {
            new MisbehaveEvent(),
            new SicknessEvent(),
            new DeadEvent()
    };

    private final int maxDays;

    private Player[] players;
    private int playerTurn;
    private int day;
    private int currentPet;

    public Game(int numberDays, Player[] players) {
        maxDays = numberDays;
        this.players = players;
    }

    public void endTurn() {
        for (Player player : players) {
            player.addMoney(ALLOWANCE);
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
            day++;
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
        return day < maxDays;
    }

    public Player getCurrentPlayer() {
        return players[playerTurn];
    }

    public int getCurrentDay() {
        return day;
    }

    public int getMaxDays() {
        return maxDays;
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
