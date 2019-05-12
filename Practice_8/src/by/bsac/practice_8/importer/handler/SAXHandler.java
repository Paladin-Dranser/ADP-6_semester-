package by.bsac.practice_8.importer.handler;

import by.bsac.practice_8.gem.Gem;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class SAXHandler extends DefaultHandler {
    private List<Gem> listOfGems;
    private Gem gem;
    private StringBuilder data;

    boolean bName = false;
    boolean bPreciousness = false;
    boolean bOrigin = false;
    boolean bColor = false;
    boolean bTransparency = false;
    boolean bFacet = false;

    public SAXHandler() {
        listOfGems = new ArrayList<>();
        gem = null;
        data = null;
    }

    public List<Gem> getListOfGems() {
        return listOfGems;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("gem")) {
            gem = new Gem();
        } else if (qName.equalsIgnoreCase("name")) {
            bName = true;
        } else if (qName.equalsIgnoreCase("preciousness")) {
            bPreciousness = true;
        } else if (qName.equalsIgnoreCase("origin")) {
            bOrigin = true;
        } else if (qName.equalsIgnoreCase("color")) {
            bColor = true;
        } else if (qName.equalsIgnoreCase("transparency")) {
            bTransparency = true;
        } else if (qName.equalsIgnoreCase("facet")) {
            bFacet = true;
        }

        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (bName) {
            gem.setName(data.toString());
            bName = false;
        } else if (bPreciousness) {
            gem.setPreciousness(Boolean.parseBoolean(data.toString()));
            bPreciousness = false;
        } else if (bOrigin) {
            gem.setOrigin(data.toString());
            bOrigin = false;
        } else if (bColor) {
            gem.setColor(data.toString());
            bColor = false;
        } else if (bTransparency) {
            gem.setTransparency(Integer.parseInt(data.toString()));
            bTransparency = false;
        } else if (bFacet) {
            gem.setFacet(Integer.parseInt(data.toString()));
            bFacet = false;
        }

        if (qName.equalsIgnoreCase("gem")) {
            listOfGems.add(gem);
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        data.append(ch, start, length);

    }
}
