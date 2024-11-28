package service;

import model.Corso;
import model.Docente;
import repository.DiscenteRepository;
import repository.DocenteRepository;
import repository.CorsoRepository;

import java.time.LocalDate;

public class CorsoService {
    Docente oDocente = new Docente();
    CorsoRepository corsoRepository = new CorsoRepository();
    DocenteRepository docenteRepository = new DocenteRepository();

    public void create(String nomeCorso, String durata, LocalDate dataInizio, int docenteId) {
        Corso oCorso = new Corso();
        oCorso.setNomeCorso(nomeCorso);
        oCorso.setDataInizio(dataInizio);
        oCorso.setDurata(durata);
        oDocente =docenteRepository.readDocenteByID(docenteId);
        oCorso.setDocente(oDocente);
        corsoRepository.createCorso(oCorso);
    }
}
