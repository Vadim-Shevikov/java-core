package task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileParser {
    public List<User> parseFile(String fileName) {
        List<User> users = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] parts = line.split(" ");
                User user = new User();
                user.setName(parts[0]);
                user.setAge(Integer.parseInt(parts[1]));

                users.add(user);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return users;
    }
}
