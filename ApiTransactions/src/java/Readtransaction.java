
import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;

public class Readtransaction {
    
    
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
