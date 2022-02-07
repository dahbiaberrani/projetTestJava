package tec;

/**
 * class PassagerStandard implement Usager et Passager
 *
 * @author Matteo MUNOZ and Dahbia BERRANI
 */

public class PassagerStresse extends PassagerAbstrait {

    public PassagerStresse(String string, int i) {
        super(string, i);
    }

    @Override
    public void choixPlaceMontee(Bus b) throws UsagerInvalideException {
        if (b.aPlaceAssise() && b.aPlaceDebout()) {
            b.demanderPlaceAssise(this);
        } else {
            throw new UsagerInvalideException("Pas de place assise pour un passager stressé");
        }
    }

    @Override
    public void choixChangerPlace(Bus b, int numeroArret) throws UsagerInvalideException {
        if (this.getDestination() == b.getNumeroArret()) {
            b.demanderSortie(this);
            this.accepterSortie();
        } else {
            if (numeroArret >= this.getDestination() - 3 && b.aPlaceDebout() && this.estAssis()) {
                b.demanderChangerEnDebout(this);
                if (!this.estDebout()) {
                    throw new UsagerInvalideException("Usager stresser n'as pas pu se lever 3 arret avant");
                }
            }
        }
    }
}
