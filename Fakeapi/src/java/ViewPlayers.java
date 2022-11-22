
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import org.json.JSONObject;

public class ViewPlayers extends HttpServlet {

    public void alert(String str) {
        JOptionPane.showMessageDialog(null, str);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.print("<a href='index.html'> Add new player</a><br>");

        try {
            Map<Integer, Player> m1 = Playerinf.getAllPlayers();
            System.out.println("Map Size: " + m1.size());
            if (m1.size() != 0) {
                m1.forEach((I, p) -> {
                    String json;
                    json = "{ ";
                    json += " id:" + p.getId() + ",\n";
                    json += " fname:" + JSONObject.quote(p.getFname()) + ",\n";
                    json += " lname:" + JSONObject.quote(p.getLname()) + ",\n";
                    json += " about:" + JSONObject.quote(p.getAbout()) + ",\n";
                    json += "age:" + p.getAge() + ",\n";
                    json += "}";
                    JSONObject jsonObj = new JSONObject(json);
                    int id = p.getId();
                    out.println(" " + id + jsonObj.toString(7));
                    out.println("<a href='DeletePlayer?id=" + p.getId() + "'>delete</a>");
                });
            } else {
                out.print("map is empty");
            }
        } catch (Exception ex) {
            out.print(ex);
        }
    }
}
