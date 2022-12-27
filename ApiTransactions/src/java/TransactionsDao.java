
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;

public class TransactionsDao {

    private static TransactionsDao instance;

    private TransactionsDao() {
    }

    public static TransactionsDao getInstance() {
        return instance;
    }

    public static int insert(int id, String prio,String appo ,String feas, boolean succ) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        int recordState = 0;
        try {
            c = ConnectionFactory.getConnection();
            ps = c.prepareStatement("INSERT INTO bsa_details (TRANSACTION_ID,priority,AppointmentNo,FeasibilityId,is_success) VALUES (?,?,?,?,?)");
            ps.setInt(1, id);
            ps.setString(2, prio);
            ps.setString(3, appo);
            ps.setString(4, feas);
            ps.setBoolean(5, succ);
            recordState = ps.executeUpdate();
        } catch (SQLException e) {
        }
        return recordState;
    }
    @SuppressWarnings("unchecked")
	public static JSONObject updateIsExecutuig(String transaction, HttpServletResponse response) throws SQLException {

		PreparedStatement ps = null;
		Connection c = null;
		JSONObject jsonObject = new JSONObject();
                GetJson g = new GetJson();
		try {
			c = ConnectionFactory.getConnection();

			String query = "UPDATE bsa_transactions SET IS_executuig = true WHERE TRANSACTION_ID = ? ";

			ps = c.prepareStatement(query);

			ps.setString(1, transaction);

			int counter = ps.executeUpdate();

			if (counter > 0) {
				g.setStatus("Success");
			} else {
				g.setStatus("Failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			g.setErrorMessage(e.getMessage());

		} finally {
			

			// Create jsonObject
			jsonObject.put("TRANSACTION_ID", transaction);
			jsonObject.put("status", g.getStatus());
			jsonObject.put("error message", g.getErrorMessage());

		}

		return jsonObject;
	}
}
