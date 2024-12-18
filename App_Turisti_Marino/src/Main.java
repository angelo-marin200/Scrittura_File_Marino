import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3); // Per gestire 3 gruppi
        Traghetto traghetto = new Traghetto();
        List<Turisti> gruppi = new ArrayList<>();

        // Creazione dei gruppi
        gruppi.add(new Turisti("francesi"));
        gruppi.add(new Turisti("tedeschi"));
        gruppi.add(new Turisti("spagnoli"));

        // Ordine casuale per simulare l'incertezza
        Collections.shuffle(gruppi);

        // Esecuzione delle fasi iniziali
        for (Turisti gruppo : gruppi) {
            executor.submit(gruppo);
        }

        executor.shutdown();

        // Aspetta la conclusione delle attività iniziali
        while (!executor.isTerminated()) {
            // Attesa
        }

        // Gestione del trasporto
        List<String> ordineViaggi = new ArrayList<>();
        for (Turisti gruppo : gruppi) {
            traghetto.trasporta(gruppo.getNomeGruppo());
            ordineViaggi.add(gruppo.getNomeGruppo());
        }

        // Scrittura dei viaggi nel file
        try (FileWriter writer = new FileWriter("report_viaggi.txt")) {
            writer.write("Data: " + LocalDate.now() + "\n");
            writer.write("Ordine viaggi:\n");
            for (String viaggio : ordineViaggi) {
                writer.write("- " + viaggio + "\n");
            }
        } catch (IOException e) {
            System.err.println("Errore nella scrittura del file: " + e.getMessage());
        }

        System.out.println("Simulazione terminata. Report scritto su file.");
    }
}
