package lab12;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;


class SaxHandlerZad1 extends DefaultHandler {
    private int elements = 0;

    public void startElement(String uri, String localName, String qName, Attributes atts) {
        elements++;
    }

    public void endDocument(){
        System.out.println("Ilość elementów: " + elements);
    }
}