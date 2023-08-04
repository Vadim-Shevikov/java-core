package task1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task1 {
    public static String formatOddNames(List<String> names) {
        return IntStream.range(0, names.size())
                .filter(i -> (i + 1) % 2 != 0)
                .mapToObj(i -> (i + 1) + ". " + names.get(i))
                .collect(Collectors.joining(", "));
    }
}
