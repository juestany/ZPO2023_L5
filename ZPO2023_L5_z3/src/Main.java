enum typ_przedmiotu {
    WYKLAD,
    CWICZENIA,
    LABORATORIA,
    SEMINARIUM
}

enum sposob_zaliczenia {
    EGZAMIN,
    ZALICZENIE
}

public class Main {
    public static void main(String[] args) {
        Przedmiot przedmiot1 = new Przedmiot("ABC123", "ZPO",
                3, 60, 5, typ_przedmiotu.LABORATORIA, sposob_zaliczenia.ZALICZENIE);
        Przedmioty listaPrzedmiotow = new Przedmioty();
        listaPrzedmiotow.dodajPrzedmiot(przedmiot1);
        listaPrzedmiotow.przedstawPrzedmiot(przedmiot1);
        listaPrzedmiotow.usunPrzedmiot("ABC123");
    }
}
