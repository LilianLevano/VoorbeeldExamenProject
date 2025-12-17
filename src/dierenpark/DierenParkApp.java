package dierenpark;

import dierenpark.personen.Adres;
import dierenpark.personen.Bezoeker;
import dierenpark.personen.Personeelsleed;
import dierenpark.zones.Activiteit;
import dierenpark.zones.Zone;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class DierenParkApp implements Serializable {

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
    ArrayList<Zone> zoneLijst =  new ArrayList<>();
    ArrayList<Personeelsleed> personeelsleedLijst =  new ArrayList<>();
    ArrayList<Bezoeker> bezoekerLijst =  new ArrayList<>();
    ArrayList<Activiteit> activiteitLijst =  new ArrayList<>();
    Personeelsleed medewerker;
    Activiteit activiteit;
    Zone zone;
    Bezoeker bezoeker;


    public void start() {
        System.out.println("Welkom op de DierenPark Manager App.");

        int keuzeMenu;


        do {
            System.out.println("""
                    Maak een keuze: \
                    
                    1. Maak een personeelsleed \
                    
                    2. Maak een activiteit \
                    
                    3. Maak een zone \
                    
                    4. Registreer een bezoeker \
                    
                    5. Medewerker toewijzen aan een activiteit \
                    
                    6. Voeg een bezoeker aan een zone \
                    
                    7. Print informatie over een bepaalde zone \
                    
                    8. Toon lijsten \
                    
                    9. Stop de applicatie.""");
            keuzeMenu = Integer.parseInt(sc.nextLine());

            switch (keuzeMenu) {
                case 1:
                    maakPersoneelsleed();
                    break;
                case 2:
                    maakActiviteit();
                    break;
                case 3:
                    maakZone();
                    break;
                case 4:
                    maakBezoeker();
                    break;
                case 5:
                    voegPersoneelAanActiviteit();
                    break;
                case 6:
                        voegBezoekerAanZone();
                    break;
                case 7:
                    zoneInBestandWegschrijven();
                    break;
                case 8:
                    toonLijsten();
                    break;
            }
        } while (keuzeMenu != 9);

    }

    private void maakPersoneelsleed(){

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
        Personeelsleed.TypePersoneel typeRol = Personeelsleed.TypePersoneel.valueOf(sc.nextLine());

        medewerker = new Personeelsleed(voornaam, achternaam, geboortedatum, new Adres(straatNaam, huisNummer, bus, postCode, woonPlaats), typeRol);
        personeelsleedLijst.add(medewerker);

    }

    private void maakActiviteit(){
        System.out.println("Categorie van de activiteit:");
        String categorie = sc.nextLine();

        System.out.println("Omschrijving van de activiteit:");
        String omschrijving = sc.nextLine();

        activiteit = new Activiteit(categorie, omschrijving);
        activiteitLijst.add(activiteit);
    }

    private void maakZone(){
        System.out.println("Naam van de zone:");
        String naamZone = sc.nextLine();

        System.out.println("Max capaciteit van de zone:");
        int maxCapaciteit = Integer.parseInt(sc.nextLine());

        zone = new Zone(naamZone, maxCapaciteit);
        zoneLijst.add(zone);

        String input;
        Bezoeker.LeeftijdsCategorie leeftijd;

        do{
            System.out.println("Welke leeftijdscategorieën zijn toegestaan in deze zone? (keuze tussen: KIND, VOLWASSEN, SENIOR) Druk STOP om te stoppen.");
            input = sc.nextLine();

            if(!input.equals("STOP")){
                leeftijd =  Bezoeker.LeeftijdsCategorie.valueOf(input);
                zone.addToegestaanLeeftijd(leeftijd);
            }

        }while (!Objects.equals(input, "STOP"));
    }

    private void maakBezoeker(){

        System.out.print("Voornaam:");
        String voornaamBezoeker = sc.nextLine();
        System.out.print("Achternaam:");
        String achternaamBezoeker = sc.nextLine();
        System.out.print("Geboortedatum (Formaat: YYYY-MM-DD):");
        LocalDate geboortedatumBezoeker = LocalDate.parse(sc.nextLine());
        System.out.print("Straatnaam:");
        String straatNaamBezoeker = sc.nextLine();
        System.out.print("Huisnummer:");
        int huisNummerBezoeker = Integer.parseInt(sc.nextLine());
        System.out.println("Bus:");
        int busBezoeker = Integer.parseInt(sc.nextLine());
        System.out.println("Postcode:");
        int postCodeBezoeker = Integer.parseInt(sc.nextLine());
        System.out.println("Woonplaat:");
        String woonPlaatsBezoeker = sc.nextLine();
        System.out.println("Leeftijdscategorie (SENIOR, VOLWASSEN, KIND):");
        Bezoeker.LeeftijdsCategorie leeftijdscategorie = Bezoeker.LeeftijdsCategorie.valueOf(sc.nextLine());

        bezoeker = new Bezoeker(voornaamBezoeker, achternaamBezoeker, geboortedatumBezoeker, new Adres(straatNaamBezoeker, huisNummerBezoeker, busBezoeker, postCodeBezoeker, woonPlaatsBezoeker), leeftijdscategorie );
        bezoekerLijst.add(bezoeker);

    }

    private void voegPersoneelAanActiviteit(){
        System.out.println("\nVoeg een personeel toe aan een activiteit. " +
                "\n Aan welke activiteit wil je een personeel toevoegen? (Gebruik de nummer van de activiteit) " +
                "\n" + activiteitLijst);

        int indexActiviteit = Integer.parseInt(sc.nextLine());
        Activiteit activiteitTeVeranderen = activiteitLijst.get(indexActiviteit);

        System.out.println("Welke personeel wil je aan deze activiteit toevoegen? (Gebruik de nummer van de personeelsleed) \n" + personeelsleedLijst);
        int indexPersoneelsleed = Integer.parseInt(sc.nextLine());
        Personeelsleed PersoneelToeVoegenAanActiviteit =  personeelsleedLijst.get(indexPersoneelsleed);

        activiteitTeVeranderen.addMederwerkers(PersoneelToeVoegenAanActiviteit);
    }

    private void voegBezoekerAanZone(){
        System.out.println("\nVoeg een bezoeker aan een zone.\nAan welke zone wil je een bezoeker toevoegen? (Gebruik de nummer van de zone)\n" + zoneLijst);
        int indexZone = Integer.parseInt(sc.nextLine());
        Zone zoneTeVeranderen = zoneLijst.get(indexZone);

        System.out.println("Welke bezoeker wil je toevoegen?\n" + bezoekerLijst);
        int indexToevoegen = Integer.parseInt(sc.nextLine());
        Bezoeker bezoekerToevoegenAanZone =  bezoekerLijst.get(indexToevoegen);

        zoneTeVeranderen.addBezoeker(bezoekerToevoegenAanZone);
    }

    private void zoneInBestandWegschrijven(){
        System.out.println("\nZone in een bestand wegschrijven." +
                "\nKies een zone dat je in een bestand wilt wegschrijven. (Gebruik de nummer van de zone) " +
                "\n" + zoneLijst);

        int indexZoneWegschrijven = Integer.parseInt(sc.nextLine());
        Zone zoneWegschrijven = zoneLijst.get(indexZoneWegschrijven);
        String bestandsnaam = zoneWegschrijven.getNaamZone() + ".txt";
        wegSchrijven(bestandsnaam, zoneWegschrijven);
    }

    private void toonLijsten(){
        System.out.println(zoneLijst);
        System.out.println(bezoekerLijst);
        System.out.println(activiteitLijst);
        System.out.println(personeelsleedLijst);
    }



    private void wegSchrijven(String bestandsNaam, Zone zone) {
        try (FileWriter writer = new FileWriter("zone/" + bestandsNaam)) {
            writer.append(zone.getLijstBezoekers());
        } catch (IOException e) {
            System.out.println("Schrijven mislukt");
        }
    }
}


