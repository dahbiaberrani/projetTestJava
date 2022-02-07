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


class PassagerStandardTest extends PassagerAbstraitTest {
    private final PassagerStandard passagerStandard = new PassagerStandard("Jean-Marc", 3);
    @BeforeEach
    void setUp() {
        super.setUp(passagerStandard);
    }

    @Test
    void testComportementSpecifiquePassagerStandardALaMontePlaceAssiseDisponibleOupasDeplaces() {
        // Vérifier qu'il y a une exception lorsque le passager standard n'obtient ni lace assise ni place debout
        Autobus bus = new Autobus(0);
        assertTrue(passagerStandard.estDehors());
        try {
            passagerStandard.monterDans(bus);
            fail("Une exception doit normalment être lancée");
        } catch (UsagerInvalideException e) {
            System.out.println("tout est normal, l'exception est attendue dans ce cas de test");
        }

        // Vérifier que le passager standard est assis juste à sa monté dans le bus qui a des places assises de disponibles
        bus = new Autobus(10);
        try {
            passagerStandard.monterDans(bus);

        } catch (UsagerInvalideException e) {
            System.out.println("problème de passager invalide" + e);
            fail();
        }
        assertTrue(passagerStandard.estAssis());
    }

    @Test
    void testComportementSpecifiquePassagerStandardALaMontePlaceDeboutUniquementeDisponible() {
        // Vérifier que le passager standard est debout juste à sa monté dans le bus qui n'a que des places debouts
        Autobus bus = new Autobus(0, 10);
        try {
            passagerStandard.monterDans(bus);

        } catch (UsagerInvalideException e) {
            System.out.println("problème de passager invalide" + e);
            fail();
        }
        assertTrue(passagerStandard.estDebout());
    }

    @Test
    void testComportementSpecifiquePassagerStandardDansLeBus() {
        Autobus bus = new Autobus(10);
        assertTrue(passagerStandard.estDehors());

        try {
            passagerStandard.monterDans(bus);
        } catch (UsagerInvalideException e) {
            System.out.println("problème de passager invalide" + e);
            fail("Une exception doit normalment être lancée");
        }
        assertTrue(passagerStandard.estAssis());

        try {
            bus.allerArretSuivant();
        } catch (UsagerInvalideException e) {
            System.out.println("problème de passager invalide" + e);
            fail("Une exception doit normalment être lancée");
        }
        assertTrue(passagerStandard.estAssis());

        try {
            bus.allerArretSuivant();
        } catch (UsagerInvalideException e) {
            System.out.println("problème de passager invalide" + e);
            fail("Une exception doit normalment être lancée");
        }
        assertTrue(passagerStandard.estAssis());

        try {
            bus.allerArretSuivant();
        } catch (UsagerInvalideException e) {
            System.out.println("problème de passager invalide" + e);
            fail("Une exception doit normalment être lancée");
        }
        assertTrue(passagerStandard.estDehors());
    }
}
