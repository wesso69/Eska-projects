
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

//saveplayer serv to add new players in the db
public class SavePlayer extends HttpServlet {

    public void alert(String str) {
        JOptionPane.showMessageDialog(null, str);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String id = req.getParameter("ID");
        String Fname = req.getParameter("Fname");
        String Lname = req.getParameter("Lname");
        String About = req.getParameter("About");
        String AGE = req.getParameter("AGE");
        if(id==null || id==" "){
            alert("please enter id");
            req.getRequestDispatcher("index.html").include(req,res);
        }
        Player p = new Player();
        p.setId(Integer.valueOf(id));
        p.setFname(Fname);
        p.setLname(Lname);
        p.setAbout(About);
        p.setAge(Integer.valueOf(AGE));
        try {
            int status = Playerinf.setPlayer(p);
            if (status > 0) {
                req.getRequestDispatcher("index.html").include(req, res);
               alert("saved");
            } else {
  
                alert("failed to save");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        out.close();

    }

}
