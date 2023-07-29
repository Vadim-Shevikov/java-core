package task2;

import java.io.IOException;
import java.util.List;

public class FromTxtToJsonConverter {
    public static void convert(String txtFile, String jsonFile) {
        FileParser parser = new FileParser();
        JsonWriter writer = new JsonWriter();

        try {
            List<User> users = parser.parseFile(txtFile);
            writer.writeJson(users, jsonFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
