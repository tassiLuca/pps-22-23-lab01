package lab01.tdd.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CircularListTest {

    private CircularList list;

    @BeforeEach
    void init() {
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
        assertEquals(5, list.size());
    }

    @Test
    void testFilteredNextOnEmptyList() {
        assertEquals(Optional.empty(), list.filteredNext(element -> true));
    }

    @Test
    void testFilteredNextWithAlwaysTruePredicate() {
        populateList();
        checkListOfElements(List.of(1, 2, 3, 4, 5), element -> true);
    }

    @Test
    void testFilteredNextWithAlwaysFalsePredicate() {
        populateList();
        assertEquals(Optional.empty(), list.filteredNext(element -> false));
    }

    @Test
    void testFilteredNext() {
        populateList();
        checkListOfElements(
            List.of(1, 3, 5),
            element -> element % 2 != 0
        );
    }

    private void populateList() {
        this.list.add(1);
        this.list.add(2);
        this.list.add(3);
        this.list.add(4);
        this.list.add(5);
    }

    private void checkListOfElements(List<Integer> expectedElements, Predicate<Integer> condition) {
        for (var expectedElement : expectedElements) {
            assertEquals(Optional.of(expectedElement), list.filteredNext(condition));
        }
    }
}