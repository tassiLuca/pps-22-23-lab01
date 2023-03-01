package lab01.tdd.step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class CircularListTest {

    private CircularList list;

    @BeforeEach
    void setUp() {
        list = new CircularListImpl();
    }

    @Test
    void testIsInitiallyEmpty() {
        assertTrue(list.isEmpty());
    }

    @Test
    void testInitialSizeIsZero() {
        assertEquals(0, list.size());
    }

    @Test
    void testAddingNewElements() {
        populateList();
        assertEquals(3, list.size());
    }

    @Test
    void testHasNextOnEmptyList() {
        assertFalse(list.forwardIterator().hasNext());
    }

    @Test
    void testNextOnEmptyListThrowsException() {
        assertThrows(NoSuchElementException.class, () -> list.forwardIterator().next());
    }

    @Test
    void testFirstNextReturnsFirstElement() {
        populateList();
        assertEquals(1, list.forwardIterator().next());
    }

    @Test
    void testMultipleNextLeadsToRestart() {
        populateList();
        final var forwardIterator = list.forwardIterator();
        forwardIterator.next();
        forwardIterator.next();
        forwardIterator.next();
        assertEquals(1, forwardIterator.next());
    }

    @Test
    void testHasPreviousOnEmptyList() {
        assertFalse(list.backwardIterator().hasNext());
    }

    @Test
    void testPreviousOnEmptyListThrowsException() {
        assertThrows(NoSuchElementException.class, () -> list.backwardIterator().next());
    }

    @Test
    void testFirstPreviousReturnsLastElement() {
        populateList();
        assertEquals(3, list.backwardIterator().next());
    }

    @Test
    void testMultiplePreviousLeadsToRestart() {
        populateList();
        final var backwardIterator = list.backwardIterator();
        backwardIterator.next();
        backwardIterator.next();
        backwardIterator.next();
        assertEquals(3, backwardIterator.next());
    }

    private void populateList() {
        this.list.add(1);
        this.list.add(2);
        this.list.add(3);
    }
}