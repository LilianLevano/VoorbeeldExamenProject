package dierenpark.personen;

import java.lang.reflect.Type;
import java.time.LocalDate;

public class Personeelsleed extends Persoon {

    public enum TypePersoneel{
        POETSPLOEG, GIDS, VERZORGER
    }

    private TypePersoneel typePersoneel;

    public Personeelsleed(String voornaam, String achternaam, LocalDate geboortedatum, Adres adres, TypePersoneel typePersoneel) {
        super(voornaam, achternaam, geboortedatum, adres);
        this.typePersoneel = typePersoneel;
    }

    public TypePersoneel getTypePersoneel() {
        return typePersoneel;
    }

    public void setTypePersoneel(TypePersoneel typePersoneel) {
        this.typePersoneel = typePersoneel;
    }

    @Override
    public String toString() {
        return "Personeelsleed{" + super.toString() +
                " typePersoneel = " + typePersoneel +
                "} " ;
    }
}
