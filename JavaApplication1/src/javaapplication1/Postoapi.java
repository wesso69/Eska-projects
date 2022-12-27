/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import org.json.simple.JSONArray;


import java.io.*;
import java.net.*;

public class Postoapi {
//    private static final String URL = "http://localhost:8080/ApiTransactions/saveTransaction";

    public Postoapi() {
    }

    public static void PostData(JSONArray jsonobject) throws MalformedURLException, IOException {
        URL url = new URL("http://localhost:8084/ApiTransactions/Test");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        con.setRequestProperty("Content-Length", "10");
        String body = jsonobject.toString();
        con.setDoOutput(true);
        try (DataOutputStream out = new DataOutputStream(con.getOutputStream())) {
            out.writeBytes(body);
            out.flush();
            out.close();
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // Print the response
        System.out.println(response.toString());
    }

}

//            			// Request
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(String.valueOf(url)))
//                .POST(HttpRequest.BodyPublishers.ofString(jsonobject.toString())).build();
//        HttpResponse<String> respose = client.send(request, HttpResponse.BodyHandlers.ofString());
//        int statusCode = respose.statusCode();
//        JSONParser jsonParser = new JSONParser();
//        Object obj = jsonParser.parse(respose.body());
//        JSONObject responseMessage = (JSONObject) obj;
//        responseMessage.put("error-Code", statusCode);
//    }
//    }
//import java.io.BufferedReader;
//        import java.io.DataOutputStream;
//        import java.io.InputStreamReader;
//        import java.net.HttpURLConnection;
//        import java.net.URL;
//
//public class Main {
//    public static void main(String[] args) {
//        try {
//            // Create a URL object for the POST request
//            URL url = new URL("http://www.example.com/post");
//
//            // Open a connection to the URL
//            HttpURLConnection con = (HttpURLConnection) url.openConnection();
//
//            // Set the request method to POST
//            con.setRequestMethod("POST");
//
//            // Set the request properties
//            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//            con.setRequestProperty("Content-Length", "10");
//
//            // Set the request body
//            String body = "key1=value1&key2=value2";
//
//            // Send the POST request
//            con.setDoOutput(true);
//            DataOutputStream out = new DataOutputStream(con.getOutputStream());
//            out.writeBytes(body);
//            out.flush();
//            out.close();
//
//            // Read the response from the server
//            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
//            String inputLine;
//            StringBuilder response = new StringBuilder();
//            while ((inputLine = in.readLine()) != null) {
//                response.append(inputLine);
//            }
//            in.close();
//
//            // Print the response
//            System.out.println(response.toString());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
