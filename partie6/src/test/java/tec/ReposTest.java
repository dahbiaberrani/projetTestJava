/**
 * *
 *
 * @author Dahbia BERRANI and Matteo MUNOZ
 */

package tec;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class ReposTest extends PassagerAbstraitTest {

    @BeforeEach
    void setUp() {
        Bus bus = new Autobus(0, 0);
        Repos passager = new Repos("Jean-Marc", 3, new Calme(new EtatCaractere(bus)));
        super.setUp(passager);
    }

    @Test
    void choixPlaceMonteePasDePlace() {
        Bus busDeboutUniquement = new Autobus(0, 0);
        Repos passager = new Repos("Jean-Marc", 3, new Calme(new EtatCaractere(busDeboutUniquement)));
        try {
            passager.monterDans(busDeboutUniquement);
            fail("Une exception doit être levée dans ce cas");
        } catch (UsagerInvalideException e) {
            System.out.println("tout est normal l'exception est attendue dans ce cas");
            assertTrue(passager.estDehors());
        }
    }

    @Test
    void choixPlaceMonteePlaceDeboutUniquement() {
        Bus busDeboutUniquement = new Autobus(0, 5);
        Repos passager = new Repos("Jean-Marc", 3, new Calme(new EtatCaractere(busDeboutUniquement)));
        try {
            passager.monterDans(busDeboutUniquement);
            assertTrue(passager.estDebout());
        } catch (UsagerInvalideException e) {
            System.out.println("Problème passager invalid" + e);
            fail("l'exception ne doit pas arriver dans ce cas");
        }
    }

    @Test
    void choixPlaceMonteeChoixPlaceDisponible() {
        Bus busChoixPlaceDisponible = new Autobus(5, 5);
        Repos passager = new Repos("Jean-Marc", 3, new Calme(new EtatCaractere(busChoixPlaceDisponible)));
        try {
            passager.monterDans(busChoixPlaceDisponible);
            assertTrue(passager.estAssis());
        } catch (UsagerInvalideException e) {
            System.out.println("Problème passager invalid" + e);
            fail("l'exception ne doit pas arriver dans ce cas");
        }
    }

    @Test
    void choixPlaceMonteePlaceAssisesUniquement() {
        Bus busDeboutUniquement = new Autobus(5, 0);
        Repos passager = new Repos("Jean-Marc", 3, new Calme(new EtatCaractere(busDeboutUniquement)));
        try {
            passager.monterDans(busDeboutUniquement);
            assertTrue(passager.estAssis());
        } catch (UsagerInvalideException e) {
            System.out.println("Problème passager invalid" + e);
            fail("l'exception ne doit pas arriver dans ce cas");
        }
    }
}
