package lab12;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;


class SaxHandlerZad4 extends DefaultHandler {

    private boolean grupa = false;
    private boolean inside = false;
    private boolean min = false;
    private Integer sum = null;

    public void startElement(String uri, String localName, String qName, Attributes atts) {
        if (qName.equals("grupa")){

            if (atts.getValue("wartosc") != null){
                if (atts.getValue("wartosc").equals("min")){
                    grupa = true;
                    min = true;
                } else if (atts.getValue("wartosc").equals("max")){
                    grupa = true;
                    min = false;
                }
            }

        } else if (grupa) {
            inside = true;
        }
    }

    public void characters(char[] ch, int start, int length){
        if (grupa && inside) {

            int val = Integer.parseInt(new String(ch, start, length));

            if (sum == null)
                sum = val;

            if (min) {
                if (sum > val) sum = val;
            } else if (sum < val)
                sum = val;

        }
    }

    public void endElement(String uri, String localName, String qName){
        if (qName.equals("grupa")){

            grupa = false;
            if (min) {
                System.out.println("Min: " + sum);
            }
            else {
                System.out.println("Max: " + sum);
            }
            sum = null;

        }
        inside = false;
    }
}