package tec;

/**
 * class PassagerStandard implement Usager et Passager
 *
 * @author Matteo MUNOZ and Dahbia BERRANI
 */

public class PassagerLunatique extends PassagerAbstrait {

    public PassagerLunatique(String string, int i) {
        super(string, i);
    }

    @Override
    public void choixPlaceMontee(Bus b)  throws UsagerInvalideException {
        if (b.aPlaceDebout()) {
            b.demanderPlaceDebout(this);
        } else {
            throw new UsagerInvalideException("Pas de place debout pour un passager lunatique");
        }
    }

    @Override
    public void choixChangerPlace(Bus b, int numeroArret) throws UsagerInvalideException {
        if (this.getDestination() == b.getNumeroArret()) {
            b.demanderSortie(this);
            this.accepterSortie();
        } else if (estAssis()) {
            if (b.aPlaceDebout()) {
                b.demanderChangerEnDebout(this);
            } else {
                throw new UsagerInvalideException("Usager Lunatique n'as pas pu se lever");
            }
        } else if (b.aPlaceAssise()) {
            b.demanderChangerEnAssis(this);
        } else  {
            throw new UsagerInvalideException("Usager Lunatique n'as pas pu s'assoir");
        }
    }
}
