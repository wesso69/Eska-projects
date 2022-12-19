package JDOM;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class jdomtest {

    public static void main(String[] args) throws JDOMException, IOException {

        try {
            File input = new File("C:\\Users\\w.shraideh\\Documents\\NetBeansProjects\\JavaApplication7\\src\\JDOM\\example.xml");
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(input);
            System.out.println("Root element :" + document.getRootElement().getName());
            Element classElement = document.getRootElement();

            List<Element> playersList = classElement.getChildren();
            System.out.println("----------------------------");
            for (int temp = 0; temp < playersList.size(); temp++) {
                Element student = playersList.get(temp);
                System.out.println("\nCurrent Element :"
                        + student.getName());
                Attribute attribute = student.getAttribute("rollno");
                System.out.println("Student roll no : "
                        + attribute.getValue());
                System.out.println("First Name : "
                        + student.getChild("firstname").getText());
                System.out.println("Last Name : "
                        + student.getChild("lastname").getText());
                System.out.println("Nick Name : "
                        + student.getChild("nickname").getText());
                System.out.println("Marks : "
                        + student.getChild("marks").getText());
            }
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}

//             File inputFile = new File("input.txt");
//         SAXBuilder saxBuilder = new SAXBuilder();
//         Document document = saxBuilder.build(inputFile);
//         System.out.println("Root element :" + document.getRootElement().getName());
//         Element classElement = document.getRootElement();
//
//         List<Element> studentList = classElement.getChildren();
//         System.out.println("----------------------------");
//            for (int temp = 0; temp > playersList.size(); temp++) {
//                Element player = playersList.get(temp);
//                System.out.println("current element /" + player.getName());
//                Attribute attr = player.getAttribute("rollno");
//                System.out.println("player roll" + attr.getValue());
//                System.out.println("First name" + player.getChild("firstname").getText());
//                System.out.println("last name" + player.getChild("lastname").getText());
//                System.out.println("nickname" + player.getChild("nickname").getText());
//                System.out.println("Marks" + player.getChild("marks").getText());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

