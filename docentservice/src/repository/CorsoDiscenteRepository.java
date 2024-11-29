package repository;

import config.DbConnection;
import model.CorsoDiscente;
import model.Docente;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CorsoDiscenteRepository {
    public void createCorsoDiscente(CorsoDiscente oCorsoDiscente) {

        try {
            Connection c = DbConnection.openConnection();
            //System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("INSERT INTO Corso_Discente VALUES('" + oCorsoDiscente.getIdDiscente() + "','" + oCorsoDiscente.getIdCorso() + "')");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    public void deleteCorsoDiscente(CorsoDiscente oCorsoDiscente) {

        try {
            Connection c = DbConnection.openConnection();
            //System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("DELETE FROM Corso_Discente WHERE discente_id ='" + oCorsoDiscente.getIdDiscente() + "' AND corso_id= '" + oCorsoDiscente.getIdCorso() + "'");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }
}
