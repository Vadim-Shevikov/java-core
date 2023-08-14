package task5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Task5 {
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> firstIterator = first.iterator();
        Iterator<T> secondIterator = second.iterator();

        List<T> result = new ArrayList<>();

        while (firstIterator.hasNext() && secondIterator.hasNext()) {
            result.add(firstIterator.next());
            result.add(secondIterator.next());
        }

        Collections.shuffle(result);

        return result.stream();
    }
}
