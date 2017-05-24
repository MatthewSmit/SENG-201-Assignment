package seng201.assignment;

import java.util.ArrayList;

/**
 * A player, owns pets, toys and food, and has money.
 */
public class Player {
    /**
     * Money a player starts with.
     */
    private static final int INITIAL_MONEY = 100;
    
    /**
     * Money a player gets per day.
     */
    private static final int ALLOWANCE = 20;

    /**
     * An array of the pet the player owns.
     */
    private Pet[] pets;
    /**
     * A list of the items the player owns.
     */
    private ArrayList<Item> items = new ArrayList<>();
    private int money = INITIAL_MONEY;
    private int score;
    private String name;

    /**
     * Creates a new player.
     * @param name The name of the player
     * @param pets An array of the pets the player has
     */
    public Player(final String name, final Pet[] pets) {
        this.name = name;
        this.pets = pets;
    }

    /**
     * Purchases an item, throws an exception if the player doesn't have enough money.
     * @param item The desired item
     */
    public void purchase(final Item item) {
        if (money < item.getPrice()) {
            throw new UnsupportedOperationException("Can't afford the toy.");
        }

        money -= item.getPrice();
        items.add(item.clone());
    }

    /**
     * Gets the name of the player.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the pets a player has.
     */
    public Pet[] getPets() {
        return pets;
    }

    /**
     * Gets the items a player has.
     */
    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * Gets the food a player has.
     */
    public ArrayList<Food> getFood() {
        ArrayList<Food> food = new ArrayList<>();
        for (Item item : items) {
            if (item instanceof Food) {
                food.add((Food)item);
            }
        }
        return food;
    }

    /**
     * Gets the toys a player has.
     */
    public ArrayList<Toy> getToys() {
        ArrayList<Toy> toys = new ArrayList<>();
        for (Item item : items) {
            if (item instanceof Toy) {
                toys.add((Toy)item);
            }
        }
        return toys;
    }

    /**
     * Gets the money a player has.
     */
    public int getMoney() {
        return money;
    }

    /**
     * Adds the money to a player's balance.
     * @param increasedMoney The money to add
     */
    public void addMoney(final int increasedMoney) {
        this.money += increasedMoney;
    }

    /**
     * Processes day to day events.
     */
    public void dayPassed() {
        calculateScore();
        
        addMoney(ALLOWANCE);
        for (Pet pet : pets) {
            pet.dayPassed();
        }
    }
    
    /**
     * Gets the score of the player.
     */
    public int getScore() {
        return score;
    }
    
    /**
     * Calculates changes to a players score.
     */
    private void calculateScore() {
        int newScore = 0;
        for (Pet pet : pets) {
            if (pet.isDead()) {
                newScore -= 100;
            } else {
                newScore += 10 - pet.getHunger();
                newScore += 10 - pet.getToiletNeed();
                newScore += 10 - pet.getTiredness();
                newScore += pet.getHappiness();
                newScore += pet.getHealth();
                if (pet.isMisbehaving()) {
                    newScore -= 10;
                }
                if (pet.isSick()) {
                    newScore -= 10;
                }
            }
        }
        
        score += newScore;
    }
}
