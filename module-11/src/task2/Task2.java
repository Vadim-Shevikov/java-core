package task2;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Task2 {
    public static List<String> sortAndUpper(List<String> names) {
        return names.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
}
