package cz.czechitas.recept;

import cz.czechitas.recept.naradi.*;
import cz.czechitas.recept.suroviny.*;
import cz.czechitas.recept.suroviny.intf.NadobaSKusovouSurovinou;

public class SpousteciTrida {

    public static void main(String[] args) {
        Miska cervenaMiska;
        Miska zlutaMiska;
        Mixer mixer;
        Vaha kuchynskaVaha;
        PlechNaPeceni plech;
        ElektrickaTrouba trouba;
        Vajicka vajicka;

        Ovoce ovoce;
        Maslo maslo125g;
        Mouka pytlikMouky;
        Cukr pytlikCukru;
        PrasekDoPeciva prasekDoPeciva;

        cervenaMiska = new Miska("cervenaMiska");
        zlutaMiska = new Miska("zlutaMiska");
        mixer = new Mixer("mixer");
        kuchynskaVaha = new Vaha("vaha");
        plech = new PlechNaPeceni("plech");
        trouba = new ElektrickaTrouba("trouba");

        vajicka = new Vajicka("vajicka");
        ovoce = new Ovoce("ovoce");
        maslo125g = new Maslo("maslo125g");
        pytlikMouky = new Mouka("pytlikMouky");
        pytlikCukru = new Cukr("pytlikCukru");
        prasekDoPeciva = new PrasekDoPeciva("prasekDoPeciva");

        //---------------------------------------------------------------------

        // TODO: Sem napiste recept na bublaninu
        // Pouzivejte napovidani v editoru.
        // Vyskakuje samo nebo pomoci Ctrl+Mezernik

        for (int i = 0; i < 4; i++) {
            cervenaMiska.nalozSiJedenKus(vajicka);

        }


        cervenaMiska.nalozSiCelyObsah(pytlikCukru);
        mixer.zamichej(cervenaMiska);
        cervenaMiska.nalozSiCelyObsah(maslo125g);
        mixer.zamichej(cervenaMiska);

        kuchynskaVaha.vynulujSeS(zlutaMiska);
        int vahaMouky=0;
        int prevazek = 0;
        int vahaMoukyPres;
        do {
            //vahaMouky = kuchynskaVaha.zjistiHmotnost(zlutaMiska);
            if (vahaMouky < 250) {
               zlutaMiska.nalozSiTrochu(pytlikMouky);
           }
            else  {
                vahaMoukyPres = kuchynskaVaha.zjistiHmotnost(zlutaMiska);
                zlutaMiska.vylozSiTrochu();
                prevazek = prevazek + (vahaMoukyPres-kuchynskaVaha.zjistiHmotnost(zlutaMiska));
            }
            vahaMouky = kuchynskaVaha.zjistiHmotnost(zlutaMiska);
        } while  (vahaMouky != 250);

        kuchynskaVaha.zjistiHmotnost(zlutaMiska);
        cervenaMiska.nalozSiObsahJineMisky(zlutaMiska);
        cervenaMiska.nalozSiCelyObsah(prasekDoPeciva);
        mixer.zamichej(cervenaMiska);
        plech.preberSiObsah(cervenaMiska);
        for (int i = 0; i < 50; i++) {
            plech.posypSeKusem(ovoce);
        }
        trouba.zapniSe(180);
        trouba.nechejPect(5);
        trouba.vlozSiDovnitr(plech);
        trouba.nechejPect(25);
        trouba.vypniSe();
        trouba.vyndejObsahVen();
        System.out.println("Při vážení bylo do voidu vyhozeno:"+prevazek+"g mouky");

    }

}
