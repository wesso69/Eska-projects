package Testing;

import static Testing.Postoapi.jsonobject1;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class PostRequest implements Runnable {

     JSONArray jsonArray = new JSONArray();

    public PostRequest(JSONArray jsonobject) {
        this.jsonArray = jsonobject;
    }

    public  void PostData() throws MalformedURLException, IOException, ParseException, SQLException {

        String appConfigPath = "C:\\Users\\w.shraideh\\Documents\\NetBeansProjects\\JavaApplication1\\src\\javaapplication1\\application.properties";
        Properties appProps = new Properties();

        appProps.load(
                new FileInputStream(appConfigPath));
        URL url = new URL(appProps.getProperty("apiUrl"));

        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Content-Length", "1000");
        con.setRequestProperty("Cookie", "name1=value1; name2=value2");
        //converting json object to String to send it to the  api
        String body = jsonArray.toString();
        //sending the post request to api 

        con.setDoOutput(true);
        try (DataOutputStream out = new DataOutputStream(con.getOutputStream())) {
            out.writeBytes(body);
            out.flush();
            out.close();
        }
        
        //getting response back 
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        //storing response in string file using StringBuilder
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
            JSONParser parser = new JSONParser();
            jsonobject1 = (JSONObject) parser.parse(inputLine);
            for (int i = 0; i < jsonobject1.size(); i++) {
                statement.updateTable(jsonobject1);
            }
        }
    }

    @Override
   synchronized public void run() {
        try {
            PostData();
        } catch (IOException ex) {
            Logger.getLogger(PostRequest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(PostRequest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PostRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
         try {
             Thread.sleep(1000);
         } catch (InterruptedException ex) {
             Logger.getLogger(PostRequest.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    private void processmessage() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
    }
}
