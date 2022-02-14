package tec;

/**
 * class AutobusExceptionTest test les Exception provoquer par la classe Autobus
 *
 * @author Dahbia BERRANI
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class AutobusExceptionTest {
    Autobus a1;
    Passager p1;
    @BeforeEach
    void setUp() throws Exception {
        this.a1 = new Autobus(5,5);
        this.p1 = new Sportif("toto", 2, new Prudent(new EtatCaractere(a1)));
    }

    @Test
    void testdDemanderPlaceAssise() {
        p1.accepterPlaceAssise();
        try {
            a1.demanderPlaceAssise(p1);
            fail("Une exception doitnormalment être lancée");
        } catch (IllegalArgumentException e) {
            System.out.println("Etat passager invalide");
        }
    }

    @Test
    void demanderPlaceDebout() {
        p1.accepterPlaceDebout();
        try {
            a1.demanderPlaceDebout(p1);
            fail("Une exception doit normalment être lancée");
        } catch (IllegalArgumentException e) {
            System.out.println(" Etat passager invalide");
        }
    }

    @Test
    void demanderChangerEnDebout() {
        p1.accepterPlaceDebout();
        try {
            a1.demanderChangerEnDebout(p1);
            fail("Une exception doit normalment être lancée");
        } catch (IllegalArgumentException e) {
            System.out.println(" Etat passager invalide tout est normal l'exception est attendue");
        }
    }

    @Test
    void demanderChangerEnAssis() {
        p1.accepterPlaceAssise();
        try {
            a1.demanderChangerEnAssis(p1);
        } catch (IllegalArgumentException e) {
            System.out.println("Etat passager invalide");
        }
    }

    @Test
    void allerArretSuivant(){
        try {
            p1.nouvelArret(a1,3);
            fail("Une exception doit normalment être lancée");
        } catch (IllegalArgumentException e) {
            System.out.println("numero arret invalide");
        } catch (UsagerInvalideException e) {
            System.out.println("Problème de passager invalide" + e);
            fail("Une exception doit normalment être lancée");
        }
    }
}
