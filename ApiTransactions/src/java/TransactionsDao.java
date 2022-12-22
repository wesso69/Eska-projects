
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
