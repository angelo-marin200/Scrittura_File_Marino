public class Turisti implements Runnable {
    private final String nomeGruppo;

    public Turisti(String nomeGruppo) {
        this.nomeGruppo = nomeGruppo;
    }

    @Override
    public void run() {
        try {
            System.out.println("Partenza dagli alloggi dei " + nomeGruppo);
            Thread.sleep(2000); // Simula il tempo per arrivare al porto
            System.out.println("Arrivo al porto dei " + nomeGruppo);
            Thread.sleep(1000); // Simula il pagamento del biglietto
            System.out.println("Pagamento del biglietto dei " + nomeGruppo);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public String getNomeGruppo() {
        return nomeGruppo;
    }
}
