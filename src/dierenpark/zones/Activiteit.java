package dierenpark.zones;

import dierenpark.personen.Personeelsleed;

import java.io.Serializable;
import java.util.ArrayList;

public class Activiteit implements Serializable {

    private String categorie, omschrijving;
    private Personeelsleed mederwerker;
    private ArrayList<Personeelsleed> lijstMederwerkers = new ArrayList<>();
    private static int activiteitteller = 0;
    private String activiteitsTel;


    public Activiteit(String categorie, String omschrijving) {
        this.categorie = categorie;
        this.omschrijving = omschrijving;
        this.activiteitsTel = "Activiteit" + activiteitteller;
        activiteitteller++;

    }

    public Personeelsleed getMederwerker() {
        return mederwerker;
    }

    public void setMederwerker(Personeelsleed mederwerker) {
        this.mederwerker = mederwerker;
    }

    public void setLijstMederwerkers(ArrayList<Personeelsleed> lijstMederwerkers) {
        this.lijstMederwerkers = lijstMederwerkers;
    }

    public static int getActiviteitteller() {
        return activiteitteller;
    }

    public static void setActiviteitteller(int activiteitteller) {
        Activiteit.activiteitteller = activiteitteller;
    }

    public String getActiviteitsTel() {
        return activiteitsTel;
    }

    public void setActiviteitsTel(String activiteitsTel) {
        this.activiteitsTel = activiteitsTel;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public ArrayList<Personeelsleed> getLijstMederwerkers() {
        return lijstMederwerkers;
    }

    public void addMederwerkers(Personeelsleed mederwerker){
        if(lijstMederwerkers.contains(mederwerker)){
            System.out.println("Deze mederwerker staat al in deze lijst.");
        }else{
            this.lijstMederwerkers.add(mederwerker);
        }

    }

    @Override
    public String toString() {
        return this.activiteitsTel + "{" +
                " categorie = " + categorie +
                ", omschrijving = " + omschrijving +
                ", lijstMederwerkers = " + lijstMederwerkers +
                '}';
    }
}
