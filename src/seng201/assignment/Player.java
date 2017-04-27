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
     * A list of the toys the player owns.
     */
    private ArrayList<Toy> toys = new ArrayList<>();
    /**
     *
     */
    private ArrayList<Food> food = new ArrayList<>();
    private int money = INITIAL_MONEY;
    private String name;

    public Player(String name, Pet[] pets) {
        this.name = name;
        this.pets = pets;
    }

    public void purchase(ToyType toy) {
        if (money < toy.getPrice())
            throw new UnsupportedOperationException("Can't afford the toy.");

        money -= toy.getPrice();
        toys.add(new Toy(toy));
    }

    public void purchase(Food food) {
        if (money < food.getPrice())
            throw new UnsupportedOperationException("Can't afford the food.");

        money -= food.getPrice();
        this.food.add(food);
    }

    public String getName() {
        return name;
    }

    public Pet[] getPets() {
        return pets;
    }

    public ArrayList<Food> getFood() {
        return food;
    }

    public ArrayList<Toy> getToys() {
        return toys;
    }

    public int getMoney() {
        return money;
    }
}
