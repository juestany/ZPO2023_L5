import java.util.*;
public class Przedmioty {
    public Map<String, Przedmiot> listaPrzedmiotow;

    public Przedmioty () {
        /**
         * Konstruktor
         */
        listaPrzedmiotow = new HashMap<String, Przedmiot>();
    }

    public void dodajPrzedmiot(Przedmiot przedmiot) {
        /**
         * Metoda pozwalająca na dodanie przedmiotu do listy przedmiotów.
         * @param przedmiot (Przedmiot)
         */
        listaPrzedmiotow.put(przedmiot.getKod_przedmiotu(), przedmiot);
    }

    public void usunPrzedmiot(String kod_przedmiotu) {
        /**
         * Metoda pozwalająca na usunięcie przedmiotu z listy przedmiotów
         * z wykorzystaniem kodu przedmiotu.
         * @param kod_przedmiotu (String)
         */
        listaPrzedmiotow.remove(kod_przedmiotu);
    }

    public void przedstawPrzedmiot(Przedmiot przedmiot) {
        /**
         * Metoda prezentująca dany przedmiot.
         * @param przedmiot (Przedmiot)
         */
        System.out.println("Kod przedmiotu: " + przedmiot.getKod_przedmiotu());
        System.out.printf("Nazwa: " + przedmiot.getNazwa_przedmiotu() + "\n");
        System.out.println("Liczba ECTS: " + przedmiot.getECTS());
        System.out.println("Numer semestru: " + przedmiot.getSemestr());
        System.out.printf("Wymiar godzinowy: " + przedmiot.getWymiar_godz() + "\n");
    }

    public void podlicz(typ_przedmiotu typ_przedmiotu) {
        /**
         * Metoda podliczająca całkowitą liczbę godzin i sumę punktów ECTS danego typu zajęć.
         * @param typ_przedmiotu (typ_przedmiotu)
         */
        if (this.listaPrzedmiotow.isEmpty()) {
            System.out.println("Brak przedmiotów do podliczenia.");
            return;
        }
        
        int suma_godzin = this.listaPrzedmiotow
                .values()
                .stream()
                .filter(przedmiot -> przedmiot.getTyp_przedmiotu() == typ_przedmiotu)
                .mapToInt(Przedmiot::getWymiar_godz)
                .sum();

        int suma_ECTS = this.listaPrzedmiotow
                .values()
                .stream()
                .filter(przedmiot -> przedmiot.getTyp_przedmiotu() == typ_przedmiotu)
                .mapToInt(Przedmiot::getECTS)
                .sum();

        System.out.println("Suma godzin dla danego typu przedmiotu: " + suma_godzin + "\nSuma ECTS dla danego przedmiotu: " + suma_ECTS);
    }
}
