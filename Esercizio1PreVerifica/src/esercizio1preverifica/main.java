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
        String path = "circolare.xml";
        System.out.println("Selezionare:");
        System.out.println("1.Cerca docenti in base al giorno");
        System.out.println("2.Cerca quando il un docente fa il ricevimento");
        int scelta = keyboard.nextInt();
        try{
            switch(scelta){
                case 1:
                    System.out.println("Inserire il giorno che si vuole ricercare");
                    String giorno = keyboard.next();
                    docenti = dom.parseDocument(path,giorno,scelta);
                    break;
                case 2:
                    System.out.println("Inserire il cognome del docente che si vuole cercare");
                    String cognome = keyboard.next();
                    System.out.println("Inserire il nome del docente che si vuole cercare");
                    String nome = keyboard.next();
                    String docente = cognome + " " + nome;
                    docenti = dom.parseDocument(path,docente,scelta);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Errore, funzione non disponibile");
                    break;
            }
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
