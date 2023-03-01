package lab01.tdd.step1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

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
        return getElementAt(() -> {
            final var requestedIndex = indexOfNextElement;
            indexOfNextElement = (indexOfNextElement + 1) % size();
            return requestedIndex;
        });
    }

    @Override
    public Optional<Integer> previous() {
        return getElementAt(() -> {
            indexOfNextElement = (indexOfNextElement == 0 ? size() : indexOfNextElement) - 1;
            return indexOfNextElement;
        });
    }

    private Optional<Integer> getElementAt(Supplier<Integer> index) {
        if (!isEmpty()) {
            return Optional.of(elements.get(index.get()));
        }
        return Optional.empty();
    }

    @Override
    public void reset() {
        this.indexOfNextElement = 0;
    }
}
