package tec;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * *
 *
 * @author Matteo MUNOZ
 */


class PassagerStandardTest {
    PassagerStandard mockPassager;

    @BeforeEach
    void setUp() {
        mockPassager = mock(PassagerStandard.class);
        when(mockPassager.estAssis()).thenReturn(false);
        when(mockPassager.estDebout()).thenReturn(false);
        when(mockPassager.estDehors()).thenReturn(true);
        when(mockPassager.nom()).thenReturn("le Passager");

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void estDehors() {
        //Passager p = new PassagerStandard("Nathalie", 0);
        assertTrue(mockPassager.estDehors());
        assertFalse(mockPassager.estAssis());
        assertFalse(mockPassager.estDebout());

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
        Passager p = new PassagerStandard("Jesus", 0);
        FauxBusDebout f = new FauxBusDebout();
        f.demanderPlaceDebout(p);
        assertTrue(p.estDebout());
        assertFalse(p.estAssis());
        assertFalse(p.estDehors());
    }

    @Test
    void nouvelArret() throws UsagerInvalideException {
        Autobus f = new Autobus(2,2);

        PassagerStandard p1 = new PassagerStandard("Josephine", 3);
        p1.monterDans(f);
        p1.accepterPlaceAssise();
        assertTrue(p1.estAssis());

        p1.nouvelArret(f,2);
        assertFalse(p1.estDebout());
        assertFalse(p1.estDehors());


        p1.nouvelArret(f,3);
        p1.accepterSortie();
        assertTrue(p1.estDehors());
    }

    @Test
    void nom() {
        PassagerStandard p1 = new PassagerStandard("Joseph", 0);
        assertSame("Joseph", p1.nom());

    }

}