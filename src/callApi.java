
import java.net.URI;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class callApi {

	private static final String POST_URL = "http://localhost:8080/Testapi/TransactionApi";
	static statement stmt = statement.getInstance();

	static public void RequestAPI(JSONArray jsonData) {

		try {

			// Request
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(POST_URL))
					.POST(HttpRequest.BodyPublishers.ofString(jsonData.toString())).build();

			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			int statusCode = response.statusCode();


			JSONParser jsonParser = new JSONParser();

			Object obj = jsonParser.parse(response.body());
			JSONObject responseMessage = (JSONObject) obj;
			responseMessage.put("error-Code", statusCode);

			stmt.updateTransactionTable(responseMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
/*
URL url = new URL("http://localhost:8080/Testapi/TransactionApi");
        HttpURLConnection request1 = (HttpURLConnection) url.openConnection();
        request1.setRequestMethod("POST");
        request1.connect();
        InputStream is = request1.getInputStream();
        BufferedReader bf_reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            while ((line = bf_reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
        } finally {
            try {
                is.close();
            } catch (IOException e) {
            }
        }
        String responseBody = sb.toString();
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(responseBody);
        System.out.println(obj);
 */