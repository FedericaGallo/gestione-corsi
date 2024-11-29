package view;

import model.Docente;
import model.Discente;
import model.Corso;
import service.DocenteService;
import service.DiscenteService;
import service.CorsoService;
import java.time.LocalDate;
import java.util.*;



public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choiceEntity;
        System.out.println("1. Per gestire docenti");
        System.out.println("2. Per gestire discenti");
        System.out.println("3. Per gestire corsi");
        choiceEntity = scanner.nextInt();

        switch (choiceEntity){
            case 1:
                gestisciDocenti();
                break;
            case 2:
                gestisciDiscenti();
                break;
            case 3:
                gestisciCorso();
                break;

        }

    }
    private static void gestisciDiscenti(){
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {

            System.out.println("Classe discente");

            System.out.println("***Menu***");
            System.out.println("1. Crea un nuovo discente");
            System.out.println("2. Aggiorna un discente");
            System.out.println("3. Visualizza la lista di discenti");
            System.out.println("4. Elimina un discente");
            System.out.println("9. Exit");
            System.out.print("inserisci la tua scelta: ");
            System.out.print("test commit push");
            // Read user input
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createDiscente();
                    break;
                case 2:
                    updateDiscente();
                    break;
                case 3:
                    readDiscenti();
                    break;
                case 4:
                    deleteDiscente();
                    break;
                case 9:
                    System.out.println("exiting");
                    break;
                default:
                    System.out.println("scelta errata. scegliere un numero da 1 a 8");
            }

        } while (choice != 9);
        scanner.close();

    }
    private static void gestisciDocenti(){
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {

            System.out.println("Classe docente");

            System.out.println("***Menu***");
            System.out.println("1. Crea un nuovo docente");
            System.out.println("2. Aggiorna un docente");
            System.out.println("3. Visualizza la lista di docenti");
            System.out.println("4. Elimina un docente");
            System.out.println("9. Exit");
            System.out.print("inserisci la tua scelta: ");

            // Read user input
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    create();
                    break;
                case 2:
                    update();
                    break;
                case 3:
                    read();
                    break;
                case 4:
                    delete();
                    break;
                case 9:
                    System.out.println("exiting");
                    break;
                default:
                    System.out.println("scelta errata. scegliere un numero da 1 a 8");
            }

        } while (choice != 9);
        scanner.close();

    }
    private static void gestisciCorso(){
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {

            System.out.println("Classe corso");

            System.out.println("***Menu***");
            System.out.println("1. Crea un nuovo corso");
            System.out.println("2. Aggiorna un corso");
            System.out.println("3. Visualizza la lista dei corsi");
            System.out.println("4. Elimina un corso");
            System.out.println("9. Exit");
            System.out.print("inserisci la tua scelta: ");

            // Read user input
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createCorso();
                    break;
                case 2:

                    updateCorso();

                    break;
                case 3:
                    readCorsi();
                    break;
                case 4:
                    deleteCorso();
                    break;
                case 9:
                    System.out.println("exiting");
                    break;
                default:
                    System.out.println("scelta errata. scegliere un numero da 1 a 8");
            }

        } while (choice != 9);
        scanner.close();

    }

    private static void read() {
        System.out.println("ecco la lista dei docenti: ");
        DocenteService oDocenteService = new DocenteService();
        List<Docente> listaDocenti= oDocenteService.readDocente();
        int i = 0;
        while(i<listaDocenti.size()){
            System.out.println(listaDocenti.get(i).getid()+" "+listaDocenti.get(i).getCognome()+" "+listaDocenti.get(i).getNome());
            i++;}

    }

    private static void readDiscenti() {
        System.out.println("ecco la lista dei discenti: ");
        DiscenteService oDiscenteService = new DiscenteService();
        List<Discente> listaDiscenti= oDiscenteService.readDiscente();
        int i = 0;
        while(i<listaDiscenti.size()){
            System.out.println(listaDiscenti.get(i).getid()+" "+ listaDiscenti.get(i).getCognome()+" "+listaDiscenti.get(i).getNome());
            i++;}

    }

    private static void readCorsi() {
        System.out.println("ecco la lista dei corsi: ");
        CorsoService oCorsoService = new CorsoService();
        List<Corso> listaCorsi= oCorsoService.readCorso();
        int i = 0;
        while(i<listaCorsi.size()){
            System.out.println(listaCorsi.get(i).getId()+" "+listaCorsi.get(i).getNomeCorso()+" "+ listaCorsi.get(i).getDataInizio()+" "+listaCorsi.get(i).getDurata()+" "+listaCorsi.get(i).getDocenteNome()+" "+listaCorsi.get(i).getDocenteCognome());
            i++;}

    }


        private static void create () {
            System.out.println("inserisci nome: ");
            Scanner scanner = new Scanner(System.in);
            String nome = scanner.next();
            System.out.println("inserisci cognome: ");
            String cognome = scanner.next();
            DocenteService oDocenteService = new DocenteService();
            oDocenteService.create(nome, cognome);

        }

    private static void createDiscente () {
        System.out.println("inserisci nome: ");
        Scanner scanner = new Scanner(System.in);
        String nome = scanner.next();
        System.out.println("inserisci cognome: ");
        String cognome = scanner.next();
        System.out.println("Inserisci la matricola: ");
        String matricola = scanner.next();
        System.out.println("Inserisci il giorno di nascita: ");
        int giorno = scanner.nextInt();
        System.out.println("Inserisci il mese di nascita: ");
        int mese = scanner.nextInt();
        System.out.println("Inserisci l'anno di nascita: ");
        int anno = scanner.nextInt();
        LocalDate dataDiNascita = LocalDate.of(anno, mese, giorno);
        DiscenteService oDiscenteService = new DiscenteService();
        oDiscenteService.create(nome, cognome, matricola, dataDiNascita);

    }

    private static void createCorso () {
        System.out.println("inserisci nome corso: ");
        Scanner scanner = new Scanner(System.in);
        String nomeCorso = scanner.next();
        System.out.println("Inserisci il giorno di inizio: ");
        int giorno = scanner.nextInt();
        System.out.println("Inserisci il mese di inizio: ");
        int mese = scanner.nextInt();
        System.out.println("Inserisci l'anno di inizio: ");
        int anno = scanner.nextInt();
        read();
        System.out.println("Inserisci l'id del docente: ");
        int docenteId = scanner.nextInt();
        System.out.println("Inserisci durata: ");
        String durata = scanner.next();
        LocalDate dataInizio = LocalDate.of(anno, mese, giorno);
        CorsoService oCorsoService = new CorsoService();
        oCorsoService.create(nomeCorso, durata, dataInizio, docenteId);

    }

        private static void delete () {
            System.out.println("Elimina il docente con id: ");
            Scanner scanner = new Scanner(System.in);
            int id = scanner.nextInt();
            DocenteService oDocenteService = new DocenteService();
            oDocenteService.delete(id);

        }

    private static void deleteDiscente () {
        System.out.println("Elimina il discente con id: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        DiscenteService oDiscenteService = new DiscenteService();
        oDiscenteService.delete(id);

    }

    private static void deleteCorso () {
        readCorsi();
        System.out.println("Elimina il corso con id: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        CorsoService oCorsoService = new CorsoService();
        oCorsoService.delete(id);

    }

        private static void update () {
            Scanner scanner = new Scanner(System.in);
            System.out.println("inserisci l'id del docente da modificare:");
            int id = scanner.nextInt();
            System.out.println("inserisci il nuovo nome:");
            String nome = scanner.next();
            System.out.println("inserisci il nuovo cognome:");
            String cognome = scanner.next();
            DocenteService oDocenteService = new DocenteService();
            oDocenteService.update(id, nome, cognome);

        }

    private static void updateDiscente () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("inserisci l'id del docente da modificare:");
        int id = scanner.nextInt();
        System.out.println("inserisci il nuovo nome:");
        String nome = scanner.next();
        System.out.println("inserisci il nuovo cognome:");
        String cognome = scanner.next();
        System.out.println("Inserisci la matricola: ");
        String matricola = scanner.next();
        System.out.println("Inserisci il nuovo giorno di nascita: ");
        int giorno = scanner.nextInt();
        System.out.println("Inserisci il nuovo mese di nascita: ");
        int mese = scanner.nextInt();
        System.out.println("Inserisci il nuovo anno di nascita: ");
        int anno = scanner.nextInt();
        LocalDate dataDiNascita = LocalDate.of(anno, mese, giorno);
        DiscenteService oDiscenteService = new DiscenteService();
        oDiscenteService.update(id, nome, cognome, matricola, dataDiNascita);

    }
    private static void updateCorso () {
        Scanner scanner = new Scanner(System.in);
        readCorsi();
        System.out.println("inserisci l'id del corso da modificare:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("inserisci il nuovo nome del corso:");
        String nome = scanner.next();
        System.out.println("inserisci la nuova durata del corso:");
        String durata = scanner.next();
        System.out.println("Inserisci il nuovo giorno di inizio del corso: ");
        int giorno = scanner.nextInt();
        System.out.println("Inserisci il nuovo mese di inizio del corso: ");
        int mese = scanner.nextInt();
        System.out.println("Inserisci il nuovo anno di inizio del corso: ");
        int anno = scanner.nextInt();
        read();
        System.out.println("Inserisci l'id del nuovo docente: ");
        int docenteId= scanner.nextInt();
        LocalDate dataDiInizio = LocalDate.of(anno, mese, giorno);
        CorsoService oCorsoService = new CorsoService();
        oCorsoService.update(id, nome, dataDiInizio, docenteId, durata);

    }

}
