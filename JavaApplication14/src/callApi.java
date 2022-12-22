//import java.net.HttpURLConnection;
//import java.net.URI;
//import java.net.URL;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//
//import main.InsertToTable;
//
//public class callApi {
//
//	private static final String POST_URL = "http://localhost:8080/TransactionsAPI/api/employee";
//
//	@SuppressWarnings("unchecked")
//	static public void RequestAPI(JSONArray jsonData) {
//
//		try {
//
//			// Request
//			HttpClient client = HttpClient.newHttpClient();
//			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(POST_URL))
//					.POST(HttpRequest.BodyPublishers.ofString(jsonData.toString())).build();
//
//			HttpResponse<String> respose = client.send(request, HttpResponse.BodyHandlers.ofString());
//			
//			
//
////			URL url = new URL(POST_URL);
////			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//			// Response
//			int statusCode = respose.statusCode();
//			
//			
//			JSONParser jsonParser = new JSONParser();
//
//			Object obj = jsonParser.parse(respose.body());
//			JSONObject responseMessage = (JSONObject) obj;
//			responseMessage.put("error-Code", statusCode);
//			
//			InsertToTable.updateTransactionTable(responseMessage);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
//
//}