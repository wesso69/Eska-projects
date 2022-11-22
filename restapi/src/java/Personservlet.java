import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

public class Personservlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String requestUrl = request.getRequestURI();
        String name = requestUrl.substring("//////////people".length());
        Person p = DataStore.getinstance().getperson(name);
        
       
        
// String json = "{" +
//                    "Name : Jai," +
//                    "Age : 25, " +
//                    "Salary: 25000.00 " +
//                    "}";

        if (p != null) {
            String json;
            json = "{ ";
            json += " name:" + JSONObject.quote(p.getName()) + ",\n";
            json += "about:" + JSONObject.quote(p.getAbout()) + ",\n";
            json += "birthyear:" + p.getBirthYear() + ",\n";
            json += "}";
            JSONObject jsonObj = new JSONObject(json);
            out.println(jsonObj.toString(4));

        } else {
                        out.println(" nothing found !");
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String name = request.getParameter("name");
        String about = request.getParameter("about");
        int birthYear = Integer.parseInt(request.getParameter("birthyear"));

        DataStore.getinstance().putperson(new Person(name, about, birthYear));
    }
}
