/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio1preverifica;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author guindani_christian
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List docenti = null;
        Parser dom = new Parser();
        Scanner keyboard = new Scanner(System.in);
        String path = keyboard.next();
        System.out.println("Inserire il giorno che si vuole ricercare");
        String giorno = keyboard.next();
        try {
            docenti = dom.parseDocument(path,giorno);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }

        // iterazione della lista e visualizzazione degli oggetti
        Iterator iterator = docenti.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }    }
    
}
