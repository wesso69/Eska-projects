
import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;

public class Readtransaction {

    //Readtransaction class to read data from reauest 
    //getbody method that takes httpservlet request as a parameter and return it as  a string  
    public String getBody(HttpServletRequest request) throws IOException {
        String trasnsactionBody = null;
        String line = null;

        try {
            BufferedReader bufferedReader = request.getReader();

            while ((line = bufferedReader.readLine()) != null) {
                trasnsactionBody = line;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return trasnsactionBody;
    }
}
