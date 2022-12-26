
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) throws SQLException {

        statement stmt = statement.getInstance();
        JSONParser jsonParser = new JSONParser();
        JSONObject JSONOBJ;
        LocalTime time = LocalTime.now();

        try (FileReader reader = new FileReader("C:\\Users\\Jereis\\IdeaProjects\\Transaction\\src\\JSONfile.json")) {
            JSONObject jsonob = (JSONObject) jsonParser.parse(reader);
            JSONObject jsonob2 = (JSONObject) jsonob.get("data");
            JSONArray ja = (JSONArray) jsonob2.get("parameters");

            for (int i = 0; i < 1; i++) {
                JSONOBJ = (JSONObject) ja.get(i);
                boolean is_excuting = false;
                String FirstName = JSONOBJ.get("FirstName").toString();
                String LastName = JSONOBJ.get("LastName").toString();
                String eventCode = JSONOBJ.get("eventCode").toString();
                String City = JSONOBJ.get("City").toString();
                String requestId = jsonob.get("requestId").toString();
                String Create_date = time.toString();

                String Transid = stmt.getTransactionID();
                JSONOBJ.replace("TransactionId", Transid);
                System.out.println(JSONOBJ);


                int s = statement.insert(eventCode, requestId, City, FirstName, LastName, " ", Create_date, " ", is_excuting);
                if (s > 0) {
                    System.out.println("insertion succssefully !");
                    JSONArray ja2 = new JSONArray();
                    ja2.add(JSONOBJ);
                    callApi.RequestAPI(ja2);
                } else {
                    System.out.println(" error 404");
                }

            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException | ParseException | SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
