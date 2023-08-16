import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import task1.Task1;
import task2.Task2;
import task3.Task3;
import task4.Task4;
import task5.Task5;

public class MainModule11 {
    public static void main(String[] args) {

        System.out.println("Task1. Add index to names and return joined string: ");

        List<String> names = List.of("Ivan", "Sasha", "Peter", "Borys", "Masha", "Kolya", "Adam");
        System.out.println("List: " + names);
        System.out.println("Result: " + Task1.formatOddNames(names));

        System.out.println("=========================================");

        System.out.println(" ");
        System.out.println("Task2. Sort and convert to uppercase: ");

        System.out.println("List: " + names);
        System.out.println("Result: " + Task2.sortAndUpper(names));

        System.out.println("=========================================");

        System.out.println(" ");
        System.out.println("Task3. Sort and convert to string: ");

        String[] array = {"2, 0, 1", "5, 4"};
        System.out.println("Array: " + Arrays.toString(array));
        System.out.println("Result: " + Task3.sortAndConvertToString(array));

        System.out.println("=========================================");

        System.out.println(" ");
        System.out.println("Task4. Custom generator with Stream.iterate: ");

        long m = (long) Math.pow(2, 48);
        System.out.println("Result: ");
        Task4.generate(25214903917L, 11, m, 5).limit(10)
                .forEach(System.out::println);

        System.out.println("=========================================");

        System.out.println(" ");
        System.out.println("Task5. Zip two streams: ");

        Stream<String> first = Stream.of("1", "3", "5");
        Stream<String> second = Stream.of("2", "4", "6");

        System.out.print("Result: ");
        var zipped = Task5.zip(first, second);
        zipped.forEach(System.out::print);
        System.out.println();

        System.out.println("=========================================");

    }
}
