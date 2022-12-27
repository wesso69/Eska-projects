
import java.io.FileNotFoundException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class TransactionJsonData {
//Get data class to do services on data
    @SuppressWarnings("unchecked")
    public JSONObject GetTags(HttpServletRequest request, HttpServletResponse response, String body)
            throws FileNotFoundException {
        boolean success = false;
        JSONObject firstObject = new JSONObject();
        //json array to store the body of the request
        JSONArray jsonArray = new JSONArray();
        //json object to update the is_Executing in the first table 
        JSONObject responseObject = new JSONObject();
        //the final json object that retuns from method
        JSONObject jsonResponse = new JSONObject();
        //the final Jsonarray that is sent as respone to main project 
        JSONArray responseArray = new JSONArray();
        String errorMessage = "";
        String status = "";
        //iterating throw content of the body 
        try {
            jsonArray = (JSONArray) new JSONParser().parse(body);

            for (int i = 0; i < jsonArray.size(); i++) {
                firstObject = (JSONObject) jsonArray.get(i);
                String priority = firstObject.get("priority").toString();
                String AppointmentNo = firstObject.get("AppointmentNo").toString();
                String FeasibilityId = firstObject.get("FeasibilityId").toString();
                String is_success = firstObject.get("FiberType").toString();
                String trancationId = firstObject.get("TransactionId").toString();
                //checking if is_success field = FTTB or FTTH to update it
                if (is_success.equalsIgnoreCase("FTTB") || is_success.equalsIgnoreCase("FTTH")) {
                    success = true;
                    int saved = TransactionsServ.insert(Integer.valueOf(trancationId), priority, AppointmentNo, FeasibilityId, success);
                    if (saved > 0) {
                        System.out.println("Successfully!");
                    }
                } else {
                    success = false;
                }
                //update is excuting in the first table
                responseObject = TransactionsServ.updateIsExecutuig(trancationId, response);
                responseArray.add(responseObject);
                status = "Success";
            }

        } catch (NumberFormatException | SQLException | ParseException e) {
            e.getMessage();
            status = "Failed";
            errorMessage = e.getMessage();
        } finally {
            jsonResponse.put("error message", errorMessage);
            jsonResponse.put("status", status);
            jsonResponse.put("data", responseArray);
        }
        return jsonResponse;
    }
}
