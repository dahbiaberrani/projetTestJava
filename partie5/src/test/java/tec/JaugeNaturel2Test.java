/**
 * *
 *
 * @author Matteo MUNOZ and Dahbia BERRANI
 */
package tec;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JaugeNaturel2Test {
    jaugeNaturel jauge2, jauge3, jauge4,jauge5,jaugeEgal,jaugeSup,jaugeSupInter;

    public Ijauge creerJauge(long min, long max, long val) {
        return new jaugeNaturel(min, max, val);
    }

    @BeforeEach
    void setUp() {

        jauge2 = new jaugeNaturel(1, 100, 50);
        jauge3 = new jaugeNaturel(1, 100, 1);
        try {
            jauge4 = new jaugeNaturel(1, 100, 0);
            fail("Une exception doit être normalement lancée");
        } catch (IllegalArgumentException e) {
            System.out.println("Tout est normal, l'exception est attendue pour ce cas:" + e);
        }
        try {
            jauge5 = new jaugeNaturel(50, 25, 30);
        } catch (IllegalArgumentException e) {
            System.out.println("Tout est normal, l'exception est attendue pour ce cas:" + e);
        }

        jaugeEgal = new jaugeNaturel(20, 20, 20);
        try  {
            jaugeSup = new jaugeNaturel(20, 20, 30);
            fail("Une exception doit être normalement lancée");
        } catch (IllegalArgumentException e) {
            System.out.println("Tout est normal, l'exception est attendue pour ce cas:" + e);
        }
        jaugeSupInter = new jaugeNaturel(1, 40, 40);
    }

    @AfterEach
    void tearDown() {
        jauge2 = null;
        jauge3 = null;
        jauge4 = null;
        jauge5 = null;
        jaugeEgal = null;
        jaugeSup = null;
        jaugeSupInter = null;
    }

    @Test
    void testDansIntervalle() {
        assertFalse(jauge2.estRouge(), "estRouge() devrait renvoyer false");
        assertTrue(jauge2.estVert(), "estVert() devrait renvoyer true");
        assertFalse(jauge2.estBleu(), "estBleu() devrait renvoyer false");
    }

    @Test
    void testDeplacer() {
        assertTrue(jauge3.estBleu(), "estBleu() devrait renvoyer true");
        assertFalse(jauge3.estRouge(), "estRouge() devrait renvoyer false");
        assertFalse(jauge3.estVert(), "estVert() devrait renvoyer false");
        jauge3.incrementer();
        assertFalse(jauge3.estBleu(), "estBleu() devrait renvoyer false");
        assertFalse(jauge3.estRouge(), "estRouge() devrait renvoyer false");
        assertTrue(jauge3.estVert(), "estVert() devrait renvoyer true");
    }

    @Test
    void testInferieurIntervalle() {
        assertTrue(jauge3.estBleu(), "estBleu() devrait renvoyer true");
        assertFalse(jauge3.estRouge(), "estRouge() devrait renvoyer false");
        assertFalse(jauge3.estVert(), "estVert() devrait renvoyer false");
    }

    @Test
    void testCreationNonValide ( ) {
        Ijauge inverse = null;
        Ijauge egale = null;
        try {
            inverse = creerJauge (78 ,13 ,0 );
            fail("Pas d'exception levée");
            System.out.println(inverse);
        } catch (Exception e) {
            assertNull(inverse);
        }

        try {
            egale = creerJauge(-45 ,-45, -46);
            fail("Pas d'exception levée");
        } catch (Exception e) {
            assertNull(egale);
        }

    }

    @Test
    void testExceptionControlee() {
        Exception exception = assertThrows( NullPointerException.class, () -> {
            throw new NullPointerException ("Attention");
        });
    }

    @Test
    void testExceptionControlee1() {
        Exception exception = assertThrows( ClassNotFoundException.class, () -> {
            throw new ClassNotFoundException("Attention");
        });
    }

    @Test
    void testSuperieurIntervalle()  {
        assertTrue(jaugeSupInter.estRouge(), "estRouge() devrait renvoyer true");
        jaugeSupInter.decrementer();
        assertFalse(jaugeSupInter.estRouge(), "estRouge() devrait renvoyer false");
    }
}
