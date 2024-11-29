package service;
import java.time.LocalDate;
import model.Corso;
import model.Docente;
import model.Discente;
import repository.DiscenteRepository;
import repository.DocenteRepository;
import repository.CorsoRepository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

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

    public List<Corso> readCorso(){
        return corsoRepository.readCorso();
    }

    public void update(int id, String nomeCorso, LocalDate dataDiInizio, int docenteId, String  durata) {
        Corso oCorso = new Corso();
        oCorso.setNomeCorso(nomeCorso);
        oCorso.setDataInizio(dataDiInizio);
        oCorso.setDurata(durata);
        oCorso.setId(id);
        oDocente =docenteRepository.readDocenteByID(docenteId);
        oCorso.setDocente(oDocente);
        corsoRepository.updateCorso(oCorso);
    }

    public void delete(int id) {
        Corso oCorso = new Corso();
        oCorso.setId(id);
        corsoRepository.deleteCorso(oCorso);
    }
    public HashMap<Integer, Discente> readDiscentiDiUnCorso(int id){
        return corsoRepository.readDiscentiDelCorso(id);
    }
}
