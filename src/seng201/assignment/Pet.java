package seng201.assignment;

/**
 * Created by Matthew on 12/04/2017.
 */
public abstract class Pet {
    private int hunger;
    private int tiredness;
    private int playfulness;
    private int roughness;
    private int toiletNeed;
    private int health;
    private boolean died;
    private String name;

    public void feed(Food food) {
    }

    public void play(Toy toy) {
    }

    public void sleep() {
    }

    public void toilet() {
    }

    public void misbehave() {
    }

    public void sickness() {
    }

    public void die() {
    }

    public int getHunger() {
        return hunger;
    }

    public int getTiredness() {
        return tiredness;
    }

    public int getPlayfulness() {
        return playfulness;
    }

    public int getRoughness() {
        return roughness;
    }

    public int getToiletNeed() {
        return toiletNeed;
    }

    public int getHealth() {
        return health;
    }

    public boolean hasDied() {
        return died;
    }

    public String getName() {
        return name;
    }

    public abstract String getSpecies();
}
