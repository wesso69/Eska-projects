package javaapplication5;

import java.sql.*;

public class JavaApplication5 {

    static final String URL = "jdbc:mysql://localhost:3306/University";
    static final String USER = "root";
    static final String PASS = "Waseem.123";
    static final String QUERY = "SELECT * FROM Itstudent";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(URL, USER, PASS);

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " "
                        + rs.getString(3) + " " + rs.getString(4) + " " + rs.getInt(5) + " " + rs.getInt(6));
            }
            System.out.println("success");
        } catch (Exception e) {
            System.out.println(e);
        }

//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection conn = DriverManager.getConnection(URL, USER, PASS);
//            Statement stmt = (Statement) conn.createStatement();
//            ResultSet rs = stmt.executeQuery(QUERY);)
//            {
//                // Extract data from result set
//                while (rs.next()) {
//                    // Retrieve by column name
//                    System.out.print("ID: " + rs.getInt(1));
//                    System.out.print(", First: " + rs.getString(2));
//                    System.out.println(", Last: " + rs.getString(3));
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}

//try {
//            //step1 load the driver class  
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//
//            try ( //step2 create  the connection object
//                    Connection con = DriverManager.getConnection(
//                            "jdbc:oracle:thin:@localhost:1521:xe", "system", "oracle")) {
//                //step3 create the statement object
//                Statement stmt = (Statement) con.createStatement();
//                //step4 execute query
//                ResultSet rs = stmt.executeQuery("select * from emp");
//                while (rs.next()) {
//                    System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
//                }
//                //step5 close the connection object
//            }
//
//        }catch(ClassNotFoundException | SQLException e){ System.out.println(e);}  
//    }
