package tec;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

class AutobusTest {
    Autobus autobus,autobus1;
    Passager passager,passager1;

    @BeforeEach
    void setUp() {
        autobus = new Autobus(5,0);
        autobus1 = new Autobus(0,8);
        passager.accepterPlaceAssise();

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
        assertTrue("true parceque il y a des place assise",autobus1.aPlaceAssise());
        assertFalse("false parce que il n' y a pas des place assise",autobus.aPlaceAssise());

    }

    /**
     * Avec une instanciation de autobus:
     * <p> A vérifier :
     * 	 <p>aPlaceDebout retourne false si il n' y a pas des place  Debout dans autobus.
     * 	 <p>aPlaceDebout retourne vrai si il y a des place  Debout dans  autobus.
     */

    @Test
    void aPlaceDebout() {
        assertTrue("y ' pas des place debout",autobus.aPlaceDebout());
        assertFalse("y 'a des place debout",autobus1.aPlaceDebout());
    }

    /**Avec une instanciation de passager
     * <p> A vérifier:
     * <p> retourne vrai si l'etat passager est passer de Dehors à assise.
     */

    @Test
    void demanderPlaceAssise(Passager p) {
        assertTrue("",demanderPlaceAssise(passager));
    }

    /**Avec une instanciation de passager
     * <p> A vérifier:
     * <p> retourne vrai si l'etat passager est passer de Dehors à debout.
     */

    @Test
    void demanderPlaceDebout(Passager p) {

    }

    /**Avec une instanciation de passager
     * <p> A vérifier:
     * <p> retourne vrai si l'etat passager est passer de assise à debout.
     * <p> retourne false si l'état de passager ne change pas de assise à l'état debout .
     */

    @Test
    void demanderChangerEnDebout(Passager p) {
    }

    /**Avec une instanciation de passager
     * <p> A vérifier:
     * <p> retourne vrai si l'etat passager est passer de debout à assise.
     * <p> retourne false si l'état de passager ne change pas de debout à l'état assise .
     */

    @Test
    void demanderChangerEnAssis(Passager p) {
    }

    /**Avec une instanciation de passager
     * <p> A vérifier:
     * <p> retourne vrai si l'etat passager est passer de debout à dehors.
     * <p> retourne vrai si l'etat passager est passer de assise à dehors.
     * <p> retourne false si l'état de passager ne change pas de assise ou debout à l'état dehors
     */

    @Test
    void demanderSortie() {
    }

    /**Avec une instanciation de autobus
     * <p> A vérifier:
     * <p>retourne vrai si est bien partie en arret suivant.
     */

    @Test
    void allerArretSuivant(){

    }
}