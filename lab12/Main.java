package lab12;

import org.xml.sax.*;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        XMLReader parser = null;

        try {
            parser = XMLReaderFactory.createXMLReader();
            SaxHandlerZad1 SaxHandlerZad1 = new SaxHandlerZad1();
            SaxHandlerZad2 SaxHandlerZad2 = new SaxHandlerZad2("grupa");
            SaxHandlerZad3 SaxHandlerZad3 = new SaxHandlerZad3();
            SaxHandlerZad4 SaxHandlerZad4 = new SaxHandlerZad4();
            SaxHandlerZad5 SaxHandlerZad5 = new SaxHandlerZad5();

            parser.setContentHandler(SaxHandlerZad1);
            parser.parse("./src/lab12/zad3.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}