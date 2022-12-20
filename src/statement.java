
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class statement {
    private static  statement instance;

    private statement() {
    }
    public static statement getInstance() {
        return instance;
    }

    public static int insert( String id,String Fname, String Lname, String eventCode , String City, String requestid ,String msg,String createDate,String ReplayDate,String isexcuting) throws SQLException, ClassNotFoundException {
        Connection c = null;
        PreparedStatement ps = null;
        int recordState = 0;

        try {
            c = ConnectionFactory.getConnection();
            ps = c.prepareStatement("insert into bsa_transactions  values (?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, id);
            ps.setString(2, Fname);
            ps.setString(3, Lname);
            ps.setString(4, eventCode);
            ps.setString(5, City);
            ps.setString(6, requestid);
            ps.setString(7,msg);
            ps.setString(8,createDate);
            ps.setString(9,ReplayDate);
            ps.setString(10,isexcuting);
            recordState = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recordState;
    }
}
