package service;

import model.Discente;
import repository.DiscenteRepository;

import java.time.LocalDate;
import java.util.List;

public class DiscenteService {


    DiscenteRepository discenteRepository = new DiscenteRepository();



    public void create(String nome, String cognome, String matricola, LocalDate data) {
        Discente oDiscente = new Discente();
        oDiscente.setCognome(cognome);
        oDiscente.setNome(nome);
        oDiscente.setMatricola(matricola);
        oDiscente.setDataDiNascita(data);
        discenteRepository.createDiscente(oDiscente);
    }


    public List<Discente> readDiscente(){
        return discenteRepository.readDiscente();
    }


    public void delete(int id) {
        Discente oDiscente = new Discente();
        oDiscente.setid(id);
        discenteRepository.deleteDiscente(oDiscente);
    }

    public void update(int id, String nome, String cognome, String matricola, LocalDate data) {
        Discente oDiscente = new Discente();
        oDiscente.setNome(nome);
        oDiscente.setCognome(cognome);
        oDiscente.setid(id);
        oDiscente.setMatricola(matricola);
        oDiscente.setDataDiNascita(data);
        discenteRepository.updateDiscente(oDiscente);
    }
}
