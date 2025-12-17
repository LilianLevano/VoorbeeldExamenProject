package dierenpark.personen;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.time.LocalDate;

public class Personeelsleed extends Persoon implements Serializable {

    public enum TypePersoneel{
        POETSPLOEG, GIDS, VERZORGER
    }

    private TypePersoneel typePersoneel;
    private static int personeelsleedteller= 0;
    private String personeelsleedTel;

    public Personeelsleed(String voornaam, String achternaam, LocalDate geboortedatum, Adres adres, TypePersoneel typePersoneel) {
        super(voornaam, achternaam, geboortedatum, adres);
        this.typePersoneel = typePersoneel;
        this.personeelsleedTel = "Personeelsleed" +  personeelsleedteller;
        personeelsleedteller++;
    }


    public static int getPersoneelsleedteller() {
        return personeelsleedteller;
    }

    public static void setPersoneelsleedteller(int personeelsleedteller) {
        Personeelsleed.personeelsleedteller = personeelsleedteller;
    }

    public String getPersoneelsleedTel() {
        return personeelsleedTel;
    }

    public void setPersoneelsleedTel(String personeelsleedTel) {
        this.personeelsleedTel = personeelsleedTel;
    }

    public TypePersoneel getTypePersoneel() {
        return typePersoneel;
    }

    public void setTypePersoneel(TypePersoneel typePersoneel) {
        this.typePersoneel = typePersoneel;
    }

    @Override
    public String toString() {
        return this.personeelsleedTel + "{" + super.toString() +
                " typePersoneel = " + typePersoneel +
                "} " ;
    }
}
