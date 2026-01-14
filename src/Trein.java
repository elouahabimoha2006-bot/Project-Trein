import java.util.ArrayList;

public class Trein {

    private Locomotief locomotief;
    private ArrayList<Wagon> wagons = new ArrayList<>();

    public Trein(Locomotief locomotief) {
        this.locomotief = locomotief;
    }

    public void voegWagonToe(Wagon w) {
        wagons.add(w);
    }

    public int totaleCapaciteit() {
        int totaal = 80; // basis
        for (Wagon w : wagons) totaal += w.getCapaciteit();
        return totaal;
    }
}