package javaapplication10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Playerserv {

    private static Playerserv instance = new Playerserv();

    public Playerserv getinstnace() {
        return instance;
    }

    public Connection getConnection() {
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

    public int setPlayer(Playert player) throws SQLException {
        int stat = 0;
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement("insert into gamers values (?,?,?,?,?)");
        ps.setInt(1, player.getId());
        ps.setString(2, player.getFname());
        ps.setString(3, player.getLname());
        ps.setString(4, player.getAbout());
        ps.setInt(5, player.getAge());
        ps.executeUpdate();
        return stat;
    }

}
