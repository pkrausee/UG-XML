package lab12;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;


class SaxHandlerZad3 extends DefaultHandler {
    private int sum = 0;
    private int elements = 0;
    private boolean grupaAkt = false;
    private boolean liczba = false;

    public void startElement(String uri, String localName, String qName, Attributes atts) {
        if (qName.equals("grupa")){
            if (atts.getValue("aktywny").equals("tak")){
                grupaAkt = true;
            }
        } else if (qName.equals("liczba") && grupaAkt)
        {
            liczba = true;
            elements++;
        }
    }

    public void endElement(String uri, String localName, String qName){
        if (qName.equals("grupa")){

            if (grupaAkt) {
                System.out.println("Suma: " + sum);
                System.out.println("Srednia: " + (float) sum / elements);

                sum = 0;
                elements = 0;
                grupaAkt = false;
            }

        } else if(qName.equals("liczba")) {
            liczba = false;
        }
    }

    public void characters(char[] ch, int start, int length){
        if (grupaAkt && liczba) {

            sum += Integer.parseInt(new String(ch, start, length));

        }
    }
}