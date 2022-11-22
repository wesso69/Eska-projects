
import java.io.PrintWriter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class servlet2 extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {

            response.setContentType("text/html");
            try (PrintWriter out = response.getWriter()) {
                Cookie ck[] = request.getCookies();
                out.print("hello " + ck[0].getValue());
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
