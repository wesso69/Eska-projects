package dp.sing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcSing {

    private static jdbcSing jdbcSing1;

    private jdbcSing() {
    }

    public static jdbcSing getInstatnce() {
        if (jdbcSing1 == null) {
            jdbcSing1 = new jdbcSing();
        }
        return jdbcSing1;
    }

    //        String uname = "root";
    //     String pass = "Waseem.123";
    //    String url = "jdbc:mysql://localhost:3306/University";
    //Class.forName("com.mysql.cj.jdbc.Driver");
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection con = null;
        if (con == null) {
            String uname = "root";
            String pass = "Waseem.123";
            String url = "jdbc:mysql://localhost:3306/University";
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, uname, pass);
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println(e);
            }

        }
        return con;
    }

    public int insert(int id, String name) throws SQLException, ClassNotFoundException {
        Connection c = null;
        PreparedStatement ps = null;
        int recordState = 0;

        try {
            c = ConnectionFactory.getConnection();
            ps = c.prepareStatement("insert into user420 values (?,?)");
            ps.setInt(1, id);
            ps.setString(2, name);
            recordState = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recordState;
    }

    public void view(int id) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = ConnectionFactory.getConnection();
            ps = c.prepareStatement("select * from user420 where id=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2));
            }
        } catch (SQLException e) {
            System.out.println(e);
        } 
//        finally {
//            if (rs != null) {
//                rs.close();
//            }
//            if (ps != null) {
//                ps.close();
//            }
//            if (c != null) {
//                c.close();
//            }
//        }

    }

    public void viewAll() throws SQLException {
        Connection c = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            c = ConnectionFactory.getConnection();
            stmt = c.createStatement();
            rs = stmt.executeQuery("select * from user420");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
//        finally {
//            if (rs != null) {
//                rs.close();
//            }
//            if (stmt != null) {
//                stmt.close();
//            }
//            if (c != null) {
//                c.close();
//            }
//        }

    }

}
