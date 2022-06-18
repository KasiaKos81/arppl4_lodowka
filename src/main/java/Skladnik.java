import java.util.Objects;

public class Skladnik {

    private String nazwa;
    IloscSkladnika iloscS;
    private double limitOstrzezenie;
    private double limitKrytyczny;

    public Skladnik(String nazwa, IloscSkladnika ilosc, double limitOstrzezenie, double limitKrytyczny) {
        this.nazwa = nazwa;
       this.iloscS = ilosc;
        this.limitOstrzezenie = limitOstrzezenie;
        this.limitKrytyczny = limitKrytyczny;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public IloscSkladnika getIloscS() {
        return iloscS;
    }

    public void setIloscS(IloscSkladnika iloscS) {
        this.iloscS = iloscS;
    }

    public double getLimitOstrzezenie() {
        return limitOstrzezenie;
    }

    public double getLimitKrytyczny() {
        return limitKrytyczny;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skladnik skladnik = (Skladnik) o;
        return Double.compare(skladnik.limitOstrzezenie, limitOstrzezenie) == 0 && Double.compare(skladnik.limitKrytyczny, limitKrytyczny) == 0 && Objects.equals(nazwa, skladnik.nazwa) && Objects.equals(iloscS, skladnik.iloscS);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazwa, iloscS, limitOstrzezenie, limitKrytyczny);
    }

    @Override
    public String toString() {
        return "Skladnik{" +
                "nazwa='" + nazwa + '\'' +
                ", ilosc=" + iloscS +
                ", limitOstrzezenie=" + limitOstrzezenie +
                ", limitKrytyczny=" + limitKrytyczny +
                '}';
    }
}
