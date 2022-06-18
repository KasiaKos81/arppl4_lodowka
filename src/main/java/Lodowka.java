import java.util.*;

public class Lodowka {

    private Map<String, Skladnik> mapaSkladniki = new HashMap<>();

    public void dodajSkladnik(String nazwa, IloscSkladnika ilosc, double limitOstrzezenie, double limitKrytyczny) {
        if (!mapaSkladniki.containsKey(nazwa)) {
            mapaSkladniki.put(nazwa, new Skladnik(nazwa, ilosc, limitOstrzezenie, limitKrytyczny));
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
            if(skladnik.getLimitKrytyczny() <= 2.0){
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
        skladnik.setIlosc((skladnik.getIlosc()) + ilosc);

    }


    }
