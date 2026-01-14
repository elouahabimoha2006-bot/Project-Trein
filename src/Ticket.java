public class Ticket {

    private Persoon passagier;
    private Reis reis;
    private String klasse;

    public Ticket(Persoon passagier, Reis reis, String klasse) {
        this.passagier = passagier;
        this.reis = reis;
        this.klasse = klasse;
    }

    @Override
    public String toString() {
        return passagier.toString() + " | Klasse: " + klasse;
    }
}