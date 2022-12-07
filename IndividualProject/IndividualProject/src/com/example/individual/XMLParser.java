package com.example.individual;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;

public class XMLParser implements Parser {

    @Override
    public ArrayList<String> parse(String path) {
        ArrayList<String > tokens= new ArrayList<>();
        try {
            File inputFile = new File(path);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("CARD_NUMBER");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    tokens.add(eElement.getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tokens;
    }

    public XMLParser() {
    }

    @Override
    public void write(String file, ArrayList<String> d) {
        try {
            DocumentBuilderFactory dbFactory =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            // root element
            Element rootElement = doc.createElement("CARDS");
            doc.appendChild(rootElement);

            // supercars element


            for (String a: d
                 ) {
                Element card = doc.createElement("CARD");
                rootElement.appendChild(card);
                Element cardNumber = doc.createElement("CARD_NUMBER");
                cardNumber.appendChild(doc.createTextNode(a.split(",")[0]));
                Element cardType = doc.createElement("CARD_TYPE");
                cardType.appendChild(doc.createTextNode(a.split(",")[1]));
                card.appendChild(cardNumber);
                card.appendChild(cardType);
            }




            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(file));
            transformer.transform(source, result);

            // Output to console for testing
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
