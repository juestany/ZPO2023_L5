import java.util.*;
public class Przedmioty {
    public Map<String, Przedmiot> listaPrzedmiotow;

    public Przedmioty () {
        listaPrzedmiotow = new HashMap<String, Przedmiot>();
    }

    public void dodajPrzedmiot(Przedmiot przedmiot) {
        listaPrzedmiotow.put(przedmiot.getKod_przedmiotu(), przedmiot);
    }

    public void usunPrzedmiot(String kod_przedmiotu) {
        listaPrzedmiotow.remove(kod_przedmiotu);
    }

    public void przedstawPrzedmiot(Przedmiot przedmiot) {
        System.out.println("Kod przedmiotu: " + przedmiot.getKod_przedmiotu());
        System.out.printf("Nazwa: " + przedmiot.getNazwa_przedmiotu() + "\n");
        System.out.println("Liczba ECTS: " + przedmiot.getECTS());
        System.out.println("Numer semestru: " + przedmiot.getSemestr());
        System.out.printf("Wymiar godzinowy: " + przedmiot.getWymiar_godz());
    }
}
