package task2;

import java.util.ArrayList;
import java.util.List;

public class ThreadsTest {

    private static <T> void print(T printValue, int currentNumber, int value) {
        if (currentNumber == value) {
            System.out.print(printValue);
            return;
        }

        System.out.print(printValue + ", ");
    }

    public static void run(int value) {
        ThreadProcessor fizzbuzz = new ThreadProcessor(n -> {
            if (n % 5 == 0 && n % 3 == 0) {
                print("fizzbuzz", n, value);
            }
        });
        ThreadProcessor fizz = new ThreadProcessor(n -> {
            if (n % 3 == 0 && n % 5 != 0) {
                print("fizz", n, value);
            }
        });
        ThreadProcessor buzz = new ThreadProcessor(n -> {
            if (n % 5 == 0 && n % 3 != 0) {
                print("buzz", n, value);
            }
        });
        ThreadProcessor number = new ThreadProcessor(n -> {
            if (n % 5 != 0 && n % 3 != 0) {
                print(n, n, value);
            }
        });

        List<ThreadProcessor> threads = new ArrayList<>();
        threads.add(fizzbuzz);
        threads.add(fizz);
        threads.add(buzz);
        threads.add(number);

        for (ThreadProcessor thread: threads) {
            thread.start();
        }


        for (int i = 1; i <= value; i++) {
            for (ThreadProcessor thread: threads) {
                thread.process(i);
            }

            while (true) {
                int processedCount = 0;
                for (ThreadProcessor thread : threads) {
                    if (thread.getIsRun()) {
                        processedCount++;
                    }
                }

                if (processedCount == threads.size()) {
                    break;
                }
            }
        }
    }
}
