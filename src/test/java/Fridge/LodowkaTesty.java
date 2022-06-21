package Fridge;

import org.junit.Assert;
import org.junit.Test;
import pl.sda.arppl4.lodowka.logic.Lodowka;
import pl.sda.arppl4.lodowka.model.IloscSkladnika;
import pl.sda.arppl4.lodowka.model.Jednostka;
import pl.sda.arppl4.lodowka.model.Skladnik;

import java.util.List;

public class LodowkaTesty {

    @Test
    public void test_mozliweJestDodawanieSkladnika() {
        Skladnik testowanySkladnik = new Skladnik("Jablko", new IloscSkladnika(0.0, Jednostka.SZTUKA), 5.0, 3.0);
        Lodowka lodowka = new Lodowka();
        lodowka.dodajSkladnik(testowanySkladnik.getNazwa(), testowanySkladnik.getIloscS().getJednostka(), testowanySkladnik.getLimitOstrzezenie(), testowanySkladnik.getLimitKrytyczny());
        List<Skladnik> wynikZwroconaLista = lodowka.zwrocListeSkladnikow();
        Assert.assertTrue("lista zwrocona zawiera skladnik", wynikZwroconaLista.contains(testowanySkladnik));
        Assert.assertEquals("lista powinna zawierac dodane skladniki", 1, wynikZwroconaLista.size());
    }

    @Test
    public void test_MozliweJestDodawanieTrzechSkladnikow(){
        Lodowka lodowka = new Lodowka();
        Skladnik testowanySkladnik1 = new Skladnik("Maslo", new IloscSkladnika(0.0, Jednostka.SZTUKA), 5.0, 3.0);
        Skladnik testowanySkladnik2 = new Skladnik("Mleko", new IloscSkladnika(0.0, Jednostka.MILILITR), 500.0, 300.0);
        Skladnik testowanySkladnik3 = new Skladnik("Cukier", new IloscSkladnika(0.0, Jednostka.GRAM), 1000.0, 500.0);
        lodowka.dodajSkladnik(testowanySkladnik1.getNazwa(), testowanySkladnik1.getIloscS().getJednostka(), testowanySkladnik1.getLimitOstrzezenie(), testowanySkladnik1.getLimitKrytyczny());
        lodowka.dodajSkladnik(testowanySkladnik2.getNazwa(), testowanySkladnik2.getIloscS().getJednostka(), testowanySkladnik2.getLimitOstrzezenie(), testowanySkladnik2.getLimitKrytyczny());
        lodowka.dodajSkladnik(testowanySkladnik3.getNazwa(), testowanySkladnik3.getIloscS().getJednostka(), testowanySkladnik3.getLimitOstrzezenie(), testowanySkladnik3.getLimitKrytyczny());
        List<Skladnik> wynikLista = lodowka.zwrocListeSkladnikow();
        Assert.assertEquals("lista powinna zwierac trzy skladniki", 3, wynikLista.size());
        Assert.assertTrue("lista zawiera składnik masło", wynikLista.contains(testowanySkladnik1));
        Assert.assertTrue("lista zawiera składnik masło", wynikLista.contains(testowanySkladnik2));
        Assert.assertTrue("lista zawiera składnik masło", wynikLista.contains(testowanySkladnik3));

    }
    @Test
    public void test_nieDzialaDodawanieSkladnikowOTejSamejNazwie(){
        Lodowka lodowka = new Lodowka();
        Skladnik pizdrykiWMasle = new Skladnik("pizdrykiWMasle", new IloscSkladnika(0.0, Jednostka.SZTUKA), 2.0, 1.0);
        Skladnik pizdrykiWMasle2 = new Skladnik("pizdrykiWMasle", new IloscSkladnika(0.0, Jednostka.GRAM), 2.0, 1.0);
        lodowka.dodajSkladnik(pizdrykiWMasle.getNazwa(), pizdrykiWMasle.getIloscS().getJednostka(), pizdrykiWMasle.getLimitOstrzezenie(), pizdrykiWMasle.getLimitKrytyczny());
        lodowka.dodajSkladnik(pizdrykiWMasle2.getNazwa(), pizdrykiWMasle2.getIloscS().getJednostka(), pizdrykiWMasle2.getLimitOstrzezenie(), pizdrykiWMasle2.getLimitKrytyczny());
        List<Skladnik> listaDruga = lodowka.zwrocListeSkladnikow();
        Assert.assertEquals("lista powinna zawierac skladnik", 1, listaDruga.size());
        Assert.assertTrue("lista powinna nie zawierac drugiego składnika", listaDruga.contains(pizdrykiWMasle2));


    }


}
