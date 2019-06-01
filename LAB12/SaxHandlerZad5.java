package lab12;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashMap;
import java.util.Map;


class SaxHandlerZad5 extends DefaultHandler {

    private boolean wiek = false;
    private boolean miejsce = false;

    private int age;

    private Map<String, Integer> sum = new HashMap<String, Integer>();
    private Map<String, Integer> quantity = new HashMap<String, Integer>();

    public void startElement(String uri, String localName, String qName, Attributes atts) {

        if (qName.equals("wiek")) {
            wiek = true;
        } else if (qName.equals("miejsce")) {
            miejsce = true;
        }

    }

    public void characters(char[] ch, int start, int length) {
        //System.out.println("b");
        if (miejsce) {

            String miejsce = new String(ch, start, length);

            if (!sum.containsKey(miejsce)) {

                sum.put(miejsce, age);
                quantity.put(miejsce, 1);

            } else {

                sum.put(miejsce, sum.get(miejsce) + age);
                quantity.put(miejsce, quantity.get(miejsce) + 1);

            }

        }

        if (wiek) {
            age = Integer.parseInt(new String(ch, start, length));
        }
    }

    public void endElement(String uri, String localName, String qName) {
        if (qName.equals("wiek")) {
            wiek = false;
        }
        if (qName.equals("miejsce")) {
            miejsce = false;
        }
    }

    public void endDocument() {
        for (String s : sum.keySet()) {
            System.out.println(s + ": " + sum.get(s).doubleValue() / quantity.get(s));
        }
    }
}