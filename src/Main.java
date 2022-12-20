import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        statement stmt = statement.getInstance();
        System.out.println(stmt.getInstance());
        JSONParser jsonParser = new JSONParser();
        JSONObject JSONOBJ;
        try (FileReader reader = new FileReader("C:\\Users\\Jereis\\IdeaProjects\\Transaction\\src\\JSONfile.json")){
           JSONObject jsonob = (JSONObject) jsonParser.parse(reader);
            JSONObject jsonob2 = (JSONObject) jsonob.get("data") ;
            JSONArray ja = (JSONArray) jsonob2.get("parameters");

            for(int i=0 ; i < 1 ; i++){
                JSONOBJ = (JSONObject) ja.get(i);
                String id= "5";
                String is_excuting ="0";
                String FirstName = JSONOBJ.get("FirstName").toString();
                String LastName = JSONOBJ.get("LastName").toString();
                String eventCode = JSONOBJ.get("eventCode").toString();
                String City = JSONOBJ.get("City").toString();
                String requestId = jsonob.get("requestId").toString();
//                System.out.println( "FirstName "+FirstName+" LastName "+LastName +" City "+City+ " eventCode "+eventCode + " requestId" +requestId);

                     int s=stmt.insert(id,eventCode,requestId,City,FirstName,LastName," "," "," ",is_excuting);
                     if (s >0){
                         System.out.println("insertion succssefully !");
                     } else {
                         System.out.println(" error 404");
                     }
            }




        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}