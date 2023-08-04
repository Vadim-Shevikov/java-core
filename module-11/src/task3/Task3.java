package task3;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Task3 {
    public static String sortAndConvertToString(String[] array) {
        return Arrays.stream(array)
                .flatMap(s -> Arrays.stream(s.split(", ")))
                .map(Integer::parseInt)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
