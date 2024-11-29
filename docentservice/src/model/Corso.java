package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Corso {
    private String nomeCorso;
    private LocalDate dataInizio;
    private String durata;
    private Docente docente;


    private int id;

    public void setNomeCorso(String nomeCorso){
        this.nomeCorso = nomeCorso;
    }

    public void setDataInizio(LocalDate dataInizio){
        this.dataInizio = dataInizio;
    }
    public void setDurata(String durata){
        this.durata = durata;
    }
    public void setDocente(Docente docente){
        this.docente = docente;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getNomeCorso(){
        return nomeCorso;
    }

    public LocalDate getDataInizio(){
        return dataInizio;
    }
    public String getDurata(){
        return durata;
    }
    public int getDocenteId(){
        return docente.getid();
    }

    public void setDocenteId(int id){
        this.docente.setid(id);
    }
    public void setDocenteNome(String nome){
        this.docente.setNome(nome);
    }
    public void setDocenteCognome(String cognome){
        this.docente.setCognome(cognome);
    }
    public String getDocenteCognome(){
        return docente.getCognome();
    }
    public String getDocenteNome(){
        return docente.getNome();
    }
    public int getId(){
        return id;
    }
}
