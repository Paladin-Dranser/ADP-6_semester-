package by.bsac.practice_8;

import by.bsac.practice_8.converter.ConverterXML;
import by.bsac.practice_8.gem.Gem;
import by.bsac.practice_8.importer.GemDOMParser;
import by.bsac.practice_8.importer.GemSAXParser;
import by.bsac.practice_8.importer.GemStAXParser;
import by.bsac.practice_8.validateXML.validateXML;

import java.util.Arrays;
import java.util.List;

public class Individual {
    public static void main(String[] args) {
        // DOM parse
        GemDOMParser gemDOMParser = new GemDOMParser();
        List<Gem> listOfGems = gemDOMParser.parseDOM();
        System.out.println(Arrays.toString(listOfGems.toArray()));

        // SAX parse
        listOfGems.clear();
        GemSAXParser gemSAXParser = new GemSAXParser();
        listOfGems = gemSAXParser.parseSAX();
        System.out.println(Arrays.toString(listOfGems.toArray()));

        // StAX parse
        listOfGems.clear();
        GemStAXParser gemStAXParser = new GemStAXParser();
        listOfGems = gemStAXParser.parseStAX();
        System.out.println(Arrays.toString(listOfGems.toArray()));

        // validate XML file
        if (validateXML.validateXMLByXSD()) {
            System.out.println("XML file is validate");
        } else {
            System.out.println("XML file is not validate");
        }

        // convert XML to HTML
        ConverterXML.convertXMLToHTML();
    }
}
