
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PeliTest {
	 private Peli peli;

	    @BeforeEach
	    void setUp() {
	        peli = new Peli();
	    }

	    @Test
	    void pelinAlussaEiOlePelattujaPelejaTaiTasapeleja() {
	        assertEquals(0, peli.getPelatutPelit());
	        assertEquals(0, peli.getTasapelit());
	    }

	    @Test
	    void tasapelinJalkeenKasvattaaTasapelienMaaraa() {
	        String tulos = peli.tarkistaVoittaja("kivi", "kivi");
	        assertEquals(tulos, "tasapeli");
	    }

	    @Test
	    void pelikierroksenJalkeenLisaaPelattujenPelienMaaraa() {
	    	peli.pelaaKierros();
            peli.tulostaTilastot();
	        assertEquals(1, peli.getPelatutPelit());
	    }

	    @Test
	    void peliPaattyyKunKolmeVoittoaSaavutetaan() {
	        for (int i = 0; i < 3; i++) {
	            peli.tarkistaVoittaja("kivi", "sakset");
	            peli.tarkistaPelinLoppuminen();
	        }
	        assertTrue(peli.onPeliLoppunut());
	    }

    @Test
    void testTasapeliKaikillaValinnoilla() {
        Peli peli = new Peli();
        assertEquals("tasapeli", peli.tarkistaVoittaja("kivi", "kivi"));
        assertEquals("tasapeli", peli.tarkistaVoittaja("paperi", "paperi"));
        assertEquals("tasapeli", peli.tarkistaVoittaja("sakset", "sakset"));
    }

    @Test
    void testPelaaja1Voittaa() {
        Peli peli = new Peli();
        assertEquals("Pelaaja 1", peli.tarkistaVoittaja("kivi", "sakset"));
        assertEquals("Pelaaja 1", peli.tarkistaVoittaja("paperi", "kivi"));
        assertEquals("Pelaaja 1", peli.tarkistaVoittaja("sakset", "paperi"));
    }

    @Test
    void testPelaaja2Voittaa() {
        Peli peli = new Peli();
        assertEquals("Pelaaja 2", peli.tarkistaVoittaja("kivi", "paperi"));
        assertEquals("Pelaaja 2", peli.tarkistaVoittaja("paperi", "sakset"));
        assertEquals("Pelaaja 2", peli.tarkistaVoittaja("sakset", "kivi"));
    }
}

