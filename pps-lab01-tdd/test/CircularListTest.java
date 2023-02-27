import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
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
    void testAddingNewElements() {
        populateList();
        assertEquals(3, this.list.size());
    }

    @Test
    void testNextCallReturnEmptyOptionalWhenEmpty() {
        assertEquals(Optional.empty(), this.list.next());
    }

    @Test
    void testPreviousCallReturnEmptyOptionalWhenEmpty() {
        assertEquals(Optional.empty(), this.list.previous());
    }

    @Test
    void testFirstNextCallReturnFirstElement() {
        populateList();
        assertEquals(1, this.list.next().get());
    }

    private void populateList() {
        this.list.add(1);
        this.list.add(2);
        this.list.add(3);
    }

}
