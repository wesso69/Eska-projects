/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author W.Shraideh
 */
public class getLastId {

    public static String getTransactionID() throws SQLException, IOException {
        Connection c = null;
        Statement stmt = null;
        ResultSet rs = null;
        String s = null;
        try {
            c = ConnectionFactory.getConnection();
            stmt = c.createStatement();
            rs = stmt.executeQuery("SELECT (TRANSACTION_ID) FROM bsa_transactions  ORDER BY TRANSACTION_ID DESC LIMIT 1");
            while (rs.next()) {
                s = rs.getString(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return s;
    }
}
