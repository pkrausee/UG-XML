package lab11;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.xerces.dom.DocumentImpl;
import org.w3c.dom.*;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;


import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSParser;
import org.w3c.dom.ls.LSSerializer;
import org.w3c.dom.ls.LSOutput;

public class Dom3Demo {
    public static Document document;

    public static void main(String[] args) {

//	    String[] strings = {"personal.xml", "personal.xsd"};
//
//		if (strings.length == 0) {
//			printUsage();
//			System.exit(1);
//		}

        try {
            System.setProperty(DOMImplementationRegistry.PROPERTY,
                    "org.apache.xerces.dom.DOMXSImplementationSourceImpl");
            DOMImplementationRegistry registry = DOMImplementationRegistry
                    .newInstance();

            DOMImplementationLS impl = (DOMImplementationLS) registry
                    .getDOMImplementation("LS");

            LSParser builder = impl.createLSParser(
                    DOMImplementationLS.MODE_SYNCHRONOUS, null);

            DOMConfiguration config = builder.getDomConfig();

            DOMErrorHandler errorHandler = getErrorHandler();
            config.setParameter("error-handler", errorHandler);

            LSSerializer domWriter = impl.createLSSerializer();

//            zad1(builder, impl, domWriter);
//            zad2(builder, impl, domWriter);
//            zad3(builder, impl, domWriter);
//            zad4(builder, impl, domWriter);
//            zad5(builder, impl, domWriter);
//            zad6(builder, impl, domWriter);
            zad7(builder, impl, domWriter);

            config = domWriter.getDomConfig();
            config.setParameter("xml-declaration", Boolean.TRUE);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void zad1(LSParser builder, DOMImplementationLS impl, LSSerializer domWriter) {
        try {
            document = builder.parseURI("./src/lab11/zad1.xml");
            Element osoba = document.createElement("osoba");
            Element imie = document.createElement("imie");
            Element nazwisko = document.createElement("nazwisko");

            imie.setTextContent("Jan");
            nazwisko.setTextContent("Kazmierczak");

            osoba.appendChild(imie);
            osoba.appendChild(nazwisko);

            document.getFirstChild().appendChild(osoba);

            LSOutput dOut = impl.createLSOutput();
            dOut.setEncoding("utf-8");
            dOut.setByteStream(new FileOutputStream("./src/lab11/new_zad1.xml"));

            System.out.println("Serializing document... ");
            domWriter.write(document, dOut);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void zad2(LSParser builder, DOMImplementationLS impl, LSSerializer domWriter) {
        try {
            document = builder.parseURI("./src/lab11/zad1.xml");

//            ((Element) document.getFirstChild()).setAttribute("aktywny", "tak");

            NodeList nodes = document.getFirstChild().getChildNodes();

            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE)
                    ((Element) node).setAttribute("aktywny", "tak");
            }
            LSOutput dOut = impl.createLSOutput();
            dOut.setEncoding("utf-8");
            dOut.setByteStream(new FileOutputStream("./src/lab11/new_zad2.xml"));

            System.out.println("Serializing document... ");
            domWriter.write(document, dOut);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void zad3(LSParser builder, DOMImplementationLS impl, LSSerializer domWriter) {
        try {
            document = new DocumentImpl();

            Element faktura = document.createElement("faktura");

            Element numer = document.createElement("numer");
            numer.setTextContent("12537/2019");

            faktura.appendChild(numer);

            Element klienci = document.createElement("klienci");

            Element osoba1 = document.createElement("osoba");

            Element imie1 = document.createElement("imie");
            Element nazwisko1 = document.createElement("nazwisko");

            osoba1.setAttribute("plec", "m");
            imie1.setTextContent("Jan");
            nazwisko1.setTextContent("Kowalski");

            osoba1.appendChild(imie1);
            osoba1.appendChild(nazwisko1);
            klienci.appendChild(osoba1);

            Element osoba2 = document.createElement("osoba");

            Element imie2 = document.createElement("imie");
            Element nazwisko2 = document.createElement("nazwisko");

            osoba2.setAttribute("plec", "k");
            imie2.setTextContent("Anna");
            nazwisko2.setTextContent("Kowalska");

            osoba2.appendChild(imie2);
            osoba2.appendChild(nazwisko2);
            klienci.appendChild(osoba2);

            faktura.appendChild(klienci);

            Element produkty = document.createElement("produkty");

            Element produkt1 = document.createElement("produkt");

            Element nazwa1 = document.createElement("nazwa");
            Element ilosc1 = document.createElement("ilosc");
            Element cena1 = document.createElement("cena");

            produkt1.setAttribute("id", "1");
            produkt1.setAttribute("kod", "7501054530107");
            produkt1.setAttribute("rodzaj", "chemia");
            nazwa1.setTextContent("Proszek do prania");
            ilosc1.setTextContent("3");
            cena1.setAttribute("waluta", "zl");
            cena1.setTextContent("24.99");

            produkt1.appendChild(nazwa1);
            produkt1.appendChild(ilosc1);
            produkt1.appendChild(cena1);

            produkty.appendChild(produkt1);

            Element produkt2 = document.createElement("produkt");

            Element nazwa2 = document.createElement("nazwa");
            Element cena2 = document.createElement("cena");

            produkt2.setAttribute("id", "2");
            produkt2.setAttribute("kod", "7213052740210");
            produkt2.setAttribute("rodzaj", "spożywczy");
            nazwa2.setTextContent("Bułka tarta");
            cena2.setAttribute("waluta", "zl");
            cena2.setTextContent("6.30");

            produkt2.appendChild(nazwa2);
            produkt2.appendChild(cena2);

            produkty.appendChild(produkt2);

            Element produkt3 = document.createElement("produkt");

            Element nazwa3 = document.createElement("nazwa");
            Element cena3 = document.createElement("cena");

            produkt3.setAttribute("id", "3");
            produkt3.setAttribute("kod", "7501054530108");
            produkt3.setAttribute("rodzaj", "chemia");
            nazwa3.setTextContent("Płyn do mycia naczyń");
            cena3.setAttribute("waluta", "zl");
            cena3.setTextContent("11.99");

            produkt3.appendChild(nazwa3);
            produkt3.appendChild(cena3);

            produkty.appendChild(produkt3);

            faktura.appendChild(produkty);

            document.appendChild(faktura);

            LSOutput dOut = impl.createLSOutput();
            dOut.setEncoding("utf-8");
            dOut.setByteStream(new FileOutputStream("./src/lab11/new_zad3.xml"));

            System.out.println("Serializing document... ");
            domWriter.write(document, dOut);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void zad4(LSParser builder, DOMImplementationLS impl, LSSerializer domWriter) {
        try {
            document = builder.parseURI("./src/lab11/zad4.xml");

            Node lista = document.getFirstChild();

            NodeList osoby = document.getFirstChild().getChildNodes();

            for (int i = 0; i < osoby.getLength(); i++) {
                Node osoba = osoby.item(i);

                if (osoba.getNodeType() == Node.ELEMENT_NODE) {
                    NodeList dane = osoba.getChildNodes();

                    for (int j = 0; j < dane.getLength(); j++) {
                        Node dana = dane.item(j);

                        if (dana.getNodeType() == Node.ELEMENT_NODE)
                            if (dana.getNodeName().equals("adres"))
                                if (((Element) dana).getAttribute("aktualny").equals("nie"))
                                    lista.removeChild(osoba);
                    }
                }
            }

            LSOutput dOut = impl.createLSOutput();
            dOut.setEncoding("utf-8");
            dOut.setByteStream(new FileOutputStream("./src/lab11/new_zad4.xml"));

            System.out.println("Serializing document... ");
            domWriter.write(document, dOut);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void zad5(LSParser builder, DOMImplementationLS impl, LSSerializer domWriter) {
        try {
            document = builder.parseURI("./src/lab11/zad5.xml");

            Node lista = document.getFirstChild();

            NodeList osoby = document.getFirstChild().getChildNodes();

            for (int i = 0; i < osoby.getLength(); i++) {
                Node node = osoby.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element osoba = (Element) node;

                    Node wiek = osoba.getElementsByTagName("wiek").item(0);

                    if (Integer.valueOf(wiek.getTextContent()) < 40)
                        lista.removeChild(osoba);
                    else
                        wiek.setTextContent(String.valueOf(Integer.valueOf(wiek.getTextContent()) - 30));

                }
            }

            LSOutput dOut = impl.createLSOutput();
            dOut.setEncoding("utf-8");
            dOut.setByteStream(new FileOutputStream("./src/lab11/new_zad5.xml"));

            System.out.println("Serializing document... ");
            domWriter.write(document, dOut);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void zad6(LSParser builder, DOMImplementationLS impl, LSSerializer domWriter) {
        try {
            document = builder.parseURI("./src/lab11/zad6.xml");

            Node grupy = document.getFirstChild();

            NodeList grupyList = document.getFirstChild().getChildNodes();

            for (int i = 0; i < grupyList.getLength(); i++) {
                Node node = grupyList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element grupa = (Element) node;

                    Attr aktywny = grupa.getAttributeNode("aktywny");

                    if (aktywny.getTextContent().equals("tak")) {
                        int suma = 0;
                        int ilosc = 0;
                        float srednia = 0;

                        NodeList liczby = grupa.getElementsByTagName("liczba");

                        for (int j = 0; j < liczby.getLength(); j++) {
                            suma += Integer.valueOf(liczby.item(j).getTextContent());
                            ilosc++;
                        }

                        srednia = (float) suma / ilosc;

                        Element sumaEl = document.createElement("suma");
                        sumaEl.setTextContent(String.valueOf(suma));

                        Element sredniaEl = document.createElement("srednia");
                        sredniaEl.setTextContent(String.valueOf(srednia));

                        grupa.appendChild(sumaEl);
                        grupa.appendChild(sredniaEl);

                        grupa.removeAttribute("aktywny");
                    }

                }

            }

            LSOutput dOut = impl.createLSOutput();
            dOut.setEncoding("utf-8");
            dOut.setByteStream(new FileOutputStream("./src/lab11/new_zad6.xml"));

            System.out.println("Serializing document... ");
            domWriter.write(document, dOut);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void zad7(LSParser builder, DOMImplementationLS impl, LSSerializer domWriter) {
        try {
            document = builder.parseURI("./src/lab11/zad7.xml");

            NodeList osoby = document.getFirstChild().getChildNodes();

            for (int i = 0; i < osoby.getLength(); i++) {
                Node node = osoby.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element osoba = (Element) node;

                    if(osoba.getAttribute("id").equals("k331")) {
                        Element imie = (Element) osoba.getElementsByTagName("imie").item(0);
                        Element nazwisko = (Element) osoba.getElementsByTagName("nazwisko").item(0);

                        imie.setTextContent("Jan");
                        nazwisko.setTextContent("Kowalski");

                        Attr plec = osoba.getAttributeNode("plec");
                        plec.setValue("m");
                    }
                }
            }

            LSOutput dOut = impl.createLSOutput();
            dOut.setEncoding("utf-8");
            dOut.setByteStream(new FileOutputStream("./src/lab11/new_zad7.xml"));

            System.out.println("Serializing document... ");
            domWriter.write(document, dOut);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void printUsage() {

        System.err.println("usage: java Dom3Demo uri");
        System.err.println();
        System.err
                .println("NOTE: You can only validate DOM tree against XML Schemas.");

    }

    public static DOMErrorHandler getErrorHandler() {
        return new DOMErrorHandler() {
            public boolean handleError(DOMError error) {
                short severity = error.getSeverity();
                if (severity == error.SEVERITY_ERROR) {
                    System.out.println("[dom3-error]: " + error.getMessage());
                }
                if (severity == error.SEVERITY_WARNING) {
                    System.out.println("[dom3-warning]: " + error.getMessage());
                }
                if (severity == error.SEVERITY_FATAL_ERROR) {
                    System.out.println("[dom3-fatal-error]: "
                            + error.getMessage());
                }
                return true;
            }
        };
    }

}
