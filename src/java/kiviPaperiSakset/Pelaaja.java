

/**
 * Pelaaja-luokka kivi-paperi-sakset -pelille.
 * Tämä luokka hallinnoi pelaajan voittoja ja antaa mahdollisuuden
 * arpoa pelaajan valinnan pelissä (kivi, paperi tai sakset).
 */
public class Pelaaja {

    private int voitot;      // Voittojen lukumäärä, muutettu yksityiseksi eli kapseloitu
    // poistettu voitotYhteensä muuttuja turhana

    /**
     * Arpoo ja palauttaa pelaajan valinnan pelissä.
     * Valinnat ovat "kivi", "paperi" tai "sakset".
     *
     * @return Satunnaisesti valittu merkkijono, joka edustaa pelaajan valintaa.
     */
    //vaihdettu metodin nimi selkeämmäksi ja poistettu swtich case hässäkkä turhana.
    public String arvoValinta() {
    	String[] valinnat = {"kivi", "paperi", "sakset"};
        int indeksi = (int) (Math.random() * 3);
        return valinnat[indeksi];
    }
    /**
     * Lisää yhden voiton pelaajan nykyiseen voittojen määrään.
     */
    public void lisaaVoitto() {
        voitot++; //muutettu metodin nimi selkeämmäksi ja laitettu metodi vain kasvattamaan voitto-muuttujan arvoa yhdellä.
    }
    /**
     * Palauttaa pelaajan voittojen kokonaismäärän.
     *
     * @return Pelaajan voittojen lukumäärä.
     */
    public int getVoitot() {
        return voitot;
    }
}
