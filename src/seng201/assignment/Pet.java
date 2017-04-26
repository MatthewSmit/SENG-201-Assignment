package seng201.assignment;

/**
 * Created by Matthew on 12/04/2017.
 */
public abstract class Pet {
    public enum DeathState {
        ALIVE,
        DEAD_ONCE,
        PERMENANTLY_DEAD
    }

    private int hunger;
    private int tiredness;
    private int playfulness;
    private int roughness;
    private int toiletNeed;
    private int health;
    private DeathState deathState = DeathState.ALIVE;
    private String name;
    private int weight;

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

    public int getWeight() {
        return weight;
    }

    public DeathState getDeathState() {
        return deathState;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public abstract String getSpecies();
}
