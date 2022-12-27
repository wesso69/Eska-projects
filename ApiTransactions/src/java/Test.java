/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;

/**
 *
 * @author W.Shraideh
 */
public class Test extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
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
            //checking wheather the method of teh request is post or get
            if (req.getMethod().equalsIgnoreCase("POST")) {
                //reading the body of the request
                Readtransaction readBody = new Readtransaction();
                String body = readBody.getBody(req);
               //calling the TransactionJsonData class to 
                TransactionJsonData TJD = new TransactionJsonData();
                responseObject = TJD.GetTags(req, res, body);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        res.setContentType("application/json");
        out.print(responseObject.toString());
        out.flush();
    }
}
