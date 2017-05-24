package seng201.assignment;

/**
 * Class used to implement a method to check if a list of items 
 * contains a specific item.
 */
public final class Lists {
    private Lists() {
    }

    /**
     * Returns true if an item is in a list, false if an item is not in a list.
     * @param iterable - list of items being investigated.
     * @param item - the item which is being checked if it is in the list.
     * @return true - if the item is list, false - if the item is not in the list.
     */
    public static <T> boolean contains(final T[] iterable, final T item) {
        for (T listItem : iterable) {
            if (listItem.equals(item)) {
                return true;
            }
        }

        return false;
    }
}
