package pl.sda.arppl4.lodowka.model;

public class IloscSkladnika {

    private double ilosc;
    private Jednostka jednostka;

    public IloscSkladnika(double ilosc, Jednostka jednostka) {
        this.ilosc = ilosc;
        this.jednostka = jednostka;
    }

    public double getIlosc() {
        return ilosc;
    }

    public void setIlosc(double ilosc) {
        this.ilosc = ilosc;
    }

    public Jednostka getJednostka() {
        return jednostka;
    }

    public void setJednostka(Jednostka jednostka) {
        this.jednostka = jednostka;
    }

    @Override
    public String toString() {
        return "pl.sda.arppl4.lodowka.model.IloscSkladnika{" +
                "ilosc=" + ilosc +
                ", jednostka=" + jednostka +
                '}';
    }
}
