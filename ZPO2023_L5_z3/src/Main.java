public class Main {
    public static void main(String[] args) {
        Przedmiot przedmiot1 = new Przedmiot("ABC123", "ZPO",
                3, 60, 5);
        Przedmioty listaPrzedmiotow = new Przedmioty();
        listaPrzedmiotow.dodajPrzedmiot(przedmiot1);
        listaPrzedmiotow.przedstawPrzedmiot(przedmiot1);
        listaPrzedmiotow.usunPrzedmiot("ABC123");
    }
}