
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewServlet extends HttpServlet {

    ServletConfig config = null;

    @Override
    public void init(ServletConfig config) {
        this.config = config;
        System.out.println("servlet is initialized ");
      
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String n = req.getParameter("name");
        out.print("hello " + n);
        out.close();
        init(config);
        String s= getServletInfo();
        out.print(s);
      
    }

    @Override
    public void destroy() {  
        System.out.println("servlet is destroyed");
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public String getServletInfo() {
        return "copyright 2007-1010";
    }
}
