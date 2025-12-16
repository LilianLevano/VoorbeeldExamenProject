package dierenpark.personen;

import java.time.LocalDate;

public class Persoon {
    private String voornaam, achternaam, naam;
    private LocalDate geboortedatum;
    private Adres adres;

    public Persoon(String voornaam, String achternaam, LocalDate geboortedatum, Adres adres) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.naam = voornaam + " " + achternaam;
        this.geboortedatum = geboortedatum;
        this.adres = adres;
    }

    public Persoon() {

    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public LocalDate getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(LocalDate geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }


    @Override
    public String toString() {
        return "Persoon{" +
                " voornaam = " + this.voornaam +
                ", achternaam = " + this.achternaam +
                ", geboortedatum = " + this.geboortedatum +
                   " " + this.adres +
                '}';
    }
}
