/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author W.Shraideh
 */
public class saveTransaction extends HttpServlet {

    /**
     *
     * @param req
     * @param res
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        try (PrintWriter out = res.getWriter()) {
            int id = (4);
            String priorty = "priorty";
            String appoint = "appoint";
            String Feas = "Feas";
            boolean is = true;
            Transactions t = new Transactions();
            t.setFeasibilityId(Feas);
            t.setAppointmentNo(appoint);
            t.setIs_success(is);
            t.setTRANSACTION_ID(id);
            t.setPriority(priorty);
            try {
                int status = TransactionsDao.insert(t);
                if (status > 0) {
                    out.print("Successfully");
                    System.out.println("Successfully");
                } else {
                    
                    System.out.println("failed to save");
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }
}
