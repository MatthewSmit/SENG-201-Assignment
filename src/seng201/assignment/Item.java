package seng201.assignment;

/**
 * Base item class, item is always 
 * either a food or a toy.
 */
public abstract class Item implements Cloneable {
    
	/**
     * Returns a copy of the item.
     * @return item - copy of the item being cloned.
     */
    public abstract Item clone();
    
    /**
     * Returns how much the item costs.
     * @return price - how much the item costs.
     */
    public abstract int getPrice();
    
    /**
     * Returns the name of the item.
     * @return name - the name of the item.
     */
    public abstract String toString();
}
