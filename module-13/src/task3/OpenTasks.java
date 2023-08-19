package task3;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

import java.util.ArrayList;
import java.util.List;

public class OpenTasks {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    private static final Gson gson = new Gson();

    public static void printOpenTodosByUserId(int userId) throws Exception {
        Response response = Jsoup.connect(BASE_URL + "/users/" + userId + "/todos")
                .method(Connection.Method.GET)
                .ignoreContentType(true)
                .execute();

        JsonArray todos = gson.fromJson(response.body(), JsonArray.class);
        List<JsonObject> openTodos = new ArrayList<>();

        for (int i = 0; i < todos.size(); i++) {
            JsonObject todo = todos.get(i).getAsJsonObject();
            if (!todo.get("completed").getAsBoolean()) {
                openTodos.add(todo);
            }
        }

        for (JsonObject openTodo : openTodos) {
            System.out.println(openTodo);
        }
    }
}
