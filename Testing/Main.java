package Testing;

import java.io.FileInputStream;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws SQLException, FileNotFoundException, IOException, InterruptedException {
        String appConfigPath = "C:\\Users\\w.shraideh\\Documents\\NetBeansProjects\\JavaApplication1\\src\\javaapplication1\\application.properties";
        Properties appProps = new Properties();
        appProps.load(new FileInputStream(appConfigPath));
        int maxT = Integer.parseInt(appProps.getProperty("thread_bool_max_size"));
        statement stmt = statement.getInstance();
        JSONParser jsonParser = new JSONParser();
        JSONObject JSONOBJ = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        //read data form file
        try (FileReader reader = new FileReader("C:\\Users\\w.shraideh\\Documents\\NetBeansProjects\\JavaApplication1\\src\\javaapplication1\\JSONfile.json")) {
            //multiple json objects to get the data inside parameters

            JSONObject jsonob = (JSONObject) jsonParser.parse(reader);
            JSONObject jsonob2 = (JSONObject) jsonob.get("data");
            JSONArray ja = (JSONArray) jsonob2.get("parameters");
            //iterating throw data form json file

            for (int i = 0; i < ja.size(); i++) {
                JSONOBJ = (JSONObject) ja.get(i);
                boolean is_excuting = false;
                String FirstName = JSONOBJ.get("FirstName").toString();
                String LastName = JSONOBJ.get("LastName").toString();
                String eventCode = JSONOBJ.get("eventCode").toString();
                String City = JSONOBJ.get("City").toString();
                String requestId = jsonob.get("requestId").toString();
                int s = statement.insert(eventCode, requestId, City, FirstName, LastName, is_excuting);
                if (s > 0) {
                    String Transid = getLastId.getTransactionID();
                    JSONOBJ.replace("TransactionId", Transid);
                    jsonArray.add(JSONOBJ);
                    List<JSONArray> list = new ArrayList<>();
                    for (int j = 0; j < jsonArray.size(); j++) {
                        for (int k = 0; k < maxT; k++) {
                            list.add(jsonArray);
                        }
                    }
                    Runnable r = new PostRequest(jsonArray);
                    ExecutorService pool = Executors.newFixedThreadPool(maxT);
                    pool.execute(r);
                } else {
                    System.out.println(" error 404");
                }
            }

//            for (int i = 0; i < maxT; i++) {
//
//            }
//            Thread.sleep(1000);
//           sss
            System.out.println("insertion succssefully!");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException | ParseException | SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
//dania al kayed carrersajib.com
