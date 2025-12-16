package dierenpark.personen;

import java.time.LocalDate;

public class Bezoeker extends Persoon{

    private LeeftijdsCategorie leeftijd;
    private double toegangsPrijs;


    public enum LeeftijdsCategorie{
        KIND, VOLWASSEN, SENIOR
    }

    public Bezoeker(String voornaam, String achternaam, LocalDate geboortedatum, Adres adres, LeeftijdsCategorie leeftijd) {
        super(voornaam, achternaam, geboortedatum, adres);
        this.leeftijd = leeftijd;

        if(leeftijd == LeeftijdsCategorie.KIND){
            this.toegangsPrijs = 5.00;
        } else if (leeftijd == LeeftijdsCategorie.SENIOR) {
            this.toegangsPrijs = 7.00;
        } else if (leeftijd == LeeftijdsCategorie.VOLWASSEN) {
            this.toegangsPrijs = 15.00;
        }
    }

    public LeeftijdsCategorie getLeeftijd() {
        return leeftijd;
    }

    public void setLeeftijd(LeeftijdsCategorie leeftijd) {
        this.leeftijd = leeftijd;
    }

    @Override
    public String toString() {
        return "Bezoeker{" + super.toString() +
                " leeftijd = " + this.leeftijd + ", toegangsprijs = " + this.toegangsPrijs + " euro"+
                "} ";
    }
}
