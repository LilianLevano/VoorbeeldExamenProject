package dierenpark.zones;

import dierenpark.personen.Personeelsleed;

import java.util.ArrayList;

public class Activiteit {

    private String categorie, omschrijving;
    private Personeelsleed mederwerker;
    private ArrayList<Personeelsleed> lijstMederwerkers = new ArrayList<>();

    public Activiteit(String categorie, String omschrijving) {
        this.categorie = categorie;
        this.omschrijving = omschrijving;
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
            System.out.println(mederwerker.getNaam() + " (mederwerker) werd succesvol toegevoegd aan " + this.categorie + ".");
        }

    }

    @Override
    public String toString() {
        return "Activiteit{" +
                " categorie = " + categorie +
                ", omschrijving = " + omschrijving +
                '}';
    }
}
