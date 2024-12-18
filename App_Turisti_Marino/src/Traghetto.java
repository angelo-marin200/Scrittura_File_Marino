public class Traghetto {
    public synchronized void trasporta(String nomeGruppo) {
        try {
            System.out.println("Imbarco sul traghetto dei " + nomeGruppo);
            Thread.sleep(3000); // Simula il tempo per il trasporto all'isola
            System.out.println("Partenza dal porto dei " + nomeGruppo);
            Thread.sleep(3000); // Simula il tempo di ritorno
            System.out.println("Ritorno al porto del traghetto");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
