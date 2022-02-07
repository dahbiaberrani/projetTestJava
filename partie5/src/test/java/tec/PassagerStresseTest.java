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

class PassagerStresseTest extends PassagerAbstraitTest {
    private final PassagerStresse passagerStresse = new PassagerStresse("Jean-Marc", 5);
    @BeforeEach
    void setUp() {
        super.setUp(passagerStresse);
    }

    @Test
    void testComportementSpecifiquePassagerStresseALaMonte() {
        // Vérifier qu'il y a une exception lorsque le passager lunatique n'obtient pas une place debout à la monté
        Autobus bus = new Autobus(0);
        assertTrue(passagerStresse.estDehors());
        try {
            passagerStresse.monterDans(bus);
            fail("Une exception doit normalment être lancée");
        } catch (UsagerInvalideException e) {
            System.out.println("Pas de place assise pour un passager stressé dans le Transport");
        }

        // Vérifier que le passager lunatique est assis juste à sa monté dans le bus
        bus = new Autobus(10);
        try {
            passagerStresse.monterDans(bus);

        } catch (UsagerInvalideException e) {
            System.out.println("problème de passager invalide" + e);
            fail("Une exception doit normalment être lancée");
        }
        assertTrue(passagerStresse.estAssis());
    }

    @Test
    void testComportementSpecifiquePassagerStresseDansLeBus() {
        Autobus bus = new Autobus(10);
        assertTrue(passagerStresse.estDehors());

        try {
            passagerStresse.monterDans(bus);
        } catch (UsagerInvalideException e) {
            System.out.println("problème de passager invalide" + e);
            fail();
        }
        assertTrue(passagerStresse.estAssis());

        try {
            bus.allerArretSuivant();
        } catch (UsagerInvalideException e) {
            System.out.println("problème de passager invalide" + e);
            fail();
        }
        assertTrue(passagerStresse.estAssis());

        try {
            bus.allerArretSuivant();
        } catch (UsagerInvalideException e) {
            System.out.println("problème de passager invalide" + e);
            fail();
        }
        assertTrue(passagerStresse.estDebout());

        try {
            bus.allerArretSuivant();
        } catch (UsagerInvalideException e) {
            System.out.println("problème de passager invalide" + e);
            fail();
        }
        assertTrue(passagerStresse.estDebout());

        try {
            bus.allerArretSuivant();
        } catch (UsagerInvalideException e) {
            System.out.println("problème de passager invalide" + e);
            fail();
        }
        assertTrue(passagerStresse.estDebout());

        try {
            bus.allerArretSuivant();
        } catch (UsagerInvalideException e) {
            System.out.println("problème de passager invalide" + e);
            fail();
        }
        assertTrue(passagerStresse.estDehors());
    }
}
