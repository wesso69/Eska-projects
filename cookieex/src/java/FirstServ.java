

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FirstServ extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {

        try {
            response.setContentType("text/html");

            PrintWriter out = response.getWriter();

            String n = request.getParameter("uname");
            out.print("Welcome " + n);
            Cookie ck = new Cookie("uname", n);
            response.addCookie(ck);
            out.print("<form action='servlet2'>");
            out.print("<input type='submit' value='go'>");
            out.print("</form>");

            out.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
