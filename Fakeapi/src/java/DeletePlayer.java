
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

//this servlet deletes players from the db and ViewPlayers
public class DeletePlayer extends HttpServlet {

    void alert(String str) {
        JOptionPane.showMessageDialog(null, str);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        try (PrintWriter out = res.getWriter()) {
            String sid = req.getParameter("id");
            Playerinf.deletePlayer(Integer.valueOf(sid));
            res.sendRedirect("ViewPlayers");
        }
    }

    public String getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return formatter.format(date);
    }
}
