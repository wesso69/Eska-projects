
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
// playerservlet servlet to get players and display them by thier id in the url
public class Playerservlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String requestUrl = req.getRequestURI();
        String pid = requestUrl.substring("/Fakeapi/players*".length());
        Player p = Playerinf.getinstance().getplayerId(Integer.parseInt(pid));

        if (p != null) {
            String json;
            json = "{ ";
            json += " id:" + p.getId() + ",\n";
            json += " fname:" + JSONObject.quote(p.getFname()) + ",\n";
            json += " lname:" + JSONObject.quote(p.getLname()) + ",\n";
            json += " about:" + JSONObject.quote(p.getAbout()) + ",\n";
            json += "age:" + p.getAge() + ",\n";
            json += "}";
            JSONObject jsonObj = new JSONObject(json);
            out.println(jsonObj.toString(6));
        } else {
            out.println(" nothing found !");
        }
        out.close();
    }

}
