package seng201.assignment;

import java.util.ArrayList;

/**
 * Created by Matthew on 12/04/2017.
 */
public abstract class Player {
    private ArrayList<Pet> pets;
    private ArrayList<Toy> toys;
    private ArrayList<Food> food;
    private int money;
    private String name;

    public void purchase(Toy toy) {
    }

    public void purchase(Food food) {
    }
}
