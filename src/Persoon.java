public class Persoon {

    private String naam;
    private String achternaam;
    private String rrn;
    private String geboortedatum;
    private String type; // passagier, bestuurder, steward, bagage

    public Persoon(String naam, String achternaam, String rrn, String geboortedatum, String type) {
        this.naam = naam;
        this.achternaam = achternaam;
        this.rrn = rrn;
        this.geboortedatum = geboortedatum;
        this.type = type;
    }
    public String getNaam() {
        return naam;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return naam + " " + achternaam + " (" + type + ")";
    }
}
