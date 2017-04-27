package seng201.assignment;

import java.util.ArrayList;

/**
 * Created by Matthew on 12/04/2017.
 */
public class Player {
    private static final int INITIAL_MONEY = 100;

    private Pet[] pets;
    private ArrayList<Toy> toys = new ArrayList<>();
    private ArrayList<Food> food = new ArrayList<>();
    private int money = INITIAL_MONEY;
    private String name;

    public Player(String name, Pet[] pets) {
        this.name = name;
        this.pets = pets;
    }

    public void purchase(Toy toy) {
        if (money < toy.getPrice())
            throw new UnsupportedOperationException("Can't afford the toy.");

        money -= toy.getPrice();
        toys.add(toy);
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
