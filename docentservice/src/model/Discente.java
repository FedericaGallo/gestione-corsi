package model;
import java.time.LocalDate;

public class Discente {

    private String nome;
    private String cognome;
    private int id;
    private String matricola;
    private LocalDate dataDiNascita;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setid(int id) {
        this.id = id;
    }

    public int getid() {
        return id;
    }

    public void setMatricola(String matricola) {this.matricola = matricola;}

    public String getMatricola() {return matricola; }

    public void setDataDiNascita(LocalDate data) {this.dataDiNascita = data;}

    public LocalDate getDataDiNascita() {return dataDiNascita; }
}
