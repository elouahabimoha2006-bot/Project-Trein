import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Persoon> passagiers = new ArrayList<>();
    static ArrayList<Reis> reizen = new ArrayList<>();

    static String[] stations = {
            "Brussel", "Amsterdam", "Parijs", "Milaan", "Berlijn",
            "Madrid", "Rome", "Wenen", "Praag", "Londen"
    };

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean bezig = true;

        while (bezig) {
            System.out.println("\n=== EUROMOON MENU ===");
            System.out.println("1. Registreer passagier");
            System.out.println("2. Maak reis");
            System.out.println("3. Koppel trein");
            System.out.println("4. Verkoop ticket");
            System.out.println("5. Stop");
            System.out.print("Keuze: ");

            String keuze = sc.nextLine();

            switch (keuze) {
                case "1": registreerPassagier(sc); break;
                case "2": maakReis(sc); break;
                case "3": koppelTrein(sc); break;
                case "4": verkoopTicket(sc); break;
                case "5": bezig = false; break;
                default: System.out.println("Ongeldige keuze");
            }
        }
    }

    static void registreerPassagier(Scanner sc) {
        System.out.print("Naam: ");
        String naam = sc.nextLine();

        System.out.print("Achternaam: ");
        String achternaam = sc.nextLine();

        System.out.print("RRN: ");
        String rrn = sc.nextLine();

        System.out.print("Geboortedatum (DD/MM/JJJJ): ");
        String geboortedatum = sc.nextLine();

        Persoon p = new Persoon(naam, achternaam, rrn, geboortedatum, "passagier");
        passagiers.add(p);

        System.out.println("Passagier geregistreerd!");
    }

    static void maakReis(Scanner sc) {

        System.out.println("Kies vertrekstation:");
        for (int i = 0; i < stations.length; i++) {
            System.out.println((i + 1) + ". " + stations[i]);
        }
        int vertrek = Integer.parseInt(sc.nextLine()) - 1;

        System.out.println("Kies aankomststation:");
        for (int i = 0; i < stations.length; i++) {
            System.out.println((i + 1) + ". " + stations[i]);
        }
        int aankomst = Integer.parseInt(sc.nextLine()) - 1;

        System.out.print("Tijdstip (JJJJ-MM-DD HH:MM): ");
        String tijdstip = sc.nextLine();

        Reis r = new Reis(stations[vertrek], stations[aankomst], tijdstip);
        reizen.add(r);

        System.out.println("Reis aangemaakt!");
    }

    static void koppelTrein(Scanner sc) {
        if (reizen.isEmpty()) {
            System.out.println("Geen reizen.");
            return;
        }

        System.out.println("Kies een reis:");
        for (int i = 0; i < reizen.size(); i++) {
            System.out.println((i + 1) + ". " + reizen.get(i));
        }
        int index = Integer.parseInt(sc.nextLine()) - 1;

        Reis r = reizen.get(index);

        // AUTOMATISCHE LOCOMOTIEF
        Locomotief loco = new Locomotief("Class 374");
        Trein trein = new Trein(loco);

        // AUTOMATISCH MAX WAGONS
        for (int i = 1; i <= loco.getMaxWagons(); i++) {
            trein.voegWagonToe(new Wagon(i, 40));
        }

        // AUTOMATISCH PERSONEEL
        r.voegPersoneelToe(new Persoon("Jan", "Bestuurder", "000", "01/01/1970", "bestuurder"));
        r.voegPersoneelToe(new Persoon("Anna", "Steward", "111", "01/01/1980", "steward"));
        r.voegPersoneelToe(new Persoon("Tom", "Steward", "222", "01/01/1985", "steward"));
        r.voegPersoneelToe(new Persoon("Lisa", "Steward", "333", "01/01/1990", "steward"));

        r.koppelTrein(trein);

        System.out.println("Trein gekoppeld met 14 wagons en personeel.");
    }

    static void verkoopTicket(Scanner sc) {
        if (passagiers.isEmpty() || reizen.isEmpty()) {
            System.out.println("Geen passagiers of reizen.");
            return;
        }

        System.out.println("Kies passagier:");
        for (int i = 0; i < passagiers.size(); i++) {
            System.out.println((i + 1) + ". " + passagiers.get(i));
        }
        int pIndex = Integer.parseInt(sc.nextLine()) - 1;

        System.out.println("Kies reis:");
        for (int i = 0; i < reizen.size(); i++) {
            System.out.println((i + 1) + ". " + reizen.get(i));
        }
        int rIndex = Integer.parseInt(sc.nextLine()) - 1;

        System.out.print("Klasse (eerste/tweede): ");
        String klasse = sc.nextLine();

        boolean gelukt = reizen.get(rIndex).verkoopTicket(passagiers.get(pIndex), klasse);

        if (gelukt) System.out.println("Ticket verkocht!");
        else System.out.println("Ticket kon niet verkocht worden.");
    }
}