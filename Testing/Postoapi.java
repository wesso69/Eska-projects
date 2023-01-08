/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing;

import org.json.simple.JSONArray;

import java.io.*;
import java.net.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Postoapi {

    static JSONObject jsonobject1 = new JSONObject();

    public Postoapi() {
    }

    public static void PostData(JSONArray jsonobject) throws MalformedURLException, IOException, ParseException, SQLException {

        String appConfigPath = "C:\\Users\\w.shraideh\\Documents\\NetBeansProjects\\JavaApplication1\\src\\javaapplication1\\application.properties";
        Properties appProps = new Properties();

        appProps.load(new FileInputStream(appConfigPath));
        URL url = new URL(appProps.getProperty("apiUrl"));

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Content-Length", "1000");
        con.setRequestProperty("Cookie", "name1=value1; name2=value2");
        //converting json object to String to send it to the  api
        String body = jsonobject.toString();
        //sending the post request to api 

        con.setDoOutput(
                true);
        try (DataOutputStream out = new DataOutputStream(con.getOutputStream())) {
            out.writeBytes(body);
            out.flush();
            out.close();
        }

        System.out.println(body);
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
}
