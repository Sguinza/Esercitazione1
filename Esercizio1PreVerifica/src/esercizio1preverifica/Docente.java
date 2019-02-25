/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package esercizio1preverifica;

/**
 *
 * @author guindani_christian
 */
public class Docente {
    
    private String nome;
    private String giorno;
    private String ora;
    private String note;
    
    public Docente() {
        this.nome = "";
        this.giorno = "";
        this.ora = "";
        this.note = "";
    }
    
    public Docente(String nome, String giorno, String ora, String note) {
        this.nome = nome;
        this.giorno = giorno;
        this.ora = ora;
        this.note = note;
    }
    
        public Docente(String nome, String giorno, String ora) {
        this.nome = nome;
        this.giorno = giorno;
        this.ora = ora;
        this.note = "";
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getGiorno() {
        return giorno;
    }
    
    public void setGiorno(String giorno) {
        this.giorno = giorno;
    }
    
    public String getOra() {
        return ora;
    }
    
    public void setOra(String ora) {
        this.ora = ora;
    }
    
    public String getNote() {
        return note;
    }
    
    public void setNote(String note) {
        this.note = note;
    }
    
        @Override
    public String toString() {
        return "nome:  " + nome + ", giorno:  " + giorno + ", ora:  " + ora + ", note:  " + note;
    }
}
