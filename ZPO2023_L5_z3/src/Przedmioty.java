import java.util.*;
import java.io.*;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.io.File;
import org.json.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Przedmioty {
    public static Map<String, Przedmiot> listaPrzedmiotow;

    public Przedmioty () {
        /**
         * Konstruktor
         */
        listaPrzedmiotow = new HashMap<String, Przedmiot>();
    }

    public static JSONObject PrzedmiotyJakoJSON(Przedmioty przedmioty) {
        /**
         * Metoda zapisująca obiekt klasy Przedmioty w formie JSON.
         * @param przedmioty (Przedmioty)
         * @returns jsonObject(JSONObject)
         */
        JSONObject jsonObject = new JSONObject();
        for(Map.Entry<String, Przedmiot> obiektPrzedmiot : przedmioty.listaPrzedmiotow.entrySet()) {
            // iteracja po kolejnych przedmiotach
            JSONObject przedmiotJSON = new JSONObject();
            Przedmiot przedmiot = obiektPrzedmiot.getValue();

            przedmiotJSON.put("kod_przedmiotu", przedmiot.getKod_przedmiotu());
            przedmiotJSON.put("nazwa_przedmiotu", przedmiot.getNazwa_przedmiotu());
            przedmiotJSON.put("ECTS", przedmiot.getECTS());
            przedmiotJSON.put("wymiar_godz", przedmiot.getWymiar_godz());
            przedmiotJSON.put("semestr", przedmiot.getSemestr());
            przedmiotJSON.put("typ_przedmiotu", przedmiot.getTyp_przedmiotu().toString());
            przedmiotJSON.put("sposob_zaliczenia", przedmiot.getSposob_zaliczenia().toString());

            if (jsonObject.containsKey(przedmiot.getKod_przedmiotu())) { // jeśli taki klucz już jest
                JSONArray przedmiotArray = (JSONArray) jsonObject.get(przedmiot.getKod_przedmiotu());
                przedmiotArray.add(przedmiotJSON);
            } else { // jeśli nie, to stwórz nowy
                JSONArray przedmiotArray = new JSONArray();
                przedmiotArray.add(przedmiotJSON);
                jsonObject.put(przedmiot.getKod_przedmiotu(), przedmiotArray);
            }
        }
        return jsonObject;
    }

    public static void eksportJSON(JSONObject jsonObject, String nazwaPliku) {
        /**
         * Metoda pozwalająca zapisać obiekt JSON w formie pliku.
         * @param jsonObject (JSONObject)
         * @param nazwaPliku (String)
         */
        try {
            FileWriter file = new FileWriter(nazwaPliku);
            file.write(jsonObject.toJSONString());
            file.close();
        } catch (IOException e) {
            e.getMessage();
        }
        System.out.println("JSON file created: "+ jsonObject);
    }

    public static Przedmioty importJSON(String path) throws IOException, ParseException {
        /**
         * Metoda pozwalająca na wczytanie pliku JSON z listą przedmiotów i zwrócenie jej w postaci klasy Przedmioty.
         * @param path (String)
         * @returns przedmioty (Przedmioty)
         * @throws IOException, ParseException
         */
        Przedmioty przedmioty = new Przedmioty();
        try {
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(path));

            for (Object key : jsonObject.keySet()) {
                String kodPrzedmiotu = (String) key;
                JSONObject przedmiotJson = (JSONObject) jsonObject.get(kodPrzedmiotu);
                
                String nazwa_przedmiotu = (String) przedmiotJson.get("nazwa_przedmiotu");
                int ECTS = (int) przedmiotJson.get("ECTS");
                int wymiar_godz = (int) przedmiotJson.get("wymiar_godz");
                int semestr = (int) przedmiotJson.get("semestr");
                typ_przedmiotu typ_przedmiotu = (typ_przedmiotu) przedmiotJson.get("typ_przedmiotu");
                sposob_zaliczenia sposob_zaliczenia = (sposob_zaliczenia) przedmiotJson.get("sposob_zaliczenia");
                
                Przedmiot przedmiot = new Przedmiot(kodPrzedmiotu, nazwa_przedmiotu, ECTS, wymiar_godz, semestr, typ_przedmiotu, sposob_zaliczenia);
                przedmioty.dodajPrzedmiot(przedmiot);
            }

        } catch (IOException | ParseException e) {
            e.getMessage();
        }
        return przedmioty;
    }

    public static void dodajPrzedmiot(Przedmiot przedmiot) {
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

        System.out.println("Suma godzin dla danego typu przedmiotu: " + suma_godzin + "\nSuma ECTS dla danego " +
                "przedmiotu: " + suma_ECTS);
    }
}
