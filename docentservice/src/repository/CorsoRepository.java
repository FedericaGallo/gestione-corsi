package repository;
import java.time.LocalDate;
import config.DbConnection;
import model.Corso;
import model.Discente;
import model.Docente;
import repository.DocenteRepository;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class CorsoRepository {

    public void createCorso(Corso oCorso) {

        try {
            Connection c = DbConnection.openConnection();
            //System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("INSERT INTO CorsoTest VALUES ('" + oCorso.getNomeCorso() +"', '" + oCorso.getDataInizio()+"', '" + oCorso.getDurata() +"', '" + oCorso.getDocenteId() +"') ");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    public ArrayList<Corso> readCorso () {
        ArrayList<Corso> listaCorsi = new ArrayList<>();
        try {
            Connection c = DbConnection.openConnection();
            //System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT c.nome_corso AS nome_corso, c.data_inizio AS data_inizio, c.durata AS durata, c.id AS corso_id, d.nome AS docente_nome, d.cognome AS docente_cognome, d.id AS docente_id  FROM CorsoTest c JOIN DocenteTest d ON c.docente_id = d.id");
            while (rs.next()) {
                Corso oCorso = new Corso();
                Docente oDocente = new Docente();
                DocenteRepository docenteRepository = new DocenteRepository();
                oCorso.setNomeCorso(rs.getString("nome_corso"));
                oCorso.setDataInizio(rs.getDate("data_inizio").toLocalDate());
                oCorso.setDurata(rs.getString("durata"));
                oCorso.setId(rs.getInt("corso_id"));
                oDocente =docenteRepository.readDocenteByID(rs.getInt("docente_id"));
                oCorso.setDocente(oDocente);
                oCorso.setDocenteNome(oDocente.getNome());
                oCorso.setDocenteCognome(oDocente.getCognome());
                listaCorsi.add(oCorso);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaCorsi;
    }

    public void updateCorso(Corso oCorso) {

        try {
            Connection c = DbConnection.openConnection();
            //System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("UPDATE CorsoTest SET nome_corso= '"+oCorso.getNomeCorso()+"', durata= '"+oCorso.getDurata()+"', data_inizio= '"+oCorso.getDataInizio()+"', docente_id= '"+ oCorso.getDocenteId()+ "' WHERE id =" + oCorso.getId());
            System.out.println(oCorso.getId());
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    public void deleteCorso(Corso oCorso) {

        try {
            Connection c = DbConnection.openConnection();
            //System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("DELETE FROM CorsoTest WHERE id = '" + oCorso.getId() + "'");
            System.out.println("model.dao.cORSO eliminato");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }
    public HashMap<Integer, Discente> readDiscentiDelCorso(int id) {
        HashMap<Integer, Discente> listaDiscentiDelCorso = new HashMap<>();
        try {
            Connection c = DbConnection.openConnection();
            //System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT cd.discente_id AS id, d.nome AS nome, d.cognome AS cognome FROM Corso_Discente cd JOIN DiscenteTest d ON cd.discente_id=d.id WHERE cd.corso_id= '" + id +"'"  );
            while (rs.next()) {
                Discente oDiscente = new Discente();
                oDiscente.setNome(rs.getString("nome"));
                oDiscente.setCognome(rs.getString("cognome"));
                oDiscente.setid(rs.getInt("id"));
                listaDiscentiDelCorso.put(oDiscente.getid(), oDiscente);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaDiscentiDelCorso;
    }
}
