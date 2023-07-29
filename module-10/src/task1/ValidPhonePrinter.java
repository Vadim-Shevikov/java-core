package task1;

import java.io.*;

public class ValidPhonePrinter {
    public static void printValidPhones(String fileName, Validatable validator) {

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;

            while ((line = br.readLine()) != null) {
                if (validator.isValid(line)) {
                    System.out.println(line);
                }
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
