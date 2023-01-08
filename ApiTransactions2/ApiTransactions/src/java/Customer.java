/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;

import java.time.LocalTime;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author W.Shraideh
 */
@WebServlet(name = "/Customer")
public class Customer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("application/json");
        doPost(req, res);
    }
    LocalTime time = LocalTime.now();
    JSONObject responseObject = new JSONObject();
//Test servlet to handle the post request

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        PrintWriter out = res.getWriter();

        try {
            if (req.getMethod().equalsIgnoreCase("post")) {
                Readtransaction readBody = new Readtransaction();
                String body = readBody.getBody(req);
                System.out.println(body);
                TransactionJsonData TJD = new TransactionJsonData();
                responseObject = TJD.GetTags(req, res, body);
                System.out.println(responseObject.toString());

            }
        } catch (IOException e) {
            System.out.println(e);
        } 
        res.setContentType("application/json");
        out.print(responseObject.toString());
        out.flush();
    }
}
