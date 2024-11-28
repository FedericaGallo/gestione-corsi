package model;

import java.time.LocalDate;

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
    public int getId(){
        return id;
    }
}
