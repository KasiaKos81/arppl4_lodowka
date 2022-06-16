import java.util.Objects;

public class Skladnik {

    private String nazwa;
    IloscSkladnika ilosc;
    private final double limitOstrzezenie;
    private final double limitKrytyczny;

    public Skladnik(String nazwa, IloscSkladnika ilosc, double limitOstrzezenie, double limitKrytyczny) {
        this.nazwa = nazwa;
       this.ilosc = ilosc;
        this.limitOstrzezenie = 3.0;
        this.limitKrytyczny = 2.0;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public IloscSkladnika getIlosc() {
        return ilosc;
    }

    public void setIlosc(IloscSkladnika ilosc) {
        this.ilosc = ilosc;
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
        return Double.compare(skladnik.limitOstrzezenie, limitOstrzezenie) == 0 && Double.compare(skladnik.limitKrytyczny, limitKrytyczny) == 0 && Objects.equals(nazwa, skladnik.nazwa) && Objects.equals(ilosc, skladnik.ilosc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazwa, ilosc, limitOstrzezenie, limitKrytyczny);
    }

    @Override
    public String toString() {
        return "Skladnik{" +
                "nazwa='" + nazwa + '\'' +
                ", ilosc=" + ilosc +
                ", limitOstrzezenie=" + limitOstrzezenie +
                ", limitKrytyczny=" + limitKrytyczny +
                '}';
    }
}
