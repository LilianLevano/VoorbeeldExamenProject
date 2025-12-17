package dierenpark.personen;

import java.io.Serializable;
import java.time.LocalDate;

public class Bezoeker extends Persoon implements Serializable {

    private LeeftijdsCategorie leeftijd;
    private double toegangsPrijs;
    private static int bezoekerteller= 0;
    private String bezoekerTel;


    public enum LeeftijdsCategorie{
        KIND, VOLWASSEN, SENIOR
    }

    public Bezoeker(String voornaam, String achternaam, LocalDate geboortedatum, Adres adres, LeeftijdsCategorie leeftijd) {
        super(voornaam, achternaam, geboortedatum, adres);
        this.leeftijd = leeftijd;
        this.bezoekerTel = "Bezoeker" + bezoekerteller;

        if(leeftijd == LeeftijdsCategorie.KIND){
            this.toegangsPrijs = 5.00;
        } else if (leeftijd == LeeftijdsCategorie.SENIOR) {
            this.toegangsPrijs = 7.00;
        } else if (leeftijd == LeeftijdsCategorie.VOLWASSEN) {
            this.toegangsPrijs = 15.00;
        }

        bezoekerteller++;
    }

    public double getToegangsPrijs() {
        return toegangsPrijs;
    }

    public void setToegangsPrijs(double toegangsPrijs) {
        this.toegangsPrijs = toegangsPrijs;
    }

    public static int getBezoekerteller() {
        return bezoekerteller;
    }

    public static void setBezoekerteller(int bezoekerteller) {
        Bezoeker.bezoekerteller = bezoekerteller;
    }

    public String getBezoekerTel() {
        return bezoekerTel;
    }

    public void setBezoekerTel(String bezoekerTel) {
        this.bezoekerTel = bezoekerTel;
    }

    public LeeftijdsCategorie getLeeftijd() {
        return leeftijd;
    }

    public void setLeeftijd(LeeftijdsCategorie leeftijd) {
        this.leeftijd = leeftijd;
    }

    @Override
    public String toString() {
        return this.bezoekerTel + "{" + super.toString() +
                " leeftijd = " + this.leeftijd + ", toegangsprijs = " + this.toegangsPrijs + " euro"+
                "} ";
    }
}
