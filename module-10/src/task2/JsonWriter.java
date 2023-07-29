package task2;

import com.google.gson.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonWriter {
    public void writeJson(List<User> users, String fileName) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(users);

        File file = new File(fileName);
        file.getParentFile().mkdirs();

        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter writer = new FileWriter(fileName);
        writer.write(json);
        writer.close();
    }
}
