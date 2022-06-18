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
        Skladnik testowanySkladnik = new Skladnik("Jablko",new IloscSkladnika(6.0, Jednostka.SZTUKA) , 5.0, 3.0);
        Lodowka lodowka = new Lodowka();
        lodowka.dodajSkladnik(testowanySkladnik.getNazwa(), testowanySkladnik.getIloscS().getJednostka(), testowanySkladnik.getLimitOstrzezenie(), testowanySkladnik.getLimitKrytyczny());
        List<Skladnik> wynikZwroconaLista = lodowka.zwrocListeSkladnikow();
        Assert.assertTrue("lista zwrocona zawiera skladnik", wynikZwroconaLista.contains(testowanySkladnik));
        Assert.assertEquals("lista pwoinna zawierac dodane skladniki", 1.0, wynikZwroconaLista.size());
    }


}
