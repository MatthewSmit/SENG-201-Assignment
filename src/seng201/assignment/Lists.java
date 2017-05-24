package seng201.assignment;

/**
 * Helper class for list/array functions.
 */
public final class Lists {
    private Lists() {
    }

    /**
     * Returns true if iterable contains item using .equals().
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
