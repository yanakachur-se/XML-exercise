package edu.sda;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import static java.lang.Double.parseDouble;

public class Parser {

    public List<Bar> fetchBars() {
        List bars = new ArrayList<Bar>();
        try {
            File inputFile = new File("bars.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList barsList = doc.getElementsByTagName("bar");

            for (int i = 0; i < barsList.getLength(); i++){
                Node barNode = barsList.item(i);
                double fett = 0;
                double protein = 0;
                double fiber = 0;
                String reviewer = "";
                String name = "";
                if (barNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element barElement = (Element) barNode;
                    name = barElement.getAttribute("SN");
                    NodeList characteristics = barElement.getChildNodes();
                    for (int j = 0; j < characteristics.getLength(); j++){
                        Node charact = characteristics.item(j);
                        if (charact.getNodeType() == Node.ELEMENT_NODE) {
                            switch (charact.getNodeName()){
                                case "fett":
                                    fett = parseDouble(charact.getTextContent());
                                    break;
                                case "protein":
                                     protein = parseDouble(charact.getTextContent());
                                    break;
                                case "fiber":
                                    fiber = parseDouble(charact.getTextContent());
                                    break;
                                case "review":
                                    NodeList review = charact.getChildNodes();
                                    for (int k = 0; k < review.getLength(); k++) {
                                        Node reviewNode = review.item(k);
                                        if (reviewNode.getNodeType() == Node.ELEMENT_NODE) {
                                            Element reviewElement = (Element) reviewNode;
                                            reviewer = reviewElement.getAttribute("personID");
                                        }
                                    }
                                    break;
                            }
                        }
                    }
                }
                Bar bar = new Bar(name, fett, protein, fiber, reviewer);
                bars.add(bar);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bars;
    }
}
