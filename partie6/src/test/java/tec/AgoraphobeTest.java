/**
 * class PassagerStandard implement Usager et Passager
 *
 * @author Matteo MUNOZ and Dahbia BERRANI
 */

package tec;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AgoraphobeTest {
    @Test
    void testComportementAgorapheDansLeBus() {
        Autobus bus = new Autobus(2);
        Repos passager = new Repos("Jean-Marc", 3, new Agoraphobe(new EtatCaractere(bus)));
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
            // Remplissage des place assises et debout du bus, l'Agoraphe doit sortir
            Fatigue passager2 = new Fatigue("Jean-Marc", 3, new Calme(new EtatCaractere(bus)));
            Sportif passager3 = new Sportif("Jean-Marc", 3, new Calme(new EtatCaractere(bus)));
            Sportif passager4 = new Sportif("Jean-Marc", 3, new Calme(new EtatCaractere(bus)));
            passager2.monterDans(bus);
            passager3.monterDans(bus);
            passager4.monterDans(bus);
            bus.allerArretSuivant();
        } catch (UsagerInvalideException e) {
            System.out.println("problème de passager invalide" + e);
            fail("Une exception ne doit pas être lancée");
        }
        assertTrue(passager.estDehors());

        try {
            bus.allerArretSuivant();
        } catch (UsagerInvalideException e) {
            System.out.println("problème de passager invalide" + e);
            fail("Une exception ne doit pas être lancée");
        }
        assertTrue(passager.estDehors());
    }
}
