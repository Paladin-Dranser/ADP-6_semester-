package by.bsac.practice_8.converter;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

public class ConverterXML {
    public static void convertXMLToHTML() {
        try {
            FileInputStream xml = new FileInputStream("/home/dranser/Documents/BSAC/2 year/6 semeseter/" +
                    "КПіМП/ADP-Labs-6_semester-/Practice_8/resources/gems.xml");
            FileInputStream xslt = new FileInputStream("/home/dranser/Documents/BSAC/2 year/6 semeseter/" +
                    "КПіМП/ADP-Labs-6_semester-/Practice_8/resources/gems.xslt");
            FileOutputStream html= new FileOutputStream("/home/dranser/Documents/BSAC/2 year/6 semeseter/" +
                    "КПіМП/ADP-Labs-6_semester-/Practice_8/resources/gems.html");

            Source xmlDoc = new StreamSource(xml);
            Source xsltDoc = new StreamSource(xslt);
            Result result = new StreamResult(html);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer(xsltDoc);
            transformer.transform(xmlDoc, result);
        } catch (IOException | TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerFactoryConfigurationError e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}