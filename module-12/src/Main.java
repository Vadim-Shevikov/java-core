import task1.TimeTracker;
import task2.ThreadsTest;

public class Main {
    public static void main(String[] args) {
        System.out.println("Task1. Time Tracking: ");
        TimeTracker.run();
        System.out.println("=========================================");

        System.out.println(" ");
        System.out.println("Task2.");

        ThreadsTest.run(20);
        System.out.println(" ");
    }
}
