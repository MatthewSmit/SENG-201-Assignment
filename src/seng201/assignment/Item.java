package seng201.assignment;

/**
 * Base item class, used for player inventory storage.
 *
 */
public abstract class Item implements Cloneable {
    /**
     * Returns a copy of the item.
     */
    public abstract Item clone();
    /**
     * Returns how much the item costs.
     */
    public abstract int getPrice();
}
