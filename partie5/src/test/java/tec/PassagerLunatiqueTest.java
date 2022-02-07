/**
 * *
 *
 * @author Matteo MUNOZ and Dahbia BERRANI
 */
package tec;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class PassagerLunatiqueTest extends PassagerAbstraitTest {
    private final PassagerLunatique passagerLunatique = new PassagerLunatique("Jean-Marc", 3);
    @BeforeEach
    void setUp() {
        super.setUp(passagerLunatique);
    }

    @Test
    void testComportementSpecifiquePassagerLunatiqueALaMonte() {
        // Vérifier qu'il y a une exception lorsque le passager lunatique n'obtient pas une place debout à la monté
        Autobus bus = new Autobus(0);
        assertTrue(passagerLunatique.estDehors());
        try {
            passagerLunatique.monterDans(bus);
            fail();
        } catch (UsagerInvalideException e) {
            System.out.println("Pas de place debout pour un passager Lunatique dans le Transport");
        }

        // Vérifier que le passager lunatique est debout juste à sa monté dans le bus
        bus = new Autobus(10);
        try {
            passagerLunatique.monterDans(bus);

        } catch (UsagerInvalideException e) {
            System.out.println("Le passager Lunatique n'st pas debout juste après sa monté dans le bus" + e);
           fail();
        }
        assertTrue(passagerLunatique.estDebout());
    }

    @Test
    void testComportementSpecifiquePassagerLunatiqueDansLeBus() {
        Autobus bus = new Autobus(10);
        assertTrue(passagerLunatique.estDehors());
        try {
            passagerLunatique.monterDans(bus);
        } catch (UsagerInvalideException e) {
            System.out.println("Probleme de passager invalide" + e);
            fail();
        }
        assertTrue(passagerLunatique.estDebout());

        try {
            bus.allerArretSuivant();
        } catch (UsagerInvalideException e) {
            System.out.println("Probleme de passager invalide" + e);
            fail();
        }
        assertTrue(passagerLunatique.estAssis());

        try {
            bus.allerArretSuivant();
        } catch (UsagerInvalideException e) {
            System.out.println("Probleme de passager invalide" + e);
            fail();
        }
        assertTrue(passagerLunatique.estDebout());

        try {
            bus.allerArretSuivant();
        } catch (UsagerInvalideException e) {
            System.out.println("Probleme de passager invalide" + e);
            fail();
        }
        assertTrue(passagerLunatique.estDehors());
    }
}
