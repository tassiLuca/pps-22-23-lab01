package lab01.tdd.step2;

import java.util.Iterator;

/**
 * Represents a list of integers, which provides {@link Iterator} in order to iterate elements
 * forward and backward circularly.
 */
public interface CircularList {

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
     * @return an {@link Iterator} which allows to iterate forward the list in a circular manner.
     */
    Iterator<Integer> forwardIterator();

    /**
     * @return an {@link Iterator} which allows to iterate backward the list in a circular manner.
     */
    Iterator<Integer> backwardIterator();
}
