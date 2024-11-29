package repository;
import config.DbConnection;
import model.Discente;
import model.Corso;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class DiscenteRepository {
    public void createDiscente(Discente oDiscente) {

        try {
            Connection c = DbConnection.openConnection();
            //System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("INSERT INTO DiscenteTest VALUES('" + oDiscente.getNome() + "','" + oDiscente.getCognome() + "', '"+ oDiscente.getMatricola()+"', '"+ oDiscente.getDataDiNascita()+"')");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    public ArrayList<Discente> readDiscente () {
        ArrayList<Discente> listaDiscenti = new ArrayList<>();
        try {
            Connection c = DbConnection.openConnection();
            //System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM DiscenteTest ORDER BY id asc");
            while (rs.next()) {
                Discente oDiscente = new Discente();
                oDiscente.setNome(rs.getString("nome"));
                oDiscente.setCognome(rs.getString("cognome"));
                oDiscente.setid(rs.getInt("id"));
                listaDiscenti.add(oDiscente);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaDiscenti;
    }

    public void deleteDiscente(Discente oDiscente) {

        try {
            Connection c = DbConnection.openConnection();
            //System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("DELETE FROM DiscenteTest WHERE id = '" + oDiscente.getid() + "'");
            System.out.println("model.dao.Discente eliminato");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    public void updateDiscente(Discente oDiscente) {

        try {
            Connection c = DbConnection.openConnection();
            //System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("UPDATE DiscenteTest SET nome='"+oDiscente.getNome()+"', cognome='"+oDiscente.getCognome()+"', matricola='"+oDiscente.getMatricola()+"', data_nascita='"+oDiscente.getDataDiNascita()+"' WHERE id ="  + oDiscente.getid());
            System.out.println("model.dao.Discente aggiornato");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    public HashMap<Integer, Corso> readCorsiSeguiti(int id) {
        HashMap<Integer, Corso> listaCorsiSeguiti = new HashMap<>();
        try {
            Connection c = DbConnection.openConnection();
            //System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT cd.corso_id AS id, c.nome_corso AS nome FROM Corso_Discente cd JOIN CorsoTest c ON cd.corso_id=c.id WHERE discente_id= '" + id +"'"  );
            while (rs.next()) {
                Corso oCorso = new Corso();
                oCorso.setNomeCorso(rs.getString("nome"));
                oCorso.setId(rs.getInt("id"));
                listaCorsiSeguiti.put(oCorso.getId(), oCorso);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaCorsiSeguiti;
    }
}
