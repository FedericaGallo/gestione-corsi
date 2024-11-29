package model;

public class CorsoDiscente {
    private int id;
    private int idDiscente;
    private int idCorso;

    public int getIdCorsoDiscenti() {
        return id;
    }

    public int getIdCorso() {
        return idCorso;
    }

    public int getIdDiscente() {
        return idDiscente;
    }

    public void setIdCorsoDiscenti(int id) {
        this.id=id;
    }

    public void setIdCorso(int id) {
        this.idCorso = id;
    }

    public void setIdDiscente(int id) {
        this.idDiscente = id;
    }
}
