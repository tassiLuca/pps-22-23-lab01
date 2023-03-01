package lab01.tdd.step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularList list;

    @BeforeEach
    void init() {
        this.list = new CircularListImpl();
    }

    @Test
    void testIsInitiallyEmpty() {
        assertTrue(this.list.isEmpty());
    }

    @Test
    void testInitialSizeIsZero() {
        assertEquals(0, this.list.size());
    }

    @Test
    void testAddingNewElements() {
        populateList();
        assertEquals(3, this.list.size());
    }

    @Test
    void testNextCallOnEmptyList() {
        assertEquals(Optional.empty(), this.list.next());
    }

    @Test
    void testMultipleNextOnEmptyList() {
        final var attempts = 10;
        for (var i = 0; i < attempts; i++) {
            assertEquals(Optional.empty(), this.list.next());
        }
        testFirstNextCallReturnFirstElement();
    }

    @Test
    void testPreviousCallOnEmptyList() {
        assertEquals(Optional.empty(), this.list.previous());
    }

    @Test
    void testMultiplePreviousOnEmptyList() {
        final var attempts = 10;
        for (var i = 0; i < attempts; i++) {
            assertEquals(Optional.empty(), this.list.previous());
        }
        testFirstPreviousCallReturnsLastElement();
    }

    @Test
    void testFirstNextCallReturnFirstElement() {
        populateList();
        assertEquals(Optional.of(1), this.list.next());
    }

    @Test
    void testMultipleNextCallsLeadsToRestart() {
        populateList();
        this.list.next();
        this.list.next();
        this.list.next();
        assertEquals(Optional.of(1), this.list.next());
    }

    @Test
    void testFirstPreviousCallReturnsLastElement() {
        populateList();
        assertEquals(Optional.of(3), this.list.previous());
    }

    @Test
    void testMultiplePreviousCallsLeadsToRestart() {
        populateList();
        this.list.previous();
        this.list.previous();
        this.list.previous();
        assertEquals(Optional.of(3), this.list.previous());
    }

    @Test
    void testResetPosition() {
        populateList();
        this.list.next();
        this.list.reset();
        assertEquals(Optional.of(1), this.list.next());
    }

    private void populateList() {
        this.list.add(1);
        this.list.add(2);
        this.list.add(3);
    }
}
