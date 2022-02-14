/**
 * class PassagerStandard implement Usager et Passager
 *
 * @author Matteo MUNOZ and Dahbia BERRANI
 */

package tec;

public class Prudent extends CaractereAbstrait {
    public Prudent(EtatCaractere etatCaractere) {
        super(etatCaractere);
    }

    @Override
    public void choixChangerPlace(int numeroArret) throws UsagerInvalideException {
        Bus b = this.etatCaractere.getBus();
        PassagerAbstrait passager = this.etatCaractere.getPassager();
        if (passager.getDestination() == b.getNumeroArret()) {
            b.demanderSortie(passager);
            passager.accepterSortie();
        } else {
            if (numeroArret >= passager.getDestination() - 3 && b.aPlaceDebout() && passager.estAssis()) {
                b.demanderChangerEnDebout(passager);
                if (!passager.estDebout()) {
                    throw new UsagerInvalideException("Usager stresser n'as pas pu se lever 3 arret avant");
                }
            }
        }
    }
}
