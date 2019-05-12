package by.bsac.practice_8.importer;

import by.bsac.practice_8.gem.Gem;
import by.bsac.practice_8.importer.handler.SAXHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GemSAXParser {
    private List<Gem> listOfGems;

    public GemSAXParser() {
        listOfGems = new ArrayList<>();
    }

    public List<Gem> parseSAX() {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            SAXHandler handler = new SAXHandler();
            saxParser.parse(new File("/home/dranser/Documents/BSAC/2 year/6 semeseter/" +
                    "КПіМП/ADP-Labs-6_semester-/Practice_8/resources/gems.xml"), handler);
            listOfGems = handler.getListOfGems();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        return listOfGems;
    }
}
