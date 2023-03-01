package lab01.tdd.step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

public final class CircularListImpl implements CircularList {

    private final List<Integer> elements = new ArrayList<>();

    @Override
    public void add(final int element) {
        elements.add(element);
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Iterator<Integer> forwardIterator() {
        return iteratorOf(IntStream.iterate(0, i -> (i + 1) % size()));
    }

    @Override
    public Iterator<Integer> backwardIterator() {
        return iteratorOf(
                IntStream
                    .iterate(0, i -> (i - 1 + size()) % size())
                    .skip(1)
        );
    }

    private Iterator<Integer> iteratorOf(final IntStream positions) {
        if (isEmpty()) {
            return Collections.emptyIterator();
        }
        return positions.map(elements::get).iterator();
    }
}