/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication14;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author W.Shraideh
 */
public class JavaApplication14 {

    private static final String input = "C:\\Users\\w.shraideh\\Documents\\NetBeansProjects\\JavaApplication14\\src\\javaapplication14\\newXMLDocument.xml";

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(input);

        doc.getDocumentElement().normalize();
        System.out.println("attribute name :" + doc.getDocumentElement().getNodeName());
        NodeList nlist = doc.getElementsByTagName("player");

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
