
import java.sql.Connection;
import java.sql.DriverManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author W.Shraideh
 */
public class ConnectionFactory {

    static Connection connection = null;

    private ConnectionFactory() {
    }

    public static Connection getConnection() {

        if (connection == null) {
            String uname = "root";
            String pass = "Waseem.123";
            String url = "jdbc:mysql://localhost:3306/University";
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, uname, pass);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return connection;
    }
}
