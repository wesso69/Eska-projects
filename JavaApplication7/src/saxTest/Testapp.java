package saxTest;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Testapp {

//    private static final String inputfile = "C:\\Users\\w.shraideh\\Documents\\NetBeansProjects\\JavaApplication7\\src\\saxTest\\input.xml";
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        try {
            File input = new File("C:\\Users\\w.shraideh\\Documents\\NetBeansProjects\\JavaApplication7\\src\\saxTest\\input.xml");
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser();
            userHandler userhandler = new userHandler();
            sp.parse(input, userhandler);

        } catch (ParserConfigurationException | SAXException e) {
            System.out.println(e);
        }
    }
}
            
        
    