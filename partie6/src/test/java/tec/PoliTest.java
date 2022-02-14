/**
 * class PassagerStandard implement Usager et Passager
 *
 * @author Matteo MUNOZ and Dahbia BERRANI
 */

package tec;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PoliTest {
    @Test
    void testComportementPoliLeDansLeBus() {
        Autobus bus = new Autobus(2);
        Repos passager = new Repos("Jean-Marc", 3, new Poli(new EtatCaractere(bus)));
        assertTrue(passager.estDehors());

        try {
            passager.monterDans(bus);
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
        assertTrue(passager.estAssis());

        try {
            // Remplissage des place assises du bus
            Fatigue passager2 = new Fatigue("Jean-Marc", 3, new Poli(new EtatCaractere(bus)));
            passager2.monterDans(bus);
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
