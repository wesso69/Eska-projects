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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        JSONObject responseObject = new JSONObject();
        try {
            if (req.getMethod().equalsIgnoreCase("POST")) {
                Readtransaction readBody = new Readtransaction();
                String body = readBody.getBody(req);
                System.out.println(body);
                GetData g = new GetData();
                responseObject = g.GetTags(req, res, body);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        res.setContentType("application/json");
        out.print(responseObject);
        out.flush();
    }
}
