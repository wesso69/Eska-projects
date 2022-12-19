package javaapplication7;

//import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
//import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
//import org.w3c.dom.Element;
import org.w3c.dom.traversal.DocumentTraversal;
import org.w3c.dom.traversal.NodeFilter;
import org.w3c.dom.traversal.NodeIterator;
import org.xml.sax.SAXException;

public class JavaApplication7 {

    private static final String inputfile = "C:\\Users\\w.shraideh\\Documents\\NetBeansProjects\\JavaApplication7\\src\\javaapplication7\\newXMLDocument.xml";

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
//        try {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(inputfile);
        doc.getDocumentElement().normalize();

        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
//            NodeList nlist = doc.getElementsByTagName("student");
        System.out.println("--------------");
        NodeList nlist = doc.getElementsByTagName("student");
        for (int temp = 0; temp < nlist.getLength(); temp++) {
            Node node = nlist.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element) node;

                System.out.println("first name : " + e.getElementsByTagName("firstname").item(0).getTextContent() 
                        + " last name : " + e.getElementsByTagName("lastname").item(0).getTextContent()
                        + " nickname : " + e.getElementsByTagName("nickname").item(0).getTextContent());
            }
        }
    }
}
//        System.out.println(nlist.item(0).getTextContent());
//        DocumentTraversal trav = (DocumentTraversal) doc;
//        NodeIterator it = trav.createNodeIterator(doc.getDocumentElement(),
//                NodeFilter.SHOW_ELEMENT, null, true);
//        int c = 1;
//        for (Node node = it.nextNode(); node != null;
//                node = it.nextNode()) {
//            String text = node.getTextContent().trim();
//            System.out.println(text);
//        }

//            System.out.println("fname"+ " ");
//            System.out.println("lname :"+node.getTextContent().trim());
//            if (node.getNodeType() == Node.ELEMENT_NODE){
//                 Element eElement = (Element) node;
////                  System.out.println("Student roll no : "
////                            + eElement.getAttribute("rollno"));
//                 System.out.println("First name" +
//                         eElement.getAttribute("firstname :"+eElement.getTextContent().trim()));
//            }
//            System.out.printf("%d %s%n", c, name);
//            c++;
//            for (int temp = 0; temp < nlist.getLength(); temp++) {
//                Node nNode = nlist.item(temp);
//                System.out.println("\nCurrent Element :" + nNode.getNodeName());
//
//                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
//                    Element eElement = (Element) nNode;
//                    System.out.println("Student roll no : "
//                            + eElement.getAttribute("rollno"));
//                    System.out.println("First Name : "
//                            + eElement
//                                    .getElementsByTagName("firstname")
//                                    .item(0)
//                                    .getTextContent());
//                    System.out.println("Last Name : "
//                            + eElement
//                                    .getElementsByTagName("lastname")
//                                    .item(0)
//                                    .getTextContent());
//                    System.out.println("Nick Name : "
//                            + eElement
//                                    .getElementsByTagName("nickname")
//                                    .item(0)
//                                    .getTextContent());
//                    System.out.println("Marks : "
//                            + eElement
//                                    .getElementsByTagName("marks")
//                                    .item(0)
//                                    .getTextContent());
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

