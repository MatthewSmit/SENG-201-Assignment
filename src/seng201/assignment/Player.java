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
     * An array of the pet the player owns.
     */
    private Pet[] pets;
    /**
     * A list of the items the player owns.
     */
    private ArrayList<Item> items = new ArrayList<>();
    private int money = INITIAL_MONEY;
    private String name;

    public Player(String name, Pet[] pets) {
        this.name = name;
        this.pets = pets;
    }

    public void purchase(Item item) {
        if (money < item.getPrice())
            throw new UnsupportedOperationException("Can't afford the toy.");

        money -= item.getPrice();
        items.add(item.clone());
    }

    public String getName() {
        return name;
    }

    public Pet[] getPets() {
        return pets;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public ArrayList<Food> getFood() {
        ArrayList<Food> food = new ArrayList<>();
        for (Item item : items) {
            if (item instanceof Food)
                food.add((Food)item);
        }
        return food;
    }

    public ArrayList<Toy> getToys() {
        ArrayList<Toy> toys = new ArrayList<>();
        for (Item item : items) {
            if (item instanceof Toy)
                toys.add((Toy)item);
        }
        return toys;
    }

    public int getMoney() {
        return money;
    }

    public void addMoney(int money) {
        this.money += money;
    }
}
