package tec;

/**
 * class PassagerStandard implement Usager et Passager
 *
 * @author Matteo MUNOZ
 */

public class PassagerStresse extends PassagerAbstrait {

    public PassagerStresse(String string, int i) {
        super(string, i);
    }

    @Override
    public void choixPlaceMontee(Bus b) {
        if (b.aPlaceAssise() && b.aPlaceDebout()) {
            b.demanderPlaceAssise(this);
        }
    }

    @Override
    public void choixChangerPlace(Bus b, int numeroArret) {
        if (this.getDestination() == b.getNumeroArret()) {
            b.demanderSortie(this);
            this.accepterSortie();
        } else if (numeroArret >= this.getDestination() - 3 && b.aPlaceDebout() && this.estAssis()) {
            b.demanderChangerEnDebout(this);
        } else {
            if (!this.estDebout()) {
                try {
                    throw new UsagerInvalideException("Usager stresser n'as pas pu se lever 3 arret avant");
                } catch (UsagerInvalideException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}