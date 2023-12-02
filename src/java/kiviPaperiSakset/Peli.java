/**
 * Peli-luokka hallinnoi kivi-paperi-sakset -pelin logiikkaa.
 * Luokka pitää kirjaa pelatuista peleistä, tasapeleistä ja kummankin pelaajan voitoista.
 */
//luokasta poistettu turhia muuttujia, kapseloitu muuttujia ja refaktoroitu toiminnallisuudet omiin metodeihinsa ja tietenkin korjattu bugit
public class Peli {
    private Pelaaja p1;
    private Pelaaja p2;
    private int pelatutPelit;
    private int tasapelit;
    private boolean peliLoppui;
    
    public Peli() {
        this.p1 = new Pelaaja();
        this.p2 = new Pelaaja();
        this.pelatutPelit = 0;
        this.tasapelit = 0;
        this.peliLoppui = false;
    }
    /**
     * Aloittaa ja hallinnoi pelin kulkua.
     * Pelaa pelejä, kunnes toinen pelaajista saavuttaa kolme voittoa.
     */
    public void pelaa() {
        while (!peliLoppui) {
            pelaaKierros();
            tulostaTilastot();
            tarkistaPelinLoppuminen();
        }
    }
    /**
     * Pelaa yhden kierroksen kivi-paperi-sakset -peliä.
     * Tulostaa pelaajien valinnat ja ilmoittaa kierroksen voittajan.
     */
    public void pelaaKierros() {
        String p1Valinta = p1.arvoValinta();
        String p2Valinta = p2.arvoValinta();
        System.out.println("Pelaaja 1 valitsee: " + p1Valinta);
        System.out.println("Pelaaja 2 valitsee: " + p2Valinta);
        String tulos = tarkistaVoittaja(p1Valinta, p2Valinta);
        if (tulos.equals("tasapeli")) {
            tasapelit++;
            System.out.println("Tasapeli.");
        } else {
            System.out.println(tulos + " voittaa!");
        }
    }
    /**
     * Tarkistaa voittajan kivi-paperi-sakset -pelissä.
     * 
     * @param p1Valinta Pelaaja 1:n valinta.
     * @param p2Valinta Pelaaja 2:n valinta.
     * @return Palauttaa "Pelaaja 1", "Pelaaja 2" tai "tasapeli" riippuen pelin tuloksesta.
     */
    public String tarkistaVoittaja(String p1Valinta, String p2Valinta) {
        if (p1Valinta.equals(p2Valinta)) {
            return "tasapeli";
        } else if ((p1Valinta.equals("kivi") && p2Valinta.equals("sakset")) ||
                   (p1Valinta.equals("sakset") && p2Valinta.equals("paperi")) ||
                   (p1Valinta.equals("paperi") && p2Valinta.equals("kivi"))) {
            p1.lisaaVoitto();
            return "Pelaaja 1";
        } else {
            p2.lisaaVoitto();
            return "Pelaaja 2";
        }
    }
    /**
     * Tarkistaa, onko peli loppunut eli onko jompikumpi pelaajista saavuttanut
     * kolme voittoa. Jos näin on, asettaa peliLoppui-muuttujan arvoksi true.
     */
    public void tarkistaPelinLoppuminen() {
        if (p1.getVoitot() >= 3 || p2.getVoitot() >= 3) {
            peliLoppui = true;
            System.out.println("KOLME VOITTOA - PELI PÄÄTTYY");
        }
    }
    /**
     * Tulostaa pelin nykyiset tilastot, kuten pelattujen pelien lukumäärän,
     * tasapelien määrän ja kummankin pelaajan voittojen lukumäärän.
     */
    public void tulostaTilastot() {
        System.out.println("Pelaaja 1 voittoja: " + p1.getVoitot());
        System.out.println("Pelaaja 2 voittoja: " + p2.getVoitot());
        System.out.println("Tasapelejä: " + tasapelit);
        pelatutPelit++;
    }
    //getterit ja setterit testausta varten
    public int getPelatutPelit() {
        return pelatutPelit;
    }

    public int getTasapelit() {
        return tasapelit;
    }

    public boolean onPeliLoppunut() {
        return peliLoppui;
    }

    public static void main(String args[]) {
        Peli peli = new Peli();
        peli.pelaa();
    }
}
