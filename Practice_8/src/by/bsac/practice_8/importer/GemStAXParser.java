package by.bsac.practice_8.importer;

import by.bsac.practice_8.gem.Gem;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class GemStAXParser {
    private List<Gem> listOfGem;
    private Gem gem;

    public GemStAXParser() {
        listOfGem = new ArrayList<>();
        gem = null;
    }

    public List<Gem> parseStAX() {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();

        try {
            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(
                    new FileInputStream("/home/dranser/Documents/BSAC/2 year/6 semeseter/" +
                            "КПіМП/ADP-Labs-6_semester-/Practice_8/resources/gems.xml")
            );

            while (xmlEventReader.hasNext()) {
                XMLEvent xmlEvent = xmlEventReader.nextEvent();

                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();

                    if (startElement.getName().getLocalPart().equalsIgnoreCase("gem")) {
                        gem = new Gem();
                    } else if (startElement.getName().getLocalPart().equalsIgnoreCase("name")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        gem.setName(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equalsIgnoreCase("preciousness")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        gem.setPreciousness(Boolean.parseBoolean(xmlEvent.asCharacters().getData()));
                    } else if (startElement.getName().getLocalPart().equalsIgnoreCase("origin")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        gem.setOrigin(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equalsIgnoreCase("color")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        gem.setColor(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equalsIgnoreCase("transparency")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        gem.setTransparency(Integer.parseInt(xmlEvent.asCharacters().getData()));
                    } else if (startElement.getName().getLocalPart().equalsIgnoreCase("facet")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        gem.setFacet(Integer.parseInt(xmlEvent.asCharacters().getData()));
                    }
                }

                if (xmlEvent.isEndElement()) {
                    EndElement endElement = xmlEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equalsIgnoreCase("gem")) {
                        listOfGem.add(gem);
                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }

        return listOfGem;
    }
}
