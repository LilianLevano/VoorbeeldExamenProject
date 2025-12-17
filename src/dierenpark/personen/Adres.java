package dierenpark.personen;

public class Adres {


    private String straatNaam;
    private int huisNummer;
    private int bus;
    private int postCode;
    private String woonPlaats;

    public Adres(String straatNaam, int huisNummer, int bus, int postCode, String woonPlaats) {
        this.straatNaam = straatNaam;
        this.huisNummer = huisNummer;
        this.bus = bus;
        this.postCode = postCode;
        this.woonPlaats = woonPlaats;
    }


    public String getStraatNaam() {
        return straatNaam;
    }

    public int getHuisNummer() {
        return huisNummer;
    }

    public int getBus() {
        return bus;
    }

    public int getPostCode() {
        return postCode;
    }

    public String getWoonPlaats() {
        return woonPlaats;
    }

    public void setStraatNaam(String straatNaam) {
        this.straatNaam = straatNaam;
    }

    public void setHuisNummer(int huisNummer) {
        this.huisNummer = huisNummer;
    }

    public void setBus(int bus) {
        this.bus = bus;
    }

    public void setPostCode(int postCode) {

        if (postCode > 9999) {
            postCode = 9999;
        }

        this.postCode = postCode;
    }

    public void setWoonPlaats(String woonPlaats) {
        this.woonPlaats = woonPlaats;
    }

    @Override
    public String toString() {
        return "Adres{" +
                " straatNaam = " + this.straatNaam +
                ", huisNummer = " + this.huisNummer +
                ", bus = " + this.bus +
                ", postCode = " + this.postCode +
                ", woonPlaats = " + this.woonPlaats +
                '}';
    }
}
