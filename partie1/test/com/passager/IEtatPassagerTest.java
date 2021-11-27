package com.passager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.passager.EtatPassager.Etat.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author: Dahbia BERRANI
 */
class IEtatPassagerTest {
    private IEtatPassager passager1,passager2,passager3;
    private static final boolean PASSAGER_CHAINE = false;

    @BeforeEach
    void setUp() {
        passager1 = creerDehors(PASSAGER_CHAINE);
        passager2 = creerAssis(PASSAGER_CHAINE);
        passager3 = creerDebout(PASSAGER_CHAINE);
    }

    private IEtatPassager creerAssis(boolean passagerChaine) {
        if (passagerChaine) {
            return new EtatPassagerChaine("ASSIS");
        } else {
            return new EtatPassager(ASSIS);
        }
    }

    private IEtatPassager creerDehors( boolean passagerChaine ) {
        if (passagerChaine) {
            return new EtatPassagerChaine("DEHORS");
        } else {
            return new EtatPassager(DEHORS);
        }
    }

    private IEtatPassager creerDebout( boolean passagerChaine ) {
        if (passagerChaine) {
            return new EtatPassagerChaine("DEBOUT");
        } else {
            return new EtatPassager(DEBOUT);
        }
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
}