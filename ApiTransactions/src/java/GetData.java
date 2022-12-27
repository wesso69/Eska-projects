
import java.io.FileNotFoundException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GetData {

    @SuppressWarnings("unchecked")
    public JSONObject GetTags(HttpServletRequest request, HttpServletResponse response, String body)
            throws FileNotFoundException {
        boolean success = false;
        JSONObject firstObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        JSONObject responseObject = new JSONObject();
        JSONObject jsonResponse = new JSONObject();
        JSONArray responseArray = new JSONArray();
        String errorMessage = "";
        String status = "";

        try {

            jsonArray = (JSONArray) new JSONParser().parse(body);

            for (int i = 0; i < jsonArray.size(); i++) {
                firstObject = (JSONObject) jsonArray.get(i);

                String priority = firstObject.get("priority").toString();
                String AppointmentNo = firstObject.get("AppointmentNo").toString();
                String FeasibilityId = firstObject.get("FeasibilityId").toString();
                String is_success = firstObject.get("FiberType").toString();
                String trancationId = firstObject.get("TransactionId").toString();
                int saved = TransactionsDao.insert(Integer.valueOf(trancationId), priority, AppointmentNo, FeasibilityId, success);
                if (saved > 0) {
                    System.out.println("Successfully!");
                }
                if (is_success.equalsIgnoreCase("FTTB") || is_success.equalsIgnoreCase("FTTH")) {
                    success = true;

                } else {
                    success = false;
                }
                responseObject = TransactionsDao.updateIsExecutuig(trancationId, response);
                responseArray.add(responseObject);

            }

            status = "Success";
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
