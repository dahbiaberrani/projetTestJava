/**
 * *
 *
 * @author Matteo MUNOZ and Dahbia BERRANI
 */
package tec;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public abstract class PassagerAbstraitTest {

    private PassagerAbstrait p;

    void setUp(PassagerAbstrait passager_reel) {
        this.p = passager_reel;

    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void estAssis() {
        FauxBusAssis f = new FauxBusAssis();
        f.demanderPlaceAssise(p);
        assertTrue(p.estAssis());
        assertFalse(p.estDehors());
        assertFalse(p.estDebout());
    }

    @Test
    void estDebout() {
        FauxBusDebout f = new FauxBusDebout();
        f.demanderPlaceDebout(p);
        assertTrue(p.estDebout());
        assertFalse(p.estAssis());
        assertFalse(p.estDehors());
    }

    @Test
    void accepterSortie() {
        FauxBus f = new FauxBus();
        f.demanderSortie(p);
        assertTrue(p.estDehors());
        assertFalse(p.estAssis());
        assertFalse(p.estDebout());
    }

    @Test
    void accepterPlaceAssise() {
        FauxBusAssis f = new FauxBusAssis();
        f.demanderPlaceAssise(p);
        assertTrue(p.estAssis());
        assertFalse(p.estDehors());
        assertFalse(p.estDebout());
    }

    @Test
    void accepterPlaceDebout() {
        FauxBusDebout f = new FauxBusDebout();
        f.demanderPlaceDebout(p);
        assertTrue(p.estDebout());
        assertFalse(p.estAssis());
        assertFalse(p.estDehors());
    }

    @Test
    void nouvelArret() throws UsagerInvalideException {
        Autobus f = new Autobus(10);
        p.monterDans(f);
        p.accepterPlaceAssise();
        assertTrue(p.estAssis());

        p.nouvelArret(f,2);
        assertFalse(p.estDehors());

        p.nouvelArret(f,3);
        p.accepterSortie();
        assertTrue(p.estDehors());
    }

    @Test
    void nom() {
        assertSame("Jean-Marc", p.nom());
    }
}
