package task1;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;

public class ApiHandler {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    private static final String BASE_USERS_URL = BASE_URL + "/users";
    private final Gson gson = new Gson();

    public JsonObject createUser(JsonObject user) throws Exception {
        Response response = Jsoup.connect(BASE_USERS_URL)
                .method(Connection.Method.POST)
                .header("Content-Type", "application/json; charset=utf-8")
                .ignoreContentType(true)
                .requestBody(user.toString())
                .followRedirects(false)
                .execute();

        JsonObject responseBody = gson.fromJson(response.body(), JsonObject.class);
        int maxId = getMaxUserId();

        if (responseBody.get("id").getAsInt() == maxId + 1) {
            return responseBody;
        } else {
            throw new Exception("User creation failed.");
        }
    }

    public JsonObject updateUser(int id, JsonObject updatedUser) throws Exception {
        Response response = Jsoup.connect(BASE_USERS_URL + "/" + id)
                .method(Connection.Method.PUT)
                .header("Content-Type", "application/json; charset=utf-8")
                .requestBody(updatedUser.toString())
                .ignoreContentType(true)
                .followRedirects(false)
                .execute();

        return gson.fromJson(response.body(), JsonObject.class);
    }

    public boolean deleteUser(int id) throws Exception {
        Response response = Jsoup.connect(BASE_USERS_URL + "/" + id)
                .method(Connection.Method.DELETE)
                .ignoreContentType(true)
                .execute();

        return response.statusCode() / 100 == 2;  // Check if status code is 2xx
    }

    public JsonArray getAllUsers() throws Exception {
        Response response = Jsoup.connect(BASE_USERS_URL)
                .method(Connection.Method.GET)
                .ignoreContentType(true)
                .execute();

        return gson.fromJson(response.body(), JsonArray.class);
    }

    public JsonObject getUserById(int id) throws Exception {
        Response response = Jsoup.connect(BASE_USERS_URL + "/" + id)
                .method(Connection.Method.GET)
                .ignoreContentType(true)
                .execute();

        return gson.fromJson(response.body(), JsonObject.class);
    }

    public JsonObject getUserByUsername(String username) throws Exception {
        Response response = Jsoup.connect(BASE_USERS_URL + "?username=" + username)
                .method(Connection.Method.GET)
                .ignoreContentType(true)
                .execute();

        JsonArray users = gson.fromJson(response.body(), JsonArray.class);
        if (users.size() > 0) {
            return users.get(0).getAsJsonObject();
        } else {
            return null;
        }
    }

    private int getMaxUserId() throws Exception {
        JsonArray allUsers = getAllUsers();
        int maxId = 0;

        for (int i = 0; i < allUsers.size(); i++) {
            int currentId = allUsers.get(i).getAsJsonObject().get("id").getAsInt();
            if (currentId > maxId) {
                maxId = currentId;
            }
        }

        return maxId;
    }

}
