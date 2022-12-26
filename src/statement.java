
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.Calendar;

public class statement {
    static LocalTime time = LocalTime.now();
    private static statement instance;

    private statement() {
    }

    public static statement getInstance() {
        return instance;
    }

    public static int insert(String EVENT_CODE, String REQUESTID, String City, String FirstName, String LastName, String response_message, String CREATE_DATE, String REPLY_DATE, boolean IS_executuig) throws SQLException, ClassNotFoundException {
        Connection c = null;
        PreparedStatement ps = null;
        int recordState = 0;

        try {
            c = ConnectionFactory.getConnection();
            ps = c.prepareStatement("INSERT INTO bsa_transactions (EVENT_CODE, REQUESTID, City, FirstName, LastName, response_message , CREATE_DATE , REPLY_DATE , IS_executuig) VALUES (?, ?, ?, ?, ?, ? , ? ,? ,?)");
            ps.setString(1, EVENT_CODE);
            ps.setString(2, REQUESTID);
            ps.setString(3, City);
            ps.setString(4, FirstName);
            ps.setString(5, LastName);
            ps.setString(6, REQUESTID);
            ps.setString(7, CREATE_DATE);
            ps.setString(8, REPLY_DATE);
            ps.setBoolean(9, false);

            recordState = ps.executeUpdate();
        } catch (SQLException e) {
        }
        return recordState;
    }

    public static String getTransactionID() throws SQLException {
        Connection c = null;
        Statement stmt = null;
        ResultSet rs = null;
        String s = null;
        try {
            c = ConnectionFactory.getConnection();
            stmt = c.createStatement();
            rs = stmt.executeQuery("SELECT (TRANSACTION_ID) FROM bsa_transactions  ORDER BY TRANSACTION_ID DESC LIMIT 1");
            while (rs.next()) {
                s = rs.getString(1);

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return s;
    }
//
//    public static String getCREATE_DATE() {
//        LocalTime time = LocalTime.now();
//        String timef = time.toString();
//        return timef;
//    }
    static public void updateTransactionTable(JSONObject responseMessage) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        JSONObject jsonObject = new JSONObject();

        try {

            connection = ConnectionFactory.getConnection();

            JSONArray responseArray = (JSONArray) responseMessage.get("data");

            for (int i = 0; i < responseArray.size(); i++) {

                jsonObject = (JSONObject) responseArray.get(i);

                String transaction = jsonObject.get("TRANSACTION_ID").toString();

                String REPLY_DATE = time.toString();

                String query = "UPDATE bsa_transactions SET response_message = ? , REPLY_DATE = ?  WHERE TRANSACTION_ID = ?";

                preparedStatement = connection.prepareStatement(query);

                preparedStatement.setObject(1, jsonObject.toString().replaceAll("null", "''"));
                preparedStatement.setString(2, REPLY_DATE);
                preparedStatement.setString(3, transaction);

                preparedStatement.execute();

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            preparedStatement.close();
        }


    }
}