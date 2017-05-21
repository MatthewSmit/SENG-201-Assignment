package seng201.assignment;

/**
 * Created by Matthew on 2017-04-27.
 */
final class Lists {
    private Lists() {
    }

    static <T> boolean contains(final T[] iterable, final T item) {
        for (T listItem : iterable) {
            if (listItem == item) {
                return true;
            }
        }

        return false;
    }
}
