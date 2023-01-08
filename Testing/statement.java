package Testing;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class statement {

    private static statement instance;

    private statement() {
    }

    public static statement getInstance() {
        return instance;
    }
//inserting data inside my table based on input fields

    public static int insert(String EVENT_CODE, String REQUESTID, String City, String FirstName, String LastName, boolean IS_executuig) throws SQLException, ClassNotFoundException, IOException {
        Connection c = null;
        PreparedStatement ps = null;
        int recordState = 0;

        try {
            c = ConnectionFactory.getConnection();
            ps = c.prepareStatement("INSERT INTO bsa_transactions (EVENT_CODE, REQUESTID, City, FirstName, LastName, CREATE_DATE , IS_executuig) VALUES (?, ?, ?, ?, ?, ? , ? )");
            ps.setString(1, EVENT_CODE);
            ps.setString(2, REQUESTID);
            ps.setString(3, City);
            ps.setString(4, FirstName);
            ps.setString(5, LastName);
            ps.setString(6, getSpecificDate.getDate());
            ps.setBoolean(7, false);

            recordState = ps.executeUpdate();

        } catch (SQLException e) {
            ps.close();
            c.close();
        }
        return recordState;

    }

    //updating the data after getting the response back from api
////////////////////
    public static void updateTable(JSONObject responseMessage) throws SQLException, IOException {
        PreparedStatement ps = null;
        Connection c = null;
        JSONObject jsonObject = new JSONObject();
        try {
            c = ConnectionFactory.getConnection();
            JSONArray resArr = (JSONArray) responseMessage.get("data");

            for (int i = 0; i < resArr.size(); i++) {
                jsonObject = (JSONObject) resArr.get(i);
                String transactionid = jsonObject.get("TRANSACTION_ID").toString();
                String query = "UPDATE bsa_transactions SET response_message = ?   WHERE TRANSACTION_ID = ?";
                ps = c.prepareStatement(query);
                ps.setObject(1, jsonObject.toString());
                ps.setString(2, transactionid);
                ps.execute();

            }
            ps.close();
            c.close();
        } catch (SQLException e) {
        } finally {

        }

    }

}
