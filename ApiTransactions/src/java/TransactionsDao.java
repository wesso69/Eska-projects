
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

    public static int insert(Transactions t) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        int recordState = 0;
        try {
            c = ConnectionFactory.getConnection();
            ps = c.prepareStatement("INSERT INTO bsa_details (TRANSACTION_ID,priority,AppointmentNo,FeasibilityId,is_success) VALUES (?,?,?,?,?)");
            ps.setInt(1, t.getTRANSACTION_ID());
            ps.setString(2, t.getPriority());
            ps.setString(3, t.getAppointmentNo());
            ps.setString(4, t.getFeasibilityId());
            ps.setBoolean(5, t.GetIs_success());
            recordState = ps.executeUpdate();
        } catch (SQLException e) {
        }
        return recordState;
    }
}
