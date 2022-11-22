
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
//player inf class (services done to the player)

public class Playerinf {

    private static Map<Integer, Player> Personmap = new HashMap<>();

    private static Playerinf instance = new Playerinf();

    public static Playerinf getinstance() {
        return instance;
    }
    //getconnection() method that returns connection to use it more than one time 

    public Connection getConnectionOLD() {
        String uname = "root";
        String pass = "Waseem.123";
        String url = "jdbc:mysql://localhost:3306/University";
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, uname, pass);

        } catch (Exception e) {
            System.out.println(e);
        }
        return con;

    }

    private Playerinf() {
        try {
            String query = "select * from Gamers";
            Connection con = ConnectionFactory.getConnection();
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                Personmap.put(rs.getInt(1),
                        new Player(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
            }
            JSONObject json = new JSONObject(Personmap);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static Map<Integer, Player> getAllPlayers() throws SQLException {
        Map<Integer, Player> Personsmap = new HashMap<>();
        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from Gamers");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Personsmap.put(rs.getInt(1),
                        new Player(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
            }
            rs.close();
            ps.close();

            // JSONObject json = new JSONObject(Personsmap);
        } catch (SQLException sq) {
            System.out.println(sq);
        }
        return Personsmap;
    }

    public Player getplayerId(int id) {
        return Personmap.get(id);
    }

    public static int setPlayer(Player p) throws SQLException {
        int status = 0;
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = con.prepareStatement(" INSERT INTO Gamers VALUES (?,?,?,?,?)");
        ps.setInt(1, p.getId());
        ps.setString(2, p.getFname());
        ps.setString(3, p.getLname());
        ps.setString(4, p.getAbout());
        ps.setInt(5, p.getAge());
        status = ps.executeUpdate();
        ps.close();
        return status;
    }

    public static int deletePlayer(int id) {
        int status = 0;
        try {
            Connection con = ConnectionFactory.getConnection();

            PreparedStatement ps = con.prepareStatement("delete from Gamers where id=?");
            ps.setInt(1, id);
            status = ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

}
