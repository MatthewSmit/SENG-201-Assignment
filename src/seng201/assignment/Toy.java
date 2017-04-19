package seng201.assignment;

/**
 * Created by Matthew on 12/04/2017.
 */
public class Toy {
    private int price;
    private int durability;

    void degrade() {
    }

    boolean isBroken() {
        return durability <= 0;
    }
}
