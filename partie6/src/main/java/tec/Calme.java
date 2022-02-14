/**
 * class PassagerStandard implement Usager et Passager
 *
 * @author Matteo MUNOZ and Dahbia BERRANI
 */

package tec;

public class Calme extends CaractereAbstrait {
    public Calme(EtatCaractere etatCaractere) {
        super(etatCaractere);
    }

    @Override
    public void choixChangerPlace(int numeroArret) {
        Bus b = this.etatCaractere.getBus();
        PassagerAbstrait passager = this.etatCaractere.getPassager();

        if (passager.getDestination() == b.getNumeroArret()) {
            b.demanderSortie(passager);
            passager.accepterSortie();
        }
    }
}
