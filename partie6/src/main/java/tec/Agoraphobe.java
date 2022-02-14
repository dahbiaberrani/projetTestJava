/**
 * class PassagerStandard implement Usager et Passager
 *
 * @author Matteo MUNOZ and Dahbia BERRANI
 */

package tec;

public class Agoraphobe extends CaractereAbstrait {
    public Agoraphobe(EtatCaractere etatCaractere) {
        super(etatCaractere);
    }

    @Override
    public void choixChangerPlace(int numeroArret) {
        Bus b = this.etatCaractere.getBus();
        PassagerAbstrait passager = this.etatCaractere.getPassager();
        if (passager.getDestination() == b.getNumeroArret() || (!b.aPlaceAssise() && !b.aPlaceDebout())) {
            b.demanderSortie(passager);
            passager.accepterSortie();
        }
    }
}
