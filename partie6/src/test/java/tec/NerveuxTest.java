/**
 * class PassagerStandard implement Usager et Passager
 *
 * @author Matteo MUNOZ and Dahbia BERRANI
 */

package tec;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NerveuxTest {
    @Test
    void testComportementNerveuxDansLeBus() {
        Autobus bus = new Autobus(10);
        Sportif passager = new Sportif("Jean-Marc", 3, new Nerveux(new EtatCaractere(bus)));
        assertTrue(passager.estDehors());

        try {
            passager.monterDans(bus);
        } catch (UsagerInvalideException e) {
            System.out.println("problème de passager invalide" + e);
            fail("Une exception ne doit pas être lancée");
        }
        assertTrue(passager.estDebout());

        try {
            bus.allerArretSuivant();
        } catch (UsagerInvalideException e) {
            System.out.println("problème de passager invalide" + e);
            fail("Une exception ne doit pas être lancée");
        }
        assertTrue(passager.estAssis());

        try {
            bus.allerArretSuivant();
        } catch (UsagerInvalideException e) {
            System.out.println("problème de passager invalide" + e);
            fail("Une exception ne doit pas être lancée");
        }
        assertTrue(passager.estDebout());

        try {
            bus.allerArretSuivant();
        } catch (UsagerInvalideException e) {
            System.out.println("problème de passager invalide" + e);
            fail("Une exception ne doit pas être lancée");
        }
        assertTrue(passager.estDehors());
    }
}
