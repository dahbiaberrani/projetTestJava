package tec;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static tec.FauxPassager.ASSIS;
import static tec.FauxPassager.DEBOUT;


class AutobusTest {
    Autobus a1;
    Autobus a2;
    Autobus a3;
    FauxPassager p1;
    FauxPassager p2;
    FauxPassager p3;
    @BeforeEach
    void setUp() throws Exception {
        this.a1= new Autobus(5,5);
        this.a2= new Autobus(5,0);
        this.a3= new Autobus(0,5);
        p1=new FauxPassager();
        p2=new FauxPassager();
        p3=new FauxPassager();

    }

    /**
     * Avec une instanciation dans autobus:
     * <p> A vérifier :
     * 	 <p>aPlaceAssise retourne false si il n' y a pas des place  assises dans autobus.
     * 	 <p>aPlaceAssise retourne vrai si il y a des place assises dans  autobus.
     * 	 @author Dahbia BERRANI
     */

    @Test
    void aPlaceAssise() {
        assertTrue(a1.aPlaceAssise());
        assertTrue(a2.aPlaceAssise());
        assertFalse(a3.aPlaceAssise());
    }

    /**
     * Avec une instanciation de autobus:
     * <p> A vérifier :
     * 	 <p>aPlaceDebout retourne false si il n' y a pas des place  Debout dans autobus.
     * 	 <p>aPlaceDebout retourne vrai si il y a des place  Debout dans  autobus.
     */

    @Test
    void testaPlaceDebout() {
        assertTrue(a1.aPlaceDebout());
        assertFalse(a2.aPlaceDebout());
        assertTrue(a3.aPlaceDebout());
    }

    /**Avec une instanciation de passager
     * <p> A vérifier:
     * <p> retourne vrai si l'etat passager est passer de Dehors à assise.
     */

    @Test
    void testdDemanderPlaceAssise() {
        a1.demanderPlaceAssise(p1);
        p1.status = ASSIS;
        a2.demanderPlaceAssise(p2);
        p2.status = ASSIS;
        a3.demanderPlaceAssise(p3);
        p3.status = ASSIS;

        assertTrue(p1.estAssis());
        assertTrue(p2.estAssis());
        assertTrue(p3.estAssis());
    }

    /**Avec une instanciation de passager
     * <p> A vérifier:
     * <p> retourne vrai si l'etat passager est passer de Dehors à debout.
     */

    @Test
    void demanderPlaceDebout() {
        a1.demanderPlaceDebout(p1);
        p1.status = DEBOUT;
        a2.demanderPlaceDebout(p2);
        p2.status = DEBOUT;
        a3.demanderPlaceDebout(p3);
        p3.status = DEBOUT;
        assertTrue(p1.estDebout());
        assertTrue(p2.estDebout());
        assertTrue(p3.estDebout());
    }

    /**Avec une instanciation de passager
     * <p> A vérifier:
     * <p> retourne vrai si l'etat passager est passer de assise à debout.
     * <p> retourne false si l'état de passager ne change pas de assise à l'état debout .
     */

    @Test
    void demanderChangerEnDebout() {
        a1.demanderChangerEnDebout(p1);
        p1.status = DEBOUT;

        assertTrue(p1.estDebout());
        a2.demanderChangerEnDebout(p2);
        p2.status = DEBOUT;

        assertTrue(p2.estDebout());
        a3.demanderChangerEnDebout(p3);
        p3.status = DEBOUT;

        assertTrue(p3.estDebout());
    }

    /**Avec une instanciation de passager
     * <p> A vérifier:
     * <p> retourne vrai si l'etat passager est passer de debout à assise.
     * <p> retourne false si l'état de passager ne change pas de debout à l'état assise .
     */

    @Test
    void demanderChangerEnAssis() {
        a1.demanderChangerEnAssis(p1);
        p1.status = ASSIS;

        assert(p1.estAssis());
        a2.demanderChangerEnAssis(p2);
        p2.status = ASSIS;
        assert(p2.estAssis());
        a3.demanderChangerEnAssis(p3);
        p3.status = ASSIS;
        assert(p3.estAssis());
    }

    /**Avec une instanciation de passager
     * <p> A vérifier:
     * <p> retourne vrai si l'etat passager est passer de debout à dehors.
     * <p> retourne vrai si l'etat passager est passer de assise à dehors.
     * <p> retourne false si l'état de passager ne change pas de assise ou debout à l'état dehors
     */

    @Test
    void demanderSortie() {
        a1.demanderSortie(p1);
        assertTrue(p1.estDehors());
        a2.demanderSortie(p2);
        assertTrue(p2.estDehors());
        a3.demanderSortie(p3);
        assertTrue(p3.estDehors());
    }

    /**Avec une instanciation de autobus
     * <p> A vérifier:
     * <p>retourne vrai si est bien partie en arret suivant.
     */

    @Test
    void allerArretSuivant(){
        p1.nouvelArret(a1,1);
        p1.accepterSortie();
        assertTrue(p1.estDehors());
    }
}