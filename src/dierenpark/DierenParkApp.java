package dierenpark;

import dierenpark.personen.Adres;
import dierenpark.personen.Bezoeker;
import dierenpark.personen.Personeelsleed;

import java.time.LocalDate;
import java.util.Scanner;

public class DierenParkApp {

//    Zorg dat je bij het starten van de applicatie een keuzemenu krijgt. Volgende zaken moet je kunnen uitvoeren in dat menu
    //    Aanmaken personeelsleden.
    //    Aanmaken activiteiten met alle nodige informatie.
    //    Aanmaken zones met alle nodige informatie.
    //    Registreren van een bezoeker
    //    Toewijzen personeel, dit voegt personeel toe aan een activiteit.
    //    Inschrijving, hier voeg je een bezoeker aan een zone toe.
    //    Print info, hier maak je een bestand aan waar je voor een zone de bezoekerslijst in een tekstfile opslaat.
//    Zorg dat je de nodige Classes en andere objecten hebt om al het bovenstaande op te slaan
//    Voorzie de nodige foutcontroles wanneer je iemand probeert toe te voegen of laat deelnemen aan een tour.
//    Je mag gerust andere (relevante/nuttige) functies toevoegen, bovenstaande is het minimum dat in je main uitvoert.

    Scanner sc = new Scanner(System.in);


    public void start() {
        System.out.println("Welkom op de DierenPark Manager App.");

        int keuzeMenu;

        do {
            System.out.println("Maak een keuze: \n1. Maak een personeelsleed \n2. Maak een activiteit \n3. Maak een zone \n4. Registreer een bezoeker \n5. Medewerker toewijzen aan een activiteit \n6. Voeg een bezoeker aan een zone \n7. Toon info over een bepaalde zone \n8. Stop de applicatie.");
            keuzeMenu = Integer.parseInt(sc.nextLine());
            Personeelsleed medewerker;

            switch (keuzeMenu) {
                case 1:

                    System.out.print("Voornaam:");
                    String voornaam = sc.nextLine();
                    System.out.print("Achternaam:");
                    String achternaam = sc.nextLine();
                    System.out.print("Geboortedatum (Formaat: YYYY-MM-DD):");
                    LocalDate geboortedatum = LocalDate.parse(sc.nextLine());
                    System.out.print("Straatnaam:");
                    String straatNaam = sc.nextLine();
                    System.out.print("Huisnummer:");
                    int huisNummer = Integer.parseInt(sc.nextLine());
                    System.out.println("Bus:");
                    int bus = Integer.parseInt(sc.nextLine());
                    System.out.println("Postcode:");
                    int postCode = Integer.parseInt(sc.nextLine());
                    System.out.println("Woonplaat:");
                    String woonPlaats = sc.nextLine();
                    System.out.println("Type medewerker (keuze tussen: GIDS, POETSPLOEG, VERZORGER");
                    dierenpark.personen.Personeelsleed.TypePersoneel typeRol = Personeelsleed.TypePersoneel.valueOf(sc.nextLine());

                    medewerker = new Personeelsleed(voornaam, achternaam, geboortedatum, new Adres(straatNaam, huisNummer, bus, postCode, woonPlaats), typeRol);


                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;

            }


        } while (keuzeMenu != 8);

    }
}
