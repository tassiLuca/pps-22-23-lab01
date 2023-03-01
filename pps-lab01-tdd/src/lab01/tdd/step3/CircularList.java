package lab01.tdd.step3;

import java.util.Optional;
import java.util.function.Predicate;

interface CircularList {

    /**
     * Adds an element to the list, namely, after the last inserted one.
     * @param element the element to be added to the list
     */
    void add(final int element);

    /**
     * Provides the current size of the list
     * @return the size of the list
     */
    int size();

    /**
     * Checks if the list is empty
     * @return true if the list is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * @param condition a {@link Predicate} specifying the condition to specify
     *                  for an element to be returned.
     * @return the next element of the list that satisfies the given condition
     * or an empty optional if no elements satisfies it.
     */
    Optional<Integer> filteredNext(Predicate<Integer> condition);
}
