package service;

import model.CorsoDiscente;
import repository.CorsoDiscenteRepository;

import java.time.LocalDate;

public class CorsoDiscenteService {
CorsoDiscenteRepository corsoDiscenteRepository = new CorsoDiscenteRepository();
    public void create( int discenteId, int corsoId) {
        CorsoDiscente oCorsoDiscente = new CorsoDiscente();
        oCorsoDiscente.setIdDiscente(discenteId);
        oCorsoDiscente.setIdCorso(corsoId);

        corsoDiscenteRepository.createCorsoDiscente(oCorsoDiscente);
    }

    public void delete( int discenteId, int corsoId) {
        CorsoDiscente oCorsoDiscente = new CorsoDiscente();
        oCorsoDiscente.setIdDiscente(discenteId);
        oCorsoDiscente.setIdCorso(corsoId);

        corsoDiscenteRepository.deleteCorsoDiscente(oCorsoDiscente);
    }
}
