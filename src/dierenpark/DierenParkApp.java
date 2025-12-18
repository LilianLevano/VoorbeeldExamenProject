package dierenpark;

import dierenpark.personen.Adres;
import dierenpark.personen.Bezoeker;
import dierenpark.personen.Personeelsleed;
import dierenpark.personen.Persoon;
import dierenpark.zones.Activiteit;
import dierenpark.zones.Zone;
import org.w3c.dom.ls.LSOutput;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class DierenParkApp implements Serializable {

    Scanner sc = new Scanner(System.in);
    ArrayList<Zone> zoneLijst =  new ArrayList<>();
    ArrayList<Personeelsleed> personeelsleedLijst =  new ArrayList<>();
    ArrayList<Bezoeker> bezoekerLijst =  new ArrayList<>();
    ArrayList<Activiteit> activiteitLijst =  new ArrayList<>();
    Personeelsleed medewerker;
    Activiteit activiteit;
    Zone zone;
    Bezoeker bezoeker;
//    public static final String ROOD = "\u001B[31m";
    public static final String GROEN = "\u001B[32m";
    public static final String GEEL = "\u001B[33m";
    public static final String RESET = "\u001B[0m";


    public void start() {
        System.out.println(GEEL + "Welkom op de DierenPark Manager App." + RESET);

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
            System.out.print("--> ");
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

        System.out.println("-".repeat(5) + "Registreer een personeelsleed" + "-".repeat(5) +"\n");
        try{
            System.out.print("Voornaam: ");
            String voornaam = sc.nextLine();
            System.out.print("Achternaam: ");
            String achternaam = sc.nextLine();
            System.out.print("Geboortedatum (Formaat: YYYY-MM-DD): ");
            LocalDate geboortedatum = LocalDate.parse(sc.nextLine());
            System.out.print("Straatnaam: ");
            String straatNaam = sc.nextLine();
            System.out.print("Huisnummer: ");
            int huisNummer = Integer.parseInt(sc.nextLine());
            System.out.print("Bus: ");
            int bus = Integer.parseInt(sc.nextLine());
            System.out.print("Postcode: ");
            int postCode = Integer.parseInt(sc.nextLine());
            System.out.print("Woonplaats: ");
            String woonPlaats = sc.nextLine();
            System.out.print("Type medewerker (keuze tussen: GIDS, POETSPLOEG, VERZORGER): ");
            Personeelsleed.TypePersoneel typeRol = Personeelsleed.TypePersoneel.valueOf(sc.nextLine());

            medewerker = new Personeelsleed(voornaam, achternaam, geboortedatum, new Adres(straatNaam, huisNummer, bus, postCode, woonPlaats), typeRol);
            personeelsleedLijst.add(medewerker);
            System.out.println(GROEN + voornaam + " " + achternaam + " succesvol toegevoegd.\n" + RESET);
        }catch (NumberFormatException e) {
            System.err.println("Foutieve invoer: huisnummer, bus of postcode moet een getal zijn.\nPersoneelsleed werd niet gemaakt. Probeer opnieuw.");
        } catch (DateTimeParseException e) {
            System.err.println("Foutieve invoer: geboortedatum moet in formaat YYYY-MM-DD zijn.\nPersoneelsleed werd niet gemaakt. Probeer opnieuw.");
        } catch (IllegalArgumentException e) {
            System.err.println("Foutieve invoer: leeftijdscategorie ongeldig (SENIOR, VOLWASSEN, KIND).\nPersoneelsleed werd niet gemaakt. Probeer opnieuw.");
        }


    }

    private void maakActiviteit(){
        System.out.println("-".repeat(5) + "Maak een activiteit" + "-".repeat(5) +"\n");

        System.out.print("Categorie van de activiteit: ");
        String categorie = sc.nextLine();

        System.out.print("Omschrijving van de activiteit: ");
        String omschrijving = sc.nextLine();

        activiteit = new Activiteit(categorie, omschrijving);
        activiteitLijst.add(activiteit);
        System.out.println( GROEN + categorie +" succesvol gemaakt en toegevoegd aan de lijst van activiteiten.\n" + RESET);
    }

    private void maakZone(){
        System.out.println("-".repeat(5) + "Maak een zone" + "-".repeat(5) +"\n");
        System.out.print("Naam van de zone: ");
        String naamZone = sc.nextLine();

        System.out.print("Maximum aantal bezoekers in deze zone: ");
        int maxCapaciteit = Integer.parseInt(sc.nextLine());

        zone = new Zone(naamZone, maxCapaciteit);
        zoneLijst.add(zone);
        System.out.println(GROEN + naamZone + " werd succesvol gemaakt en toegevoegd aan de lijst van zones." + RESET);

        String input = "";
        Bezoeker.LeeftijdsCategorie leeftijd;
        boolean fouteinput = false;


        do{
            try{
                do{

                    System.out.println("Welke leeftijdscategorieën zijn toegestaan in deze zone? (keuze tussen: KIND, VOLWASSEN, SENIOR) Druk STOP om te stoppen.): ");
                    input = sc.nextLine();

                    if(input.equals("STOP")){
                        fouteinput = false;
                    }

                    if(!input.equals("STOP")){
                        leeftijd =  Bezoeker.LeeftijdsCategorie.valueOf(input);
                        zone.addToegestaanLeeftijd(leeftijd);
                        System.out.println(GROEN + input + " werd succesvol toegevoegd aan de lijst van toegestaan leeftijden." + RESET);

                    }

                }while (!Objects.equals(input, "STOP"));
            }catch (IllegalArgumentException e) {
                System.err.println("Deze type leeftijdscategorie bestaat niet. Probeer opnieuw met de correcte schrijfwijze.");
                fouteinput = true;
            }
        }while(fouteinput);


    }

    private void maakBezoeker(){
        System.out.println("-".repeat(5) + "Registreer een bezoeker" + "-".repeat(5) +"\n");
    try{
        System.out.print("Voornaam: ");
        String voornaamBezoeker = sc.nextLine();
        System.out.print("Achternaam: ");
        String achternaamBezoeker = sc.nextLine();
        System.out.print("Geboortedatum (Formaat: YYYY-MM-DD): ");
        LocalDate geboortedatumBezoeker = LocalDate.parse(sc.nextLine());
        System.out.print("Straatnaam: ");
        String straatNaamBezoeker = sc.nextLine();
        System.out.print("Huisnummer: ");
        int huisNummerBezoeker = Integer.parseInt(sc.nextLine());
        System.out.print("Bus: ");
        int busBezoeker = Integer.parseInt(sc.nextLine());
        System.out.print("Postcode: " );
        int postCodeBezoeker = Integer.parseInt(sc.nextLine());
        System.out.print("Woonplaats: ");
        String woonPlaatsBezoeker = sc.nextLine();
        System.out.print("Leeftijdscategorie (SENIOR (+65), VOLWASSEN, KIND (-12): ");
        Bezoeker.LeeftijdsCategorie leeftijdscategorie = Bezoeker.LeeftijdsCategorie.valueOf(sc.nextLine());

        bezoeker = new Bezoeker(voornaamBezoeker, achternaamBezoeker, geboortedatumBezoeker, new Adres(straatNaamBezoeker, huisNummerBezoeker, busBezoeker, postCodeBezoeker, woonPlaatsBezoeker), leeftijdscategorie );
        bezoekerLijst.add(bezoeker);

        System.out.println(GROEN + voornaamBezoeker + " " + achternaamBezoeker + " werd succesvol geregistreerd en toegevoegd aan de lijst van bezoekers." + RESET);
    } catch (NumberFormatException e) {
        System.err.println("Foutieve invoer: huisnummer, bus of postcode moet een getal zijn.\nBezoeker werd niet gemaakt. Probeer opnieuw.");
    } catch (DateTimeParseException e) {
        System.err.println("Foutieve invoer: geboortedatum moet in formaat YYYY-MM-DD zijn.\nBezoeker werd niet gemaakt. Probeer opnieuw.");
    } catch (IllegalArgumentException e) {
        System.err.println("Foutieve invoer: leeftijdscategorie ongeldig (SENIOR, VOLWASSEN, KIND).\nBezoeker werd niet gemaakt. Probeer opnieuw.");
    }




    }

    private void voegPersoneelAanActiviteit() {
        System.out.println("-".repeat(5) + "Voeg een personeelsleed aan een activiteit" + "-".repeat(5) +"\n");
        if (activiteitLijst.isEmpty()) {
            System.err.println("Er zijn momenteel geen activiteiten gemaakt.");
        }else if(personeelsleedLijst.isEmpty()){
            System.err.println("Er zijn momenteel geen medewerkers gemaakt.");
        }else{
            System.out.println("""
                
                Voeg een personeel toe aan een activiteit. \
                
                Aan welke activiteit wil je een personeel toevoegen? (Gebruik de nummer van de activiteit) \
                
                """);

            for(Activiteit activiteit: activiteitLijst){
                System.out.println(GEEL + activiteit.getActiviteitsTel() + RESET +
                        "\nCategorie activiteit: " + activiteit.getCategorie() +
                        "\nOmschrijving activiteit: " + activiteit.getOmschrijving() +
                        "\nLijst medewerkers: " + activiteit.getLijstMederwerkers());
            }

            int indexActiviteit = Integer.parseInt(sc.nextLine());
            Activiteit activiteitTeVeranderen = activiteitLijst.get(indexActiviteit);

            System.out.println("Welke personeel wil je aan deze activiteit toevoegen? (Gebruik de nummer van de personeelsleed) \n");

            for(Personeelsleed personeelsleed : personeelsleedLijst){
                System.out.println(GEEL + personeelsleed.getPersoneelsleedTel() +RESET+
                        "\nVoornaam: " + personeelsleed.getVoornaam() + ", achternaam: " + personeelsleed.getAchternaam() +
                        "\nAdres van de bezoeker: " + personeelsleed.getAdres());

            }

            int indexPersoneelsleed = Integer.parseInt(sc.nextLine());
            Personeelsleed PersoneelToeVoegenAanActiviteit =  personeelsleedLijst.get(indexPersoneelsleed);

            activiteitTeVeranderen.addMederwerkers(PersoneelToeVoegenAanActiviteit);

            System.out.println(GROEN + PersoneelToeVoegenAanActiviteit.getNaam() + " werd succesvol toegevoegd aan " + activiteitTeVeranderen.getCategorie() + RESET);
        }



    }

    private void voegBezoekerAanZone(){
        System.out.println("-".repeat(5) + "Voeg een bezoeker aan een zone" + "-".repeat(5) +"\n");
        System.out.println("\nVoeg een bezoeker aan een zone.\nAan welke zone wil je een bezoeker toevoegen? (Gebruik de nummer van de zone)\n");

        for(Zone zone : zoneLijst){
            System.out.println(GEEL + zone.getZoneTel() +RESET+
                    "\nNaam van de zone: " + zone.getNaamZone()+
                    "\nMaximum capaciteit van de zone: " + zone.getMaxCapaciteit());

        }

        int indexZone = Integer.parseInt(sc.nextLine());
        Zone zoneTeVeranderen = zoneLijst.get(indexZone);

        System.out.println("Welke bezoeker wil je toevoegen? (Gebruik de nummer van de persoon)" );

        for(Bezoeker bezoeker : bezoekerLijst){
            System.out.println(GEEL + bezoeker.getBezoekerTel() +RESET+
                    "\nVoornaam: " + bezoeker.getVoornaam() + ", achternaam: " + bezoeker.getAchternaam() +
                    "\nLeeftijd van de bezoeker: " + bezoeker.getLeeftijd() +
                    "\nToegangsprijs van de bezoeker: " + bezoeker.getToegangsPrijs() +
                    "\nAdres van de bezoeker: " + bezoeker.getAdres());

        }

        int indexToevoegen = Integer.parseInt(sc.nextLine());
        Bezoeker bezoekerToevoegenAanZone =  bezoekerLijst.get(indexToevoegen);

        zoneTeVeranderen.addBezoeker(bezoekerToevoegenAanZone);
        System.out.println(GROEN + bezoekerToevoegenAanZone.getNaam() + " werd succesvol aan deze zone toegevoegd" + RESET);
    }

    private void zoneInBestandWegschrijven(){
        System.out.println("-".repeat(5) + "Print informatie over een zone af" + "-".repeat(5) +"\n");
        System.out.println("\nZone in een bestand wegschrijven." +
                "\nKies een zone dat je in een bestand wilt wegschrijven. (Gebruik de nummer van de zone) ");

        for(Zone zone : zoneLijst){
            System.out.println(GEEL + zone.getZoneTel() +RESET+
                    "\nNaam van de zone: " + zone.getNaamZone()+
                    "\nMaximum capaciteit van de zone: " + zone.getMaxCapaciteit());

        }

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


