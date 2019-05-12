package by.bsac.practice_8.importer;

import by.bsac.practice_8.gem.Gem;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GemDOMParser {
    private List<Gem> listOfGems;

    public GemDOMParser() {
        listOfGems = new ArrayList<>();
    }

    public List<Gem> parseDOM() {
        try {
            File xmlFile = new File("/home/dranser/Documents/BSAC/2 year/6 semeseter/" +
                    "КПіМП/ADP-Labs-6_semester-/Practice_8/resources/gems.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newDefaultInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document document = dBuilder.parse(xmlFile);
            document.getDocumentElement().normalize();


            NodeList nodeList = document.getElementsByTagName("gem");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                Gem gem = new Gem();

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    gem.setName(element.getElementsByTagName("name").item(0).getTextContent());
                    gem.setPreciousness(Boolean.parseBoolean(element.getElementsByTagName("preciousness").item(0).getTextContent()));
                    gem.setOrigin(element.getElementsByTagName("origin").item(0).getTextContent());
                    gem.setColor(element.getElementsByTagName("color").item(0).getTextContent());
                    gem.setTransparency(Integer.parseInt(element.getElementsByTagName("transparency").item(0).getTextContent()));
                    gem.setFacet(Integer.parseInt(element.getElementsByTagName("facet").item(0).getTextContent()));

                    listOfGems.add(gem);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listOfGems;
    }
}
