
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class Test {

    private static Map<Integer, Player> Personmap = new HashMap<>();

    public static void main(String[] args) throws SQLException, JsonProcessingException {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = con.prepareStatement(" select * from Gamers");
        
//        ps.setInt(1,4);
//        ps.setString(2, "wesso4");
//        ps.setString(3, "ayman");
//        ps.setString(4, "cs go");
//        ps.setInt(5, 22);
ResultSet rs = ps.executeQuery();
while(rs.next()){
        System.out.println(rs.getInt(1)+" "+ rs.getString(2));
}
    }
}











