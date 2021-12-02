package passager;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tec.EtatPassager;

import static tec.EtatPassager.Etat.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

class EtatPassagerTest {
    private EtatPassager passager1,passager2,passager3;
    @BeforeEach
    void setUp() {
        passager1 = new EtatPassager(DEHORS);
        passager2 = new EtatPassager(ASSIS);
        passager3 = new EtatPassager(DEBOUT);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void estExterieur() {

        assertTrue(passager1.estExterieur());
        assertFalse(passager1.estAssis());
        assertFalse(passager1.estDebout());
    }

    @Test
    void estAssis() {
        assertFalse(passager2.estExterieur());
        assertTrue(passager2.estAssis());
        assertFalse(passager2.estDebout());
    }

    @Test
    void estDebout() {
        assertFalse(passager3.estExterieur());
        assertFalse(passager3.estAssis());
        assertTrue(passager3.estDebout());
    }

    @Test
    void estInterieur() {
        assertFalse(passager1.estInterieur());
        assertTrue(passager2.estInterieur());
        assertTrue(passager3.estInterieur());
    }


    @Test
    void testToString() {
    }
}