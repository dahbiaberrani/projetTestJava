package tec;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * *
 * 	 @author Matteo MUNOZ
 */


class PassagerStandardTest {

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void estDehors() {
        Passager p = new PassagerStandard("Nathalie", 0);
        assertTrue(p.estDehors());
        assertFalse(p.estAssis());
        assertFalse(p.estDebout());

    }

    @Test
    void estAssis() {
        Passager p = new PassagerStandard("Jean-Marc", 0);
        FauxBusAssis f = new FauxBusAssis();
        f.demanderPlaceAssise(p);
        assertTrue(p.estAssis());
        assertFalse(p.estDehors());
        assertFalse(p.estDebout());
    }

    @Test
    void estDebout() {
        Passager p = new PassagerStandard("Corine", 0);
        FauxBusDebout f = new FauxBusDebout();
        f.demanderPlaceDebout(p);
        assertTrue(p.estDebout());
        assertFalse(p.estAssis());
        assertFalse(p.estDehors());
    }

    @Test
    void accepterSortie() {
        Passager p = new PassagerStandard("Benjamin", 0);
        FauxBus f = new FauxBus();
        f.demanderSortie(p);
        assertTrue(p.estDehors());
        assertFalse(p.estAssis());
        assertFalse(p.estDebout());
    }

    @Test
    void accepterPlaceAssise() {
        Passager p = new PassagerStandard("Corentin", 0);
        FauxBusAssis f = new FauxBusAssis();
        f.demanderPlaceAssise(p);
        assertTrue(p.estAssis());
        assertFalse(p.estDehors());
        assertFalse(p.estDebout());
    }

    @Test
    void accepterPlaceDebout() {
    }

    @Test
    void nouvelArret() {
    }

    @Test
    void nom() {
    }

    @Test
    void monterDans() {
    }
}