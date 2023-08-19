package task2;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CreateFileFromComment {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    private static final Gson gson = new Gson();

    private static JsonArray getPostsByUserId(int userId) throws IOException {
        Response response = Jsoup.connect(BASE_URL + "/users/" + userId + "/posts")
                .method(Connection.Method.GET)
                .ignoreContentType(true)
                .execute();

        return gson.fromJson(response.body(), JsonArray.class);
    }

    private static JsonArray getLastPostCommentsByPostId(int postId) throws Exception {
        Response response = Jsoup.connect(BASE_URL + "/posts/" + postId + "/comments")
                .method(Connection.Method.GET)
                .ignoreContentType(true)
                .execute();

        return gson.fromJson(response.body(), JsonArray.class);
    }

    public static void saveUserLastPostCommentsToFile(int userId) throws Exception {
        JsonArray posts = getPostsByUserId(userId);

        int maxPostId = 0;
        for (int i = 0; i < posts.size(); i++) {
            int currentPostId = posts.get(i).getAsJsonObject().get("id").getAsInt();
            if (currentPostId > maxPostId) {
                maxPostId = currentPostId;
            }
        }

        JsonArray comments = getLastPostCommentsByPostId(maxPostId);

        String filename = "user-" + userId + "-post-" + maxPostId + "-comments.json";
        Files.write(Paths.get(filename), gson.toJson(comments).getBytes());
    }
}
