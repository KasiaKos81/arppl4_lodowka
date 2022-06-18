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
            if(skladnik.getLimitOstrzezenie() <= 3.0){
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


    }
