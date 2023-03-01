package lab01.tdd.step2;

import java.util.Iterator;

/**
 * Represents a list of integers, which provides an {@link Iterator} in order to iterate elements
 * forward and backward circularly. Example: with a list like {1,2,3}, the first call of next()
 * on the forward iterator returns 1, the second call returns 2, the third returns 3, the fourth
 * returns 1, and so on. Call to the next() on the backward iterator goes in the other way.
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
