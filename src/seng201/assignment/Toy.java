package seng201.assignment;

/**
 * Created by Matthew on 12/04/2017.
 */
public enum Toy {
    Test;

    private int price;
    private int durability;

    void degrade() {
    }

    boolean isBroken() {
        return durability <= 0;
    }

    public int getPrice() {
        return price;
    }
}
