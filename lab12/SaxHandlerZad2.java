package lab12;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;


class SaxHandlerZad2 extends DefaultHandler {
    private int elements;
    private String elementName;

    public SaxHandlerZad2(String name) {
        this.elements = 0;
        this.elementName = name;
    }

    public void startElement(String uri, String localName, String qName, Attributes atts) {
        if (qName.equals(elementName))
            elements++;
    }

    public void endDocument() {
        System.out.println("Ilość elementów: " + elements);
    }
}