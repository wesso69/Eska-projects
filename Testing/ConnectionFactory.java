package Testing;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    //using singleton design pattern to get instance from connection factory class
    static Connection connection = null;

    private ConnectionFactory() {
    }

    public static Connection getConnection() throws FileNotFoundException, IOException {
        String appConfigPath = "C:\\Users\\w.shraideh\\Documents\\NetBeansProjects\\JavaApplication1\\src\\javaapplication1\\application.properties";
        Properties appProps = new Properties();
        appProps.load(new FileInputStream(appConfigPath));
        if (connection == null) {
            String uname = appProps.getProperty("uname");
            String pass = appProps.getProperty("password");
            String url = appProps.getProperty("url");
            try {
                Class.forName(appProps.getProperty("className"));
                connection = DriverManager.getConnection(url, uname, pass);
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println(e);
            }
        }
        return connection;
    }
}
