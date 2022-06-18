import java.util.*;

public class Lodowka {

    private Map<String, Skladnik> mapaSkladniki = new HashMap<>();

    public void dodajSkladnik(String nazwa, Jednostka jednostka, double limitOstrzezenie, double limitKrytyczny) {
        if (!mapaSkladniki.containsKey(nazwa)) {
            mapaSkladniki.put(nazwa, new Skladnik(nazwa, new IloscSkladnika(0.0, jednostka), limitOstrzezenie, limitKrytyczny));
        }
    }
    public List<Skladnik> zwrocSkladnikiKtorychJestMalo(){
        List<Skladnik> listaSkladnikowKtorychJestMalo = new ArrayList<>();
        for (Skladnik skladnik : mapaSkladniki.values()) {
            if(skladnik.getLimitOstrzezenie() >= skladnik.getIloscS().getIlosc()){
                listaSkladnikowKtorychJestMalo.add(skladnik);
            }
        } return listaSkladnikowKtorychJestMalo;
    }
    public List<Skladnik> zwrocSkladnikiKtorychJestWCholereMalo(){
        List<Skladnik> listaSkladnikowKtorychJestWCholereMalo = new ArrayList<>();
        for (Skladnik skladnik : mapaSkladniki.values()) {
            if(skladnik.getLimitKrytyczny() >= skladnik.getIloscS().getIlosc()){
                listaSkladnikowKtorychJestWCholereMalo.add(skladnik);
            }
        } return listaSkladnikowKtorychJestWCholereMalo;
    }
    public void zwiekszIloscSkladnika(String nazwa, double ilosc){
        if(!mapaSkladniki.containsKey(nazwa)){
            System.out.println("Nie ma takiego składnika");
            return;
        }
        Skladnik skladnik  = mapaSkladniki.get(nazwa);
        skladnik.getIloscS().setIlosc((skladnik.getIloscS().getIlosc()) + ilosc);
    }
    public void zmniejszIloscSkladnik(String nazwa, double ilosc){
        if(!mapaSkladniki.containsKey(nazwa)){
            System.out.println("Nie ma takiego składnika");
            return;
        }
        double roznicaStanuIlosci = mapaSkladniki.get(nazwa).getIloscS().getIlosc() - ilosc;
        if (roznicaStanuIlosci < 0){
            System.out.println("za mało produktu");
            return;
        }
        Skladnik skladnik = mapaSkladniki.get(nazwa);
        skladnik.getIloscS().setIlosc((skladnik.getIloscS().getIlosc()) - ilosc);
    }

    public Optional<IloscSkladnika> zwrocStanSkladnika(String nazwa){
        if(mapaSkladniki.containsKey(nazwa)){
            System.out.println("Jest taki skladnik w lodowce: " + nazwa);
            return Optional.of(mapaSkladniki.get(nazwa).getIloscS());
        } else {
            System.err.println("doopa, nie ma skladnika");
            return Optional.empty();
        }
    }

}
