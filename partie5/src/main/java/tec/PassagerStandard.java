package tec;

/**
 * class PassagerStandard implement Usager et Passager
 *
 * @author Matteo MUNOZ
 */

public class PassagerStandard extends PassagerAbstrait {

    public PassagerStandard(String string, int i) {
        super(string, i);
    }

    @Override
    public void choixPlaceMontee(Bus b) {
        if (b.aPlaceAssise()) {
            b.demanderPlaceAssise(this);
        } else {
            b.demanderPlaceDebout(this);
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