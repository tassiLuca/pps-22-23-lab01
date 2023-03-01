package lab01.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class CircularListImpl implements CircularList {

    private final List<Integer> elements = new ArrayList<>();

    private int indexOfNextElement = 0;

    @Override
    public void add(int element) {
        this.elements.add(element);
    }

    @Override
    public int size() {
        return this.elements.size();
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public Optional<Integer> next() {
        if (isEmpty()) {
            return Optional.empty();
        }
        final var nextElement = this.elements.get(indexOfNextElement);
        indexOfNextElement = (indexOfNextElement + 1) % this.size();
        return Optional.of(nextElement);
    }

    @Override
    public Optional<Integer> previous() {
        if (isEmpty()) {
            return Optional.empty();
        }
        indexOfNextElement = (indexOfNextElement - 1 + this.size()) % this.size();
        final var previousElement = this.elements.get(indexOfNextElement);
        return Optional.of(previousElement);
    }

    @Override
    public void reset() {

    }
}
