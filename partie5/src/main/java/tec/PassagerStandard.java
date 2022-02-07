package tec;

/**
 * class PassagerStandard implement Usager et Passager
 *
 * @author Matteo MUNOZ and Dahbia BERRANI
 */

public class PassagerStandard extends PassagerAbstrait {

    public PassagerStandard(String string, int i) {
        super(string, i);
    }

    @Override
    public void choixPlaceMontee(Bus b) throws UsagerInvalideException {
        if (b.aPlaceAssise()) {
            b.demanderPlaceAssise(this);
        } else {
            if (b.aPlaceDebout()) {
                b.demanderPlaceDebout(this);
            } else {
                throw new UsagerInvalideException("Usager Standard n'a pas pu monter car aucune place n'est disponible");
            }
        }
    }

    @Override
    public void choixChangerPlace(Bus b, int numeroArret) {
        if (this.getDestination() == b.getNumeroArret()) {
            b.demanderSortie(this);
            this.accepterSortie();
        }
    }
}
