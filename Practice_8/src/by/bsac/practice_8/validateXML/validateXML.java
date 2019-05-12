package by.bsac.practice_8.validateXML;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

public class validateXML {

    public static boolean validateXMLByXSD() {
        File xml = new File("/home/dranser/Documents/BSAC/2 year/6 semeseter/" +
                "КПіМП/ADP-Labs-6_semester-/Practice_8/resources/gems.xml");
        File xsd = new File("/home/dranser/Documents/BSAC/2 year/6 semeseter/" +
                "КПіМП/ADP-Labs-6_semester-/Practice_8/resources/gems.xsd");

        try {
            SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI)
                    .newSchema(xsd)
                    .newValidator()
                    .validate(new StreamSource(xml));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
