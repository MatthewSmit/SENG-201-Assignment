package seng201.assignment;

/**
 * Created by programmdude on 27/04/17.
 */
final class Lists {
    private Lists() {
    }

    static <T> boolean contains(T[] iterable, T item) {
        for (T listItem : iterable) {
            if (listItem == item)
                return true;
        }

        return false;
    }
}
