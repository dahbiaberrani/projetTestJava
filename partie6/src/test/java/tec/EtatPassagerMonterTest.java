package tec;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tec.EtatPassagerMonter;

import static tec.EtatPassagerMonter.Etat.ASSIS;
import static tec.EtatPassagerMonter.Etat.DEBOUT;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

class EtatPassagerMonterTest {
    private EtatPassagerMonter passager2,passager3;
    @BeforeEach
    void setUp() {
        passager2 = new EtatPassagerMonter(ASSIS);
        passager3 = new EtatPassagerMonter(DEBOUT);

    }

    @AfterEach
    void tearDown() {
    }



    @Test
    void estAssis() {

        assertTrue(passager2.estAssis());
        assertFalse(passager2.estDebout());
    }

    @Test
    void estDebout() {

        assertFalse(passager3.estAssis());
        assertTrue(passager3.estDebout());
    }

    @Test
    void estInterieur() {

        assertTrue(passager2.estInterieur());
        assertTrue(passager3.estInterieur());
    }

    @Test
    void estExterieur() {

        assertFalse(passager2.estExterieur());
        assertTrue(passager2.estAssis());
        assertFalse(passager2.estDebout());

    }

    @Test
    void testToString() {
    }
}