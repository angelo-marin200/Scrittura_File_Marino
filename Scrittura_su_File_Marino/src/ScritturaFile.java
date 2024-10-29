import java.io.*;

public class ScritturaFile {

    // Metodo statico per leggere dal console e scrivere su file
    public static void scriviDaConsoleSuFile(String nomeFile) {
        try (
                // Creazione di BufferedReader per leggere da console
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

                // Creazione di PrintWriter per scrivere su file
                PrintWriter writer = new PrintWriter(new FileWriter(nomeFile))
        ) {
            System.out.println("Inserisci testo (lascia una linea vuota per terminare):");

            String linea;
            while (!(linea = reader.readLine()).isEmpty()) {
                writer.println(linea);
            }

            System.out.println("Scrittura completata nel file " + nomeFile);
        } catch (IOException e) {
            System.err.println("Errore durante la scrittura del file: " + e.getMessage());
        }
    }
}
