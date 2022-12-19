package Test10;

import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;

//import org.json.simple.JSONObject;
public class reqres {

    public static void main(String[] args) {
        JSONObject userdetails = new JSONObject();
        userdetails.put("firstName", "waseem");
        userdetails.put("lastName", "shraideh");
        userdetails.put("email", "Waseemshraideh@test.com");

        JSONObject userdetail = new JSONObject();
        userdetail.put("user", userdetails);
        JSONArray jsonarray = new JSONArray();
        jsonarray.put(userdetail);
        try (FileWriter file = new FileWriter("users.json")) {
            //We can write any JSONArray or JSONObject instance to the file
            System.out.println(jsonarray.toString());
            file.write(jsonarray.toString());
            file.flush();

        } catch (IOException e) {
        }
    }

}
