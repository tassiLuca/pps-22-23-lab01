package lab01.tdd.step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class CircularListImpl implements CircularList {

    private final List<Integer> elements = new ArrayList<>();

    private int currentElement = 0;

    @Override
    public void add(int element) {
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
    public Optional<Integer> filteredNext(Predicate<Integer> condition) {
        final var searched = IntStream.iterate(currentElement, i -> (i + 1) % size())
                .limit(size())
                .mapToObj(elements::get)
                .filter(condition)
                .findFirst();
        searched.ifPresent(element -> currentElement = elements.indexOf(element) + 1);
        return searched;
    }
}
