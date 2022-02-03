package tec;

/**
 * class AutobusExceptionTest test les Exception provoquer par la classe Autobus
 *
 * @author Dahbia BERRANI
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AutobusExceptionTest {
    Autobus a1;
    Passager p1;
    @BeforeEach
    void setUp() throws Exception {
        this.a1= new Autobus(5,5);
        this.p1=new PassagerStandard("toto", 2);
    }

    @Test
    void testdDemanderPlaceAssise() {
        p1.accepterPlaceAssise();
        try {
            a1.demanderPlaceAssise(p1);
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            System.out.println("Etat passager invalide");
        }
    }

    @Test
    void demanderPlaceDebout() {
        p1.accepterPlaceDebout();
        try {
            a1.demanderPlaceDebout(p1);
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            System.out.println(" Etat passager invalide");
        }
    }

    @Test
    void demanderChangerEnDebout() {
        p1.accepterPlaceDebout();
        try {
            a1.demanderChangerEnDebout(p1);
        } catch (IllegalArgumentException e) {
            System.out.println(" Etat passager invalide");
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
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            System.out.println("numero arret invalide");
        }
    }
}
