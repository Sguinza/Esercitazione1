package esercizio1preverifica;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class Parser {
    
    private List docenti;
    
    public Parser() {
        docenti = new ArrayList();
    }
    
    public List parseDocument(String filename,String giorno)
            throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory;
        DocumentBuilder builder;
        Document document;
        Element root, element;
        NodeList nodelist;
        Docente docente;
        String giornata="";
        String nome="";
        String note="";
        String ora="";
        boolean esito;
        // creazione dell’albero DOM dal documento XML
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        document = builder.parse(filename);
        root = document.getDocumentElement();
        nodelist = root.getElementsByTagName("tr");
        if (nodelist != null && nodelist.getLength() > 0) {
            for (int i = 2; i < nodelist.getLength(); i++) {
                element = (Element) nodelist.item(i);
                NodeList nd = element.getElementsByTagName("td");
                esito = false;
                for(int j = 1; j < nd.getLength(); j++){
                    Element el = (Element) nd.item(j);
                    switch(j){
                        case 1:
                            nome = el.getTextContent();
                            break;
                        case 2:
                            if(j == 2){
                                giornata = el.getTextContent();
                                if(giorno.equals(giornata)){
                                    esito = true;
                                }
                            }
                            break;
                        case 3:
                            ora = el.getTextContent();
                            break;
                        case 4:
                            note = el.getTextContent();
                            break;
                        default:
                            break;
                    }
                }
                docente = new Docente(nome, giornata, ora, note);
                if(esito == true){
                    docenti.add(docente);
                }
            }
        }
        return docenti;
    }
}
