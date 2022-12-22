
import java.io.FileNotFoundException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author W.Shraideh
 */
public class GetJson {

    @SuppressWarnings("unchecked")
    public JSONObject GetTags(HttpServletRequest request, HttpServletResponse response, String body)
            throws FileNotFoundException {
        boolean success = false;
        JSONObject finalObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        JSONObject responseObject = new JSONObject();
        JSONObject jsonResponse = new JSONObject();
        JSONArray responseArray = new JSONArray();
        String errorMessage = "";
        String status = "";

        try {

            jsonArray = (JSONArray) new JSONParser().parse(body);

            for (int i = 0; i < jsonArray.size(); i++) {
                finalObject = (JSONObject) jsonArray.get(i);
                
                String priority = finalObject.get("priority").toString();
                String AppointmentNo = finalObject.get("AppointmentNo").toString();
                String FeasibilityId = finalObject.get("FeasibilityId").toString();
                String is_success = finalObject.get("FiberType").toString();
                String trancationId = finalObject.get("Transaction").toString();

//                Transactions t = new Transactions();
//                t.setAppointmentNo(AppointmentNo);
//                t.setFeasibilityId(FeasibilityId);
//                t.setTRANSACTION_ID(Integer.valueOf(trancationId));
//                t.setPriority(priority);
//                t.setIs_success(false);

                int saved = TransactionsDao.insert(Integer.valueOf(trancationId),priority,AppointmentNo,FeasibilityId,success);
                if (saved > 0) {
                    System.out.println("Successfully!");
                }
                if (is_success.equalsIgnoreCase("FTTB") || is_success.equalsIgnoreCase("FTTH")) {
                    success = true;

                } else {
                    success = false;
                }
              
                responseArray.add(responseObject);

            }

            status = "Success";
        } catch (NumberFormatException | SQLException | ParseException e) {
            e.getMessage();
            status = "Failed";
            errorMessage = e.getMessage();
        

        } finally {
            jsonResponse.put("errro message", errorMessage);
            jsonResponse.put("status", status);
            jsonResponse.put("data", responseArray);

        }
     return jsonResponse;
    }
}



