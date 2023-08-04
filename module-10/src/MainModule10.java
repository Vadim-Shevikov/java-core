import task1.PhoneValidator;
import task1.ValidPhonePrinter;
import task2.FromTxtToJsonConverter;
import task3.WordCounter;

public class MainModule10 {
    public static void main(String[] args) {
        System.out.println("Task1. From /files/task1.txt valid phones:");

        ValidPhonePrinter.printValidPhones("./module-10/files/task1.txt", new PhoneValidator());

        System.out.println("=========================================");

        System.out.println(" ");
        System.out.println("Task2. From /files/task2.txt to user.json:");

        FromTxtToJsonConverter.convert("./module-10/files/task2.txt", "./module-10/files/user.json");

        System.out.println("=========================================");

        System.out.println(" ");
        System.out.println("Task3. Count words from task3.txt:");

        WordCounter.countAndPrintWordsInFile("./module-10/files/task3.txt");

        System.out.println("=========================================");
    }
}
