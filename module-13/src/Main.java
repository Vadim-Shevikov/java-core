import com.google.gson.Gson;
import com.google.gson.JsonObject;
import task1.*;
import task2.CreateFileFromComment;
import task3.OpenTasks;

public class Main {
    public static void main(String[] args) {
        try {
            //task1
            ApiHandler handler = new ApiHandler();

            User newUser = new User();
            newUser.setId(11);
            newUser.setName("Leanne Graham");
            newUser.setUsername("Bret");
            newUser.setEmail("Sincere@april.biz");
            newUser.setPhone("1-770-736-8031 x56442");
            newUser.setWebsite("hildegard.org");

            Address address = new Address();
            address.setStreet("Kulas Light");
            address.setSuite("Apt. 556");
            address.setCity("Gwenborough");
            address.setZipcode("92998-3874");

            Geo geo = new Geo();
            geo.setLat("-37.3159");
            geo.setLng("81.1496");
            address.setGeo(geo);

            newUser.setAddress(address);

            Company company = new Company();
            company.setName("Romaguera-Crona");
            company.setCatchPhrase("Multi-layered client-server neural-net");
            company.setBs("harness real-time e-markets");
            newUser.setCompany(company);

            JsonObject userJson = new Gson().toJsonTree(newUser).getAsJsonObject();

            System.out.println(handler.createUser(userJson));
            System.out.println(handler.updateUser(2, userJson));
            System.out.println(handler.deleteUser(1));
            System.out.println(handler.getAllUsers());
            System.out.println(handler.getUserById(1));
            System.out.println(handler.getUserByUsername("Leanne Graham"));


            // task2
            int userId = 1;
            CreateFileFromComment.saveUserLastPostCommentsToFile(userId);

            //task3
            OpenTasks.printOpenTodosByUserId(userId);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
