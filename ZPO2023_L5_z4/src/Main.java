import java.util.*;

public class Main {
    public static void main(String[] args) {
        /**
         * Poniższy kod pozwala użytkownikowi samemu wpisać zdanie do sprawdzenia
         */
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Podaj zdanie w celu zliczenia wystąpień danych ");
//        String tekst = myObj.nextLine();

        Map<String, Integer> wystapienia_slow = new HashMap<String, Integer>();
        Map<String, Integer> wystapienia_znakow = new HashMap<String, Integer>();

        String tekst = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

        // liczy liczbę znaków i słów pozbywając się m.in. spacji
        int liczba_znakow = tekst.replace(" ", "").length();
        int liczba_slow = tekst.split("\\s").length;

        // lista Stringów z pomniejszonymi wielkimi literami i bez niechcianych znaków
        String[] slowa = tekst.toLowerCase().replaceAll("[^a-zA-Z0-9\\s]+", "").split("\\s+");
        String[] znaki = tekst.toLowerCase().replaceAll(" ", "").split("(?!^)");

        // dodanie słowa do mapy jeśli istnieje wraz z liczbą wystąpień.
        // jeśli nie istnieje, tworzy się nowa para klucz-wartość
        for(String slowo : slowa) {
            Optional<Integer> slowo_count = Optional.ofNullable(wystapienia_slow.get(slowo));
            if (slowo_count.isPresent()) {
                wystapienia_slow.compute(slowo, (k, v) -> v + 1);
            } else {
                wystapienia_slow.put(slowo, 1);
            }
        }

        // jak wyżej, ale znaki
        for(String znak : znaki) {
            Optional<Integer> znak_count = Optional.ofNullable(wystapienia_znakow.get(znak));
            if(znak_count.isPresent()) {
                wystapienia_znakow.compute(znak, (k, v) -> v + 1);
            } else {
                wystapienia_znakow.put(znak, 1);
            }
        }



        // przedstawienie wyniku
        System.out.println("Liczba słów w podanym zdaniu: " + liczba_slow + "\n");
        System.out.println("Liczba znaków w podanym zdaniu: " + liczba_znakow + "\n");

        System.out.println("Wystąpienia słów: \n");
        for(Map.Entry<String, Integer> para_slowa : wystapienia_slow.entrySet()) {
            System.out.println(para_slowa.getKey() + ": " + para_slowa.getValue());
        }

        System.out.println("");

        System.out.printf("Wystąpienia znaków: \n");
        for(Map.Entry<String, Integer> para_znaki : wystapienia_znakow.entrySet()) {
            System.out.println(para_znaki.getKey() + ": " + para_znaki.getValue());
        }
    }
}
