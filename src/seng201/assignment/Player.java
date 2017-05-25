package seng201.assignment;

import java.util.ArrayList;

/**
 * Implements a player class, with the player
 * owning pets, toys, foods and money. Methods implemented to
 * allow for the player to interact with pets and items, and be
 * allocated a daily (and final) score.
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
     * @param name - The name of the player.
     * @param pets - An array of the pets the player has.
     */
    public Player(final String name, final Pet[] pets) {
        this.name = name;
        this.pets = pets;
    }

    /**
     * Purchases an item, throws an exception if the player doesn't have enough money.
     * @param item - the item to be purchased.
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
     * @return name - the name of the player.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the pets the player has.
     * @return pets - a Pet[] list of the pets the player owns.
     */
    public Pet[] getPets() {
        return pets;
    }

    /**
     * Gets the items the player has.
     * @return items - an ArrayList of the items the player owns.
     */
    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * Gets the foods the player has.
     * @return foods - an ArrayList of the foods the player owns.
     */
    public ArrayList<Food> getFood() {
        ArrayList<Food> foods = new ArrayList<>();
        for (Item item : items) {
            if (item instanceof Food) {
                foods.add((Food)item);
            }
        }
        return foods;
    }

    /**
     * Gets the toys the player has.
     * @return toys - an ArrayList of the toys the player owns.
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
     * Gets the money the player has.
     * @return money - the amount of money the player has.
     */
    public int getMoney() {
        return money;
    }

    /**
     * Adds money to the players wallet. Added through the daily allowance or by selling items.
     * @param increasedMoney - the money to be added to the player's wallet.
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
     * @return score - the current score of the player.
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
