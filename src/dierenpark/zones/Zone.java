package dierenpark.zones;

import dierenpark.personen.Bezoeker;


import java.io.Serializable;
import java.util.ArrayList;

public class Zone implements Serializable {


    private Bezoeker bezoeker;
    private Activiteit activiteit;
    private String naamZone;
    private int maxCapaciteit;
    private Bezoeker.LeeftijdsCategorie leeftijd;
    private static int zoneteller = 0;
    private String zoneTel;

    private ArrayList<Activiteit> lijstActiviteit = new ArrayList<>();
    private ArrayList<Bezoeker> lijstBezoekers = new ArrayList<>();

    private ArrayList<Bezoeker.LeeftijdsCategorie> toegestaanLeeftijd = new ArrayList<>();

    public Zone(String naamZone, int maxCapaciteit) {
        this.naamZone = naamZone;
        this.maxCapaciteit = maxCapaciteit;
        this.zoneTel = "Zone" + zoneteller;
        zoneteller++;
    }

    public Bezoeker getBezoeker() {
        return bezoeker;
    }

    public void setBezoeker(Bezoeker bezoeker) {
        this.bezoeker = bezoeker;
    }

    public Activiteit getActiviteit() {
        return activiteit;
    }

    public void setActiviteit(Activiteit activiteit) {
        this.activiteit = activiteit;
    }

    public void setNaamZone(String naamZone) {
        this.naamZone = naamZone;
    }

    public int getMaxCapaciteit() {
        return maxCapaciteit;
    }

    public void setMaxCapaciteit(int maxCapaciteit) {
        this.maxCapaciteit = maxCapaciteit;
    }

    public Bezoeker.LeeftijdsCategorie getLeeftijd() {
        return leeftijd;
    }

    public void setLeeftijd(Bezoeker.LeeftijdsCategorie leeftijd) {
        this.leeftijd = leeftijd;
    }

    public static int getZoneteller() {
        return zoneteller;
    }

    public static void setZoneteller(int zoneteller) {
        Zone.zoneteller = zoneteller;
    }

    public String getZoneTel() {
        return zoneTel;
    }

    public void setZoneTel(String zoneTel) {
        this.zoneTel = zoneTel;
    }

    public ArrayList<Activiteit> getLijstActiviteit() {
        return lijstActiviteit;
    }

    public void setLijstActiviteit(ArrayList<Activiteit> lijstActiviteit) {
        this.lijstActiviteit = lijstActiviteit;
    }

    public void setLijstBezoekers(ArrayList<Bezoeker> lijstBezoekers) {
        this.lijstBezoekers = lijstBezoekers;
    }

    public ArrayList<Bezoeker.LeeftijdsCategorie> getToegestaanLeeftijd() {
        return toegestaanLeeftijd;
    }

    public void setToegestaanLeeftijd(ArrayList<Bezoeker.LeeftijdsCategorie> toegestaanLeeftijd) {
        this.toegestaanLeeftijd = toegestaanLeeftijd;
    }

    public String getLijstBezoekers() {
        return ""+lijstBezoekers;
    }

    public String getNaamZone() {
        return naamZone;
    }

    public void addToegestaanLeeftijd(Bezoeker.LeeftijdsCategorie leeftijd){
        if(this.toegestaanLeeftijd.contains(leeftijd)){
            System.out.println("Deze categorie is al toegestaan.");
        }else{
            toegestaanLeeftijd.add(leeftijd);
            System.out.println("Categorie succesvol toegestaan.");
        }
    }


    public void addActiviteit(Activiteit activiteit){
        if(lijstActiviteit.contains(activiteit)){
            System.out.println("Deze activiteit bestaat al in deze zone.");
        }else{
            lijstActiviteit.add(activiteit);
            System.out.println(activiteit + "  werd succesvol toegevoegd in deze zone.");
        }
    }

    public void addBezoeker(Bezoeker bezoeker){

        if(toegestaanLeeftijd.contains(bezoeker.getLeeftijd())){
            if(this.maxCapaciteit == lijstBezoekers.size()){
                System.out.println("Deze zone is compleet. Geen extra bezoekers kunnen toegevoegd worden.");
            }else{
                lijstBezoekers.add(bezoeker);

            }
        }else{
            System.out.println("Deze leeftijdscategorie is niet toegestaan in deze zone.");
        }

    }

    @Override
    public String toString() {
        return this.zoneTel + "{" +
                " activiteit = " + activiteit +
                ", naamZone = " + naamZone +
                ", maxCapaciteit = " + maxCapaciteit +
                ", toegestaanLeeftijd = " + toegestaanLeeftijd +
                ", lijstBezoekers = " + lijstBezoekers +
                ", lijstActiviteit = " + lijstActiviteit +
                '}';
    }


}
