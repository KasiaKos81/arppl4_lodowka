import java.util.*;

public class Lodowka {

    private Map<String, Skladnik> skladniki = new HashMap<>();

    public void dodajSkladnik(String nazwa, IloscSkladnika ilosc, double limitOstrzezenie, double limitKrytyczny) {
        if (!skladniki.containsKey(nazwa)) {
            skladniki.put(nazwa, new Skladnik(nazwa, ilosc, limitOstrzezenie, limitKrytyczny));
        }
    }
    public List<Skladnik> zwrocSkladnikiKtorychJestMalo(){
        List<Skladnik> listaSkladnikowKtorychJestMalo = new ArrayList<>();
        for (Skladnik skladnik : skladniki.values()) {
            if(skladnik.getLimitOstrzezenie() <= 3.0){
                listaSkladnikowKtorychJestMalo.add(skladnik);
            }
        } return listaSkladnikowKtorychJestMalo;
    }
    public List<Skladnik> zwrocSkladnikiKtorychJestWCholereMalo(){
        List<Skladnik> listaSkladnikowKtorychJestWCholereMalo = new ArrayList<>();
        for (Skladnik skladnik : skladniki.values()) {
            if(skladnik.getLimitKrytyczny() <= 2.0){
                listaSkladnikowKtorychJestWCholereMalo.add(skladnik);
            }
        } return listaSkladnikowKtorychJestWCholereMalo;
    }



    }
