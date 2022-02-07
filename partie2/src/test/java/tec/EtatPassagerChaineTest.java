package tec;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tec.EtatPassagerChaine;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

class EtatPassagerChaineTest {
    private EtatPassagerChaine passager4, passager5, passager6;
    @BeforeEach
    void setUp() {

        passager4 = new EtatPassagerChaine("DEHORS");
        passager5 = new EtatPassagerChaine("ASSIS");
        passager6 = new EtatPassagerChaine("DEBOUT");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void estExterieur() {

        assertTrue(passager4.estExterieur());
        assertFalse(passager4.estAssis());
        assertFalse(passager4.estDebout());
    }

    @Test
    void estAssis() {
        assertFalse(passager5.estExterieur());
        assertTrue(passager5.estAssis());
        assertFalse(passager5.estDebout());
    }

    @Test
    void estDebout() {
        assertFalse(passager6.estExterieur());
        assertFalse(passager6.estAssis());
        assertTrue(passager6.estDebout());
    }

    @Test
    void estInterieur() {
        assertFalse(passager4.estInterieur());
        assertTrue(passager5.estInterieur());
        assertTrue(passager6.estInterieur());
    }
}