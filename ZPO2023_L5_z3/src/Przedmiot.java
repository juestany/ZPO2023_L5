public class Przedmiot {
    private String kod_przedmiotu;
    private String nazwa_przedmiotu;
    private int ECTS;
    private int wymiar_godz;
    private int semestr;
    private typ_przedmiotu typ_przedmiotu;
    private sposob_zaliczenia sposob_zaliczenia;

    public Przedmiot(
            String kod_przedmiotu,
            String nazwa_przedmiotu,
            int ECTS, int wymiar_godz,
            int semestr,
            typ_przedmiotu typ_przedmiotu,
            sposob_zaliczenia sposob_zaliczenia) {
        /**
         * Konstruktor
         */
        this.kod_przedmiotu = kod_przedmiotu;
        this.nazwa_przedmiotu = nazwa_przedmiotu;
        this.ECTS = ECTS;
        this.wymiar_godz = wymiar_godz;
        this.semestr = semestr;
        this.typ_przedmiotu = typ_przedmiotu;
        this.sposob_zaliczenia = sposob_zaliczenia;
    }

    public void setKod_przedmiotu(String kod_przedmiotu) {
        this.kod_przedmiotu = kod_przedmiotu;
    }

    public void setNazwa_przedmiotu(String nazwa_przedmiotu) {
        this.nazwa_przedmiotu = nazwa_przedmiotu;
    }

    public void setECTS(int ECTS) {
        this.ECTS = ECTS;
    }

    public void setWymiar_godz(int wymiar_godz) {
        this.wymiar_godz = wymiar_godz;
    }

    public void setSemestr(int semestr) {
        this.semestr = semestr;
    }

    public void setTyp_przedmiotu(typ_przedmiotu typ_przedmiotu) { this.typ_przedmiotu = typ_przedmiotu; }

    public void setSposob_zaliczenia(sposob_zaliczenia sposob_zaliczenia) { this.sposob_zaliczenia = sposob_zaliczenia;}

    public String getKod_przedmiotu() {
        return this.kod_przedmiotu;
    }

    public String getNazwa_przedmiotu() {
        return this.nazwa_przedmiotu;
    }

    public int getECTS() {
        return this.ECTS;
    }

    public int getWymiar_godz() {
        return this.wymiar_godz;
    }

    public int getSemestr() {
        return this.semestr;
    }

    public typ_przedmiotu getTyp_przedmiotu() { return this.typ_przedmiotu; }

    public sposob_zaliczenia getSposob_zaliczenia() { return this.sposob_zaliczenia;}
}
