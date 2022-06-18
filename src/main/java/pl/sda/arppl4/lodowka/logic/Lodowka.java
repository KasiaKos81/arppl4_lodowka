package pl.sda.arppl4.lodowka.logic;

import pl.sda.arppl4.lodowka.exception.BrakSkladnikaException;
import pl.sda.arppl4.lodowka.model.IloscSkladnika;
import pl.sda.arppl4.lodowka.model.Jednostka;
import pl.sda.arppl4.lodowka.model.Skladnik;

import java.util.*;

public class Lodowka {

    private Map<String, Skladnik> mapaSkladniki = new HashMap<>();

    public void dodajSkladnik(String nazwa, Jednostka jednostka, double limitOstrzezenie, double limitKrytyczny) {
        if (!mapaSkladniki.containsKey(nazwa)) {
            mapaSkladniki.put(nazwa, new Skladnik(nazwa, new IloscSkladnika(0.0, jednostka), limitOstrzezenie, limitKrytyczny));
        }
    }
    public List<Skladnik> zwrocListeSkladnikow(){
        return new ArrayList<>(mapaSkladniki.values());
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
            throw new RuntimeException("nie ma składnika exception");
        }
        Skladnik skladnik  = mapaSkladniki.get(nazwa);
        skladnik.getIloscS().setIlosc((skladnik.getIloscS().getIlosc()) + ilosc);
    }
    public void zmniejszIloscSkladnik(String nazwa, double ilosc){
        if(!mapaSkladniki.containsKey(nazwa)){
           throw new BrakSkladnikaException("nie ma składnika");

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
    public void zwmienLimitKrytyczny(String nazwa, double nowaIlosc){
        if(!mapaSkladniki.containsKey(nazwa)){

        }

    }

}
