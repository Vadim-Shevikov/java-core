package task1;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TimeTracker {
    public static void run() {
        ScheduledExecutorService scheduler1 = Executors.newSingleThreadScheduledExecutor();
        ScheduledExecutorService scheduler2 = Executors.newSingleThreadScheduledExecutor();

        AtomicInteger secondsPassed = new AtomicInteger(0);

        scheduler1.scheduleAtFixedRate(() -> {
            System.out.println("Минуло " + secondsPassed.incrementAndGet() + " секунд з запуску програми");
        }, 1, 1, TimeUnit.SECONDS);

        scheduler2.scheduleAtFixedRate(() -> {
            System.out.println("Минуло 5 секунд");
        }, 5, 5, TimeUnit.SECONDS);
    }
}
